package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Clef est une classe qui est un Objet.
 * @see Objet
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public final class Clef extends Objet {

  /**
   * Constructeur Clef : cree une instance de Clef.
   * @param  String                                    nom           Nom de la clef.
   * @param  Monde                                     monde         Monde dans lequel se trouve la clef.
   * @throws NomDEntiteDejaUtiliseDansLeMondeException Si le nom donne a la clef est deja utilise par une entite du monde.
   */
  protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }

  /**
   * Permet de savoir si la clef est deplacable (retourne toujours vrai).
   * @return Vrai
  */
  public boolean estDeplacable(){
    return true;
  }
}
