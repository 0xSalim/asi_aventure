package fr.insarouen.asi.prog.asiaventure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.MondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
 * EntiteDejaDansUnAutreMondeException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class EntiteDejaDansUnAutreMondeException extends MondeException {

  public  EntiteDejaDansUnAutreMondeException(){
    super();
  }

  public  EntiteDejaDansUnAutreMondeException(String msg){
    super(msg);
  }
}
