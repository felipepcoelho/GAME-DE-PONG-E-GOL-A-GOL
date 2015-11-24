
package golagol;

import interfaces.IPincel;
import interfaces.IPreenchimentoFacade;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.text.html.HTML;

public class PreenchimentoSombra implements IPincel
{
    @Override
    public void preencher(Graphics2D g) 
    {
        IPreenchimentoFacade facade = new PreenchimentoFacade();
        facade.gerarPrenchimentoSobra(g, new Color(0x0153CC));
    }    
}
