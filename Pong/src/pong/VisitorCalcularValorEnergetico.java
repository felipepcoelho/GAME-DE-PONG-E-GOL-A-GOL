
package pong;

import interfaces.IVisitable;
import interfaces.IVisitor;


public class VisitorCalcularValorEnergetico implements IVisitor {
	public void visit(IVisitable visitable){
		if(visitable instanceof Alimento){
                    Alimento alimento = (Alimento) visitable;
                    double valorKcal = 0.0;
                    valorKcal = (alimento.getCarboidratos()/2) * 10.2;
                    alimento.setValorEnegetico(valorKcal);
		}
	}
}
