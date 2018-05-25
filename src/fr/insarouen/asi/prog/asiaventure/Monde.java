package fr.insarouen.asi.prog.asiaventure;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.MondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Monde est une classe representant un monde.
 * @author Theo Castel et Salim Talout
 * @version 2.0
*/
public class Monde {

  /**
   * Le nomDuMonde
   * @see Monde#getNom()
  */
  private String nomDuMonde;

  /**
   * HashMap d'entites
   * @see Entite
   * @see Monde#getEntites()
  */
  private HashMap <String,Entite> entites;



  /**
   * Contructeur Monde, cree une instance de monde.
   * A la construction du monde, on fixe un nom au monde, et on cree un HashMap vide des entites.
   * @param  String nomDuMonde
  */
  public Monde(java.lang.String nomDuMonde){
    this.nomDuMonde=nomDuMonde;
    this.entites= new HashMap<String,Entite>();

  }

  /**
   * Retourne les informations concernant le monde.
   * @return les informations du monde sous forme de chaine de caracteres.
  */
  public String toString(){
  	StringBuilder s = new  StringBuilder(99999);
  	s.append(this.nomDuMonde);
  	s.append(" \n");
    for (String h: entites.keySet()){
      s.append(h);
    }
  	return s.toString();
  }

  /**
   * Retourne vrai s'il existe un element portant le nom en entree.
   * @param  String nomEntite     nom d'element a tester.
   * @return        Vrai si le nom de cet element existe dans le monde.
  */
  public boolean estPresentNomElement(String nomEntite){
    return entites.containsKey(nomEntite);
  }

  /**
   * Ajoute une entite au HashMap d'entites
   * @param  Entite                                    entite        l'entite a ajouter.
   * @throws NomDEntiteDejaUtiliseDansLeMondeException S'il existe deja une entite portant ce nom.
   * @throws EntiteDejaDansUnAutreMondeException       Si l'entite est deja presente dans un autre monde.
  */
  public void ajouter(Entite entite) throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
    if (estPresentNomElement(entite.getNom())){
      throw new NomDEntiteDejaUtiliseDansLeMondeException("NomDEntiteDejaUtiliseDansLeMondeException");
    }
    if (entite.getMonde().getNom()!=this.getNom()){
      throw new EntiteDejaDansUnAutreMondeException("EntiteDejaDansUnAutreMondeException");
    }
    entites.put(entite.getNom(),entite);
  }

  /**
   * Retourne le nom du monde.
   * @return String : Nom du monde.
  */
  public String getNom(){
    return nomDuMonde;
  }

  /**
   * Retourne l'entite portant le nom en entree.
   * @param  String nomEntite     Nom de l'entite a trouver.
   * @return        L'entite portant le nom en entree.
   */
  public Entite getEntite(String nomEntite){
    return entites.get(nomEntite);
  }

  public HashMap<String,Entite> getEntites(){
    return entites;
  }


  public Collection<Executable> getExecutables(){
    ArrayList<Executable> executables;
    executables=new ArrayList<Executable>();
    for(Entite e : entites.values()){
      if (e instanceof Executable){
        executables.add((Executable)e);
      }
    }
    return executables;
  }
}
