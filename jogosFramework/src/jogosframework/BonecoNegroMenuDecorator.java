package jogosframework;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class BonecoNegroMenuDecorator extends Decorator
{
    public BonecoNegroMenuDecorator(Graphics2D g, IVisualComponente visualComponente, int x, int y) {
        super(g, visualComponente, x, y);
    }
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){
        String bonecoNegroURL = "../jogosFramework/img/boneco2ComBola.gif"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          bonecoNegroIMG = toolkit.getImage(bonecoNegroURL);
        g.drawImage(bonecoNegroIMG, posicaoX, posicaoY, null);
    }
    private Image bonecoNegroIMG;
    
}
