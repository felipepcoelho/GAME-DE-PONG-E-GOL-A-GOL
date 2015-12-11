
package pong;

import interfaces.IVisitable;
import interfaces.IVisitor;


public class VisitorCalcularQuantidadeDeProteinas implements IVisitor {
	public void visit(IVisitable visitable){
		if(visitable instanceof Alimento){
                    Alimento alimento = (Alimento) visitable;
                    double quantidade = 0.0;
                    //SUPONDO QUE SEJA DESSA FORMA O CALCULO DA QUANTIDADE DE PROTEINAS DE UM ALIMENTO
                    quantidade = alimento.getPorcao() - (alimento.getCarboidratos() / alimento.getPorcao());
                    alimento.setProteinas(quantidade);
                    
		}
	}
}