package com.example.wlnii.pakmayne;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class SurfaceDessin extends View {

    Paint crayon;
    Jeu leJeu;
    PakMayne lePakmayne;
    Drawable pakE, pakN, pakO, pakS,blinky,inky,pinky;
    int coteCarre = 34;
    int separateur = 4;
    int debutCarree = 10;
    int debutCercle = 27;
    int hauteurCercle = 20;


    public SurfaceDessin(Context context, AttributeSet attrs) {
        super(context, attrs);

        leJeu = new Jeu(context);
        lePakmayne = new PakMayne(leJeu.getLeLabyrinthe());


        pakE = context.getResources().getDrawable(R.drawable.est);
        pakO = context.getResources().getDrawable(R.drawable.ouest);
        pakN = context.getResources().getDrawable(R.drawable.nord);
        pakS = context.getResources().getDrawable(R.drawable.sud);
        blinky = context.getResources().getDrawable(R.drawable.blinky);
        inky = context.getResources().getDrawable(R.drawable.inky);
        pinky = context.getResources().getDrawable(R.drawable.pinky);

    }


    protected void onDraw(Canvas canvas) {
    // methode permettant de dessigner le labyrinthe en se basant sur les lettres trouve lors de la lecture de la matrice
        for (int y = 0; y < 31; y++) {
            for (int x = 0; x < 28; x++) {
                if (leJeu.getLeLabyrinthe().getMatrice()[y][x] == 'x') { // si lettre est un x alors on creer un carre de couleur bleu avec les dimensions defini dans les variables global
                    crayon = new Paint();
                    crayon.setAntiAlias(true);
                    crayon.setColor(Color.BLUE);
                    crayon.setStyle(Paint.Style.FILL);
                    canvas.drawRect(debutCarree + x * (coteCarre + separateur), y * (coteCarre + separateur), (coteCarre + debutCarree) + x * (coteCarre + separateur), coteCarre + y * (coteCarre + separateur), crayon);
                } else if (leJeu.getLeLabyrinthe().getMatrice()[y][x] == 'o') {
                    crayon = new Paint();  // si lettre est un o alors on creer un cercle rempli de couleur jaune avec les dimensions defini dans les variables global
                    crayon.setAntiAlias(true);
                    crayon.setColor(Color.YELLOW);
                    crayon.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(debutCercle + x * (coteCarre + separateur), hauteurCercle + y * (coteCarre + separateur), hauteurCercle / 2, crayon);
                } else if (leJeu.getLeLabyrinthe().getMatrice()[y][x] == '0') {
                    crayon = new Paint();
                    crayon.setAntiAlias(true);
                    crayon.setColor(Color.WHITE);// si lettre est un 0 alors on creer un cercle rempli de couleur blanche avec les dimensions defini dans les variables global
                    crayon.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(debutCercle + x * (coteCarre + separateur), hauteurCercle + y * (coteCarre + separateur), hauteurCercle - debutCarree / 2, crayon);
                } else if (leJeu.getLeLabyrinthe().getMatrice()[y][x] == 'p') {
                    crayon = new Paint();
                    crayon.setAntiAlias(true);
                    crayon.setColor(Color.RED);// si lettre est un p alors on creer un carre de couleur rouge avec les dimensions defini dans les variables global
                    crayon.setStyle(Paint.Style.FILL);
                    canvas.drawRect(separateur + x * (coteCarre + separateur), y * (coteCarre + separateur), (coteCarre + separateur) + x * (coteCarre + separateur), coteCarre + y * (coteCarre + separateur), crayon);
                }


            }

        }




        if (lePakmayne.getDirCourante() == 'E') {//methode permettant d'avoir diferrent dessin du cvmMan  dependament de la direction qui est choisi
            if(lePakmayne.getX()>27)
            {
                lePakmayne.setX(0);
            }
            pakE.setBounds((coteCarre + separateur) * lePakmayne.getX(), (coteCarre + separateur) * lePakmayne.getY(), (coteCarre + separateur) * (lePakmayne.getX() + 1), (coteCarre + separateur) * (lePakmayne.getY() + 1));
            pakE.draw(canvas);
        } else if (lePakmayne.getDirCourante() == 'O') {
            pakO.setBounds((coteCarre + separateur) * lePakmayne.getX(), (coteCarre + separateur) * lePakmayne.getY(), (coteCarre + separateur) * (lePakmayne.getX() + 1), (coteCarre + separateur) * (lePakmayne.getY() + 1));
            pakO.draw(canvas);
        } else if (lePakmayne.getDirCourante() == 'N') {
            pakN.setBounds((coteCarre + separateur) * lePakmayne.getX(), (coteCarre + separateur) * lePakmayne.getY(), (coteCarre + separateur) * (lePakmayne.getX() + 1), (coteCarre + separateur) * (lePakmayne.getY() + 1));
            pakN.draw(canvas);
        } else if (lePakmayne.getDirCourante() == 'S') {
            pakS.setBounds((coteCarre + separateur) * lePakmayne.getX(), (coteCarre + separateur) * lePakmayne.getY(), (coteCarre + separateur) * (lePakmayne.getX() + 1), (coteCarre + separateur) * (lePakmayne.getY() + 1));
            pakS.draw(canvas);
        }

        //les trois fantomes sont desinner a chaque refresh du canvas
        blinky.setBounds((coteCarre + separateur) * leJeu.blinky.getPosX(), (coteCarre + separateur) * leJeu.blinky.getPosY(), (coteCarre + separateur) * (leJeu.blinky.getPosX() + 1), (coteCarre + separateur) * (leJeu.blinky.getPosY() + 1));
        blinky.draw(canvas);

        inky.setBounds((coteCarre + separateur) * leJeu.inky.getPosX(), (coteCarre + separateur) * leJeu.inky.getPosY(), (coteCarre + separateur) * (leJeu.inky.getPosX() + 1), (coteCarre + separateur) * (leJeu.inky.getPosY() + 1));
        inky.draw(canvas);

        pinky.setBounds((coteCarre + separateur) * leJeu.pinky.getPosX(), (coteCarre + separateur) * leJeu.pinky.getPosY(), (coteCarre + separateur) * (leJeu.pinky.getPosX() + 1), (coteCarre + separateur) * (leJeu.pinky.getPosY() + 1));
        pinky.draw(canvas);




    }

    public Jeu getLeJeu() {
        return leJeu;
    }

    public PakMayne getLePakmayne() {
        return lePakmayne;
    }
}


