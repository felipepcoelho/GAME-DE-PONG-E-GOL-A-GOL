
package golagol;

import interfaces.IComponente;
import interfaces.IComposicaoJogador;
import interfaces.IJogador;
import java.util.ArrayList;

public class ComposicaoDeJogadores implements IComposicaoJogador,IComponente
{
    public ComposicaoDeJogadores()
    {
        listComposicao = new ArrayList<IJogador>();
    }
    public void add(IJogador jogador)
    {
      if(!listComposicao.contains(jogador))
         listComposicao.add(jogador);
    }
    public void remover(IJogador jogador)
    {
      if(listComposicao.contains(jogador))
        listComposicao.remove(jogador);
    }
    public void remover()
    {
        listComposicao.clear();
    }
    @Override
    public void moverParaCima(boolean acima)
    {
       for(IJogador jogador: listComposicao){
          if (acima)
        {
            if (jogador.getPosicaoY() - jogador.getVelocidade() > 0) jogador.setPosicaoY(jogador.getPosicaoY()- jogador.getVelocidade());  
            else jogador.setPosicaoY(0);
        }
        else
        {
            if (jogador.getPosicaoY() + jogador.getAltura() + jogador.getVelocidade() < 300) jogador.setPosicaoY(jogador.getPosicaoY() + jogador.getVelocidade());
            else jogador.setPosicaoY(300 - jogador.getAltura());
        }
       }
    }
    public void moverParaLados(boolean direita)
    {
        for(IJogador jogador: listComposicao){
         if (direita)
        {
            if (jogador.getPosicaoX() - jogador.getVelocidade() > 0 ) 
                jogador.setPosicaoX(jogador.getPosicaoX() - jogador.getVelocidade() );
            else jogador.setPosicaoX(0);
        }
        else
        {
            if (jogador.getPosicaoX() + jogador.getLargura() + jogador.getVelocidade() < 350) 
                jogador.setPosicaoX(jogador.getPosicaoX() +jogador.getVelocidade());
            else jogador.setPosicaoX(350  - jogador.getLargura());
        }      
       }
    }
  
    private ArrayList<IJogador> listComposicao ;
}
