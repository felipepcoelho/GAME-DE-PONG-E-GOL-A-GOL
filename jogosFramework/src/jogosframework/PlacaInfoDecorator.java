
package jogosframework;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class PlacaInfoDecorator extends Decorator
{

    public PlacaInfoDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String placaInfoURL = "../jogosFramework/img/placaInfoMenu.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          placaInfoIMG = toolkit.getImage(placaInfoURL);
        g.drawImage(placaInfoIMG, posicaoX, posicaoY, null);
    }
    private Image placaInfoIMG;
}
