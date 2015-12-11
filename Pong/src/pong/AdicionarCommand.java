
package pong;

import interfaces.ICommand;
import java.awt.Graphics2D;

public class AdicionarCommand  implements ICommand{
    
    public AdicionarCommand(Boomerang boomerang){
        this.boomerang = boomerang;
    }
    
    public void posicaoAtual(int posicaoX,int posicaoY, int jogador){
        boomerang.posicaoAtual(posicaoX, posicaoY, jogador);
    }
    
    @Override
    public void executar()
    {
        boomerang.lancar(10, jogador);
    }
    
    public void exibirBoomerang(Graphics2D g, int jogador){
        boomerang.construir(g,jogador);
        this.jogador = jogador;
    }
    
    public boolean verificaLimiteMapa(int jogador)
    {
        return boomerang.verificaLimiteMapa(jogador);
    }
    
    private Boomerang boomerang;
    private int jogador;
}
