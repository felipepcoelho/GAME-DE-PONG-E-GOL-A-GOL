package jogosframework;

import interfaces.IBola;
import interfaces.ICampo;
import interfaces.IFabricaFlexivel;
import interfaces.IJogoControle;
import interfaces.IPlugin;
import interfaces.IRegras;
import interfaces.ITime;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class JogoControle implements IJogoControle , ActionListener, KeyListener
{
    public static JogoControle getInstanciaJogoControle()
    {
        if(instancia == null)
            instancia = new JogoControle();
        return instancia;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(telaMenu == false) update();
        renderizador = renderizador.getInstanciaRenderizador();
        renderizador.repaint();    
        try {
            JogosFramework.carregarPlugins();
        } catch (Exception ex) {
            Logger.getLogger(JogoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke)
    {
    }
    
    @Override
    public void keyPressed(KeyEvent ke)
    {
        int id = ke.getKeyCode();
        if (id == KeyEvent.VK_W) w = true;
        if (id == KeyEvent.VK_CONTROL){ 
            time.selecionarGrupoJogadorDoTime();
            ctrl = true;
        }
        if(id == KeyEvent.BUTTON1_MASK){
            time.removerGrupoDeJogador();
            shift = true;
        }
        else if (id == KeyEvent.VK_S) s = true;
        else if(id == KeyEvent.VK_A) a = true;
        else if(id == KeyEvent.VK_D)d = true;
        else if (id == KeyEvent.VK_UP) up = true;
        else if (id == KeyEvent.VK_DOWN) down = true;
        else if(id == KeyEvent.VK_ESCAPE)
        {    
            telaMenu = true;
            ConfiguracoesDeTela.getInstantica().setLargura(615);
            ConfiguracoesDeTela.getInstantica().setAltura(615);
            Nucleo.getInstancia().getUiControle().removerBarraMenu();
            try {
            JogosFramework.carregarPlugins();
            Nucleo.getInstancia().getIJogoControle().setPluginsHM(pluginsHM);
        } catch (Exception ex) {
            Logger.getLogger(JogoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }else if (id == KeyEvent.VK_RIGHT)
        {
            if(telaMenu)
            {
                if (contadorDeJogos < contadorDeJogosMaximo-1) contadorDeJogos++;
                else contadorDeJogos = 0;
            }else right = true;
            
        }
        else if (id == KeyEvent.VK_LEFT)
        {
            if(telaMenu){
                if (contadorDeJogos > 0)contadorDeJogos--;
                else contadorDeJogos = 0;
            }else left = true;
        }
        else if (id == KeyEvent.VK_ENTER)
        {
            try {
                if(telaMenu){
                inicializarPlugin(chaveSelecionada);
                criarProdutos(fabricas.get(chaveSelecionada));
                time.setFormaTime("Circulo");
                time.setPincel("Uniforme Azul");
                telaMenu = false;
                }
            } catch (Exception ex) {
                Logger.getLogger(JogoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(id == KeyEvent.VK_0){
            this.regras.lancarBoomerangJogador2(ConfiguracoesDeTela.getInstantica().getLargura(),time.getPosicaoJogador2());
        }else if(id == KeyEvent.VK_F){
            this.regras.lancarBoomerangJogador1(0,this.time.getPosicaoJogador1());
        }
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
        switch(ke.getKeyCode())
        {
            case 87:w = false;
            case 83:s = false;
            case 38:up = false;
            case 65:a = false;
            case 68:d = false;
            case 40:down = false;
            case 37:left = false;
            case 39:right = false;
            case 16:shift = false;
            case 17:ctrl = false;
            case 48:zero = false;
            case 70:f = false;
                
        }
    }
    
    @Override
    public void adicionarFabrica(String nomeFabrica, IFabricaFlexivel fabrica)
    {
       fabricas.put(nomeFabrica,fabrica);
       contadorDeJogosMaximo = fabricas.size();
    }
    
    @Override
    public void atualizarProdutos(Graphics2D g)
    {
        campo.exibir(g);
        bola.construir(g);
        time.exibir(g);
        regras.exibirPontuacaoJogadores(g);
    }
    
    public void setPluginsHM(HashMap<String,URLClassLoader> pluginsHM)
    {
        this.pluginsHM = pluginsHM;
        contadorDeJogosMaximo = pluginsHM.size();
    }
    
    private void inicializarPlugin(String nome) throws Exception
    {
        for(String chave: pluginsHM.keySet()){
                  if(chave.equals(nome)){
                     IPlugin plugin = (IPlugin) Class.forName(nome.toLowerCase()+"."+ nome, true, pluginsHM.get(chave)).newInstance();
                     if (plugin != null)
                         plugin.inicializar(nome,Nucleo.getInstancia());
                  }    
            }
    }
    
    public void adicionarChaveSelecionada(String s)
    {
        this.chaveSelecionada = s;
    }
    
    public HashMap<String,IFabricaFlexivel> fabricasDeJogos()
    {
        return fabricas;
    }
    
    public int valorContadorDeJogos()
    {
        return contadorDeJogos;
    }
    
    public void setChaveSelecionada(String chave)
    {
        this.chaveSelecionada = chave;
    }
    
    public boolean statusTelaMenu()
    {
        return telaMenu;
    }
    
    public int quantidadeDeJogosInstalados()
    {
        return pluginsHM.size();
    }
    
    public HashMap<String,URLClassLoader> getPlugins(){
        return pluginsHM;
    }
    
    private JogoControle()
    {
       Timer timer = new Timer(20,this);
       timer.start();
       fabricas = new HashMap<>();
       telaMenu = true;
    }
    
    private void criarProdutos(IFabricaFlexivel fabrica)
    {
         campo = (ICampo) fabrica.criar("Campo");
         ConfiguracoesDeTela.getInstantica().setAltura(campo.altura());
         ConfiguracoesDeTela.getInstantica().setLargura(campo.largura());
         bola    = (IBola) fabrica.criar("Bola");
         time   = (ITime) fabrica.criar("Time");
         time.posicionar();
         regras = (IRegras) fabrica.criar("Regras");
         bola.regras(regras);
     }
    
    private void atualizarBola()
    {
        bola.atualizarPosicao(time);
    }
    
    private void update()
    {
        jogador1();
        jogador2();
        atualizarBola();
    }
        
    private void jogador1()
    {
        if(w != null)if(w)time.moveraCima(true,1); 
        if(s != null)if(s)time.moveraCima(false,1);
        if(a != null)if(a)time.moverDireita(true,1);
        if(d != null)if(d)time.moverDireita(false,1);
    }
    
    private void jogador2()
    { 
        if(up != null)if(up) time.moveraCima(true,2) ;
        if(down != null)if(down)time.moveraCima(false,2);
        if(left != null)if(left)time.moverDireita(true,2);
        if(right != null)if(right)time.moverDireita(false,2);
    }
    
    public void setFormaDoTime(String nome)
    {
        time.setFormaTime(nome);
    }
    
    public void setPreenchimentoDoTime(String nome)
    {
        time.setPincel(nome);
    }
    
    public boolean getStatusCtrl(){
        return ctrl;
    }
    
    private static JogoControle instancia;
    private IBola bola;
    private ICampo campo;
    private ITime time;
    private IRegras regras;
    private HashMap<String,IFabricaFlexivel> fabricas;
    private Renderizador renderizador;
    private Boolean w,s,up,a,d,down,right,left,ctrl,shift,telaMenu,zero,f;
    private int contadorDeJogos = 0,contadorDeJogosMaximo;
    private String chaveSelecionada;
    private HashMap<String,URLClassLoader> pluginsHM;
}
