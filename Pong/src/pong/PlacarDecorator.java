
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class PlacarDecorator extends Decorator
{

    public PlacarDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String placarURL = "../jogosFramework/img/placarPong.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          placarIMG = toolkit.getImage(placarURL);
        g.drawImage(placarIMG, posicaoX, posicaoY, null);
    }
    private Image placarIMG;
    
}
