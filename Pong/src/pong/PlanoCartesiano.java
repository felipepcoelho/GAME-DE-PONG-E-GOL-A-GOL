
package pong;

import interfaces.IPlanoCartesiano;

public class PlanoCartesiano implements IPlanoCartesiano{

    public PlanoCartesiano(){
        this.posicaoX = 0;
        this.posicaoY = 0;
    }
    
    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
    private int posicaoX;
    private int posicaoY;
}
