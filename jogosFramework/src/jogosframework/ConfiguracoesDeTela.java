package jogosframework;

public class ConfiguracoesDeTela 
{
    private ConfiguracoesDeTela()
    {
        largura = 615;
        altura = 615;
    }
    
    public static ConfiguracoesDeTela getInstantica(){
        if(instancia == null){
            instancia = new ConfiguracoesDeTela();
        }
        return instancia;
    }
    
    public void setLargura(int largura){
        this.largura = largura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    
    public int getLargura(){
        return this.largura;
    }
    public int getAltura(){
        return this.altura;
    }
    
    public int aumentarLagura(int valor){
       return this.largura += valor;
    }
    public int aumentarAltura(int valor){
       return this.altura += valor;
    }
    
    private static ConfiguracoesDeTela instancia;
    private int largura;
    private int altura;
}
