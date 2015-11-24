package jogosframework;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class BonecoVermelhoMenuDecorator extends Decorator
{

    public BonecoVermelhoMenuDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String bonecoVermelhoURL = "../jogosFramework/img/boneco1Menu.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          bonecoVermelhoIMG = toolkit.getImage(bonecoVermelhoURL);
        g.drawImage(bonecoVermelhoIMG, posicaoX, posicaoY, null);
    }
    private Image bonecoVermelhoIMG;
}
