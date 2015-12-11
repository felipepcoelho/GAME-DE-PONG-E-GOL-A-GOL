package jogosframework;


import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import jogosframework.Decorator;

public class BotaoEnterDecorator extends Decorator
{
    public BotaoEnterDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String botaoEnterURL = "../jogosFramework/img/btEnterMenu.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          botaoEnterIMG = toolkit.getImage(botaoEnterURL);
        g.drawImage(botaoEnterIMG, posicaoX, posicaoY, null);
    }
    private Image botaoEnterIMG;
}
