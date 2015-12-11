
package pong;

import interfaces.IPlanoCartesiano;
import interfaces.IStrategyMovimentacao;


public class MovimentoEmFuriaStrategy implements IStrategyMovimentacao{

    @Override
    public IPlanoCartesiano lancarObjeto(IPlanoCartesiano ObjPlanoAtual) {
        IPlanoCartesiano plano = new PlanoCartesiano();
        plano.setPosicaoX(plano.getPosicaoX()+30);
       return plano;
    }
    
}
