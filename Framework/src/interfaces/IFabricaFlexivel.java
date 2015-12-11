
package interfaces;

public interface IFabricaFlexivel 
{
    IPrototipo criar(String nome);
    boolean addPrototipo(String nome);
    boolean removerPrototipo(String nome);
    boolean removerTodosPrototipos();
}
