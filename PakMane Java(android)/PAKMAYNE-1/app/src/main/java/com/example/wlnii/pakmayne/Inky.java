package com.example.wlnii.pakmayne;

/**
 * Created by eric on 2018-05-09.
 */

import java.util.Vector;

public class Inky extends Fantome
{
    public Inky( Labyrinthe laby)
    {
        super ( 14, 12, 'n', laby );
    }

    public void avance (PakMayne c, Blinky b ) {

        if ( getDirection() == 's')
            sud(c,b);
        else if ( getDirection() == 'n')
            nord(c,b);
        else if ( getDirection() =='o')
            ouest(c,b);
        else
            est(c,b);
    }
    public void sud(PakMayne pakMayne, Blinky b)
    {
        //direction sud

        if ( getLaby().getMatrice()[getPosY()+1][getPosX()]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
        } else if ((getLaby().getMatrice()[getPosY()+1][getPosX()]!='x') && ( getLaby().getMatrice()[getPosY()+1][getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()+1][getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
            setLigne (getPosY() +1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            setLigne (getPosY()+1);
        }
    }

    public void nord(PakMayne pakMayne, Blinky b)
    {

        if ( getLaby().getMatrice()[getPosY()-1][getPosX()]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
        } else if ((getLaby().getMatrice()[getPosY()-1][getPosX()]!='x') && ( getLaby().getMatrice()[getPosY()-1][getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()-1][getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
            setLigne (getPosY() -1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            setLigne (getPosY()-1);
        }
    }

    public void est(PakMayne pakMayne, Blinky b)
    {
        //direction est
        if ( getLaby().getMatrice()[getPosY()][getPosX()+1]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
        } else if ((getLaby().getMatrice()[getPosY()][getPosX()+1]!='x') && ( getLaby().getMatrice()[getPosY()-1][getPosX()+1] !='x' || getLaby().getMatrice()[getPosY()+1][getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
            setColonne (getPosX() +1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            if ( getPosX() == 26 && getPosY() == 14 )
                setColonne( 0);
            else
                setColonne (getPosX()+1);
        }
    }

    public void ouest(PakMayne pakMayne, Blinky b)
    {
        if ( getLaby().getMatrice()[getPosY()][getPosX()-1]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
        } else if ((getLaby().getMatrice()[getPosY()][getPosX()-1]!='x') && ( getLaby().getMatrice()[getPosY()+1][getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()-1][getPosX()-1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne,b);
            setColonne (getPosX() -1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            if ( getPosX() == 1 && getPosY() == 14 ) // passage secret
                setColonne( 26);
            else
                setColonne (getPosX()-1);
        }
    }

    public void deciderDirectionObligatoireOrienteCVMMan(PakMayne pakMayne, Blinky b) { // n'a pas le choix de changer de direction, entre dans un mur
        // 4 directions possibles

        Vector<Character> dirDispo;
        Vector<Character> cibles;

        int diffColonneCible=0;
        int diffLigneCible=0;
        if ( getDirection() == 's')
        {
            dirDispo = directionsDispo(getPosY()+1, getPosX());
            // est ou ouest ou nord dépend du pakMayne, il ne peut plus aller vers le sud
            dirDispo.remove(new Character('n'));
            int[] dif = retourne2Devant(pakMayne, b);
            cibles = determinerDirectionCible( b.getPosY() + 2*dif[0], b.getPosX()+2* dif[1]);
        } else if ( getDirection() =='n')
        {
            dirDispo = directionsDispo(getPosY()-1, getPosX());
            dirDispo.remove(new Character('s'));
            cibles = determinerDirectionCible( pakMayne.getY()-4, pakMayne.getX()-4);
        } else if ( getDirection() =='e')
        {
            dirDispo = directionsDispo(getPosY(), getPosX()+1);
            // est ou ouest ou nord dépend du pakMayne, il ne peut plus aller vers le sud
            dirDispo.remove(new Character('o'));
            cibles = determinerDirectionCible( pakMayne.getY(), pakMayne.getX()+4);
            //if ( cibles.size() == 0)  // le pakMayne est face à nous
            //je ne peux pas revenir sur mon chemin, ca serait reculer et m eloigne de pakMayne

        } else //si c'est ouest
        {
            dirDispo = directionsDispo(getPosY(), getPosX()-1);
            dirDispo.remove(new Character('e')); //ne pas pouvoir reculer et entrer en transe
            cibles = determinerDirectionCible( pakMayne.getY(), pakMayne.getX()-4);
        }

        Vector<Character> intersect = (Vector<Character>) dirDispo.clone();
        intersect.retainAll(cibles);
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

    public int[] retourne2Devant(PakMayne pakMayne, Blinky b)
    {
        int[] diff = new int[2];
        if ( pakMayne.getDirCourante() =='s')
        {
            // 2 cases devant :
            diff[0] = pakMayne.getY()+2 - b.getPosY();
            diff[1] = pakMayne.getX() - b.getPosX();
        } else if ( pakMayne.getDirCourante() == 'n')
        {
            // 2 cases devant :
            diff[0] = pakMayne.getY()-2 - b.getPosY();
            diff[1] = pakMayne.getX() - b.getPosX();

        } else if ( pakMayne.getDirCourante() == 'e')
        {
            // 2 cases devant :
            diff[0] = pakMayne.getY() - b.getPosY();
            diff[1] = pakMayne.getX()+2 - b.getPosX();

        } else if ( pakMayne.getDirCourante() == 'o')
        {
            // 2 cases devant :
            diff[0] = pakMayne.getY() - b.getPosY();
            diff[1] = pakMayne.getX()-2 - b.getPosX();
        }
        return diff;
    }
}