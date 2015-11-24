package pong;
import interfaces.IFabricaFlexivel;
import interfaces.INucleo;
import interfaces.IPlugin;
import interfaces.IPrototipo;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pong implements IFabricaFlexivel,IPlugin
{
    @Override
    public boolean inicializar(String nomePlugin,INucleo nucleo)
    {
        this.addPrototipo("Bola");
        this.addPrototipo("Campo");
        this.addPrototipo("Time");
        this.addPrototipo("Regras");
        nucleo.getIJogoControle().adicionarFabrica(nomePlugin,this);
        return true;
    }
    public IPrototipo criar(String nome)
    {
        if(nomeProdutos.containsKey(nome)){
            IPrototipo p = (IPrototipo) nomeProdutos.get(nome);
            return p.clone();
        }
        return null;
    }
    public boolean addPrototipo(String nome)
    {
        if(!nomeProdutos.containsKey(nome)){
                IPrototipo prototipo = null;
            try {
                prototipo = (IPrototipo) Class.forName("pong."+nome).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
            }
                nomeProdutos.put(nome,prototipo);    
            return true;
        }
        return false;
    }
    public boolean removerPrototipo(String nome)
    {
        if(!nomeProdutos.containsKey(nome)){
            nomeProdutos.remove(nome);
            return true;
        }
        return false;
    }
    public boolean removerTodosPrototipos()
    {
        nomeProdutos.clear();
        return true;
    }
    private HashMap<String,IPrototipo> nomeProdutos = new HashMap<>();
}
