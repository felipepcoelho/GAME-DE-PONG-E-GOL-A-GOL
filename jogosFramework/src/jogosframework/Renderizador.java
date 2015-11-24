
package jogosframework;

import interfaces.IUiControle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Renderizador extends JPanel{
    
    private Renderizador()
    {
    }
    
    public static Renderizador getInstanciaRenderizador()
    {
        if(instancia == null)
            instancia = new Renderizador();
        return instancia;
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        UiControle.getInstancia().renderizar((Graphics2D) g);
    }
    
    private static Renderizador instancia;
}
