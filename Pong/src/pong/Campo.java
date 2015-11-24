package pong;
import interfaces.ICampo;
import interfaces.IPrototipo;
import interfaces.IVisualComponente;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Campo implements ICampo,IPrototipo, IVisualComponente
{
    @Override
    public void exibir(Graphics2D g, int posicaoX, int posicaoY) {
       mostraMapa(g);
    }
    
    public void exibir(Graphics2D g)
    {
       IVisualComponente nuvens = new NuvensDecorator(g, this, 0, 0);
       IVisualComponente placar = new PlacarDecorator(g, nuvens, 0, 100);
       IVisualComponente moinho = new MoinhoDecorator(g, placar, 0, 0);
       IVisualComponente traves = new TravesDecorator(g, moinho, 500, 328);
       IVisualComponente infoNutricional = new InformacaoNutricionalDecorator(g, traves, 350, 339);
       infoNutricional.exibir(g, 143, 395);
    }

    private void mostraMapa(Graphics2D g) {
        String campo = "../jogosFramework/img/mapaPingPong.png";
        Toolkit toolkit =
                Toolkit.getDefaultToolkit();
        imagem = toolkit.getImage(campo);
        g.drawImage(imagem, 0, 0, null);
    }
    @Override
    public int largura() {
       return larguraDoCampo;
    }
    @Override
    public int altura() {
        return alturaDoCampo;
    }
    public Campo()
    {
        alturaDoCampo = 600;
        larguraDoCampo = 800;
    }
     private Campo(Campo campo)
     {
        this.alturaDoCampo = campo.alturaDoCampo;
        this.larguraDoCampo = campo.larguraDoCampo;
     }
     @Override
    public IPrototipo clone() {
        return new Campo(this);
    }
    private Image imagem;
    public final int larguraDoCampo;
    public final int alturaDoCampo;   


}
