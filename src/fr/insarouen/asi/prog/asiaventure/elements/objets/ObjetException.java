package fr.insarouen.asi.prog.asiaventure.elements.objets;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;

/**
 * ObjetNonDeplacableException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class ObjetException extends ASIAventureException {

  public  ObjetException(){
    super();
  }

  public  ObjetException(String msg){
    super(msg);
  }
}
