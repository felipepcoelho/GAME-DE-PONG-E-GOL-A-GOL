package pong;

import interfaces.IPlanoCartesiano;
import interfaces.IStrategyMovimentacao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Boomerang
{
    public Boomerang(){
        this.largura = 60;
        this.altura = 60;
        bloqueioMovimento = BloqueioMovimento.getInstanciaBloqueioMovimento();
    }
    
    public Boomerang(boolean estadoFuria){
        this.largura = 60;
        this.altura = 60;
        this.bloqueioMovimento = BloqueioMovimento.getInstanciaBloqueioMovimento();
        this.estadoFuria = estadoFuria;
    }
    
    public void construir(Graphics g,int jogador)
    {
        String boomerang;
        if(jogador == 1)
            boomerang = "../jogosFramework/img/boomerangJogador1.png";
        else
            boomerang = "../jogosFramework/img/boomerangJogador2.png";
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          imagem = toolkit.getImage(boomerang);
        g.drawImage(imagem, posicaoAtualX, posicaoAtualY, largura, altura, null);
    }
    
    public void posicaoAtual(int x, int y, int jogador){
        posicaoAtualX = x;
        posicaoAtualY = y;
       if(jogador == 1)
           bloqueioMovimento.informarPosicaoBonusAtingirJogador2(posicaoAtualY);
       else
           bloqueioMovimento.informarPosicaoBonusAtingirJogador1(posicaoAtualY);
    }
    
    public void lancar(int x, int jogador){
       this.plano = new PlanoCartesiano();
        if(this.estadoFuria == true)
            this.setStrategy(new MovimentoEmFuriaStrategy());
       else
            this.setStrategy(new MovimentoNormalStrategy());
       plano.setPosicaoX(x);
       plano.setPosicaoY(posicaoAtualY);
       if(jogador == 1){
         plano = this.lancarObjetoNoPlano(plano);
         posicaoAtualX += plano.getPosicaoX();
       }else{
         plano = this.lancarObjetoNoPlano(plano);
         posicaoAtualX -= plano.getPosicaoX();
       }
    }
    
    public boolean verificaLimiteMapa(int jogador){
        if(jogador == 1)
        {
            if(posicaoAtualX > 800)
                return true;
            else
                return false;
        }
        else
        {
            if(posicaoAtualX < 0)
                return true;
            else
                return false;
        }
    }
    
    public void setStrategy(IStrategyMovimentacao strategy){
        this.tipoMovimentacao = strategy;
    }
    
    public IPlanoCartesiano lancarObjetoNoPlano(IPlanoCartesiano plano){
         return this.tipoMovimentacao.lancarObjeto(plano);
    }

    public int getPosicaoAtualX() {
        return posicaoAtualX;
    }
    
    private BloqueioMovimento bloqueioMovimento;
    private boolean estadoFuria;
    private int posicaoAtualX;
    private int posicaoAtualY;
    private IPlanoCartesiano plano;
    private final int largura,altura;
    private Image imagem;
    private IStrategyMovimentacao tipoMovimentacao;
}
