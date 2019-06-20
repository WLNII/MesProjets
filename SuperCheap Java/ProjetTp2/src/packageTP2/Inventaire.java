package packageTP2;
import java.util.*;
public class Inventaire 
{
private static Hashtable<String, Produit> listeProduits = new Hashtable<String, Produit>();

 

//retourne la liste des produit dans la table 
  public static Hashtable<String, Produit> getListe()
  {
  return listeProduits;
  }

  //va chercher la valeur associe au nom dans la table 
  public static Produit getProduit ( String  nom )
  {
  return listeProduits.get(nom);
  }

  //Permet d'ajouter les produits dans la hashtable
  public static void ajouterProduit ( Produit p)
  {
  listeProduits.put(p.getNom(), p);
  }

 
  
}