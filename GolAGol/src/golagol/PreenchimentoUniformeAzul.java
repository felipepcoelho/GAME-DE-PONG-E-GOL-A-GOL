package golagol;

import interfaces.IPincel;
import java.awt.Color;
import java.awt.Graphics2D;

public class PreenchimentoUniformeAzul implements IPincel
{
    @Override
    public void preencher(Graphics2D g)
    {
        g.setColor(Color.BLUE);
    }
}
