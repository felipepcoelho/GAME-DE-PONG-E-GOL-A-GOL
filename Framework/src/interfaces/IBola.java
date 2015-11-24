
package interfaces;

import java.awt.Graphics;

public interface IBola {
    public void construir(Graphics g);
    public void atualizarPosicao(ITime time);
    public void regras(IRegras regras);
    public int getPosicaoY();
}
