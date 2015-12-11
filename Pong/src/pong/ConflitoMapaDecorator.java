
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class ConflitoMapaDecorator extends Decorator
{

    public ConflitoMapaDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String conflitoMapaURL = "../jogosFramework/img/conflitoPongMapa.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          conflitoMapaIMG = toolkit.getImage(conflitoMapaURL);
        g.drawImage(conflitoMapaIMG, posicaoX, posicaoY, null);
    }
    private Image conflitoMapaIMG;
    
}
