
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class RaqueteDecorator extends Decorator
{

    public RaqueteDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String raqueteURL = "../jogosFramework/img/raquetePong.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          raqueteIMG = toolkit.getImage(raqueteURL);
        g.drawImage(raqueteIMG, posicaoX+0, posicaoY+25, null);
    }
    private Image raqueteIMG;
}
