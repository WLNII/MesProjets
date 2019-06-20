package com.example.wlnii.pakmayne;

public class Labyrinthe {
    public Labyrinthe()
    {

    }

    private char [][] matrice;

    public Labyrinthe(char[][] matrice) {
        this.matrice = matrice;
    }

    public char[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(char[][] matrice) {
        this.matrice = matrice;
    }


}
