
package interfaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RelatorioTemplateMethod 
{
    protected final void gerarRelatorio(String templateFile, String outputFile, HashMap<String, Object> dictionary) throws IOException{
        this.templateFileName = templateFile;
        this.outputFileName = outputFile;
        this.dictionary = dictionary;
        renderizarRelatorio();
    }
    
    private void renderizarRelatorio()throws FileNotFoundException,IOException 
    {
        BufferedReader br = new BufferedReader(new FileReader(templateFileName));
        String line;
        while ((line = br.readLine()) != null) {
            Pattern pAll = Pattern.compile("\\[% (.*?) %\\]");
            Matcher matcher = pAll.matcher(line);
            while (matcher.find()) {
                line = line.replace(matcher.group(), dictionary.get(matcher.group(1)).toString());
                matcher = pAll.matcher(line);
            }
            System.out.println(line);
        }
    }
    
    private String templateFileName;
    private String outputFileName;
    private HashMap<String, Object> dictionary;

}
