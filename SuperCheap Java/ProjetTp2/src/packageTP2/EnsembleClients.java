package packageTP2;
import java.util.*;
public class EnsembleClients 
{
private static Hashtable<String, Client> listeClients = new Hashtable<String,Client>();

 

//retourne la liste des clients dans la table 
  public static Hashtable<String, Client> getListe()
  {
  return listeClients;
  }

  //va chercher la valeur associe au noCarteBoni dans la table 
  public static Client getClient ( String noCarteBoni )
  {
  return listeClients.get(noCarteBoni);
  }

  //insere une valeur dans la table en cherchant le noCarteBoni pris dans la classe Client
  public static void ajouterClient ( Client c)
  {
  listeClients.put(c.getNoCarte(), c);
  }
  

}