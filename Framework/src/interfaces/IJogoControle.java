
package interfaces;

import java.awt.Graphics2D;
import java.net.URLClassLoader;
import java.util.HashMap;

public interface IJogoControle
{
    public void adicionarFabrica(String nomeFabrica,IFabricaFlexivel fabrica);
    public void atualizarProdutos(Graphics2D g);
    public HashMap<String,IFabricaFlexivel> fabricasDeJogos();
    public int valorContadorDeJogos();
    public void setChaveSelecionada(String chave);
    public boolean statusTelaMenu();
    public int quantidadeDeJogosInstalados();
    public HashMap<String,URLClassLoader> getPlugins();
    public void setPluginsHM(HashMap<String,URLClassLoader> pluginsHM);
    public void setFormaDoTime(String nome);
    public void setPreenchimentoDoTime(String nome);
    public boolean getStatusCtrl();
}
