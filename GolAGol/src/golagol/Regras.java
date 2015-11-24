package golagol;
import interfaces.IPrototipo;
import interfaces.IRegras;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Regras implements IRegras,IPrototipo
{
    public Regras()
    {
        pontuacaoJogador1 = 0;
        pontuacaoJogador2 = 0;
        contadorPartida = 0;
        pontuacaoMaxima = 10;
    }
    public Regras(Regras regras)
    {
        this.pontuacaoJogador1 = regras.pontuacaoJogador1;
        this.pontuacaoJogador2 = regras.pontuacaoJogador2;
        this.contadorPartida = regras.contadorPartida;
        this.pontuacaoMaxima = regras.pontuacaoMaxima;
    }
    public void exibirPontuacaoJogadores(Graphics2D g)
    {
        if(contadorPartida == 1) novaPartida();
        g.setFont(new Font("Arial", 1, 30));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(pontuacaoJogador1), 900 / 2 - 80, 50);
        g.drawString(String.valueOf(pontuacaoJogador2), 900 / 2 + 25, 50);
        if(pontuacaoJogador1 ==  pontuacaoMaxima){
           g.drawString("Fim de jogo - Jogador 1 venceu !!!",150, 100); 
           contadorPartida = 1;
        }
        if(pontuacaoJogador2 ==  pontuacaoMaxima){
           g.drawString("Fim de jogo - Jogador 2 venceu !!!",150, 100);
           contadorPartida = 1;
        }
    }
    private void novaPartida()
    {
        try {
            Thread.sleep(3000);
            contadorPartida = 0;
            restartarJogo();
        }catch (InterruptedException ex) {
            Logger.getLogger(Regras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void restartarJogo()
    {
        pontuacaoJogador1 = 0;
        pontuacaoJogador2 = 0;
        pontuacaoMaxima = 10;
    }
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
        jogador.setPosicaoY(300 / 2 - jogador.getAltura() / 2);
        return jogador;
    }
    public Jogador posicionarJogador2(Jogador jogador)
    {
        jogador.setPosicaoX(900 - jogador.getLargura());
        jogador.setPosicaoY(300 / 2 - jogador.getAltura() / 2);
        return jogador;
    }
    public Jogador posicionarJogador3(Jogador jogador)
    {
        jogador.setPosicaoX(0);
        jogador.setPosicaoY(150 / 2 - jogador.getAltura() / 2);
        return jogador;
    }
    public int verificarColisaoBolaJogador(Jogador jogador,int numJogador,Bola bola)
    {
        if (bola.getPosicaoX() < jogador.getPosicaoX() + jogador.getLargura() && bola.getPosicaoX() + bola.getRaio() > jogador.getPosicaoX() && bola.getPosicaoY() < jogador.getPosicaoY() + jogador.getAltura() && bola.getPosicaoY()+ bola.getDiametro() > jogador.getPosicaoY()) return 1;
        else if ((jogador.getPosicaoX() > bola.getPosicaoX() && numJogador == 1) || (jogador.getPosicaoX() < bola.getPosicaoX() - bola.getRaio() && numJogador == 2)) return 2;
        return 0;
    }
    @Override
    public IPrototipo clone()
    {
        return new Regras(this);
    }
    
    @Override
    public void lancarBoomerangJogador1(int posicaoX, int posicaoY) {
       
    }

    @Override
    public void lancarBoomerangJogador2(int posicaoX, int posicaoY) {
        
    }
    
        @Override
    public int getPontuacaoJogador1() {
       return pontuacaoJogador1;
    }

    @Override
    public int getPontuacaoJogador2() {
        return pontuacaoJogador2;
    }
    
    private static int pontuacaoJogador1;
    private static int pontuacaoJogador2;
    private static int pontuacaoMaxima,contadorPartida;
}
