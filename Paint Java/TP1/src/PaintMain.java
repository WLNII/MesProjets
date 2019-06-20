import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class PaintMain extends JFrame {

	private surfaceDessin board;
	private MainLever trait;
	private EcouteurBoutton ecButton;
	private EcouteurSurface ecSurface;

	private ButtonGroup groupA = new ButtonGroup();
	private ButtonGroup groupB = new ButtonGroup();
	private ButtonGroup groupC = new ButtonGroup();
	private ButtonGroup groupD = new ButtonGroup();

	private JPanel panelA;
	private JPanel panelB;
	private JPanel panelC;
	private JPanel panelD;
	private JPanel surface;

	private JToggleButton btnCrayon;
	private JToggleButton btnEfface;
	private JToggleButton btnSample;
	private JToggleButton btnFillup;
	private JToggleButton btnSave;
	private JToggleButton btnCarre;
	private JToggleButton btnCercle;
	private JToggleButton btnTriangle;
	private JToggleButton btnC1;
	private JToggleButton btnC2;

	private JFileChooser fileChooser = new JFileChooser();

	private JLabel btnVert;
	private JLabel btnMauve;
	private JLabel btnJaune;
	private JLabel btnRose;
	private JLabel btnBleu;
	private JLabel btnTurquoise;
	private JLabel btnRouge;
	private JLabel btnNoir;
	private JLabel btnOrange;
	private JLabel btnBlanc;
	JLabel labelC1 = new JLabel(); 
	JLabel labelC2 = new JLabel();
	private JTextField epaisseurTrait;
	private JLabel lblTailleDuTrait;
	private  int x=0;
	private  int y=0;
	private Vector <MainLever> vect2Vector = new Vector <MainLever>();
	int selection;
	private BufferedImage i ;
	MainLever temp;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintMain frame = new PaintMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public PaintMain() {
		setTitle("PAINT");
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		board = new surfaceDessin();
		board.setBounds(6, 100, 1162, 604);
		getContentPane().add(board);


		//crayon efface pipette peinture
		panelA = new JPanel();
		panelA.setBounds(6, 0, 363, 88);
		getContentPane().add(panelA);
		panelA.setLayout(null);

		btnCrayon = new JToggleButton("");
		btnCrayon.setBounds(0, 41, 71, 41);
		ImageIcon crayonimg = new ImageIcon("icones/crayon.gif");
		btnCrayon.setIcon(crayonimg);
		panelA.add(btnCrayon);

		btnEfface = new JToggleButton("");
		btnEfface.setBounds(70, 41, 71, 41);
		btnEfface.setBackground(Color.WHITE);
		ImageIcon effaceimg = new ImageIcon("icones/efface.gif");
		btnEfface.setIcon(effaceimg);
		panelA.add(btnEfface);

		btnSample = new JToggleButton("");
		btnSample.setBounds(139, 41, 71, 41);
		ImageIcon sampleimg = new ImageIcon("icones/pipette.gif");
		btnSample.setIcon(sampleimg);
		panelA.add(btnSample);

		btnFillup = new JToggleButton("");
		btnFillup.setBounds(215, 41, 71, 41);
		ImageIcon Fillimg = new ImageIcon("icones/remplissage.gif");
		btnFillup.setIcon(Fillimg);
		panelA.add(btnFillup);

		btnSave = new JToggleButton("");
		btnSave.setBounds(298, 6, 55, 41);
		ImageIcon Saveimg = new ImageIcon("icones/save.gif");
		btnSave.setIcon(Saveimg);
		panelA.add(btnSave);

		// differentes formes
		panelB = new JPanel();
		panelB.setBounds(369, 0, 249, 88);
		getContentPane().add(panelB);
		panelB.setLayout(null);

		btnCarre = new JToggleButton("Carree");
		btnCarre.setBounds(6, 36, 81, 46);
		panelB.add(btnCarre);

		btnCercle = new JToggleButton("Cercle");
		btnCercle.setBounds(87, 36, 81, 46);
		panelB.add(btnCercle);

		btnTriangle = new JToggleButton("Triangle");
		btnTriangle.setBounds(168, 36, 81, 46);
		panelB.add(btnTriangle);




		//dual couleur
		panelC = new JPanel();
		panelC.setBounds(619, 0, 211, 127);
		getContentPane().add(panelC);
		panelC.setLayout(null);
		
		//creation bouton couleur 1 et 2 
		btnC1 = new JToggleButton("Couleur 1");
		btnC1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnC1.setBounds(6, 6, 94, 70);
		panelC.add(btnC1);
		btnC1.setLayout( new FlowLayout());
		labelC1.setBackground(Color.BLACK);
		labelC1.setOpaque(true);
		btnC1.add(labelC1);
		labelC1.setPreferredSize(new Dimension(80, 35));



		btnC2 = new JToggleButton("Couleur 2");
		btnC2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnC2.setBounds(112, 6, 94, 70);
		panelC.add(btnC2);
		btnC2.setLayout( new FlowLayout());
		labelC2.setBackground(Color.BLACK);
		labelC2.setOpaque(true);
		btnC2.add(labelC2);
		labelC2.setPreferredSize(new Dimension(80, 35));





		//code pour personnalisation grille couleur
		panelD = new JPanel();
		panelD.setBounds(842, 0, 332, 88);
		getContentPane().add(panelD);
		panelD.setLayout(new GridLayout(2, 5, 0, 0));

		btnRose = new JLabel("");
		btnRose.setBackground(Color.PINK);
		btnRose.setOpaque(true);
		panelD.add(btnRose);

		btnJaune = new JLabel("");
		btnJaune.setBackground(Color.YELLOW);
		btnJaune.setOpaque(true);
		panelD.add(btnJaune);

		btnMauve = new JLabel("");
		btnMauve.setBackground(Color.MAGENTA);
		btnMauve.setOpaque(true);
		panelD.add(btnMauve);

		btnBleu = new JLabel("");
		btnBleu.setBackground(Color.BLUE);
		btnBleu.setOpaque(true);
		panelD.add(btnBleu);

		btnRouge = new JLabel("");
		btnRouge.setBackground(Color.RED);
		btnRouge.setOpaque(true);
		panelD.add(btnRouge);

		btnOrange = new JLabel("");
		btnOrange.setBackground(Color.ORANGE);
		btnOrange.setOpaque(true);
		panelD.add(btnOrange);

		btnVert = new JLabel("");
		btnVert.setBackground(Color.GREEN);
		btnVert.setOpaque(true);
		panelD.add(btnVert);

		btnTurquoise = new JLabel("");
		btnTurquoise.setBackground(Color.CYAN);
		btnTurquoise.setOpaque(true);
		panelD.add(btnTurquoise);

		btnNoir = new JLabel("");
		btnNoir.setBackground(Color.BLACK);
		btnNoir.setOpaque(true);
		panelD.add(btnNoir);

		btnBlanc = new JLabel("");
		btnBlanc.setBackground(Color.WHITE);
		btnBlanc.setOpaque(true);
		panelD.add(btnBlanc);

		//surface ou l'on dessine 
		surface = new JPanel();
		surface.setBounds(6, 100, 1188, 604);
		getContentPane().add(surface);

		//groupe Panel A
		groupA.add(btnCrayon);
		groupA.add(btnEfface);
		groupA.add(btnSample);
		groupA.add(btnFillup);
		groupA.add(btnSave);
		
		//attribut de crayon epaisseur du trait avec valeur par defaut 
		epaisseurTrait = new JTextField();
		epaisseurTrait.setBounds(88, 2, 122, 27);
		epaisseurTrait.setText("8");
		panelA.add(epaisseurTrait);
		epaisseurTrait.setColumns(10);
		
		//JLabel qui contiendra valeur grosseur du trait 
		lblTailleDuTrait = new JLabel("Taille du trait");
		lblTailleDuTrait.setBounds(0, 6, 82, 15);
		panelA.add(lblTailleDuTrait);

		//groupe Panel B
		groupB.add(btnCarre);
		groupB.add(btnCercle);
		groupB.add(btnTriangle);

		//groupe Panel C
		groupC.add(btnC1);
		groupC.add(btnC2);

		//declaration ecouteurs surface et boutton
		ecButton= new EcouteurBoutton();
		ecSurface= new EcouteurSurface();

		btnSave.addMouseListener(ecButton);

		Component[] tab = panelD.getComponents();
		//boucle ameliorer qui applique un ecouteur sur tout les JLabel dans le panelD
		for ( Component c : tab)
		{
			((JLabel)c).addMouseListener(ecButton);
		}

		board.addMouseMotionListener(ecSurface);
		board.addMouseListener(ecSurface);
	}

	///permet de tramsformer en image 
	public BufferedImage recupererImage ( JPanel surface )
	{
		Dimension size = surface.getSize();
		BufferedImage image = new BufferedImage( size.width, 	size.height , BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		surface.paint(g2);
		return image;
	}
	
	
	
	private class EcouteurSurface implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
			//quand on drag la souris les coordonnees sont enregistrer dans un vecteur de points
			if(btnCrayon.isSelected() || btnEfface.isSelected())
			{
				x=e.getX();
				y=e.getY();

				Point p = new Point(x,y);

				trait.ajoutPointDansVect(p);
				repaint();
			}
			else
			{
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(btnFillup.isSelected())
			{
				//si bouton remplissage est selectionner on prend couleur du label dependament du click choisi 
				//et onl'applique au background de btnEfface(WHITE) car c'est c'est attribut que prend le background au debut
				if(e.getButton()== MouseEvent.BUTTON1)
				{
					board.setBackground(labelC1.getBackground());	
					btnEfface.setBackground(labelC1.getBackground());
				}
				else if(e.getButton()== MouseEvent.BUTTON3)
				{
					board.setBackground(labelC2.getBackground());	
					btnEfface.setBackground(labelC2.getBackground());
				}
				repaint();
				
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			//quand la souris est peser et que le bouton crayon est selectionner 
			//on creer un object trait qui contient les attributs de couleur et grosseur de trait
			
			if(btnCrayon.isSelected())
			{
				if(e.getButton()== MouseEvent.BUTTON1)
				{
					trait = new Crayon(labelC1.getBackground(),Integer.parseInt(epaisseurTrait.getText()));
				}
				else if(e.getButton()== MouseEvent.BUTTON3)
				{
					trait = new Crayon(labelC2.getBackground(),5);
				}

			}
			else if(btnEfface.isSelected())
			{
				trait = new Effacer(board.getBackground(),Integer.parseInt(epaisseurTrait.getText()));
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
			//quand le bouton est relacher on met le vecteur dans un vecteur de vecteur 
			if(btnCrayon.isSelected() || btnEfface.isSelected())
				vect2Vector.addElement(trait);
			

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}



	private class EcouteurBoutton implements MouseListener,MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			//permet de choisir les couleurs qui seront dans les deux push button pour crayon formes etc.
			if(btnC1.isSelected())
				labelC1.setBackground(e.getComponent().getBackground());
			else if(btnC2.isSelected())
				labelC2.setBackground(e.getComponent().getBackground());
			
			//permet de sauvegarder le dessin de l'usager
			else if(e.getSource().equals(btnSave))
			{
				fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Sauvegarde");
				selection = fileChooser.showSaveDialog(null);

				if(selection == JFileChooser.APPROVE_OPTION)
				{
					File pic = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".JPG");
					String ext = "JPG";					
					BufferedImage image = recupererImage(board);

							try{
								ImageIO.write(image, ext, pic);
							} catch(IOException er) {
								er.printStackTrace();
							}
				}
			}
			
			

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}



	class surfaceDessin extends JPanel {

		surfaceDessin(){}

		protected void paintComponent (Graphics g)
		{
			//permet de rendre les lignes plus aggreables et moins pixeliser
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//redefinission de la methode paintComponent afin de pouvoir dessiner
			super.paintComponent(g);
			
			//couleur de fond pour la zone de dessin
			this.setBackground(btnEfface.getBackground());
			

			if(btnCrayon.isSelected())
			{	
				//premiere boucle permet d'aller chercher les points dans le vecteur de points 
				for(int i = 0 ; i<vect2Vector.size(); i++)
				{
					BasicStroke ligne = new BasicStroke(vect2Vector.elementAt(i).getGrosseurTrait(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2.setStroke(ligne);
					g2.setColor(vect2Vector.elementAt(i).getCouleurTrait());

					for(int j = 0 ; j < vect2Vector.elementAt(i).getVect().size()-1; j++)
					{
						g2.drawLine(vect2Vector.elementAt(i).getVect().elementAt(j).x, vect2Vector.elementAt(i).getVect().elementAt(j).y, vect2Vector.elementAt(i).getVect().elementAt(j+1).x, vect2Vector.elementAt(i).getVect().elementAt(j+1).y);

					}

				}


				//dexieme boucle permet d'aller chercher les points qui seront dessiner apres les points deja dans le vecteur 
				for(int k = 0 ; k < trait.getVect().size()-1; k++)
				{	
					g.drawLine(trait.getVect().elementAt(k).x, trait.getVect().elementAt(k).y, trait.getVect().elementAt(k+1).x, trait.getVect().elementAt(k+1).y); 
					BasicStroke ligne = new BasicStroke(trait.getGrosseurTrait(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2.setStroke(ligne);
					g2.setColor(trait.getCouleurTrait());
				}


			}
			//meme code que pour les points cependant la c'est pour effacer donc on prend toujours la couleur de l'arriere plan
			else if(btnEfface.isSelected())
			{
				for(int i = 0 ; i<vect2Vector.size(); i++)
				{
					BasicStroke ligne = new BasicStroke(vect2Vector.elementAt(i).getGrosseurTrait(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2.setStroke(ligne);
					g2.setColor(vect2Vector.elementAt(i).getCouleurTrait());

					for(int j = 0 ; j < vect2Vector.elementAt(i).getVect().size()-1; j++)
					{
						g2.drawLine(vect2Vector.elementAt(i).getVect().elementAt(j).x, vect2Vector.elementAt(i).getVect().elementAt(j).y, vect2Vector.elementAt(i).getVect().elementAt(j+1).x, vect2Vector.elementAt(i).getVect().elementAt(j+1).y);

					}

				}


				for(int k = 0 ; k < trait.getVect().size()-1; k++)
				{	
					g.drawLine(trait.getVect().elementAt(k).x, trait.getVect().elementAt(k).y, trait.getVect().elementAt(k+1).x, trait.getVect().elementAt(k+1).y); 
					BasicStroke ligne = new BasicStroke(trait.getGrosseurTrait(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2.setStroke(ligne);
					g2.setColor(trait.getCouleurTrait());
				}

			}
			
			else if(btnCarre.isSelected())
			{/*
				for(int i = 0 ; i<vect2Vector.size(); i++)
				{
					BasicStroke ligne = new BasicStroke(vect2Vector.elementAt(i).getGrosseurTrait(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
					g2.setStroke(ligne);
					g2.setColor(vect2Vector.elementAt(i).getCouleurTrait());

					for(int j = 0 ; j < vect2Vector.elementAt(i).getVect().size()-1; j++)
					{
						g.drawRect(vect2Vector.elementAt(i).getVect().elementAt(j).x, vect2Vector.elementAt(i).getVect().elementAt(j).y, i, j);
					}
				}
					
					/*for(int k = 0 ; k < trait.getVect().size()-1; k++)
					{	
						g.drawRect(trait.getVect().elementAt(k).x, trait.getVect().elementAt(k).y, k,k+10);						
						BasicStroke ligne = new BasicStroke(trait.getGrosseurTrait(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
						g2.setStroke(ligne);
						g2.setColor(trait.getCouleurTrait());
						
					}*/
				
				
				
				
			}
			
			
		}

	}

}
