package packageTP2;

public class Produit 
{

private int code;
private String nom;
private int qteStock;
private double prix;
private int points;

//Constructeur Produits qui prend 5 attributs descriptifs en parametre
public Produit ( int code, String nom,int qteStock, double prix, int points )
{
this.code = code;
this.qteStock=qteStock;
this.prix=prix;
this.points=points;
this.nom = nom;
}

//get pour chercher les valeurs des variables prives
public String getNom()
{
return nom;
}
public int getCode ()
{
return code;
}
public int getQteStock()
{
return qteStock;
}
public double getPrix()
{
return prix;
}
public int getPoints()
{
return points;
}

/*boolean qui verifi si la quantite achetee et l'enleve de la quantite en 
 	stock si la quantite acheter est moindre ou egal a la quantite en stock */
public boolean modifierQteStock ( int qteAchetee)
{
if ( qteAchetee <= qteStock )
  {
  this.qteStock-=qteAchetee;
  return true;
  }
else
  return false;
   
}
}