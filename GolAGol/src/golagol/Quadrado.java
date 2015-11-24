
package golagol;

import interfaces.Forma;
import java.awt.Graphics;

public class Quadrado extends Forma
{
    @Override
    public void desenhar(int x, int y, int largura, int altura, Graphics g)
    {
       g.fillRect(x,y,largura,altura);
    }
}
