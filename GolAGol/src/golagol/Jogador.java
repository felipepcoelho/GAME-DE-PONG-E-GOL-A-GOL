package golagol;
import interfaces.Cores;
import interfaces.IJogador;
import java.awt.Color;

public class Jogador implements IJogador
{    
    public Jogador()
    {
        this.largura = 45;
        this.altura =  45;
        this.posicaoX = 0;
        this.posicaoY = 0;
        this.velocidade = 5;
        cor = Cores.gerarCorRandomica();
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
    
    private int posicaoX;
    private int posicaoY;
    private int largura; 
    private int altura;
    private int velocidade;
    private final Color cor;
}
