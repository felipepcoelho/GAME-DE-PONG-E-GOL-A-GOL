
package interfaces;

import java.awt.Graphics2D;
import javax.swing.JMenuItem;


public interface IUiControle
{
     public void renderizar(Graphics2D g);
     public JMenuItem addMenuItem(String menuName, String menuItem);
     public boolean addMenu(String menuName);
     public void removerBarraMenu();
}
