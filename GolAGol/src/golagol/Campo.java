package golagol;
import interfaces.ICampo;
import interfaces.IPrototipo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Campo implements ICampo,IPrototipo
{
    public void exibir(Graphics2D g) 
    {
        g.setColor(Color.green.darker());
        g.fillRect(0, 0, larguraDoCampo, alturaDoCampo);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(5f));
	g.drawLine(larguraDoCampo / 2, 0, larguraDoCampo / 2, alturaDoCampo);
	g.setStroke(new BasicStroke(2f));
        g.drawRect(larguraDoCampo / 2 - 100, alturaDoCampo / 2 - 340 , 200, 100);
        g.setFont(new Font("Arial", 1, 15));
        g.setColor(Color.WHITE);
        g.drawRect(larguraDoCampo / 2 -100, alturaDoCampo / 2 - 300 , 200, 200);
        g.drawOval(larguraDoCampo / 2 - 100, alturaDoCampo / 2 - 100, 200, 200);
        g.drawRect(larguraDoCampo / 2 - 550, alturaDoCampo / 2 - 100 , 200, 200);
        g.drawRect(larguraDoCampo / 2 + 350 , alturaDoCampo / 2 - 100  , 200, 200);
        g.drawString("Pontos", larguraDoCampo / 2 + 25, 10);
        g.drawString("Pontos", larguraDoCampo / 2 - 80, 10);
    }
    public Campo()
    {
        alturaDoCampo = 300;
        larguraDoCampo = 900;
                
    }
    public Campo(Campo campo)
    {
        this.alturaDoCampo = campo.alturaDoCampo;
        this.larguraDoCampo = campo.larguraDoCampo;
    }
    @Override
    public int largura()
    {
        return larguraDoCampo;
    }
    @Override
    public int altura()
    {
        return alturaDoCampo;
    }
    @Override
    public IPrototipo clone()
    {
       return new Campo(this);
    }
    private final int larguraDoCampo;
    private final int alturaDoCampo;
}
