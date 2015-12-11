
package pong;

public class BloqueioMovimento 
{
    private BloqueioMovimento()
    {
        this.movimentoBloqueado = false;
        this.tempo = 0;
    }
    
    public void informarPosicaoJogador1(int posicaoJogador1Y){
        this.posicaoJogador1Y = posicaoJogador1Y;
        verificarBloqueioMovimentoJogador(posicaoJogador1Y,this.posicaoBonusAtingirJogador1Y,1);
    }
    
    public void informarPosicaoJogador2(int posicaoJogador2Y){
        this.posicaoJogador2Y = posicaoJogador2Y;
        verificarBloqueioMovimentoJogador(posicaoJogador2Y,this.posicaoBonusAtingirJogador2Y,2);
    }
    
    public void informarPosicaoBonusAtingirJogador1(int posicaoBonusAtingirJogador1Y){
        this.posicaoBonusAtingirJogador1Y = posicaoBonusAtingirJogador1Y;
        verificarBloqueioMovimentoJogador(posicaoJogador1Y,posicaoBonusAtingirJogador1Y,1);
    }
    
    public void informarPosicaoBonusAtingirJogador2(int posicaoBonusAtingirJogador2Y){
        this.posicaoBonusAtingirJogador2Y = posicaoBonusAtingirJogador2Y;
        verificarBloqueioMovimentoJogador(posicaoJogador2Y,posicaoBonusAtingirJogador2Y,2);
    }
    
    private void verificarBloqueioMovimentoJogador(int posicaoJogador, int projetilInimigo, int jogador){
           if( posicaoJogador == projetilInimigo || 
              (posicaoJogador + 93)  == projetilInimigo ||
              (posicaoJogador - 93)  == projetilInimigo ){
               bloquearMovimento();
               jogadorMovimentoBloqueado = jogador;
           }
    }
    
    private void bloquearMovimento(){
        this.movimentoBloqueado = true;
    }
    
    public void jogadorBloqueioMovimento(int jogador){
        this.jogadorMovimentoBloqueado = jogador;
    }
    
    public int getJogadorBloqueioMovimento(){
        return this.jogadorMovimentoBloqueado;
    }
    
    public boolean movimentoBloqueado(){
        return this.movimentoBloqueado;
    }
    
    public void tempoDoMovimentoBloqueado(){
        if(this.movimentoBloqueado == true){ 
            this.tempo += 5;
                if(tempo == 300){
                  this.movimentoBloqueado = false;
                  jogadorMovimentoBloqueado = 0;
                  this.tempo = 0;
                }
        }
    }
    
    public static BloqueioMovimento getInstanciaBloqueioMovimento()
    {
        if(instancia == null)
            return new BloqueioMovimento();
        else
            return instancia;
    }
    
    private static BloqueioMovimento instancia;
    private static int jogadorMovimentoBloqueado;
    private static int posicaoJogador1Y,posicaoJogador2Y;
    private static int posicaoBonusAtingirJogador1Y,posicaoBonusAtingirJogador2Y;
    private static int tempo;
    private static boolean movimentoBloqueado;
}
