package com.example.wlnii.pakmayne;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MayneActivity extends AppCompatActivity {

    SurfaceDessin surface;
    Ecouteur ecouteur;
    Thread t;
    Handler h;
    Button boutonS, boutonN, boutonO, boutonE, boutonStr;
    boolean peser;
    TextView txtScore, txtVies, score, vies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayne);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtVies = (TextView) findViewById(R.id.txtVies);
        score = (TextView) findViewById(R.id.score);
        vies = (TextView) findViewById(R.id.vies);


        boutonE = (Button) findViewById(R.id.btnEst);
        boutonS = (Button) findViewById(R.id.btnSud);
        boutonN = (Button) findViewById(R.id.btnNord);
        boutonO = (Button) findViewById(R.id.btnOuest);
        boutonStr = (Button) findViewById(R.id.btnStart);
        surface = (SurfaceDessin) findViewById(R.id.surface);
        btnOff();

        ecouteur = new Ecouteur();
        boutonS.setOnClickListener(ecouteur);
        boutonN.setOnClickListener(ecouteur);
        boutonO.setOnClickListener(ecouteur);
        boutonE.setOnClickListener(ecouteur);
        boutonStr.setOnClickListener(ecouteur);

        t = new Thread() {
            public void run() {
                boucleJeu();
            }
        };
        h = new Handler();

    }

    public void boucleJeu() { //boucle jeu qui appellent les differentes methodes qui se succedent dans un ordre décidé
        updateScore();
        updateVie();
        surface.getLePakmayne().prochaineDirection();
        surface.getLePakmayne().avance();
        surface.getLeJeu().mettreAjour();

        surface.invalidate(); // permet de redessiner le canvas avec les changements

        h.postDelayed(t, 300);

    }

    private class Ecouteur implements View.OnClickListener {
        // methode qui envoie la touche peser ( direction choisi) au cvmMan
        @Override
        public void onClick(View v) {
            if (boutonStr.isPressed() && !peser) { //si bouton start est peser on part la parti et change le texte du bouton
                h.post(t);
                peser = true;
                btnOn();
                boutonStr.setText("Pause");
            } else if (boutonE.isPressed()) {
                surface.getLePakmayne().setDirSuivante('E');
            } else if (boutonO.isPressed()) {
                surface.getLePakmayne().setDirSuivante('O');
            } else if (boutonN.isPressed()) {
                surface.getLePakmayne().setDirSuivante('N');
            } else if (boutonS.isPressed()) {
                surface.getLePakmayne().setDirSuivante('S');
            } else if (boutonStr.isPressed() && peser) { // si le bouton start est peser et que la boucle plus haut a ete excuter(bollean) on pause et change le texte
                h.removeCallbacks(t);
                peser = false;
                boutonStr.setText("Start");
                btnOff();


            }
        }
    }


    public SurfaceDessin getSurface() {
        return surface;
    }


    public void updateScore() {
        score.setText(surface.getLePakmayne().updateScore().toString());
    } //methode permettant d'afficher le score

    public void updateVie(){vies.setText(surface.getLePakmayne().updateVies().toString());
    };//methode permettant d'afficher les vies

    //methode qui desactive tout les boutons du jeu apart le start/pause
    private void btnOff() {
        boutonS.setEnabled(false);
        boutonO.setEnabled(false);
        boutonE.setEnabled(false);
        boutonN.setEnabled(false);

    }

    //methode qui active tout les boutons du jeu apart le start/pause
    private void btnOn() {
        boutonS.setEnabled(true);
        boutonO.setEnabled(true);
        boutonE.setEnabled(true);
        boutonN.setEnabled(true);

    }


}
