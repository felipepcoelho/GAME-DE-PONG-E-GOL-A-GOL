package pong;
import interfaces.IPrototipo;
import interfaces.ITime;
import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Time implements ITime,IPrototipo,IVisualComponente
{
    public Time()
    {
        jogador1 = new Jogador();
        jogador2 = new Jogador();
        jogador1.setNome("Jogador1");
        jogador2.setNome("Jogador2");
        
    }
    public void moveraCima(boolean acima, int jogador)
    {
         if(jogador == 1) moverJogador1Cima(acima);
         else moverJogador2Cima(acima);
    }
    @Override
    public void exibir(Graphics2D g, int posicaoX, int posicaoY){
        exbirJogador2(g);
        exbirJogador1(g);
    }
    @Override
    public void exibir(Graphics2D g){
        decoratorJogador2(g);
        decoratorJogador1(g);
        bloqueioMovimento.tempoDoMovimentoBloqueado();
        jogador1.getFuriaJogador().exibir(g, 176, 37);
        jogador2.getFuriaJogador().exibir(g, 570, 37);
    }

    private void decoratorJogador2(Graphics2D g) {
        IVisualComponente pranchaDecorator = new PranchaJogador2Decorator(g, this, jogador2.getPosicaoX(), jogador2.getPosicaoY());
        pranchaDecorator.exibir(g, jogador2.getPosicaoX(), jogador2.getPosicaoY());
    }

    private void decoratorJogador1(Graphics2D g) {
        IVisualComponente capaceteDecorator = new CapaceteDecorator(g,this,jogador1.getPosicaoX(), jogador1.getPosicaoY());
        IVisualComponente oculosDecorator = new OculosDecorator(g,capaceteDecorator,jogador1.getPosicaoX(), jogador1.getPosicaoY());
        IVisualComponente pranchaDecorator = new PranchaJogador1Decorator(g, oculosDecorator, jogador1.getPosicaoX(), jogador1.getPosicaoY());
        pranchaDecorator.exibir(g, jogador1.getPosicaoX(), jogador1.getPosicaoY());
    }
    
    public void moverDireita(boolean direita, int jogador)
    {
    }
    
    private Time(Time time)
    {
        this.jogador1 = time.jogador1;
        this.jogador2 = time.jogador2;
        bloqueioMovimento = BloqueioMovimento.getInstanciaBloqueioMovimento();
    }
    private void exbirJogador1(Graphics2D g)
    {
        String jogador1ImgURL = "../jogosFramework/img/jogador1Pong.gif"; 
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgJogador1 = toolkit.getImage(jogador1ImgURL);
        g.drawImage(imgJogador1, jogador1.getPosicaoX(),jogador1.getPosicaoY(), null);
     }
    private void exbirJogador2(Graphics2D g)
    {
        String jogador2ImgURL = "../jogosFramework/img/jogador2Pong.png"; 
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imgJogador2 = toolkit.getImage(jogador2ImgURL);
        g.drawImage(imgJogador2, jogador2.getPosicaoX(),jogador2.getPosicaoY(), null);
    }
    
    public void posicionar()
    {
       Regras regraTime = new Regras();
       jogador1 = regraTime.posicionarJogador1(jogador1);
       jogador2 = regraTime.posicionarJogador2(jogador2);
     }
    
    private void moverJogador1Cima(boolean acima)
    {
      if(bloqueioMovimento.getJogadorBloqueioMovimento() != 1 && !bloqueioMovimento.movimentoBloqueado()){ 
        if (acima)
        {
            if (jogador1.getPosicaoY() - jogador1.getVelocidade() > 0) jogador1.setPosicaoY(jogador1.getPosicaoY()- jogador1.getVelocidade());  
            else jogador1.setPosicaoY(0);
        }
        else
        {
            if (jogador1.getPosicaoY() + jogador1.getAltura() + jogador1.getVelocidade() < 600) jogador1.setPosicaoY(jogador1.getPosicaoY() + jogador1.getVelocidade());
            else jogador1.setPosicaoY(600 - jogador1.getAltura());
        }
        bloqueioMovimento.informarPosicaoJogador1(jogador1.getPosicaoY());
      }
     }
    private void moverJogador2Cima(boolean acima)
    {
      if(bloqueioMovimento.getJogadorBloqueioMovimento() != 2 && !bloqueioMovimento.movimentoBloqueado()){ 
        if (acima)
        {
            if (jogador2.getPosicaoY() - jogador2.getVelocidade() > 0) jogador2.setPosicaoY(jogador2.getPosicaoY() - jogador2.getVelocidade());
            else jogador2.setPosicaoY(0);
        }
        else
        {
            if (jogador2.getPosicaoY() + jogador2.getAltura() + jogador2.getVelocidade() < 600) jogador2.setPosicaoY(jogador2.getPosicaoY() +jogador2.getVelocidade());
            else jogador2.setPosicaoY(600 - jogador2.getAltura());
        }
        bloqueioMovimento.informarPosicaoJogador2(jogador2.getPosicaoY());
      }
    }
    @Override
    public int getPosicaoJogador1()
    {
        return jogador1.getPosicaoY();
    }
    @Override
    public int getPosicaoJogador2()
    {
      return jogador2.getPosicaoY();
    }
    @Override
    public void setPosicaoJogador1(int posicaoy) 
    {
       jogador1.setPosicaoY(posicaoy);
    }
    @Override
    public void setPosicaoJogador2(int posicaoy)
    {
        jogador2.setPosicaoY(posicaoy); 
    }
    public Jogador getJogador1()
    {
        return jogador1;
    }
    public void setJogador1(Jogador jogador1)
    {
        this.jogador1 = jogador1;
    }
    public Jogador getJogador2()
    {
        return jogador2;
    }
    @Override
    public void setFormaTime(String nome) 
    {
    }
    public void setJogador2(Jogador jogador2)
    {
        this.jogador2 = jogador2;
    }
    @Override
    public IPrototipo clone()
    {
        return new Time(this);
    }
    @Override
    public void setPincel(String nome)
    {
    }
    @Override
    public int getPosicaoJogador3() 
    {
       return 0;
    }
    @Override
    public void setPosicaoJogador3(int posicaoy)
    {
    }
    @Override
    public void selecionarGrupoJogadorDoTime()
    {
    }
    @Override
    public void removerGrupoDeJogador()
    {
    }
    
    private BloqueioMovimento bloqueioMovimento;
    private Image imgJogador1;
    private Image imgJogador2;
    private Jogador jogador1;
    private Jogador jogador2;
}
