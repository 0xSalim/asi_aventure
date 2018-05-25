package fr.insarouen.asi.prog.asiaventure;
import fr.insarouen.asi.prog.asiaventure.MondeException;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * NomDEntiteDejaUtiliseDansLeMondeException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException {

  public  NomDEntiteDejaUtiliseDansLeMondeException(){
    super();
  }

  public  NomDEntiteDejaUtiliseDansLeMondeException(String msg){
    super(msg);
  }
}
