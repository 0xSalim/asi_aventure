package fr.insarouen.asi.prog.asiaventure.elements.objets;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;

/**
 * Objet est une classe qui est une Entite.
 * @see Entite
 *
 * @author Theo Castel et Salim Talout
 * @version 1.0
 */
public abstract class Objet extends Entite{

  /**
   * Constructeur Objet : sert a creer une nouvelle instance Objet.
   *
   * @param nom Nom de l'objet
   * @param monde Monde de l'objet
   *
   * @see Entite#Entite(String, Monde)
   * @see Entite#nom
   * @see Entite#monde
  */
  public Objet(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
    super(nom,monde);
  }

  /**
   * Retourne vrai si un objet est deplacable.
   * @return Booleen (vrai si l'objet est deplacable).
  */
  public abstract boolean estDeplacable();
}
