import java.awt.Color;
import java.awt.Point;

	public class Cercle extends MainLever{
		
		public Cercle(){
			
		}
		
		public Cercle(Color couleurTrait, int grosseurTrait)
		{
			super(couleurTrait,grosseurTrait);
		}

		@Override
		public void ajoutPointDansVect(Point ajout) {
			// TODO Auto-generated method stub
			super.getVect().addElement(ajout);
		}

	}