package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.Monde;

/**
 * ElementStructurel est une classe qui est une Entite.
 * @see Entite
 *
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public abstract class ElementStructurel extends Entite{
  
  /**
   * Constructeur ElementStructurel :sert à creer une nouvelle instance ElementStructurel
   * @param  String nom           nom de l'ElementStructurel
   * @param  Monde  monde         monde de l'ElementStructurel
   * @see Entite#Entite(String, Monde)
   * @see Entite#nom
   * @see Entite#monde
   * @return l'ElementStructurel créé.
  */
  public ElementStructurel(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException  {
    super(nom,monde);
  }

}
