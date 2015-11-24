package golagol;
import interfaces.Forma;
import interfaces.IComponente;
import interfaces.IPincel;
import interfaces.IPrototipo;
import interfaces.ITime;
import java.awt.Graphics2D;

public class Time implements ITime,IPrototipo
{
    public Time()
    {
       jogador1 = new Jogador();
       jogador2 = new Jogador();
       jogador3 = new Jogador();
       composicaoJogador = new ComposicaoDeJogadores();
       composicaoJogador.add(jogador1);
    }
    public Time(Time time)
    {
       this.jogador1 = time.jogador1;
       this.jogador2 = time.jogador2;
       this.jogador3 = time.jogador3;
    }
    public void exibir(Graphics2D g)
    {
        exibirJogador1(g);
        exibirJogador2(g);
        exibirJogador3(g);
    }
    private void exibirJogador1(Graphics2D g)
    {
        forma.setPincel(pincel);
        forma.preencher(g);
        forma.desenhar(jogador1.getPosicaoX(), jogador1.getPosicaoY(), jogador1.getLargura(), jogador1.getAltura(),g);
                
    }  
    private void exibirJogador2(Graphics2D g)
    {
        forma.setPincel(pincel);
        forma.preencher(g);
        forma.desenhar(jogador2.getPosicaoX(), jogador2.getPosicaoY(), jogador2.getLargura(), jogador2.getAltura(),g);
                
    }
    private void exibirJogador3(Graphics2D g)
    {
        forma.setPincel(pincel);
        forma.preencher(g);
        forma.desenhar(jogador3.getPosicaoX(), jogador3.getPosicaoY(), jogador3.getLargura(), jogador3.getAltura(),g);
    }
    public void posicionar()
    {
       Regras regraTime = new Regras();
       jogador1 = regraTime.posicionarJogador1(jogador1);
       jogador2 = regraTime.posicionarJogador2(jogador2);
       jogador3 = regraTime.posicionarJogador3(jogador3);
     }
    public void moveraCima(boolean acima, int jogador)
    {   
       if(jogador == 1) moverJogador1Cima(acima);
         else moverJogador2Cima(acima);
    }
    private void moverJogador1Cima(boolean acima)
    {
        IComponente jogadores = (IComponente) composicaoJogador;
        jogadores.moverParaCima(acima);
     
     }
    private void moverJogador2Cima(boolean acima)
    {
        if (acima)
        {
            if (jogador2.getPosicaoY() - jogador2.getVelocidade() > 0) jogador2.setPosicaoY(jogador2.getPosicaoY() - jogador2.getVelocidade());
            else jogador2.setPosicaoY(0);
        }
        else
        {
            if (jogador2.getPosicaoY() + jogador2.getAltura() + jogador2.getVelocidade() < 300) jogador2.setPosicaoY(jogador2.getPosicaoY() +jogador2.getVelocidade());
            else jogador2.setPosicaoY(300 - jogador2.getAltura());
        }
     }
    private void moverJogador3Cima(boolean acima)
    {
        if (acima)
        {
            if (jogador3.getPosicaoY() - jogador3.getVelocidade() > 0) jogador3.setPosicaoY(jogador3.getPosicaoY()- jogador3.getVelocidade());  
            else jogador3.setPosicaoY(0);
        }
        else
        {
            if (jogador3.getPosicaoY() + jogador3.getAltura() + jogador3.getVelocidade() < 300) jogador3.setPosicaoY(jogador3.getPosicaoY() + jogador3.getVelocidade());
            else jogador3.setPosicaoY(300 - jogador3.getAltura());
        }
    }
    public void moverDireita(boolean direita,int jogador)
    {      
       if(jogador == 1) moverDireitaJogador1(direita);
       else moverDireitaJogador2(direita);
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
    public int getPosicaoJogador3()
    {
      return jogador3.getPosicaoY();
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
    @Override
    public void setPosicaoJogador3(int posicaoy)
    {
        jogador3.setPosicaoY(posicaoy);
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
    public void setJogador2(Jogador jogador2)
    {
        this.jogador2 = jogador2;
    }
    public void setFormaTime(String nome)
    {
        if(nome.equals("Circulo"))
            forma = new Circulo();
        else
            forma = new Quadrado();
    }
    public void setPincel(String nome)
    {
        if(nome.equals("Uniforme Azul"))
            pincel = new PreenchimentoUniformeAzul();
        else
            pincel = new PreenchimentoSombra();
    } 
    @Override
    public IPrototipo clone()
    {
        return new Time(this);
    }
    public void selecionarGrupoJogadorDoTime()
    {
        composicaoJogador.add(jogador3);
    }
    public void removerGrupoDeJogador()
    {
        composicaoJogador.remover(jogador3);
    }
    private void moverDireitaJogador1(boolean direita)
    {
       IComponente jogadores = (IComponente) composicaoJogador;
        jogadores.moverParaLados(direita);
    }
    private void moverDireitaJogador2(boolean direita)
    {
        if (direita)
        {
            if (jogador2.getPosicaoX() - jogador2.getVelocidade() > 0 && jogador2.getPosicaoX() - jogador2.getVelocidade() > 545) 
                jogador2.setPosicaoX(jogador2.getPosicaoX() - jogador2.getVelocidade());
            else jogador2.setPosicaoX(550);
	}else
        {
            if (jogador2.getPosicaoX() + jogador2.getLargura() + jogador2.getVelocidade() < 900 - jogador2.getLargura()) 
                jogador2.setPosicaoX(jogador2.getPosicaoX() + jogador2.getVelocidade());
            else jogador2.setPosicaoX(900 - jogador2.getLargura());
        }
    }
    private void moverDireitaJogador3(boolean direita)
    {
        if (direita)
        {
            if (jogador3.getPosicaoX() - jogador3.getVelocidade() > 0 ) 
                jogador3.setPosicaoX(jogador3.getPosicaoX() - jogador3.getVelocidade() );
            else jogador3.setPosicaoX(0);
        }
        else
        {
            if (jogador3.getPosicaoX() + jogador3.getLargura() + jogador3.getVelocidade() < 350) 
                jogador3.setPosicaoX(jogador3.getPosicaoX() +jogador3.getVelocidade());
            else jogador3.setPosicaoX(350  - jogador3.getLargura());
        }   
    }
    
    private Jogador jogador1;
    private Jogador jogador2; 
    private Jogador jogador3;
    private Forma forma;
    private IPincel pincel;
    private static ComposicaoDeJogadores composicaoJogador;
}
