
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class TravesDecorator extends Decorator
{

    public TravesDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String travesMapaURL = "../jogosFramework/img/travesPong.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          travesMapaIMG = toolkit.getImage(travesMapaURL);
        g.drawImage(travesMapaIMG, posicaoX, posicaoY, null);
    }
    private Image travesMapaIMG;
    
}
