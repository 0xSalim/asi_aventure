package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;

/**
 * ObjetAbsentDeLaPieceException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class ObjetAbsentDeLaPieceException extends PieceException {

  public  ObjetAbsentDeLaPieceException(){
    super();
  }

  public  ObjetAbsentDeLaPieceException(String msg){
    super(msg);
  }
}
