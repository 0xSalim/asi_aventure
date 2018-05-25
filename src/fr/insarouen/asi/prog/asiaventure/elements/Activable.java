package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
 * Activable est une interface.
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public interface Activable {
  public boolean activableAvec(Objet obj);
  public void activer() throws ActivationException;
  public void activerAvec(Objet obj) throws ActivationException;
}
