package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

/**
 * PieceException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class PieceException extends ElementStructurelException {

  public  PieceException(){
    super();
  }

  public  PieceException(String msg){
    super(msg);
  }
}
