package com.example.wlnii.pakmayne;

public class PakMayne {

    Labyrinthe labyrinthe;
    private int x = 14;
    private int y = 23;
    private int nbGommeManger = 0; //242
    private int nbSuperGommeManger = 0; //4
    private int nbVie = 3;
    char dirCourante = 'E';
    char dirSuivante;
    Jeu jeu;

    public PakMayne(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }


    public void avance() {

        if (dirCourante == 'E') {
            if (x == 27) // si a la position 27 et ouest est la direction on l'envoie a l'autre extremité
                x = 0;
            else if (getUnlabyrinthe().getMatrice()[y][x + 1] != 'x') { //si pas un mur alors il avance d'une case
                x++;
                if (getUnlabyrinthe().getMatrice()[y][x] == 'o') { //si gomme sur son chemin on incremente le score et on fait disparaitre la gomme
                    nbGommeManger += 10;
                    getUnlabyrinthe().getMatrice()[y][x] = ' ';
                } else if (getUnlabyrinthe().getMatrice()[y][x] == '0') {
                    nbSuperGommeManger += 50;
                    getUnlabyrinthe().getMatrice()[y][x] = ' ';
                }
            }

        } else if (dirCourante == 'O') {
            if (x == 0)
                x = 27;
            else if (getUnlabyrinthe().getMatrice()[y][x - 1] != 'x') {
                x--;
                if (getUnlabyrinthe().getMatrice()[y][x] == 'o') {
                    nbGommeManger += 10;
                    getUnlabyrinthe().getMatrice()[y][x] = ' ';
                } else if (getUnlabyrinthe().getMatrice()[y][x] == '0') {
                    nbSuperGommeManger += 50;
                    getUnlabyrinthe().getMatrice()[y][x] = ' ';
                }
            }
        } else if (dirCourante == 'S' && getUnlabyrinthe().getMatrice()[y + 1][x] != 'x') {
            y++;
            if (getUnlabyrinthe().getMatrice()[y][x] == 'o') {
                nbGommeManger += 10;
                getUnlabyrinthe().getMatrice()[y][x] = ' ';
            } else if (getUnlabyrinthe().getMatrice()[y][x] == '0') {
                nbSuperGommeManger += 50;
                getUnlabyrinthe().getMatrice()[y][x] = ' ';
            }
        } else if (dirCourante == 'N' && getUnlabyrinthe().getMatrice()[y - 1][x] != 'x') {
            y--;
            if (getUnlabyrinthe().getMatrice()[y][x] == 'o') {
                nbGommeManger += 10;
                getUnlabyrinthe().getMatrice()[y][x] = ' ';
            } else if (getUnlabyrinthe().getMatrice()[y][x] == '0') {
                nbSuperGommeManger += 50;
                getUnlabyrinthe().getMatrice()[y][x] = ' ';
            }
        }

    }


    void prochaineDirection() {
        if (dirCourante == 'E' && dirSuivante == 'O' && x == 0) // si direction courante est est et que on est sur premiere case et direction suivante est ouest on le met sur la derniere case et faison le changement de direction.
            dirCourante = 'O';
        else if (dirCourante == 'O' && dirSuivante == 'E' && x == 27) // meme chose que dans le if mais pour lautre direction
            dirCourante = 'E';
        else if (dirSuivante == 'E' && (getUnlabyrinthe().getMatrice()[y][x + 1] != 'x')) { // si direction suivante est est et que il n'ya  apas d'obstacle on change pour direction courante sinon la direction courante reste la meme
            dirCourante = 'E';
            dirSuivante = ' ';
        } else if (dirSuivante == 'O' && (getUnlabyrinthe().getMatrice()[y][x - 1] != 'x')) {
            dirCourante = 'O';
            dirSuivante = ' ';
        }
        if (dirSuivante == 'S' && getUnlabyrinthe().getMatrice()[y + 1][x] != 'x' && getUnlabyrinthe().getMatrice()[y + 1][x] != 'p') { //meme concept que plus haut cependant on ajoute les p car seulement accesible en allant vers le sud
            dirCourante = 'S';
            dirSuivante = ' ';
        } else if (dirSuivante == 'N' && getUnlabyrinthe().getMatrice()[y - 1][x] != 'x') {
            dirCourante = 'N';
            dirSuivante = ' ';
            ;
        }
    }

    public String updateScore() //methode qui met a jour le score en additionnant les differents points des gommes mangés
    {
        int scoretotal= getNbGommeManger()+getNbSuperGommeManger();

        String scoretotalString = String.valueOf(scoretotal);

        return scoretotalString;
    }

    public String updateVies() //methode qui retourne en string le nombre de vie qui cvmMan
    {
        String lesVies = String.valueOf(getNbVie());

        return lesVies;
    }

    //les get et set pour acceder au methodes

    public Labyrinthe getUnlabyrinthe() {
        return labyrinthe;
    }

    public void setUnlabyrinthe(Labyrinthe unlabyrinthe) {
        unlabyrinthe = unlabyrinthe;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNbGommeManger() {
        return nbGommeManger;
    }

    public void setNbGommeManger(int nbGommeManger) {
        this.nbGommeManger = nbGommeManger;
    }

    public int getNbVie() {
        return nbVie;
    }

    public void setNbVie(int nbVie) {
        this.nbVie = nbVie;
    }


    public char getDirCourante() {
        return dirCourante;
    }

    public void setDirCourante(char dirCourante) {
        this.dirCourante = dirCourante;
    }

    public char getDirSuivante() {
        return dirSuivante;
    }

    public void setDirSuivante(char dirSuivante) {
        this.dirSuivante = dirSuivante;
    }

    public int getNbSuperGommeManger() {
        return nbSuperGommeManger;
    }

    public void setNbSuperGommeManger(int nbSuperGommeManger) {
        this.nbSuperGommeManger = nbSuperGommeManger;
    }

}
