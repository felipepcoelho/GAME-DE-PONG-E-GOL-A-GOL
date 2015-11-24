
package golagol;

import interfaces.Forma;
import java.awt.Graphics;

public class Circulo extends Forma
{
    @Override
    public void desenhar(int x, int y, int raio, int diametro, Graphics g)
    {
        g.fillOval(x, y, raio, diametro);
    }
}
