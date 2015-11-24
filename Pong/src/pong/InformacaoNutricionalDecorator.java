
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class InformacaoNutricionalDecorator extends Decorator
{

    public InformacaoNutricionalDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String infoNutricionalURL = "../jogosFramework/img/placaNutricional.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          infoNutricionalIMG = toolkit.getImage(infoNutricionalURL);
        g.drawImage(infoNutricionalIMG, posicaoX, posicaoY, null);
    }
    private Image infoNutricionalIMG;
}
