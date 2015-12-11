package pong;
import interfaces.IBola;
import interfaces.IPrototipo;
import interfaces.IRegras;
import interfaces.ITime;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;


public class Bola implements IBola,IPrototipo
{
    public void atualizarPosicao(ITime time)
    {
        Time timeJogador = (Time) time;
        timeJogador.getJogador1().addObserver(regra);
        timeJogador.getJogador2().addObserver(regra);
        int velocidade = 5;
        this.posicaoX += movimentoX * velocidade;
        this.posicaoY += movimentoY * velocidade;
        if (this.posicaoY + diamentro - movimentoY > 600 || this.posicaoY + movimentoY < 0)
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
                this.posicaoY = 600 - diamentro;
                if (movimentoY == 0)movimentoY = -1;
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
            if (movimentoY == 0)movimentoY = 1;
            quantidadeDeAcessos++;
        }
        if (verificaColisao(timeJogador.getJogador1(),1) == 2)
        {
            regra.atualizarPontuacaoJogador2();
            timeJogador.getJogador1().setFuriaJogador(1);
            lancar();
        }
        else if (verificaColisao(timeJogador.getJogador2(),2) == 2)
        {
            regra.atuliazarPontuacaoJogador1();
             timeJogador.getJogador2().setFuriaJogador(1);
            lancar();
        }
    }
    public void construir(Graphics g)
    {
        String bola = "../jogosFramework/img/macaBola.png"; 
        Toolkit toolkit = 
            Toolkit.getDefaultToolkit();
          imagem = toolkit.getImage(bola);
        g.drawImage(imagem, posicaoX, posicaoY, raio, diamentro, null);
        exibirInformacaoNutricionalBola(g);
    }
    
   private void exibirInformacaoNutricionalBola(Graphics g){
       g.setFont(new Font("Arial", 1, 12));
       g.setColor(Color.DARK_GRAY);
       g.drawString(bola.getNome(),207, 425);
       g.drawString(String.valueOf(bola.getValorEnegetico()),207, 445);
       g.drawString(String.valueOf(bola.getProteinas()),244, 468);
   }
    
    public void regras(IRegras regras)
    {
        regra =(Regras)regras;
    }
    public Bola()
    {
       this.random = new Random();
       this.raio = 40;
       this.diamentro = 40;
       this.bola = new Alimento("Maçã", 100, 60);
       bola.accept(new VisitorCalcularQuantidadeDeProteinas());
       bola.accept(new VisitorCalcularValorEnergetico());
       lancar();
    }
    private Bola(Bola bola) 
    {
       this.random = bola.random;
       this.raio = bola.raio;
       this.diamentro = bola.diamentro;
       lancar();
    }
    private void lancar()
    {
        this.quantidadeDeAcessos = 0;
        this.posicaoX = 800 / 2 - this.raio / 2;
        this.posicaoY = 600 / 2 - this.diamentro / 2;
        this.movimentoY = -2 + random.nextInt(4);
        if (movimentoY == 0) movimentoY = 1;
        if (random.nextBoolean()) movimentoX = 1;
        else movimentoX = -1;
    }
    private int verificaColisao(Jogador jogador,int numJogador)
    {
        return regra.verificarColisaoBolaJogador(jogador, numJogador, this);
    }
    @Override
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
    
    private Image imagem;
    private int posicaoX,posicaoY,raio,diamentro,quantidadeDeAcessos,movimentoX,movimentoY;
    private Random random;
    private Regras regra;
    private static Alimento bola;


}
