package briskula;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
public class BRISKULA {
	protected static final Karta NULL = null;
	public static int potezi=0;
	public static int peska=0;
	public int klikkarta=0;
	public int prviigra;
	public boolean kliknut=false;
	JLabel odigranaigrac=new JLabel();
	JLabel odigranakomp=new JLabel();
	JButton novaigra=new JButton();
	public JPanel panela=new JPanel();
	public int pobjednikruke=1;
	public String briskula;
	public Karta brisk;
	public JFrame frame = new JFrame();
	public boolean mouselistener=true;
	public boolean pesk=false;
	public Karta temp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BRISKULA window = new BRISKULA();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public BRISKULA() throws IOException, InterruptedException {
		initialize();
	}
	
	 public int provjera(Karta k1,Karta k2)/* vodit racuna o briskuli vrati 0 ako je komp k1=komp k2=igrac*/
	    {
			if(k1.vrsta()==briskula&&k2.vrsta()==briskula) {
				if(k1.jakost()>k2.jakost()){
					return 0;
	            }
				else return 1;
            }
			else if(k1.vrsta()==briskula&&k2.vrsta()!=briskula) {
				return 0;
            }
			else if(k1.vrsta()!=briskula&&k2.vrsta()==briskula) {
					return 1;
				}
			else if(k1.vrsta()==k2.vrsta())
			{
				if(k1.jakost()>k2.jakost()) {
					return 0;
				}else return 1;
			}if(prviigra==0) {/*ako nije nijedan od ovih slucaja onda ide onome tko je prvi odigra*/
				return 0;
			}
			else return 1;
			 
	    }
	 public void novaigra(JLabel igrac1,JLabel igrac2,JLabel igrac3,JLabel komp1,JLabel komp2,JLabel komp3,JLabel spil,JLabel briskula1,JButton peskaj,JButton novaigra) throws IOException, InterruptedException
	    {
		 potezi=0;
		 peska=0;
		 klikkarta=0;
		 kliknut=false;
		 pobjednikruke=1;
		panela.remove(igrac1);
		panela.remove(igrac2);
		panela.remove(igrac3);
		panela.remove(komp1);
		panela.remove(komp2);
		panela.remove(komp3);
		panela.remove(spil);
		panela.remove(briskula1);
		panela.remove(peskaj);
		panela.remove(novaigra);
		 initialize();
	    }
	 
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	private void initialize() throws IOException, InterruptedException {
		frame.setTitle("Briskula");
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Spil karte=new Spil();
		karte.mjesaj();
		panela.setSize(800, 800);
		Karta GUI[]=new Karta[7];
		for(int i=0;i<7;i++)
			GUI[i]=karte.vrhspila();
		JLabel igrac1=GUI[0].okrenikartu();
		JLabel igrac2=GUI[1].okrenikartu();
		JLabel igrac3=GUI[2].okrenikartu();
		BufferedImage buff=ImageIO.read(new File("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\poledina.jpg"));
		JLabel spil=new JLabel(new ImageIcon(buff));
		JLabel komp1=GUI[3].donjastrana();
		JLabel komp2=GUI[4].donjastrana();
		JLabel komp3=GUI[5].donjastrana();
		JLabel briskula1=new JLabel(new ImageIcon(GUI[6].dohvatikartu()));
		briskula=GUI[6].briskula();
		brisk=new Karta(GUI[6].ime(),GUI[6].vrsta(),GUI[6].jakost(),GUI[6].punti(),GUI[6].dohvatikartu());
		Igrac igrac=new Igrac(GUI[0],GUI[1],GUI[2]);/* igrac i komp*/
		Komp komp=new Komp(GUI[3],GUI[4],GUI[5]);
		panela.setLayout(null);
		panela.setBackground(Color.green);
		igrac1.setBounds(350, 600, 130, 245);
		panela.add(igrac1);
		igrac2.setBounds(350+130, 600, 130, 245);
		panela.add(igrac2);
		igrac3.setBounds(350+260, 600, 130, 245);
		panela.add(igrac3);
		spil.setBounds(100, 300, 130, 245);
		panela.add(spil);
		briskula1.setBounds(250, 300, 130, 245);
		panela.add(briskula1);
		komp1.setBounds(350, 20, 130, 245);
		panela.add(komp1);
		komp2.setBounds(350+130, 20, 130, 245);
		panela.add(komp2);
		komp3.setBounds(350+260, 20, 130, 245);
		panela.add(komp3);
		JButton peskaj=new JButton();
		peskaj.setText("Peskaj");
		peskaj.setFont(new Font("Arial", Font.PLAIN, 20));
		peskaj.setSize(100, 100);
		peskaj.setBackground(Color.black);
		peskaj.setForeground(Color.white);
		peskaj.setBounds(800, 400, 100, 40);
		panela.add(peskaj);
		novaigra.setText("Nova igra");
		novaigra.setFont(new Font("Arial", Font.PLAIN, 20));
		novaigra.setSize(100, 100);
		novaigra.setBackground(Color.black);
		novaigra.setForeground(Color.white);
		novaigra.setBounds(800, 300, 150, 50);
		panela.add(novaigra);
		frame.add(panela);
	    frame.setVisible(true);
	    novaigra.addMouseListener(new MouseAdapter()
	    {
	        public void mousePressed(MouseEvent evt)
	        {
	        try {
				novaigra(igrac1,igrac2,igrac3,komp1,komp2,komp3,spil,briskula1,peskaj,novaigra);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	    });
		MouseListener botun = new MouseAdapter() {
		      public void mousePressed(MouseEvent mouseEvent) {
		    	  if(pesk==true) {
		    	  mouselistener=true;
		    	  if(peska==16) 
		    	spil.setVisible(false);
		    	  Karta temp1=karte.vrhspila();
		    	  Karta temp2=karte.vrhspila();
		    	  if(temp2==NULL) {
		    		  temp2=brisk;
		    		  briskula1.setVisible(false);
		    	  }
		    	  if(peska<17&&pobjednikruke==1)
		    	  {
		    		  peska++;
		    	if(klikkarta==1) {
		    		igrac1.setVisible(true);
		    		igrac1.setIcon(igrac.novakarta(temp1).lice());
		    		igrac1.setBounds(350, 600, 130, 245);
		    		igrac1.repaint();
		    		igrac1.setVisible(true);/* dilimo prvo igracu*/
		    	}else if(klikkarta==2) {
		    		igrac2.setVisible(true);
		    		igrac2.setIcon(igrac.novakarta(temp1).lice());
		    		igrac2.setBounds(350+130, 600, 130, 245);
		    		igrac2.repaint();
		    		igrac2.setVisible(true);
		    	}else { igrac3.setIcon(igrac.novakarta(temp1).lice());
		    	igrac3.setBounds(350+260, 600, 130, 245); igrac3.repaint();
		    	igrac3.setVisible(true);}
		    	if(komp.odigrana==0) {
		    		try {
						komp1.setIcon(komp.novakarta(temp2).poledina());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		komp1.setBounds(350, 20, 130, 245);
		    		komp1.repaint();
		    		komp1.setVisible(true);
		    	}else if(komp.odigrana==1){
		    		try {
						komp2.setIcon(komp.novakarta(temp2).poledina());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		komp2.setBounds(350+130, 20, 130, 245);
		    		komp2.repaint();
		    		komp2.setVisible(true);
		    	}else {
		    		try {
						komp3.setIcon(komp.novakarta(temp2).poledina());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		komp3.setBounds(350+260, 20, 130, 245);
		    		komp3.repaint();
		    		komp3.setVisible(true);
		    	}
		      	}
		    	  else if(peska<17&&pobjednikruke==0)/* dilimo prvo kompu*/
		      	{
		    		  peska++;
		    		  if(komp.odigrana==0) {
				    		try {
								komp1.setIcon(komp.novakarta(temp1).poledina());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    		komp1.setBounds(350, 20, 130, 245);
				    		komp1.repaint();
				    		komp1.setVisible(true);
				    	}else if(komp.odigrana==1){
				    		try {
								komp2.setIcon(komp.novakarta(temp1).poledina());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    		komp2.setBounds(350+130, 20, 130, 245);
				    		komp2.repaint();
				    		komp2.setVisible(true);
				    	}else {
				    		try {
								komp3.setIcon(komp.novakarta(temp1).poledina());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    		komp3.setBounds(350+260, 20, 130, 245);
				    		komp3.repaint();
				    		komp3.setVisible(true);
				    	}
		    		  if(klikkarta==1) {
				    		igrac1.setIcon(igrac.novakarta(temp2).lice());
				    		igrac1.setBounds(350, 600, 130, 245);
				    		igrac1.repaint();
				    		igrac1.setVisible(true);
				    	}else if(klikkarta==2) {
				    		igrac2.setIcon(igrac.novakarta(temp2).lice());
				    		igrac2.setBounds(350+130, 600, 130, 245);
				    		igrac2.repaint();
				    		igrac2.setVisible(true);
				    	}else { igrac3.setIcon(igrac.novakarta(temp2).lice());
				    	igrac3.setBounds(350+260, 600, 130, 245); igrac3.repaint();
				    	igrac3.setVisible(true);}
		    		 
		      	}
		      	else { peskaj.setEnabled(false);
		      	JOptionPane.showMessageDialog(null, "Spil prazan");}
		    	 pesk=false;/*da ne moze peskavat dok ne odigra*/
		    	 if(pobjednikruke==0) {
		    		 prviigra=0;/*komp prvi igra ako je dobio ruku zadnju*/
		    		 if(potezi>=34&&potezi<=40) {/*zadnja ruka sve isto kao u clicku radi*/
		    		temp=komp.igrajzadnja();
		    		 potezi++;
		    		 if(komp.zadnja==1) {
		    		odigranakomp=komp1;
             		komp1.setIcon(temp.lice());
             		komp1.setBounds(600, 300, 130,245);
             		komp1.repaint();
		    		 }else if(komp.zadnja==2) {
		    			odigranakomp=komp2;
		             	komp2.setIcon(temp.lice());
		             	komp2.setBounds(600, 300, 130,245);
		             	komp2.repaint();
		    		 }else {odigranakomp=komp3;
		             	komp3.setIcon(temp.lice());
		             	komp3.setBounds(600, 300, 130,245);
		             	komp3.repaint(); }
		    	 }else 	{/*igraj nomalno sve*/
		    		 potezi++;
		    		 temp=komp.igraj();
		    		 if(komp.odigrana==0) {
	                		odigranakomp=komp1;
	                		komp1.setIcon(temp.lice());
	                		komp1.setBounds(600, 300, 130,245);
	                		komp1.repaint();
	                	}else if(komp.odigrana==1) {
	                		odigranakomp=komp2;
	                		komp2.setIcon(temp.lice());
	                		komp2.setBounds(600, 300, 130,245);
	                		komp2.repaint();
	                	}else {odigranakomp=komp3;komp3.setBounds(600, 300, 130,245);
	                	komp3.setIcon(temp.lice()); komp3.repaint();}
		    	 }
		      }
		      }
		      }
		};
		peskaj.addMouseListener(botun);
		igrac1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(e.getSource() == igrac1) {
                	if(!kliknut) {
                	igrac1.setBounds(350, 600-30, 130, 245);
                	igrac2.setBounds(350+130, 600, 130, 245);
                	igrac3.setBounds(350+260, 600, 130, 245);
                	igrac1.repaint();
                	igrac2.repaint();
                	igrac3.repaint();
                	}
                }
            }
        });	
		igrac2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(e.getSource() == igrac2) {
                	if(!kliknut) {
                	igrac2.setBounds(350+130, 600-30, 130, 245);
                	igrac1.setBounds(350, 600, 130, 245);
                	igrac3.setBounds(350+260, 600, 130, 245);
                	igrac2.repaint();
                	igrac1.repaint();
                	igrac3.repaint();
                	}
                }
            }
        });	
		igrac3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(e.getSource() == igrac3) {
                	if(!kliknut) {
                	igrac3.setBounds(350+260, 600-30, 130, 245);
                	igrac1.setBounds(350, 600, 130, 245);
                	igrac2.setBounds(350+130, 600, 130, 245);
                	igrac3.repaint();
                	igrac1.repaint();
                	igrac2.repaint();
                	}
                }
            }
        });	
		igrac1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(mouselistener==true) {
                	pesk=false;/*ne mozes peskat sve dok ne zavrsi ruka*/
                	if(potezi>=34&&potezi<=40) {
                    	mouselistener=false;
                		potezi++;
                		odigranaigrac=igrac1;
                		igrac1.setBounds(400, 300, 130,245);
                    	igrac1.repaint();
                    	/*provjeri jeli odigra komp ako nije onda ovo radi*/
                    	Karta temp2=igrac.igraj(1);
                    	if(pobjednikruke==1) {/*komp nije igrao*/
                    	potezi++;             
                    		temp=komp.igrajzadnja();
                    		 if(komp.zadnja==1) {
             		    		odigranakomp=komp1;
                          		komp1.setIcon(temp.lice());
                          		komp1.setBounds(600, 300, 130,245);
                          		komp1.repaint();
             		    		 }else if(komp.zadnja==2) {
             		    			odigranakomp=komp2;
             		             	komp2.setIcon(temp.lice());
             		             	komp2.setBounds(600, 300, 130,245);
             		             	komp2.repaint();
             		    		 }else {odigranakomp=komp3;
             		             	komp3.setIcon(temp.lice());
             		             	komp3.setBounds(600, 300, 130,245);
             		             	komp3.repaint(); }
                    	}
                    	if(provjera(temp,temp2)==1) {
                    		igrac.punti=igrac.punti+temp.punti()+temp2.punti();
                    		pobjednikruke=1;
                    		prviigra=1;
                    	}
                    	else {komp.punti=komp.punti+temp.punti()+temp2.punti();
                    	pobjednikruke=0;
                    	prviigra=0;}
                    	ActionListener taskPerformer = new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                            	odigranaigrac.setVisible(false);
                            	odigranakomp.setVisible(false);
                            	kliknut=false;
                            	mouselistener=true;
                            	  if(potezi<40&&pobjednikruke==0) {/*odigraj ako je zadnja ruka komp jer ne moze ga vise botun peskaj reaktivirat*/
                                     	potezi++;             
                                 		temp=komp.igrajzadnja();
                                 		 if(komp.zadnja==1) {
                          		    		odigranakomp=komp1;
                                       		komp1.setIcon(temp.lice());
                                       		komp1.setBounds(600, 300, 130,245);
                                       		komp1.repaint();
                          		    		 }else if(komp.zadnja==2) {
                          		    			odigranakomp=komp2;
                          		             	komp2.setIcon(temp.lice());
                          		             	komp2.setBounds(600, 300, 130,245);
                          		             	komp2.repaint();
                          		    		 }else {odigranakomp=komp3;
                          		             	komp3.setIcon(temp.lice());
                          		             	komp3.setBounds(600, 300, 130,245);
                          		             	komp3.repaint(); }}
                            }
                        };
                        Timer timer=new Timer(3000, taskPerformer);
                        timer.start();
                       timer.setRepeats(false);
                    	System.out.println(komp.punti);
                    	System.out.println(igrac.punti);
                    	if(potezi==40) {
                    		ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\party.png");
                    	if(komp.punti>igrac.punti) {
                            JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Pobijedio je kompjutor.Cestitamo!!!", 
                                    "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                    	else if(komp.punti<igrac.punti) {
                    		 JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Pobijedili ste.Cestitamo!!!", 
                                     "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                    	else  JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Nema pobjednika.Jako napeta partija!!!", 
                                "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                		
                	}else {
                		potezi++;
                	igrac1.setBounds(400, 300, 130,245);
                	igrac1.repaint();
                	klikkarta=1;
                	odigranaigrac=igrac1;
                	Karta temp2=igrac.igraj(klikkarta);
                	if(pobjednikruke==1) {
                		potezi++;             
                		temp=komp.igraj();
                	if(komp.odigrana==0) {
                		odigranakomp=komp1;
                		komp1.setIcon(temp.lice());
                		komp1.setBounds(600, 300, 130,245);
                		komp1.repaint();
                	}else if(komp.odigrana==1) {
                		odigranakomp=komp2;
                		komp2.setIcon(temp.lice());
                		komp2.setBounds(600, 300, 130,245);
                		komp2.repaint();
                	}else {odigranakomp=komp3;komp3.setBounds(600, 300, 130,245);
                	komp3.setIcon(temp.lice()); komp3.repaint();}
                	}
                	if(provjera(temp,temp2)==1) {
                		igrac.punti=igrac.punti+temp.punti()+temp2.punti();
                		pobjednikruke=1;
                		prviigra=1;
                	}
                	else {komp.punti=komp.punti+temp.punti()+temp2.punti();pobjednikruke=0;prviigra=0;}
                	ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                        	odigranaigrac.setVisible(false);
                        	odigranakomp.setVisible(false);
                        	kliknut=false;
                        	pesk=true;
                        }
                    };
                    Timer timer=new Timer(3000, taskPerformer);
                    timer.start();
                   timer.setRepeats(false);
                	System.out.println(komp.punti);
                	System.out.println(igrac.punti);
                	mouselistener=false;/* onemoguæi klik dok ne peska*/
                }
                }else { ImageIcon icon2 = new ImageIcon("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\error.jfif");
                	JOptionPane.showMessageDialog(null,"Prvo peskajte kartu", 
                        "Obavijest", JOptionPane.INFORMATION_MESSAGE, icon2);}
                }});	
		igrac2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(mouselistener==true) {
                	pesk=false;
                	if(potezi>=34&&potezi<=40) {
                    	mouselistener=false;
                		potezi++;
                		odigranaigrac=igrac2;
                		igrac2.setBounds(400, 300, 130,245);
                    	igrac2.repaint();
                    	Karta temp2=igrac.igraj(2);
                    	if(pobjednikruke==1) {
                    	potezi++;
                    	 temp=komp.igrajzadnja();
                    	 if(komp.zadnja==1) {
         		    		odigranakomp=komp1;
                      		komp1.setIcon(temp.lice());
                      		komp1.setBounds(600, 300, 130,245);
                      		komp1.repaint();
         		    		 }else if(komp.zadnja==2) {
         		    			odigranakomp=komp2;
         		             	komp2.setIcon(temp.lice());
         		             	komp2.setBounds(600, 300, 130,245);
         		             	komp2.repaint();
         		    		 }else {odigranakomp=komp3;
         		             	komp3.setIcon(temp.lice());
         		             	komp3.setBounds(600, 300, 130,245);
         		             	komp3.repaint(); }

                    	}
                    	if(provjera(temp,temp2)==1) {
                    		igrac.punti=igrac.punti+temp.punti()+temp2.punti();
                    		pobjednikruke=1;
                    		prviigra=1;/*nebitno*/
                    	}
                    	else {komp.punti=komp.punti+temp.punti()+temp2.punti();
                    	pobjednikruke=0;
                    	prviigra=0;}
                    	ActionListener taskPerformer = new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                            	odigranaigrac.setVisible(false);
                            	odigranakomp.setVisible(false);
                            	kliknut=false;
                            	mouselistener=true;
                            	  if(potezi<40&&pobjednikruke==0) {
                                     	potezi++;             
                                 		temp=komp.igrajzadnja();
                                 		 if(komp.zadnja==1) {
                          		    		odigranakomp=komp1;
                                       		komp1.setIcon(temp.lice());
                                       		komp1.setBounds(600, 300, 130,245);
                                       		komp1.repaint();
                          		    		 }else if(komp.zadnja==2) {
                          		    			odigranakomp=komp2;
                          		             	komp2.setIcon(temp.lice());
                          		             	komp2.setBounds(600, 300, 130,245);
                          		             	komp2.repaint();
                          		    		 }else {odigranakomp=komp3;
                          		             	komp3.setIcon(temp.lice());
                          		             	komp3.setBounds(600, 300, 130,245);
                          		             	komp3.repaint(); }}

                            }
                        };
                        Timer timer=new Timer(3000, taskPerformer);
                        timer.start();
                       timer.setRepeats(false);                    	System.out.println(komp.punti);
                    	System.out.println(igrac.punti);
                    	if(potezi==40) {
                    		ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\party.png");
                    	if(komp.punti>igrac.punti) {
                            JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Pobijedio je kompjutor.Cestitamo!!!", 
                                    "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                    	else if(komp.punti<igrac.punti) {
                    		 JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Pobijedili ste.Cestitamo!!!", 
                                     "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                    	else  JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Nema pobjednika.Jako napeta partija!!!", 
                                "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                	}else {
                		potezi++;
                	igrac2.setBounds(400, 300, 130,245);
                	igrac2.repaint();
                	klikkarta=2;
                	odigranaigrac=igrac2;
                	Karta temp2=igrac.igraj(klikkarta);
                	if(pobjednikruke==1) {
                    temp=komp.igraj();
                	potezi++;
                	if(komp.odigrana==0) {
                		odigranakomp=komp1;
                		komp1.setIcon(temp.lice());
                		komp1.setBounds(600, 300, 130,245);
                		komp1.repaint();
                	}else if(komp.odigrana==1) {
                		odigranakomp=komp2;
                		komp2.setIcon(temp.lice());
                		komp2.setBounds(600, 300, 130,245);
                		komp2.repaint();
                	}else {odigranakomp=komp3;komp3.setBounds(600, 300, 130,245);
                	komp3.setIcon(temp.lice()); komp3.repaint();}
                	}
                	if(provjera(temp,temp2)==1) {
                		igrac.punti=igrac.punti+temp.punti()+temp2.punti();
                		 pobjednikruke=1;
                		 prviigra=1;
                	}
                	else {komp.punti=komp.punti+temp.punti()+temp2.punti(); pobjednikruke=0;prviigra=0;}
                	ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                        	odigranaigrac.setVisible(false);
                        	odigranakomp.setVisible(false);
                        	kliknut=false;
                        	pesk=true;
                        }
                    };
                    Timer timer=new Timer(3000, taskPerformer);
                    timer.start();
                    timer.setRepeats(false);
                	System.out.println(komp.punti);
                	System.out.println(igrac.punti);
                	mouselistener=false;
                }
                

                }else{ ImageIcon icon2 = new ImageIcon("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\error.jfif");
                	JOptionPane.showMessageDialog(null,"Prvo peskajte kartu", 
                        "Obavijest", JOptionPane.INFORMATION_MESSAGE, icon2);}
            }
        });	
		igrac3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(mouselistener==true) {
                	pesk=false;
                	if(potezi>=34&&potezi<=40) {
                    	mouselistener=false;/*onemoguci igru dok ne prode timer*/
                		potezi++;
                		odigranaigrac=igrac3;
                		igrac3.setBounds(400, 300, 130,245);
                    	igrac3.repaint();
                    	Karta temp2=igrac.igraj(3);
                    	if(pobjednikruke==1) {
                         temp=komp.igrajzadnja();
                    	potezi++;
                    	 if(komp.zadnja==1) {
         		    		odigranakomp=komp1;
                      		komp1.setIcon(temp.lice());
                      		komp1.setBounds(600, 300, 130,245);
                      		komp1.repaint();
         		    		 }else if(komp.zadnja==2) {
         		    			odigranakomp=komp2;
         		             	komp2.setIcon(temp.lice());
         		             	komp2.setBounds(600, 300, 130,245);
         		             	komp2.repaint();
         		    		 }else {odigranakomp=komp3;
         		             	komp3.setIcon(temp.lice());
         		             	komp3.setBounds(600, 300, 130,245);
         		             	komp3.repaint(); }

                    	}
                    	if(provjera(temp,temp2)==1) {
                    		igrac.punti=igrac.punti+temp.punti()+temp2.punti();
                    		pobjednikruke=1;
                    		prviigra=1;
                    	}
                    	else {komp.punti=komp.punti+temp.punti()+temp2.punti();
                    	pobjednikruke=0;
                    	prviigra=0;}
                    	ActionListener taskPerformer = new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                            	odigranaigrac.setVisible(false);
                            	odigranakomp.setVisible(false);
                            	kliknut=false;
                            	mouselistener=true;
                            	if(potezi<40&&pobjednikruke==0) {
                                   	potezi++;             
                               		temp=komp.igrajzadnja();
                               		 if(komp.zadnja==1) {
                        		    		odigranakomp=komp1;
                                     		komp1.setIcon(temp.lice());
                                     		komp1.setBounds(600, 300, 130,245);
                                     		komp1.repaint();
                        		    		 }else if(komp.zadnja==2) {
                        		    			odigranakomp=komp2;
                        		             	komp2.setIcon(temp.lice());
                        		             	komp2.setBounds(600, 300, 130,245);
                        		             	komp2.repaint();
                        		    		 }else {odigranakomp=komp3;
                        		             	komp3.setIcon(temp.lice());
                        		             	komp3.setBounds(600, 300, 130,245);
                        		             	komp3.repaint(); }}
                            }
                        };
                        Timer timer=new Timer(3000, taskPerformer);
                        timer.start();
                       timer.setRepeats(false);
                       System.out.println(komp.punti);
                    	System.out.println(igrac.punti);
                    	if(potezi==40) {
                    		ImageIcon icon = new ImageIcon("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\party.png");
                    	if(komp.punti>igrac.punti) {
                            JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Pobijedio je kompjutor.Cestitamo!!!", 
                                    "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                    	else if(komp.punti<igrac.punti) {
                    		 JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Pobijedili ste.Cestitamo!!!", 
                                     "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                    	else  JOptionPane.showMessageDialog(null,"Kompjutor:"+komp.punti+"\nIgrac:"+igrac.punti+"Nema pobjednika.Jako napeta partija!!!", 
                                "Pobjednik", JOptionPane.INFORMATION_MESSAGE, icon);
                    	}
                	}else {
                      		potezi++;
                      	igrac3.setBounds(400, 300, 130,245);
                      	igrac3.repaint();
                      	klikkarta=3;
                      	odigranaigrac=igrac3;
                      	Karta temp2=igrac.igraj(klikkarta);
                      	if(pobjednikruke==1) {
                      	temp=komp.igraj();
                      	potezi++;
                      	if(komp.odigrana==0) {
                      		odigranakomp=komp1;
                      		komp1.setBounds(600, 300, 130,245);
                      		komp1.setIcon(temp.lice());
                      		komp1.repaint();
                      	}else if(komp.odigrana==1) {
                      		odigranakomp=komp2;
                      		komp2.setBounds(600, 300, 130,245);
                      		komp2.setIcon(temp.lice());
                      		komp2.repaint();
                      	}else {odigranakomp=komp3;komp3.setBounds(600, 300, 130,245);
                      	komp3.setIcon(temp.lice()); komp3.repaint();}
                      	}
                      	if(provjera(temp,temp2)==1) {
                      		igrac.punti=igrac.punti+temp.punti()+temp2.punti();
                      		pobjednikruke=1;
                      		prviigra=1;
                      	}
                      	else { komp.punti=komp.punti+temp.punti()+temp2.punti();pobjednikruke=0;prviigra=0;}
                      	ActionListener taskPerformer = new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                            	odigranaigrac.setVisible(false);
                            	odigranakomp.setVisible(false);
                            	kliknut=false;
                            	pesk=true;
                            }
                        };
                        Timer timer=new Timer(3000, taskPerformer);
                        timer.start();
                        timer.setRepeats(false);
                    	System.out.println(komp.punti);
                    	System.out.println(igrac.punti);
                    	mouselistener=false;
                      }
                     
                }else { ImageIcon icon2 = new ImageIcon("C:\\Users\\Acer\\eclipse-workspace\\briskula\\src\\briskula\\slike\\error.jfif");
                	JOptionPane.showMessageDialog(null,"Prvo peskajte kartu", 
                        "Obavijest", JOptionPane.INFORMATION_MESSAGE, icon2);}
            
            }});
		igrac1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getSource() == igrac1) {
                	kliknut=true;
                }
            }
        });	
		igrac2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getSource() == igrac2) {
                	kliknut=true;
                }
            }
        });	
		igrac3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getSource() == igrac3) {
                	kliknut=true;
                }
            }
        });	
		
		

		
		
	}
}
