package briskula;

import javax.swing.JLabel;
import java.util.Random;
public class Komp {
	public int punti=0;
	public int odigrana;
	public int zadnja=0;
	private Karta komp[]=new Karta[3];
	public Komp(Karta k1,Karta k2,Karta k3)
	{
		komp[0]=k1;
		komp[1]=k2;
		komp[2]=k3;
	}
	public Karta novakarta(Karta nova)
	{
		komp[odigrana]=nova;
		return komp[odigrana];
		}
	public Karta igraj()
	{
		Random rand=new Random();
		odigrana=rand.nextInt(3);
		return komp[odigrana];
	}
	public Karta igrajzadnja()
	{
		return komp[zadnja++];
	}
}
