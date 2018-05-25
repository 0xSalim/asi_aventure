package fr.insarouen.asi.prog.asiaventure.elements.vivants;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;

/**
 * ObjetNonPossedeParLeVivantException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class ObjetNonPossedeParLeVivantException extends VivantException {

  public  ObjetNonPossedeParLeVivantException(){
    super();
  }

  public  ObjetNonPossedeParLeVivantException(String msg){
    super(msg);
  }
}
