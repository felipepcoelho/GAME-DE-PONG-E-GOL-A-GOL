package pong;
import interfaces.ICommand;
import interfaces.IPrototipo;
import interfaces.IRegras;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Regras implements Observer, IRegras, IPrototipo 
{    
    public void atuliazarPontuacaoJogador1()
    {
        this.pontuacaoJogador1 ++;
    }
    public void atualizarPontuacaoJogador2()
    {
        this.pontuacaoJogador2 ++;
    }
    public Jogador posicionarJogador1(Jogador jogador)
    {
        jogador.setPosicaoX(0);
        jogador.setPosicaoY(600 / 2 - jogador.getAltura() / 2);
        return jogador;
    }
    public Jogador posicionarJogador2(Jogador jogador)
    {
        jogador.setPosicaoX(800 - jogador.getLargura());
        jogador.setPosicaoY(600 / 2 - jogador.getAltura() / 2);
        return jogador;
    }
    public int verificarColisaoBolaJogador(Jogador jogador,int numJogador,Bola bola)
    {
        if (bola.getPosicaoX() < jogador.getPosicaoX() + jogador.getLargura() && bola.getPosicaoX() + bola.getRaio() > jogador.getPosicaoX() && bola.getPosicaoY() < jogador.getPosicaoY() + jogador.getAltura() && bola.getPosicaoY()+ bola.getDiametro() > jogador.getPosicaoY()) return 1;
        else if ((jogador.getPosicaoX() > bola.getPosicaoX() && numJogador == 1) || (jogador.getPosicaoX() < bola.getPosicaoX() - bola.getRaio() && numJogador == 2)) return 2;
        return 0;
    }
    
    public void exibirPontuacaoJogadores(Graphics2D g)
    {
        carregarImagemVencedor();
        if(contadorPartida == 1) try {
            novaPartida(g);
        } catch (IOException ex) {
            Logger.getLogger(Regras.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.setFont(new Font("Arial", 1, 30));
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(pontuacaoJogador1), 800 / 2 - 75, 40);
        g.drawString(String.valueOf(pontuacaoJogador2), 800 / 2 + 60, 45);
        exibirBonusJogador(g);
        try {
            verificaJogador1Vencedor(g);
        } catch (IOException ex) {
            Logger.getLogger(Regras.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            verificaJogador2Vencedor(g);
        } catch (IOException ex) {
            Logger.getLogger(Regras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void verificaJogador2Vencedor(Graphics2D g) throws IOException
    {
        if(pontuacaoJogador2 ==  pontuacaoMaxima){
            g.drawImage(imagemJogado2Vencedor, 0, 0, null);
            RelatorioDePartidaJogarPong rel = new RelatorioDePartidaJogarPong(this);
            jogadorVencedor = 2;
            contadorPartida = 1;
        }
    }
    private void verificaJogador1Vencedor(Graphics2D g) throws IOException
    {
        if(pontuacaoJogador1 ==  pontuacaoMaxima){
            g.drawImage(imagemJogado1Vencedor, 0, 0, null);
            RelatorioDePartidaJogarPong rel = new RelatorioDePartidaJogarPong(this);
            jogadorVencedor = 1;
            contadorPartida = 1;
        }
    }
    private void carregarImagemVencedor()
    {
        String jogadorVencedor1 = "../jogosFramework/img/jogador1V.png"; 
        Toolkit toolkit1 = 
        Toolkit.getDefaultToolkit();
        imagemJogado1Vencedor = toolkit1.getImage(jogadorVencedor1);
        
        String jogadorVencedor2 = "../jogosFramework/img/jogador2V.png"; 
        Toolkit toolkit2 = 
        Toolkit.getDefaultToolkit();
        imagemJogado2Vencedor = toolkit2.getImage(jogadorVencedor2);
    }
    private void exibirBonusJogador(Graphics2D g)
    {
        g.setFont(new Font("Arial", 1, 30));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(listaDeComandosJogador1.size()), 105, 42);
        g.drawString(String.valueOf(listaDeComandosJogador2.size()), 690, 42);
        exibirItensBonus(g);
    }
    private void exibirItensBonus(Graphics2D g)
    {
        if(boomerangJogador1 != null)
        {
            boomerangJogador1.exibirBoomerang(g,1);
            boomerangJogador1.executar();
            if(boomerangJogador1.verificaLimiteMapa(1)){
              listaDeComandosJogador1.remove(boomerangJogador1);
              boomerangJogador1 = null;
            }
        }
        if(boomerangJogador2 != null)
        {
            boomerangJogador2.exibirBoomerang(g,2);
            boomerangJogador2.executar();
            if(boomerangJogador2.verificaLimiteMapa(2)){
              listaDeComandosJogador2.remove(boomerangJogador2);
              boomerangJogador2 = null;
            }
        }
    }
    public void lancarBoomerangJogador1(int posicaoX, int posicaoY)
    {
      if(boomerangJogador1 == null)
      {
        if(listaDeComandosJogador1.size() > 0){
         boomerangJogador1 = (AdicionarCommand) listaDeComandosJogador1.get(listaDeComandosJogador1.size() -1);
         boomerangJogador1.posicaoAtual(130, posicaoY,1);
        }
      }
          
    }
    public void lancarBoomerangJogador2(int posicaoX, int posicaoY)
    {
     if(boomerangJogador2 == null)
     {
        if(listaDeComandosJogador2.size() > 0){
           boomerangJogador2 = (AdicionarCommand) listaDeComandosJogador2.get(listaDeComandosJogador2.size() -1);
           boomerangJogador2.posicaoAtual(670, posicaoY,2);
        }
      }
    }
    public Regras()
    {
        pontuacaoJogador1 = 0;
        pontuacaoJogador2 = 0;
        contadorPartida = 0;
        pontuacaoMaxima = 5;
        
        listaDeComandosJogador1 = new ArrayList<ICommand>();
        listaDeComandosJogador2 = new ArrayList<ICommand>();
        this.listaDeComandosJogador1 = adicionarBoomerangParaJogador(3,listaDeComandosJogador1,false);
        this.listaDeComandosJogador2 = adicionarBoomerangParaJogador(3,listaDeComandosJogador2,false);
    }
    
    @Override
    public void update(Observable arg0, Object arg1)  {
       Jogador jogador = (Jogador) arg0;
       int quantidade = (int) arg1;
       if(jogador.getNome().equals("Jogador1") && jogador.getFuriaJogador().getFuria() == 3)
            this.listaDeComandosJogador1 = adicionarBoomerangParaJogador(quantidade,listaDeComandosJogador1,true);
       else if(jogador.getNome().equals("Jogador2") && jogador.getFuriaJogador().getFuria() == 3)
            this.listaDeComandosJogador2 = adicionarBoomerangParaJogador(quantidade,listaDeComandosJogador2,true);
    }
    
    private ArrayList<ICommand> adicionarBoomerangParaJogador(int quantidade,ArrayList<ICommand> lista,boolean estadoFuria)
    {
        for(int i=0; i < quantidade;++i)
        {
            AdicionarCommand obj;
            if(estadoFuria == false)
                obj = new AdicionarCommand( new Boomerang());
            else
                obj = new AdicionarCommand( new Boomerang(true));
            lista.add(obj);
        }
        return lista;
    }
    private Regras(Regras regras)
    {
        this.pontuacaoJogador1 = regras.pontuacaoJogador1;
        this.pontuacaoJogador2 = regras.pontuacaoJogador2;
        this.contadorPartida = regras.contadorPartida;
        this.pontuacaoMaxima = regras.pontuacaoMaxima;
    }
    private void novaPartida(Graphics2D g) throws IOException
    {
        verificaJogador1Vencedor(g);
        verificaJogador2Vencedor(g);
            try {
                Thread.sleep(5000);
                restartarJogo();
                contadorPartida = 0;
            } catch (InterruptedException ex) {
                Logger.getLogger(Regras.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void restartarJogo()
    {
        pontuacaoJogador1 = 0;
        pontuacaoJogador2 = 0;
        pontuacaoMaxima = 5;
        listaDeComandosJogador1 = new ArrayList<ICommand>();
        listaDeComandosJogador2 = new ArrayList<ICommand>();
        this.listaDeComandosJogador1 = adicionarBoomerangParaJogador(3,listaDeComandosJogador1,false);
        this.listaDeComandosJogador2 = adicionarBoomerangParaJogador(3,listaDeComandosJogador2,false);
    }
    @Override
    public IPrototipo clone() {
        return new Regras(this);
    }
    
    public int getPontuacaoJogador1(){
        return pontuacaoJogador1;
    }
    
    public int getPontuacaoJogador2(){
        return pontuacaoJogador2;
    }
    
    private static int pontuacaoJogador1;
    private static int pontuacaoJogador2;
    private AdicionarCommand boomerangJogador1;
    private AdicionarCommand boomerangJogador2;
    private static ArrayList<ICommand> listaDeComandosJogador1;
    private static ArrayList<ICommand> listaDeComandosJogador2;
    private static int pontuacaoMaxima,contadorPartida;
    private static  Image imagemJogado1Vencedor;
    private static  Image imagemJogado2Vencedor;
    private int jogadorVencedor;
}
