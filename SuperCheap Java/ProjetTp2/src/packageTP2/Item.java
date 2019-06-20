
package packageTP2;

public class Item 
{
private String nomProduit;
private int qteDemandee;
private int numeroCommandeAssociee;

//Constructeur Item qui prend en parametre 3 attributs descriptifs
  public Item(String nomProduit, int qteDemandee, int numeroCommandeAssociee)
  {
  this.nomProduit = nomProduit;
  this.qteDemandee = qteDemandee;
  this.numeroCommandeAssociee = numeroCommandeAssociee;
  }
  
  //Getters qui permettent d'aller chercher l'information privee des variables 
  public String getNomProduit()
  {
  return nomProduit;
  }
  public int getQte()
  {
  return qteDemandee;
  }
  public int getNumeroCommandeAssociee()
  {
  return numeroCommandeAssociee;
  }
  
  //permet d'aller chercher le produit de la hashtable
  public Produit getProduit()
  {
  return Inventaire.getProduit(nomProduit);
  }
  
  //affiche le produit avec son nom, la quantite demander ainsi que le prix 
  public String afficherItem ()
  {
  return this.nomProduit+"\r"+this.qteDemandee+"\r"+getProduit().getPrix()*this.qteDemandee;
  }
  

  
}