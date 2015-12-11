
package jogosframework;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class RegrasControleDecorator extends Decorator
{
    public RegrasControleDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y)
    {
        super(g, visualComponente, x, y);
    }
    public void exibir(Graphics2D g,int posicaoX,int posicaoY)
    {
        String regrasControleURL = "../jogosFramework/img/botoesDosJogos.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          regrasControleIMG = toolkit.getImage(regrasControleURL);
        g.drawImage(regrasControleIMG, posicaoX, posicaoY, null);
    }
    private Image regrasControleIMG;
}
