package com.example.wlnii.pakmayne;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Jeu {

    private Labyrinthe leLabyrinthe;
    private PakMayne lePakmayne;
    private char character;
    private char [][] tableau;
    int points;
    Blinky blinky;
    Pinky pinky;
    Inky inky;

    InputStream inputStreamFichExistant;
    InputStreamReader readerFichExistant;
    BufferedReader readerCharExistant;

    public Jeu()
    { }

    public Jeu(Context context) { //creation des objets utiliser dans la classe jeu

        leLabyrinthe = new Labyrinthe(lireFich(context));
        blinky = new Blinky(leLabyrinthe);
        inky = new Inky(leLabyrinthe);
        pinky = new Pinky(leLabyrinthe);
        lePakmayne=new PakMayne(leLabyrinthe);
    }

    public char[][] lireFich(Context context) { //methode permettant de lire un fichier texte

        tableau = new char[31][28];

        int compteur = 0;

        inputStreamFichExistant = context.getResources().openRawResource(R.raw.plan);
        readerFichExistant = new InputStreamReader(inputStreamFichExistant);
        readerCharExistant = new BufferedReader(readerFichExistant);
        try {
            String ligne = readerCharExistant.readLine();
            while (ligne != null) {
               // System.out.println(ligne);

                for (int i = 0; i < ligne.length(); i++) {
                    tableau[compteur][i] = ligne.charAt(i); // lus ligne par ligne chaque lettres est entree dans un tableau 2 dimension
                }
                ligne = readerCharExistant.readLine();
                compteur++;
            }

            readerCharExistant.close(); //fermeture du flux
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tableau;

    }


    public Labyrinthe getLeLabyrinthe() {
        return leLabyrinthe;
    }







    public void mettreAjour() // methode qui appelle la methode avance de chaque fantome, la methode mettre a jour est appeler dans l'Activity
    {
        blinky.avance(lePakmayne);
        pinky.avance(lePakmayne);
        inky.avance(lePakmayne,blinky);
    }

}
