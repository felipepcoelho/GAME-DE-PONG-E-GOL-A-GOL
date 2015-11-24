
package pong;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;

public class Furia  
{   
    public Furia()
    {
        this.tipoEstrela = 0;
    }
    
    public void setFuria(int tipoEstrela) {
           if(this.tipoEstrela < 3)
               this.tipoEstrela += tipoEstrela;
    }
    
    public int getFuria(){
        return this.tipoEstrela;
    }
    
    public void exibir(Graphics2D g,int posicaoX, int posicaoY){
        String estrelaURL = "../jogosFramework/img/Estrela_"+tipoEstrela+".png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          estrela = toolkit.getImage(estrelaURL);
        g.drawImage(estrela, posicaoX, posicaoY, null);
    }
    private int tipoEstrela;
    private Image estrela;
}
