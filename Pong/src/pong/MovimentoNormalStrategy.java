
package pong;

import interfaces.IPlanoCartesiano;
import interfaces.IStrategyMovimentacao;


public class MovimentoNormalStrategy implements IStrategyMovimentacao{

    @Override
    public IPlanoCartesiano lancarObjeto(IPlanoCartesiano ObjPlano) {
       return ObjPlano;
    }
}
