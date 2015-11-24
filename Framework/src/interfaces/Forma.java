package interfaces;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Forma
{
    public void setPincel(IPincel pincel)
    {
        this.pincel = pincel;
    }
    public void preencher(Graphics2D g)
    {
        pincel.preencher(g);
    }
    public abstract void desenhar(int x, int y, int raio, int diametro,Graphics g);
    
    private IPincel pincel;
    private Forma forma;
}
