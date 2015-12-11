package interfaces;

import java.awt.Graphics2D;

public interface IRegras {
    public void exibirPontuacaoJogadores(Graphics2D g);
    public void lancarBoomerangJogador1(int posicaoX, int posicaoY);
    public void lancarBoomerangJogador2(int posicaoX, int posicaoY);
    public int getPontuacaoJogador1();
    public int getPontuacaoJogador2();
}
