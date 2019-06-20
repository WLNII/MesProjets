import java.awt.Color;
import java.awt.Point;

	public class Triangle extends MainLever{
		
		public Triangle(){
			
		}
		
		public Triangle(Color couleurTrait, int grosseurTrait)
		{
			super(couleurTrait,grosseurTrait);
		}

		@Override
		public void ajoutPointDansVect(Point ajout) {
			// TODO Auto-generated method stub
			super.getVect().addElement(ajout);
		}

	}