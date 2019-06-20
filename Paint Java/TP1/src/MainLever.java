import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JPanel;

public abstract class MainLever{
	

	private Vector <Point> vect;
	private Color couleurTrait;
	private int grosseurTrait;
	
	public MainLever(){
		
	}
	
	//constructeur qui sera utiliser par plusieurs classes usant des memes attributs 
	MainLever(Color couleurTrait, int grosseurTrait  )
	{
		vect= new Vector <Point>();
		this.couleurTrait=couleurTrait;
		this.grosseurTrait=grosseurTrait;
		
	}
	
	public abstract void ajoutPointDansVect(Point ajout);
	
	
	public Color getCouleurTrait() {
		return couleurTrait;
	}

	public void setCouleurTrait(Color couleurTrait) {
		this.couleurTrait = couleurTrait;
	}

	public int getGrosseurTrait() {
		return grosseurTrait;
	}

	public void setGrosseurTrait(int grosseurTrait) {
		this.grosseurTrait = grosseurTrait;
	}

	

	public Vector<Point> getVect() {
		return vect;
	}

	public void setVect(Vector<Point> vect) {
		this.vect = vect;
	}
	
	
	
}
