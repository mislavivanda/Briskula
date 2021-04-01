package briskula;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
public class Spil {
    private static final Karta NULL = null;
	private Karta spil[]=new Karta[40];
    private int vrh=0;
    public Spil() throws IOException
    {
        String[] vrsta={"As","Trica","Kralj","Konj","Fanat","7","6","5","4","2"};
        String[] zog={"Spade","Kupe","Dinari","Bastoni"};
        int Jakost[]={10,9,8,7,6,5,4,3,2,1};
        int Punti[]={11,10,4,3,2,0,0,0,0,0};
        final int visina=146;/* final=konstanta ne moze se mijenjat*/
        final int sirina=80;
        BufferedImage buff=ImageIO.read(new File("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\briskula.png"));
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<10;j++)
            {
                BufferedImage temp=buff.getSubimage(j*sirina,i*visina, sirina, visina);
                Image prava=temp.getScaledInstance(130, 245, Image.SCALE_DEFAULT);
                spil[i*10+j]=new Karta(vrsta[j],zog[i],Jakost[j],Punti[j],prava);
            }
            
        }
    }
    public void mjesaj()
    {
    Random rand=new Random();
    for(int j=0;j<40;j++)
    {
       int x=rand.nextInt(40);
        Karta temp2=spil[x];
        spil[x]=spil[j];
        spil[j]=temp2;
    }		
    }
    public Karta vrhspila()
    {
    	if(this.vrh<=39)
    	{
    		return spil[vrh++];
    		
    	}
    	else return NULL;
    }
    public void ispis()
    {
        JFrame prozor=new JFrame("Briskula2");
        prozor.setSize(1000,1000);
        prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        prozor.setVisible(true);
        panel.setSize(900,900);
        
        try {
			BufferedImage buff=ImageIO.read(new File("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\poledina.jpg"));
			JLabel label2=new JLabel(new ImageIcon(buff));
			label2.setSize(130, 245);
			panel.setLayout(null);
			label2.setBounds(250, 200, 130, 245);/* za ispisat na odredenoj poziciji na ekranu*/
			panel.add(label2);
			 prozor.add(panel);
             prozor.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
   
}
