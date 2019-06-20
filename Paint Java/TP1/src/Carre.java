import java.awt.Color;
import java.awt.Point;

	public class Carre extends MainLever{
		
		public Carre(){
			
		}
		
		public Carre(Color couleurTrait, int grosseurTrait)
		{
			super(couleurTrait,grosseurTrait);
		}

		@Override
		public void ajoutPointDansVect(Point ajout) {
			// TODO Auto-generated method stub
			super.getVect().addElement(ajout);
		}

	}