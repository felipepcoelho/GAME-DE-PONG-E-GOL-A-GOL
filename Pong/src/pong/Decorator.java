
package pong;

import interfaces.IVisualComponente;
import java.awt.Graphics2D;

public class Decorator implements IVisualComponente
{
    public Decorator(Graphics2D g,IVisualComponente visualComponente,int x,int y)
    {
        this.visualComponente = visualComponente;
        visualComponente.exibir(g, x, y);
    }
    
    @Override
    public void exibir(Graphics2D g,int posicaoX,int posicaoY){}
    
    private IVisualComponente visualComponente;
}
