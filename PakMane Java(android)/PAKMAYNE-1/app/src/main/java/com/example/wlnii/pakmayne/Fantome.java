package com.example.wlnii.pakmayne;
/**
 * Created by eric on 2018-04-26.
 * modified by Wilny on 2018-05-15
 */

import java.util.Hashtable;
import java.util.Vector;


public class Fantome {
    private int colonne; // colonne
    private int ligne; // ligne
    private char direction; // 's', 'n', 'e', 'o'
    private Labyrinthe laby;


    public Fantome(int ligne, int colonne, char direction, Labyrinthe laby) {
        this.colonne = colonne;
        this.ligne = ligne;
        this.direction = direction;
        this.laby = laby;

    }

    public void recommencer() {
        setLigne(13);
        setColonne(14);
        setDirection('n');
    }


    public int getPosX() {
        return colonne;
    }

    public int getPosY() {
        return ligne;
    }

    public char getDirection() {
        return direction;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }


    public Labyrinthe getLaby() {
        return laby;
    }


    public void setJeu(Labyrinthe laby) {
        this.laby = laby;
    }


    public Vector<Character> directionsDispo(int ligne, int colonne) {
        Vector<Character> dirDispo = new Vector<Character>();

        if (laby.getMatrice()[ligne + 1][colonne] != 'x' && laby.getMatrice()[ligne + 1][colonne] != 'p')
            dirDispo.add('s');

        if (laby.getMatrice()[ligne - 1][colonne] != 'x' && laby.getMatrice()[ligne - 1][colonne] != 'p')
            dirDispo.add('n');

        if (laby.getMatrice()[ligne][colonne + 1] != 'x' && laby.getMatrice()[ligne][colonne + 1] != 'p')
            dirDispo.add('e');

        if (laby.getMatrice()[ligne][colonne - 1] != 'x' && laby.getMatrice()[ligne][colonne - 1] != 'p')
            dirDispo.add('o');

        return dirDispo;
    }


    public Vector<Character> determinerDirectionCible(int ligneCible, int colonneCible) {
        Vector<Character> cibles = new Vector<Character>();
        if (ligneCible < getPosY()) {
            if (colonneCible < getPosX()) {

                cibles.add('n');
                cibles.add('o');
            } else if (colonneCible == getPosX())
                cibles.add('n');
            else {
                cibles.add('n');
                cibles.add('e');
            }
        } else if (ligneCible == getPosY()) {
            if (colonneCible < getPosX()) {
                cibles.add('o');
            } else
                cibles.add('e');
        } else //ligneCible > getLigne()
        {
            if (colonneCible < getPosX()) {
                //no
                cibles.add('s');
                cibles.add('o');
            } else if (colonneCible == getPosX())
                cibles.add('s');
            else {
                cibles.add('s');
                cibles.add('e');
            }
        }
        return cibles;
    }


}

