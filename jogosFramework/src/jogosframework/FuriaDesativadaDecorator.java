
package jogosframework;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class FuriaDesativadaDecorator extends Decorator
{

    public FuriaDesativadaDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
     public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String furiaURL = "../jogosFramework/img/modoFuriaDesativado.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          furia = toolkit.getImage(furiaURL);
        g.drawImage(furia, posicaoX, posicaoY, null);
    }
    private Image furia;
}
