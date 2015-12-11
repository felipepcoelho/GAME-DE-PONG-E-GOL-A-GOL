
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class CapaceteDecorator extends Decorator 
{
    public CapaceteDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String capaceteURL = "../jogosFramework/img/capaceteSparta.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          capaceteIMG = toolkit.getImage(capaceteURL);
        g.drawImage(capaceteIMG, posicaoX+15, posicaoY-48, null);
    }
    private Image capaceteIMG;
}
