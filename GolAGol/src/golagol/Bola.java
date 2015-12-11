package golagol;
import interfaces.IBola;
import interfaces.IPrototipo;
import interfaces.IRegras;
import interfaces.ITime;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bola implements IBola,IPrototipo
{
    public void atualizarPosicao(ITime time)
    {
        Time timeJogador = (Time) time;
        int velocidade = 3;
        this.posicaoX += movimentoX * velocidade;
        this.posicaoY += movimentoY * velocidade;
        if (this.posicaoY + diamentro - movimentoY > 300 || this.posicaoY + movimentoY < 0)
        {
            if (this.movimentoY < 0)
            {
                this.posicaoY = 0;
                this.movimentoY = random.nextInt(4);
                if (movimentoY == 0) movimentoY = 1;
            }
            else
            {
                this.movimentoY = -random.nextInt(4);
                this.posicaoY = 300 - diamentro;
                if (movimentoY == 0) movimentoY = -1;
            }
        }

        if (verificaColisao(timeJogador.getJogador1(),1) == 1)
        {
                this.movimentoX = 1 + (quantidadeDeAcessos / 5);
                this.movimentoY = -2 + random.nextInt(4);
                if (movimentoY == 0) movimentoY = 1;
                quantidadeDeAcessos++;
        }
        else if (verificaColisao(timeJogador.getJogador2(),2) == 1)
        {
                this.movimentoX = -1 - (quantidadeDeAcessos / 5);
                this.movimentoY = -2 + random.nextInt(4);
                if (movimentoY == 0) movimentoY = 1;
                quantidadeDeAcessos++;
        }
            if (verificaColisao(timeJogador.getJogador1(),1) == 2)
            {
                regra.atualizarPontuacaoJogador2();
                lancar();
            }
            else if (verificaColisao(timeJogador.getJogador2(),2) == 2)
            {
                regra.atuliazarPontuacaoJogador1();
                lancar();
            }
	}
    public void construir(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(posicaoX, posicaoY, raio, diamentro);
    }
    public void regras(IRegras regras)
    {
        regra =(Regras)regras;
    }
    public Bola()
    {
       this.random = new Random();
       this.raio = 25;
       this.diamentro = 25;
       lancar();
    }
    public Bola(Bola bola)
    {
       this.random = bola.random;
       this.raio = bola.raio;
       this.diamentro = bola.diamentro;
       lancar();
    }
    public int getPosicaoY()
    {
       return posicaoY;
    }
    public int getPosicaoX()
    {
        return posicaoX;
    }
    public int getDiametro()
    {
        return diamentro;
    }
    public int getRaio()
    {
        return raio;
    }
    @Override
    public IPrototipo clone()
    {
        return new Bola(this);
    }
    private void lancar()
    {
        this.quantidadeDeAcessos = 0;
        this.posicaoX = 900 / 2 - this.raio / 2;
        this.posicaoY = 300 / 2 - this.diamentro / 2;
        this.movimentoY = -2 + random.nextInt(4);
        if (movimentoY == 0) movimentoY = 1;
        if (random.nextBoolean())  movimentoX = 1;
        else movimentoX = -1;
    }
    private int verificaColisao(Jogador jogador,int numJogador)
    {
        return regra.verificarColisaoBolaJogador(jogador, numJogador, this);
    }
      
    private int posicaoX,posicaoY,raio,diamentro,quantidadeDeAcessos,movimentoX,movimentoY;
    private Random random;
    private Regras regra;
}
