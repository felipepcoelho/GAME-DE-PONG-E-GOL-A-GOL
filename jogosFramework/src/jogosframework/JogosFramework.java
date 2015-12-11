
package jogosframework;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class JogosFramework
{
    public static void main(String[] args) throws Exception
    {
        nucleo =  Nucleo.getInstancia();
        pluginsHM = new HashMap<>();
        carregarPlugins();
        nucleo.getIJogoControle().setPluginsHM(pluginsHM);
    }
    public static void carregarPlugins() throws Exception
    {
        File currentDir = new File("./plugins");
        String []plugins = currentDir.list();
        int i;
        URL[] jars = new URL[plugins.length];
        for (i = 0; i < plugins.length; ++i)
            jars[i] = (new File("./plugins/" + plugins[i])).toURL();
        URLClassLoader ulc = new URLClassLoader(jars);
        for (i = 0; i < plugins.length; ++i) {
            String nomePlugin = plugins[i].split("\\.")[0];
            pluginsHM.put(nomePlugin,ulc); 
      }
    }
    private static Nucleo nucleo;
    private static HashMap<String,URLClassLoader> pluginsHM;
}
