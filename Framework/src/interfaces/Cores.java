package interfaces;
import java.awt.Color;
import java.util.Random;

public class Cores 
{    
    public static Color gerarCorRandomica()
    {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return  new Color(r, g, b);
    }
}
