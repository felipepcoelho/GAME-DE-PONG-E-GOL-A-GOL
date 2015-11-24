
package pong;

import interfaces.IRegras;
import interfaces.RelatorioTemplateMethod;
import java.io.IOException;
import java.util.HashMap;


public class RelatorioDePartidaJogarPong extends RelatorioTemplateMethod
{
    public RelatorioDePartidaJogarPong(IRegras regras) throws IOException{
        
        HashMap<String, Object> dictionary = new HashMap<String, Object>();
        dictionary.put("NAME",verificarVencedor(regras) );
        dictionary.put("RESULT", " VENCEDOR");
        dictionary.put("PONTUACAO_JOGADOR1", regras.getPontuacaoJogador1());
        dictionary.put("PONTUACAO_JOGADOR2", regras.getPontuacaoJogador2());
        
        this.gerarRelatorio("../../NetBeansProjects/jogosFramework/template1.tmpl", 
                "../../NetBeansProjects/jogosFramework/output1.txt", dictionary);
    }
    
    private String verificarVencedor(IRegras regras){
        if(regras.getPontuacaoJogador1() < regras.getPontuacaoJogador2())
            return "JOGADOR 2";
        else
            return "JOGADOR 1";
    }
    
    
    
}
