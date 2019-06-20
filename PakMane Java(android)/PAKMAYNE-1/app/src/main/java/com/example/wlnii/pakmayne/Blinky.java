package com.example.wlnii.pakmayne;


/**
 * Created by eric on 2018-05-06.
 */
import java.util.Random;
import java.util.Vector;
public class Blinky extends Fantome {






    public Blinky( Labyrinthe jeu)
    {

        super ( 11, 12, 'e', jeu );

    }

    public void avance (PakMayne pakMayne) {

        if ( getDirection() == 's')
            sud(pakMayne);
        else if ( getDirection() == 'n')
            nord(pakMayne);
        else if ( getDirection() =='o')
            ouest(pakMayne);
        else
            est(pakMayne);
    }

    public void sud(PakMayne pakMayne)
    {
        //direction sud

        if ( getLaby().getMatrice()[getPosY()+1] [getPosX()]=='x' || getLaby().getMatrice()[getPosY()+1] [getPosX()]=='p'){ // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        }

        else if ((getLaby().getMatrice()[getPosY()+1][getPosX()]!='x') && ( getLaby().getMatrice()[getPosY()+1] [getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()+1] [getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setLigne (getPosY() +1);
        }
        else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            setLigne (getPosY()+1);
        }
    }

    public void nord(PakMayne pakMayne)
    {

        if ( getLaby().getMatrice()[getPosY()-1] [getPosX()]=='x' || getLaby().getMatrice()[getPosY()-1] [getPosX()]=='p') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        }

        else if ((getLaby().getMatrice()[getPosY()-1] [getPosX()]!='x') && ( getLaby().getMatrice()[getPosY()-1] [getPosX()-1] !='x' || getLaby().getMatrice() [getPosY()-1] [getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setLigne (getPosY() -1);
        }
        else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            setLigne (getPosY()-1);
        }
    }

    public void est(PakMayne pakMayne)
    {
        //direction est
        if ( getLaby().getMatrice()[getPosY()] [getPosX()+1]=='x'|| getLaby().getMatrice() [getPosY()] [getPosX()+1]=='p') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        }

        else if ((getLaby().getMatrice() [getPosY()] [getPosX()+1]!='x') && ( getLaby().getMatrice() [getPosY()-1] [getPosX()+1] !='x' || getLaby().getMatrice() [getPosY()+1] [getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setColonne (getPosX() +1);
        }
        else  {
            // pas d'intersection, il poursuit son chemin dans sa direction
            if ( getPosX() == 26 && getPosY() == 14 )
                setColonne( 0);
            else
                setColonne (getPosX()+1);
        }
    }

    public void ouest(PakMayne pakMayne)
    {
        if ( getLaby().getMatrice()[getPosY()] [getPosX()-1]=='x'|| getLaby().getMatrice()[getPosY()] [getPosX()-1]=='p') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        }

        else if ((getLaby().getMatrice()[getPosY()] [getPosX()-1]!='x') && ( getLaby().getMatrice()[getPosY()+1] [getPosX()-1] !='x' || getLaby().getMatrice() [getPosY()-1] [getPosX()-1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {

            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setColonne (getPosX() -1);
        }
        else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            if ( getPosX() == 1 && getPosY() == 14 ) // passage secret
                setColonne( 26);
            else

                setColonne (getPosX()-1);
        }
    }

    public void deciderDirectionObligatoireOrienteCVMMan(PakMayne pakMayne) {
        // 4 directions possibles

        Vector<Character> dirDispo;

        if ( getDirection() == 's')
        {
            dirDispo = directionsDispo(getPosY()+1, getPosX());
            // est ou ouest ou nord dépend du cvmman, il ne peut pas rebrousser chemin / reculer
            dirDispo.remove(new Character('n'));


        }
        else if ( getDirection() =='n')
        {
            dirDispo = directionsDispo(getPosY()-1, getPosX());
            dirDispo.remove(new Character('s'));
        }
        else if ( getDirection() =='e')
        {

            dirDispo = directionsDispo(getPosY(), getPosX()+1);

            dirDispo.remove(new Character('o'));


        }
        else //si c'est ouest
        {

            dirDispo = directionsDispo(getPosY(), getPosX()-1);
            dirDispo.remove(new Character('e')); //ne pas pouvoir reculer et entrer en transe

        }

        Vector<Character> cibles = determinerDirectionCible( pakMayne.getY(), pakMayne.getX());
        Vector<Character> intersect = (Vector<Character>) dirDispo.clone(); //une copie du Vecteur
        intersect.retainAll(cibles); //on fait une intersection pour garder les meilleures positions
        //intersection
        if ( intersect.size()== 0)
        {
            int indiceChoisi = (int)(Math.random()*(dirDispo.size()-1));

            setDirection( dirDispo.get(indiceChoisi));
        }
        else
        {
            int indiceChoisi = (int)(Math.random()*(intersect.size()-1));

            setDirection( intersect.get(indiceChoisi));
        }
    }





}





