package packageTP2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NvClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNvNomClient;
	
	private String nomEntree;
	private String numeroCarte;
	private int pointsBonis = 0;
	private String point = String.valueOf(pointsBonis);
	
	//getters permettant le rapatriement des information dans la classe main
	
	public String getNomEntree() {
		return nomEntree;
	}

	public String getPointsBonis() {
		return point;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public Ecouteur getEcn() {
		return ecn;
	}

	public void setEcn(Ecouteur ecn) {
		this.ecn = ecn;
	}

	boolean done;


	public String getNumeroCarte(){
		return numeroCarte;
	}


	private JLabel lblNvNomClient;
	JButton btnAnnuler = new JButton("Annuler");
	JButton btnOk = new JButton("OK");

	Ecouteur ecn = new Ecouteur();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NvClient dialog = new NvClient(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NvClient(Supercheap parent) {
		setBounds(100, 100, 350, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnOk.setBounds(6, 151, 126, 71);
		contentPanel.add(btnOk);
		btnAnnuler.setBounds(218, 151, 126, 71);
		contentPanel.add(btnAnnuler);

		textFieldNvNomClient = new JTextField();
		textFieldNvNomClient.setBounds(214, 48, 130, 26);
		contentPanel.add(textFieldNvNomClient);
		textFieldNvNomClient.setColumns(10);

		lblNvNomClient = new JLabel("Nom du nouveau client:");
		lblNvNomClient.setBounds(6, 53, 150, 16);
		contentPanel.add(lblNvNomClient);

		btnOk.addActionListener(ecn);
		btnAnnuler.addActionListener(ecn);


	}

	private class Ecouteur implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource() == btnAnnuler)
			{
				dispose(); //ferme la fenetre si bouton annuler est clicker 
			}
			else if(e.getSource() == btnOk && !textFieldNvNomClient.getText().equals("")) // verifie si le bouton ok est clicker et que un nom est entrer 
			{
				//creation du numero de la carte (aleatoire)
				Random rand = new Random();
				int n = 100000 + rand.nextInt(900000-1);
				String numCarte = Integer.toString(n);

				//enregistrement nom du nouveau client
				nomEntree = textFieldNvNomClient.getText();
				Client nv = new Client(numCarte, nomEntree,0);


				if(EnsembleClients.getClient(numCarte) == null) // si le numero creer n'est pas dans la hashtable on ajoute le client dans la hashtable
				{

					numeroCarte= numCarte;
					EnsembleClients.ajouterClient(nv);
					done=true;
					JOptionPane.showMessageDialog(NvClient.this, "numero de la carte est: " + numCarte);

				}
				else
				{
					JOptionPane.showMessageDialog(NvClient.this, "Conflit systeme revalider"); // si le meme numero existant est generer affiche ce message
					done=false;


				}
				
				dispose();

			}
			else
			{
				JOptionPane.showMessageDialog(NvClient.this, "Entrer le nom du client"); // si les conditions de la boucle plus haut ne sont pas respectes
				done=false;
			}

		}
	}

	public JTextField getTextFieldNvNomClient() {
		return textFieldNvNomClient;
	}

}
