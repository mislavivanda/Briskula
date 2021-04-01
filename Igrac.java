package briskula;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Igrac {
public int punti=0;
public int odigrana;
private Karta igrac[]=new Karta[3];
public Igrac(Karta k1,Karta k2,Karta k3)
{
	igrac[0]=k1;
	igrac[1]=k2;
	igrac[2]=k3;
}
public Karta novakarta(Karta nova)
{
	igrac[odigrana]=nova;
	return igrac[odigrana];
}
public Karta igraj(int i)
{
	odigrana=i-1;
	return igrac[i-1];
}
}

