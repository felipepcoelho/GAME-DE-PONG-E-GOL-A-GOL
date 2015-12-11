
package pong;

import interfaces.IVisitable;
import interfaces.IVisitor;

public class Alimento implements IVisitable
{
    public Alimento(String nome, double porcaoGramas,double carboidratos){
        this.nome = nome;
        this.porcao = porcaoGramas;
        this.carboidratos = carboidratos;
    }
    
    public void setDescricao(String descricao){
            this.nome = descricao;
    }
    public String getDescricao(){
            return this.nome;
    }
    
    public void accept(IVisitor visitor){
            visitor.visit(this);
    }
        
    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    public double getGordurasTotais() {
        return gordurasTotais;
    }

    public void setGordurasTotais(double gordurasTotais) {
        this.gordurasTotais = gordurasTotais;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getValorEnegetico() {
        return valorEnegetico;
    }

    public void setValorEnegetico(double valorEnegetico) {
        this.valorEnegetico = valorEnegetico;
    }
    
    private String nome;
    private double carboidratos;
    private double proteinas;
    private double valorEnegetico;
    private double porcao;
    private double gordurasTotais;

}