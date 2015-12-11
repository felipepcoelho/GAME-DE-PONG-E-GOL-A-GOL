
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class PranchaJogador2Decorator extends Decorator
{

    public PranchaJogador2Decorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String pranchaURL = "../jogosFramework/img/prachaJogador2.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          pranchaIMG = toolkit.getImage(pranchaURL);
        g.drawImage(pranchaIMG, posicaoX+10, posicaoY+135, null);
    }
    private Image pranchaIMG;
    
}
