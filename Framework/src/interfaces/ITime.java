
package interfaces;

import java.awt.Graphics2D;


public interface ITime {
     public void posicionar();
     public int getPosicaoJogador1();
     public int getPosicaoJogador2();
     public int getPosicaoJogador3();
     public void setPosicaoJogador1(int posicaoy);
     public void setPosicaoJogador2(int posicaoy);
     public void setPosicaoJogador3(int posicaoy);
     public void exibir(Graphics2D g);
     public void moveraCima(boolean acima, int jogador);
     public void moverDireita(boolean direita,int jogador);
     public void setFormaTime(String nome);
     public void setPincel(String nome);
     public void selecionarGrupoJogadorDoTime();
     public void removerGrupoDeJogador();
}
