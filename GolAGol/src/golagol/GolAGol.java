package golagol;
import interfaces.IFabricaFlexivel;
import interfaces.INucleo;
import interfaces.IPlugin;
import interfaces.IPrototipo;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;

public class GolAGol implements IFabricaFlexivel,IPlugin
{   
    public IPrototipo criar(String nome)
    {
        if(nomeProdutos.containsKey(nome)){
                IPrototipo  p = (IPrototipo) nomeProdutos.get(nome);
            return p.clone();
        }
        return null;
    }
    public boolean addPrototipo(String nome)
    {
        if(!nomeProdutos.containsKey(nome)){
            try {
                IPrototipo prototipo = null;
                prototipo = (IPrototipo) Class.forName("golagol."+nome).newInstance();
                nomeProdutos.put(nome,prototipo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GolAGol.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(GolAGol.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(GolAGol.class.getName()).log(Level.SEVERE, null, ex);
            }      
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
    @Override
    public boolean inicializar(String nomePlugin,INucleo nucleo)
    {
        nucleo.getUiControle().addMenu("Jogadores");
        JMenuItem itemQuadrado =  nucleo.getUiControle().addMenuItem("Jogadores", "Quadrado");
        JMenuItem itemCirulo   =  nucleo.getUiControle().addMenuItem("Jogadores", "Circulo");
        nucleo.getUiControle().addMenu("Preenchimento");
        JMenuItem itemPreUniforme = nucleo.getUiControle().addMenuItem("Preenchimento", "Uniforme Azul");
        JMenuItem itemPreSombra = nucleo.getUiControle().addMenuItem("Preenchimento", "Sombra");
        this.addPrototipo("Bola");
        this.addPrototipo("Campo");
        this.addPrototipo("Time");
        this.addPrototipo("Regras");
        this.nucleo = nucleo;
        nucleo.getIJogoControle().adicionarFabrica(nomePlugin,this);
        
        itemPreUniforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPreUniformeActionPerformed(evt);
            }
        });
        
        itemPreSombra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPreSombraActionPerformed(evt);
            }
        });
        
        itemQuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuadradoActionPerformed(evt);
            }
        });
        
        itemCirulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCiruloActionPerformed(evt);
            }
        });
        return true;
    }
    private void itemPreUniformeActionPerformed(java.awt.event.ActionEvent evt) 
    {                                           
        nucleo.getIJogoControle().setPreenchimentoDoTime("Uniforme Azul");
    }
    private void itemPreSombraActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        nucleo.getIJogoControle().setPreenchimentoDoTime("Radial");
    }
    private void itemQuadradoActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        nucleo.getIJogoControle().setFormaDoTime("Quadrado");
    }
    private void itemCiruloActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        nucleo.getIJogoControle().setFormaDoTime("Circulo");
    }
    private HashMap<String,IPrototipo> nomeProdutos = new HashMap<>();
    private INucleo nucleo;
}

