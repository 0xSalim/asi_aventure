package fr.insarouen.asi.prog.asiaventure.elements;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;

/**
 * Entite est un element indivisible et composite d'un monde.
 * @see Monde
 *
 * @author Theo Castel et Salim Talout
 * @version 2.0
*/
public abstract class Entite {
  private static int MAXIMUMNOMALEATOIRE;
  private String nom;
  private Monde monde;

  /**
   * Constructeur Entite : sert à creer une nouvelle instance Entite.
   * @param  String nom           nom de l'Entite
   * @param  Monde  monde         monde de l'Entite
   * @return        L'entite créée.
  */
  public Entite(String nom,Monde monde)
  	throws NomDEntiteDejaUtiliseDansLeMondeException{
  	this.nom=nom;
  	this.monde=monde;
  	try{
  	  this.monde.ajouter(this);
  	}catch(EntiteDejaDansUnAutreMondeException e){
  	  System.out.println("Ne devrait jamais arriver");
  	  System.exit(13);
  	}
  }


  /**
   * Methode permettant d'obtenir le nom d'une Entite.
   * @return le nom de l'Entite.
  */
  public String getNom(){
    return nom;
  }

  /**
   * Methode permettant d'obtenir le nom d'une Entite.
   * @return le monde de l'entite.
  */
  public Monde getMonde(){
    return monde;
  }

  /**
   * Methode permettant de vérifier l'égalité entre deux Entités.
   * @param  Object o            L'Entite avec laquel on veut tester l'égalité.
   * @return        Un boolean attestant ou non de l'égalité.
  */
  public boolean equals(Object o){
    Entite e=(Entite)o;
    return e.getMonde().equals(this.monde) && e.getNom().equals(this.nom) && (o instanceof Entite);
  }

  /**
   * Methode permettant la modification du hashCode après l'utilisation de la methode equals.
   * @return
  */
  public int hashCode(){
    return nom.hashCode()+monde.hashCode();
  }

  /**
   * Methode permettant de creer la chaine de caractere du nom et du monde de l'Entite.
   * @return La chaine de caractere du nom et du monde de l'Entite.
  */
  public String toString(){
    return this.nom+", "+this.monde.getNom();
  }
}
