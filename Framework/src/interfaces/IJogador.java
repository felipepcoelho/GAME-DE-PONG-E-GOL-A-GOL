
package interfaces;

import java.awt.Color;


public interface IJogador
{
    public int getPosicaoX();
    public int getPosicaoY();
    public int getLargura();
    public int getAltura();
    public int getVelocidade();
    public Color getCor();
    public void setPosicaoX(int posicaoX);
    public void setPosicaoY(int posicaoY);
    public void setLargura(int largura);
    public void setAltura(int altura);
    public void setVelocidade(int velocidade);
    
}
