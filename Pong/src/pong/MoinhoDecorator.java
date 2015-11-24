
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class MoinhoDecorator extends Decorator
{

    public MoinhoDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String moinhoURL = "../jogosFramework/img/moinhoPong.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          moinhoIMG = toolkit.getImage(moinhoURL);
        g.drawImage(moinhoIMG, posicaoX, posicaoY, null);
    }
    private Image moinhoIMG;
}
