
package jogosframework;

import interfaces.IJogoControle;
import interfaces.INucleo;
import interfaces.IUiControle;


public class Nucleo implements INucleo
{
    private Nucleo()
    {
        uiControle = uiControle.getInstancia();
        GameControle = GameControle.getInstanciaJogoControle();
    }
    
    public static Nucleo getInstancia()
    {
        if(instancia == null)
            instancia = new Nucleo();
        return instancia;
    }
    
    @Override
    public IUiControle getUiControle()
    {
        return uiControle;
    }
    @Override
    public IJogoControle getIJogoControle()
    {
       return GameControle;
    }
    
    private static Nucleo instancia;
    private UiControle uiControle;
    private JogoControle GameControle;
}
