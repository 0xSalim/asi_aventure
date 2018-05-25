package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

/**
 * PorteFermeException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class PorteFermeException extends PieceException {

  public  PorteFermeException(){
    super();
  }

  public  PorteFermeException(String msg){
    super(msg);
  }
}
