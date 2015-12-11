package jogosframework;

import interfaces.IUiControle;
import interfaces.IVisualComponente;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UiControle implements IUiControle,IVisualComponente
{
    public static UiControle getInstancia()
    {
        if(instancia == null)
            instancia = new UiControle();
        return instancia;
    }
    public boolean addMenu(String menuName)
    {
        JMenu menu = new JMenu(menuName);
        menuBar.add(menu);
        jframe.setVisible(true);
        return true;
    }
    public JMenuItem addMenuItem(String menuName, String menuItem)
    {
        int counter = menuBar.getMenuCount();
        JMenu menu = null;
        for (int i = 0; i < counter; i++) {
            if (menuBar.getMenu(i).getText().equals(menuName)) {
                menu = menuBar.getMenu(i);
                break;
            }
        }
        if (menu == null)
            return null;
        JMenuItem item = new JMenuItem(menuItem);
        menu.add(item);
        jframe.setVisible(true);
        return item;
    }
    public void adicionarKeyListener()
    {
        jframe.addKeyListener(jogoControle);
    }
    public void renderizar(Graphics2D g)
    {
       if(jogoControle.statusTelaMenu())textoMenuPrincipal(g);
       else
          if(jogoControle.quantidadeDeJogosInstalados() > 0) jogoControle.atualizarProdutos(g);   
       AtualizaTela();
    }
    public void removerBarraMenu()
    {
        menuBar.removeAll();
        jframe.remove(menuBar);
        jframe.setVisible(true);
    }
    private UiControle()
    {
        jframe = new JFrame("JOGOS DE QUADRA E BOLA");
        menuBar = new JMenuBar();
        jframe.setJMenuBar(menuBar);  
        jframe.setLayout(new BorderLayout());
        renderizador = renderizador.getInstanciaRenderizador();
        jframe.setSize(ConfiguracoesDeTela.getInstantica().getLargura()+15, ConfiguracoesDeTela.getInstantica().getAltura()+28);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(renderizador);
        jogoControle = jogoControle.getInstanciaJogoControle();
        adicionarKeyListener();
    }
    private void AtualizaTela()
    {
        jframe.setSize(ConfiguracoesDeTela.getInstantica().getLargura() + 6, ConfiguracoesDeTela.getInstantica().getAltura() + 52);
    }
    @Override
    public void exibir(Graphics2D g, int posicaoX, int posicaoY)
    {
        String menuPrincipal = "../jogosFramework/img/menuPrincipalBG.png"; 
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        menuPrincipalImg = toolkit.getImage(menuPrincipal);
        g.drawImage(menuPrincipalImg, 0, 0, null);
        g.setFont(new Font("Arial", 1, 25));
        g.setColor(Color.DARK_GRAY);
        int i = 0;
        for(String chave: jogoControle.getPlugins().keySet()){
              g.drawString(i+1+" - "+chave,120, 245 + i*30);
              localizacao = 235 + i*30;
              i++;
        }
        if(i == 0){
              g.drawString("Nenhum Jogo Instalado",120, 245 + i*30);
              localizacao = 245 + i*30;
              i++;
        }
        g.setColor(Color.DARK_GRAY);
        g.fillRect(ConfiguracoesDeTela.getInstantica().getLargura() - 545,localizacao +20 ,490,45);
        g.setColor(Color.WHITE);
        i = 0;
        for(String chave: jogoControle.getPlugins().keySet()){
            if(i == jogoControle.valorContadorDeJogos()){
                g.drawString("SELECIONE: <-"+ chave +" ->",120, localizacao + 50);
                jogoControle.setChaveSelecionada(chave);
            }
            i++;
        }
    }
    private void textoMenuPrincipal(Graphics2D g)
    {
        IVisualComponente logoTopo = new LogoTopoDecorator(g, instancia, 0, 0);
        IVisualComponente bonecoVermelho = new BonecoVermelhoMenuDecorator(g, logoTopo, 0, 0);
        IVisualComponente placaInfoDisciplina = new PlacaInfoDecorator(g, bonecoVermelho, 20, 440);
        IVisualComponente botaoEnterMenu = new BotaoEnterDecorator(g, placaInfoDisciplina, 0, 557);
        IVisualComponente regrasControle = new RegrasControleDecorator(g, botaoEnterMenu, 186, 439);
        IVisualComponente bonecoNegro = new BonecoNegroMenuDecorator(g, regrasControle, 170, 488);
        IVisualComponente furiaAtivada = new FuriaAtivadaDecorator(g, bonecoNegro, 500, 431);
        IVisualComponente furiaDesativada = new FuriaDesativadaDecorator(g, furiaAtivada, 15, 92);
        furiaDesativada.exibir(g,498 , 92 );
    }
    
    private static UiControle instancia;
    private JogoControle jogoControle;
    private JFrame jframe;
    private JMenuBar menuBar;
    private Image menuPrincipalImg;
    private Renderizador renderizador;
    private int localizacao;
}
