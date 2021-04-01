package briskula;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Karta {
	private String imekarte;
    private int jakost;
    private int punti;
    private String vrsta;
    private Image slikakarte;
    public Karta(String imekarte,String vrsta,int jakost,int punti,Image slikakarte)
    {
        this.imekarte=imekarte;
        this.vrsta=vrsta;
        this.jakost=jakost;
        this.punti=punti;
        this.slikakarte=slikakarte;
    }
    
    public String tostring()
    {
        return imekarte+ " "+ vrsta;
    }
    public String vrsta()
    {
        return this.vrsta;
    }
    public String ime()
    {
        return this.imekarte;
    }
    public String briskula()
    {
        return vrsta;
    }
    public int punti()
    {
        return this.punti;
    }
    public int jakost()
    {
        return this.jakost;
    }
    public JLabel donjastrana() throws IOException
    {
    	BufferedImage buff=ImageIO.read(new File("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\poledina.jpg"));
        JLabel donja=new JLabel(new ImageIcon(buff));
        return donja;
    }
    public JLabel okrenikartu()
    {
       JLabel gornja=new JLabel(new ImageIcon(this.dohvatikartu()));
       return gornja;
    }
    public Icon lice() {
    	Icon nova=new ImageIcon(this.slikakarte);
    	return nova;
    }
    public Icon poledina() throws IOException {
     BufferedImage straga=ImageIO.read(new File("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\poledina.jpg"));
    	Icon a=new ImageIcon(straga);
    	return a;
    }
 
    public Image dohvatikartu()
    {
        return slikakarte;
    }
    
}
