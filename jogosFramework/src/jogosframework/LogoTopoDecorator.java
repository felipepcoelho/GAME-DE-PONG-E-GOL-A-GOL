
package jogosframework;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class LogoTopoDecorator extends Decorator
{
    public LogoTopoDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String logoTopoURL = "../jogosFramework/img/logoSuperiorMenu.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          logoTopoIMG = toolkit.getImage(logoTopoURL);
        g.drawImage(logoTopoIMG, posicaoX, posicaoY, null);
    }
    private Image logoTopoIMG;
}
