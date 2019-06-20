package packageTP2;

import java.awt.EventQueue;
import java.awt.ItemSelectable;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Supercheap extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnOption;
	JMenuItem itemNvClient, itemFermeture;
	private JPanel panelClient;
	private JPanel panelCommande;
	private JPanel panelProduit;
	private JButton btnAchat;
	private JButton btnTerminer;
	private JLabel lblcarteBoni;
	private JLabel lblNomClient;
	private JLabel lblPtnBoni;
	private JTextField tfCarte;
	private JTextField tfNom;


	private JTextField tfPoints;
	private JLabel lblCommande;
	private JLabel lblArticle;
	private JComboBox comboBox;
	private JTextField tfdPrix;
	private JTextField tfStock;
	private JLabel lblNewLabel_2;
	private JLabel lblQteEnStock;
	Ecouteur ec = new Ecouteur();
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modele;

	private JLabel lblMontantDonne;
	private JLabel lblMontantRemis;
	private JButton btnNvCommande;
	private JTextField tfMontantDonne;
	private JTextField tfMontantRemis;
	DecimalFormat df= new DecimalFormat("#,##0.00$");
	private Commande commande;

	String select; 
	String prix;

	NvClient nv = new NvClient(null);


	InputStream inp; 
	XSSFWorkbook classeur; 
	XSSFSheet feuille;

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
					Supercheap frame = new Supercheap();
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
	public Supercheap() {
		setBounds(100, 100, 455, 630);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 455, 22);
		getContentPane().add(menuBar);

		mnOption = new JMenu("Fichier");
		menuBar.add(mnOption);

		itemNvClient = new JMenuItem("Nouveau Client");
		mnOption.add(itemNvClient);

		itemFermeture = new JMenuItem("Fermeture de session");
		mnOption.add(itemFermeture);

		panelClient = new JPanel();
		panelClient.setBackground(new Color(176,196,222));
		panelClient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelClient.setBounds(10, 34, 434, 141);
		getContentPane().add(panelClient);
		panelClient.setLayout(null);

		lblcarteBoni = new JLabel("Numero Carte Boni :");
		lblcarteBoni.setBounds(6, 6, 130, 16);
		panelClient.add(lblcarteBoni);

		lblNomClient = new JLabel("Nom du client :");
		lblNomClient.setBounds(6, 53, 104, 16);
		panelClient.add(lblNomClient);

		lblPtnBoni = new JLabel("Nombre de point boni a ce jour :");
		lblPtnBoni.setBounds(6, 103, 227, 16);
		panelClient.add(lblPtnBoni);

		tfCarte = new JTextField();
		tfCarte.setBounds(360, 6, 68, 26);
		panelClient.add(tfCarte);
		tfCarte.setColumns(10);

		tfNom = new JTextField();
		tfNom.setBounds(298, 53, 130, 26);
		panelClient.add(tfNom);
		tfNom.setColumns(10);
		tfNom.setEditable(false);

		tfPoints = new JTextField();
		tfPoints.setBounds(360, 103, 68, 26);
		panelClient.add(tfPoints);
		tfPoints.setColumns(10);
		tfPoints.setEditable(false);

		panelCommande = new JPanel();
		panelCommande.setBackground(new Color(176,196,222));
		panelCommande.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCommande.setBounds(10, 201, 311, 134);
		getContentPane().add(panelCommande);
		panelCommande.setLayout(null);

		lblCommande = new JLabel("COMMANDE");
		lblCommande.setBounds(6, 6, 84, 16);
		panelCommande.add(lblCommande);

		lblArticle = new JLabel("Article");
		lblArticle.setBounds(6, 48, 61, 16);
		panelCommande.add(lblArticle);

		comboBox = new JComboBox();
		comboBox.setBounds(56, 44, 249, 27);
		panelCommande.add(comboBox);

		tfdPrix = new JTextField();
		tfdPrix.setBounds(6, 102, 55, 26);
		tfdPrix.setEditable(false);
		panelCommande.add(tfdPrix);
		tfdPrix.setColumns(10);

		tfStock = new JTextField();
		tfStock.setColumns(10);
		tfStock.setBounds(250, 102, 55, 26);
		tfStock.setEditable(false);
		panelCommande.add(tfStock);

		lblNewLabel_2 = new JLabel("prix unitaire:");
		lblNewLabel_2.setBounds(6, 88, 84, 16);
		panelCommande.add(lblNewLabel_2);

		lblQteEnStock = new JLabel("Qte en stock");
		lblQteEnStock.setBounds(225, 88, 80, 16);
		panelCommande.add(lblQteEnStock);

		panelProduit = new JPanel();
		panelProduit.setBackground(new Color(176,196,222));
		panelProduit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelProduit.setBounds(10, 363, 434, 222);
		getContentPane().add(panelProduit);
		panelProduit.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 422, 125);
		panelProduit.add(scrollPane);

		modele = new DefaultTableModel();
		table = new JTable(modele);
		scrollPane.setViewportView(table);

		modele.addColumn("Produit");
		modele.addColumn("Quantite");
		modele.addColumn("Prix");

		lblMontantDonne = new JLabel("Montant donne");
		lblMontantDonne.setBounds(6, 153, 100, 16);
		panelProduit.add(lblMontantDonne);

		lblMontantRemis = new JLabel("Montant remis");
		lblMontantRemis.setBounds(6, 200, 100, 16);
		panelProduit.add(lblMontantRemis);

		btnNvCommande = new JButton("Nouvelle Commande");
		btnNvCommande.setBounds(286, 153, 142, 63);
		btnNvCommande.setEnabled(false);
		panelProduit.add(btnNvCommande);

		tfMontantDonne = new JTextField();
		tfMontantDonne.setBounds(145, 153, 100, 26);
		panelProduit.add(tfMontantDonne);
		tfMontantDonne.setColumns(10);
		tfMontantDonne.setEditable(false);

		tfMontantRemis = new JTextField();
		tfMontantRemis.setColumns(10);
		tfMontantRemis.setBounds(145, 191, 100, 26);
		tfMontantRemis.setEditable(false);
		panelProduit.add(tfMontantRemis);

		btnAchat = new JButton("ACHAT");
		btnAchat.setBounds(333, 201, 111, 57);
		getContentPane().add(btnAchat);

		btnTerminer = new JButton("TERMINER");
		btnTerminer.setBounds(333, 278, 111, 57);
		btnTerminer.setEnabled(false);
		getContentPane().add(btnTerminer);


		//Lire les deux fichiers excel Produits et Clients
		lireFichierProduit();
		lireFichierClient();


		Set<String> ensembleCles = Inventaire.getListe().keySet();
		for ( String str:ensembleCles)
			comboBox.addItem(str);

		//ecouteur Items, Bouttons, ComboBox et JTextfield
		comboBox.addActionListener(ec);
		comboBox.setSelectedIndex(0);
		itemNvClient.addActionListener(ec);
		itemFermeture.addActionListener(ec);
		btnAchat.addActionListener(ec);
		btnTerminer.addActionListener(ec);
		btnNvCommande.addActionListener(ec);
		tfCarte.addKeyListener(ec);
		nv.btnOk.addActionListener(ec);
		tfMontantDonne.addKeyListener(ec);
		btnNvCommande.addActionListener(ec);

		//restriction a l'utilisateur//
		table.setEnabled(false); //empeche de changer les information
		table.getTableHeader().setReorderingAllowed(false); // empeche de changer l'ordre des colonnes
		table.getTableHeader().setResizingAllowed(false);//empeche de redimensionner les colonnes

	}

	//permet de lire les client du fichier Produits.xlsx
	private void lireFichierProduit()
	{	

		// creer un flux de lecture
		try
		{
			int i=1;

			inp = new FileInputStream ( "Produits.xlsx");
			classeur = ( XSSFWorkbook ) WorkbookFactory.create(inp);
			feuille = classeur.getSheetAt(0); // feuille commence a 0

			while(feuille.getRow(i) !=null)
			{

				XSSFRow rangee = feuille.getRow(i); // rangee commencent a 0
				XSSFCell cellule  = rangee.getCell(0); // 1ere cellule 
				int c1 = (int)cellule.getNumericCellValue();
				XSSFCell cellule2  = rangee.getCell(1); // 2ere cellule 
				String c2 = cellule2.getStringCellValue();
				XSSFCell cellule3  = rangee.getCell(2); // 3ere cellule 
				int c3 = (int)cellule3.getNumericCellValue();
				XSSFCell cellule4  = rangee.getCell(3); // 4ere cellule 
				double c4 = cellule4.getNumericCellValue();
				XSSFCell cellule5  = rangee.getCell(4); // 5ere cellule 
				int c5 = (int)cellule5.getNumericCellValue();

				Produit leProduit = new Produit(c1,c2,c3,c4,c5);
				Inventaire.ajouterProduit(leProduit);

				i++;

			}

			inp.close();
		}
		catch ( Exception f)
		{
			f.printStackTrace();
		}



	}

	//permet de lire les client du fichier Clients.xlsx
	private void lireFichierClient()
	{	

		// creer un flux de lecture
		try
		{
			int i=1;

			inp = new FileInputStream ( "Clients.xlsx");
			classeur = ( XSSFWorkbook ) WorkbookFactory.create(inp);
			feuille = classeur.getSheetAt(0); // feuille commence a 0

			while(feuille.getRow(i) !=null)
			{

				XSSFRow rangee = feuille.getRow(i); // rangee commencent a 0
				XSSFCell cellule  = rangee.getCell(0); // 1ere cellule 
				int c1 = (int)cellule.getNumericCellValue();
				String c11= Integer.toString(c1);
				XSSFCell cellule2  = rangee.getCell(1); // 2ere cellule 
				String c2 = cellule2.getStringCellValue();
				XSSFCell cellule3  = rangee.getCell(2); // 3ere cellule 
				int c3 = (int)cellule3.getNumericCellValue();

				Client leClient = new Client(c11,c2,c3);
				EnsembleClients.ajouterClient(leClient);

				i++;

			}


			inp.close();

		}
		catch ( Exception f)
		{
			f.printStackTrace();
		}

	}

	//permet l'enregistrement des clients dans le c=fichier excel
	private void enregistrementClient() throws IOException{

		// creer un flux de lecture
		try
		{
			int i=1;

			inp = new FileInputStream ( "Clients.xlsx");
			classeur = ( XSSFWorkbook ) WorkbookFactory.create(inp);
			feuille = classeur.getSheetAt(0); // feuille commence a 0


			Set<String> ensembleCles = EnsembleClients.getListe().keySet();
			for ( String str:ensembleCles)
			{
				int numCarte = Integer.parseInt(EnsembleClients.getClient(str).getNoCarte());
				String nom = EnsembleClients.getClient(str).getNom();
				int pointsBonis = EnsembleClients.getClient(str).getNbPointsAcc();

				//cretion de nouvelles cellules et rangee pour chaque cle de la hashtable 
				XSSFRow rangee = feuille.createRow(i); // rangee commencent a 0
				XSSFCell nouvelleCellule = rangee.createCell(0);
				nouvelleCellule.setCellValue(numCarte);
				XSSFCell nouvelleCellule2 = rangee.createCell(1);
				XSSFCell nouvelleCellule3 = rangee.createCell(2);
				nouvelleCellule2.setCellValue(nom);
				nouvelleCellule3.setCellValue(pointsBonis);
				i++;
			}



			OutputStream out = new FileOutputStream ( "Clients.xlsx");
			classeur.write(out);  
			out.close();
			inp.close();



		}
		catch ( Exception f)
		{
			f.printStackTrace();
		}


	}




	//permet l'enregistrement des clients dans le c=fichier excel
	private void enregistrementProduit() throws IOException{

		// creer un flux de lecture
		try
		{
			int i=1;

			inp = new FileInputStream ( "Produits.xlsx");
			classeur = ( XSSFWorkbook ) WorkbookFactory.create(inp);
			feuille = classeur.getSheetAt(0); // feuille commence a 0


			Set<String> ensembleCles = Inventaire.getListe().keySet();
			for ( String str:ensembleCles)
			{
				int code = Inventaire.getListe().get(str).getCode();
				String nom = Inventaire.getListe().get(str).getNom();
				int stock = Inventaire.getListe().get(str).getQteStock();
				double prix = Inventaire.getListe().get(str).getPrix();
				int nbPoints = Inventaire.getListe().get(str).getPoints();

				//cretion de nouvelles cellules et rangee pour chaque cle de la hashtable 
				XSSFRow rangee = feuille.createRow(i); // rangee commencent a 0
				XSSFCell nouvelleCellule = rangee.createCell(0);
				XSSFCell nouvelleCellule2 = rangee.createCell(1);
				XSSFCell nouvelleCellule3 = rangee.createCell(2);
				XSSFCell nouvelleCellule4 = rangee.createCell(3);
				XSSFCell nouvelleCellule5 = rangee.createCell(4);
				nouvelleCellule.setCellValue(code);
				nouvelleCellule2.setCellValue(nom);
				nouvelleCellule3.setCellValue(stock);
				nouvelleCellule4.setCellValue(prix);
				nouvelleCellule5.setCellValue(nbPoints);

				i++;
			}



			OutputStream out = new FileOutputStream ( "Produits.xlsx");
			classeur.write(out);  
			out.close();
			inp.close();



		}
		catch ( Exception f)
		{
			f.printStackTrace();
		}


	}





	private class Ecouteur implements ActionListener, KeyListener{




		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int acheter = 1;

			if(e.getSource()==comboBox) //si on click sur la combobox l'item selectionner affichera le prix et la quantite restante dans les jtextfield associes
			{
				select = (String)comboBox.getSelectedItem();
				prix = String.valueOf(Inventaire.getProduit(select).getPrix());
				tfdPrix.setText(prix);

				String quant = String.valueOf(Inventaire.getProduit(select).getQteStock());
				tfStock.setText(quant);

			}

			//Si nouveau client selectionner dans menu cree objet nvClient de la classe NvClient
			if(e.getSource()==itemNvClient)
			{
				NvClient nc = new NvClient(Supercheap.this);
				nc.setModal(true); //permet de ne pas continuer la boucle tant que la jdialog n'est pas fermer
				nc.setVisible(true);

				//prennent tout les informations creer a partir du jdialog nvClient
				tfCarte.setText(nc.getNumeroCarte());
				tfNom.setText(nc.getNomEntree());
				tfPoints.setText(nc.getPointsBonis());

				commande = new Commande(nc.getNumeroCarte());

			}

			//Si fermeture selectionner dans menu ferme programme avec delai 1 seconde
			else if(e.getSource()== itemFermeture)
			{

				//debug

				try {
					enregistrementClient();
					enregistrementProduit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.exit(0);
			}


			//achat d'un produit
			else if(e.getSource() == btnAchat && !tfStock.getText().equals("0"))
				if(!tfNom.getText().equals(""))
				{
					Inventaire.getProduit(select).modifierQteStock(acheter); //baisse la quantite dans la hashtable de 1 a chaque achat 

					Item item = new Item(select, acheter, commande.getNumero());

					commande.ajouterItem(item);
					modele.addRow(new Object[]{select,1,prix}); //ajoute rangee dans la comboBox

					String quant = String.valueOf(Inventaire.getProduit(select).getQteStock());
					tfStock.setText(quant);

					btnTerminer.setEnabled(true);
				}
				else
					JOptionPane.showMessageDialog(Supercheap.this, "Selectionner un client svp");
			tfCarte.requestFocus();

			if(e.getSource()==btnTerminer)
			{
				//si le vecteur est vide signifie pas d'achat en cours alors on valide
				if(!commande.getItems().isEmpty())
				{
					modele.addRow(new Object[]{"","",""});
					modele.addRow(new Object[]{"AVANT TAXES","",df.format(commande.calculerSousTotal())});
					modele.addRow(new Object[]{"TPS","",df.format(commande.calculerTPS())});
					modele.addRow(new Object[]{"TVQ","",df.format(commande.calculerTVQ())});
					modele.addRow(new Object[]{"TOTAL","",df.format(commande.calculerGrandTotal())});
					commande.calculerPointsBonis();
					tfMontantDonne.setEditable(true);
					tfMontantDonne.requestFocus();
				}
				else
					JOptionPane.showMessageDialog(Supercheap.this, "Aucune transaction detecte");
			}
			else if(e.getSource()==btnNvCommande) //si nouvelle commande on efface tout les champs et on cree un nouveau scrollpane
			{
				tfCarte.setText("");
				tfNom.setText("");
				tfPoints.setText("");
				tfMontantDonne.setText("");
				tfMontantRemis.setText("");

				modele.removeTableModelListener(table);
				modele = new DefaultTableModel();
				table = new JTable(modele);
				scrollPane.setViewportView(table);

				modele.addColumn("Produit");
				modele.addColumn("Quantite");
				modele.addColumn("Prix");

				btnTerminer.setEnabled(false);
				btnNvCommande.setEnabled(false);
				itemNvClient.setEnabled(true);
				tfMontantDonne.setEditable(false);
				tfCarte.setEditable(true);
			}


		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			String numCarte = tfCarte.getText(), montantEntree = tfMontantDonne.getText();

			if(e.getSource()==tfCarte && e.getKeyCode()==KeyEvent.VK_ENTER && tfNom.getText().equals("")) //valide si le numero de la carte existe et que il n'y a pas de clieent deja inscrit dans la case 
			{

				String numEntree = tfCarte.getText();

				/*compare la string entree a ce qui se trouve dans la hashtable
				 * si correspond alors on le met dans la jtextfield 
				 * pour les points on converti les int en string
				 */
				if(EnsembleClients.getClient(numEntree) !=null)
				{
					String nom = EnsembleClients.getClient(numEntree).getNom();
					int nbPointsInt = EnsembleClients.getClient(numEntree).getNbPointsAcc();
					String nbPointsString = Integer.toString(nbPointsInt);
					tfPoints.setText(nbPointsString);;
					tfNom.setText(nom);

					commande = new Commande(numCarte);
					itemNvClient.setEnabled(false);
					tfCarte.setEditable(false);

				}
				else
				{
					JOptionPane.showMessageDialog(Supercheap.this, "Ce client n'existe pas, entrez un numero valide"); // si conditions plus haut ne sont pas respecter
					tfCarte.setText("");

				}

			}
			else if(e.getSource()==tfMontantDonne && e.getKeyCode()==KeyEvent.VK_ENTER) // quand on appuie enter sur montant donner
			{
				double montantEntreeD = Double.parseDouble(montantEntree);


				if(EnsembleClients.getClient(numCarte).assezArgent(commande, montantEntreeD)) // verifie si le montant donner est asser pour payer 
				{
					double montant = EnsembleClients.getClient(numCarte).paieCommande(commande, montantEntreeD); //si oui la commande est paye

					tfMontantRemis.setText(df.format(montant)); // on retourne le change 
					btnNvCommande.setEnabled(true);

				}
				else
					JOptionPane.showMessageDialog(Supercheap.this, "Montant inssufisant"); // si les conditions plus haut ne sont pas respecter 


			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
