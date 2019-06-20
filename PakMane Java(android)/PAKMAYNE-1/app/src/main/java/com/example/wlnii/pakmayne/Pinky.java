package com.example.wlnii.pakmayne;

/**
 * Created by eric on 2018-05-07.
 */

import java.util.Vector;

public class Pinky extends Fantome
{
    public Pinky(Labyrinthe laby)
    {
        super ( 15, 13, 'n', laby );
    }

    public void avance (PakMayne c) {

        if ( getDirection() == 's')
            sud(c);
        else if ( getDirection() == 'n')
            nord(c);
        else if ( getDirection() =='o')
            ouest(c);
        else
            est(c);
    }
    public void sud(PakMayne pakMayne)
    {
        //direction sud
        if ( getLaby().getMatrice()[getPosY()+1][getPosX()]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        } else if ((getLaby().getMatrice()[getPosY()+1][getPosX()]!='x') && ( getLaby().getMatrice()[getPosY()+1][getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()+1][getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setLigne (getPosY() +1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            setLigne (getPosY()+1);
        }
    }

    public void nord(PakMayne pakMayne)
    {
        if ( getLaby().getMatrice()[getPosY()-1][getPosX()]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        } else if ((getLaby().getMatrice()[getPosY()-1][getPosX()]!='x') && ( getLaby().getMatrice()[getPosY()-1][getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()-1][getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setLigne (getPosY() -1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            setLigne (getPosY()-1);
        }
    }

    public void est(PakMayne pakMayne)
    {
        //direction est
        if ( getLaby().getMatrice()[getPosY()][getPosX()+1]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        } else if ((getLaby().getMatrice()[getPosY()][getPosX()+1]!='x') && ( getLaby().getMatrice()[getPosY()-1][getPosX()+1] !='x' || getLaby().getMatrice()[getPosY()+1][getPosX()+1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setColonne (getPosX() +1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            if ( getPosX() == 26 && getPosY() == 14 )
                setColonne( 0);
            else
                setColonne (getPosX()+1);
        }
    }

    public void ouest(PakMayne pakMayne)
    {
        if ( getLaby().getMatrice()[getPosY()][getPosX()-1]=='x') { // il entre dans un mur, on doit absolument changer de direction
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
        } else if ((getLaby().getMatrice()[getPosY()][getPosX()-1]!='x') && ( getLaby().getMatrice()[getPosY()+1][getPosX()-1] !='x' || getLaby().getMatrice()[getPosY()-1][getPosX()-1] != 'x' ) ) // il est à une intersection, tente de suivre le CVM-Man
        {
            deciderDirectionObligatoireOrienteCVMMan(pakMayne);
            setColonne (getPosX() -1);
        } else  {  // pas d'intersection, il poursuit son chemin dans sa direction
            if ( getPosX() == 1 && getPosY() == 14 ) // passage secret
                setColonne( 26);
            else
                setColonne (getPosX()-1);
        }
    }

    public void deciderDirectionObligatoireOrienteCVMMan(PakMayne pakMayne) { // n'a pas le choix de changer de direction, entre dans un mur
        // 4 directions possibles

        Vector<Character> dirDispo;
        Vector<Character> cibles;
        if ( getDirection() == 's')
        {
            dirDispo = directionsDispo(getPosY()+1, getPosX());
            // est ou ouest ou nord dépend du pakMayne, il ne peut plus aller vers le sud
            dirDispo.remove(new Character('n'));
            cibles = determinerDirectionCible( pakMayne.getY()+4, pakMayne.getX());
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
        }
        else //si c'est ouest
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
}

