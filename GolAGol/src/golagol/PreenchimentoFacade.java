
package golagol;

import interfaces.IPreenchimentoFacade;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

public class PreenchimentoFacade implements IPreenchimentoFacade
{

    @Override
    public void gerarPrenchimentoSobra(Graphics2D g, Color c) {
       Paint p;     
        g.setColor(c);
        p = new GradientPaint(0, 0, new Color(0.0f, 0.0f, 0.0f, 0.4f),
                0, 45, new Color(0.0f, 0.0f, 0.0f, 0.0f));
        g.setPaint(p);
        p = new GradientPaint(0, 0, new Color(1.0f, 1.0f, 1.0f, 0.0f),
                0, 45, new Color(1.0f, 1.0f, 1.0f, 0.4f));
        g.setPaint(p);
        p = new RadialGradientPaint(new Point2D.Double(45 / 2.0,
                45 / 2.0), 45 / 2.0f,
                new float[] { 0.0f, 1.0f },
                new Color[] { new Color(6, 76, 160, 127),
                    new Color(0.0f, 0.0f, 0.0f, 0.8f) });
        g.setPaint(p);
    }
    
}
