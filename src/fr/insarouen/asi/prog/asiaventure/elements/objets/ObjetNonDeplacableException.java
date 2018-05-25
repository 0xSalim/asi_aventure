package fr.insarouen.asi.prog.asiaventure.elements.objets;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

/**
 * ObjetNonDeplacableException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class ObjetNonDeplacableException extends ObjetException {

  public  ObjetNonDeplacableException(){
    super();
  }

  public  ObjetNonDeplacableException(String msg){
    super(msg);
  }
}
