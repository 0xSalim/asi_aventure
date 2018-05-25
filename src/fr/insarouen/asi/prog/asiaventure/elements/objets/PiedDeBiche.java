package fr.insarouen.asi.prog.asiaventure.elements.objets;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;



/**
 * PiedDeBiche est une classe qyu est un Objet
 * @see Objet
 *
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class PiedDeBiche extends Objet{

  /**
   * Constructeur PiedDeBiche : cree une nouvelle instance PiedDeBiche
   * @param  String nom           Nom du pied de biche.
   * @param  Monde  monde         Monde du pied de biche.
   * @return        retourne PiedDeBiche
   *
   * @see Objet#Objet(String, Monde)
   * @see Objet#nom
   * @see Objet@monde
  */
  public PiedDeBiche(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }

  /**
   * Retourne vrai si un pied de biche est deplacable.
   * @return Booleen (vrai si le pied de biche est deplacable).
  */
  public boolean estDeplacable(){
    return true;
  }
}
