
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class OculosDecorator extends Decorator {

    public OculosDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
        this.exibir(g, x, y);
    }

    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String oculosURL = "../jogosFramework/img/oculos.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          oculosIMG = toolkit.getImage(oculosURL);
        g.drawImage(oculosIMG, posicaoX+73, posicaoY+40, null);
    }
    private Image oculosIMG;
}
