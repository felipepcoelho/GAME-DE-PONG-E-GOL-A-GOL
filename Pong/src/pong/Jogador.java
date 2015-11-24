package pong;
import interfaces.IStrategyMovimentacao;
import java.awt.Color;
import java.util.Observable;

public class Jogador extends Observable
{
    public Jogador()
    {
        this.largura = 124;
        this.altura = 138;
        this.posicaoX = 0;
        this.posicaoY = 0;
        this.velocidade = 10;
        this.furia = new Furia();
        cor = Cores.gerarCorRandomica();
    }
    
    public void setFuriaJogador(int quantidade) {
		furia.setFuria(quantidade);
		setChanged();
		notifyObservers(quantidade);
    }
    
    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public Color getCor() {
        return cor;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public Furia getFuriaJogador() {
        return furia;
    }
    
    public void setStrategy(IStrategyMovimentacao strategy){
    
    }
    
    private int posicaoX;
    private int posicaoY;
    private int largura; 
    private int altura;
    private int velocidade;
    private String nome;
    private Furia furia;
    private final Color cor;
    private IStrategyMovimentacao strategy;
}
