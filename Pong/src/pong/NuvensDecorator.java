
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class NuvensDecorator extends Decorator{

    public NuvensDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String nuvensURL = "../jogosFramework/img/nuvensPong.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          nuvensIMG = toolkit.getImage(nuvensURL);
        g.drawImage(nuvensIMG, posicaoX, posicaoY, null);
    }
    private Image nuvensIMG;
    
}
