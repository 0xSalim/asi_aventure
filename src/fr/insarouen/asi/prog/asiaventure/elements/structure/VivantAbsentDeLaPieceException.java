package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

/**
 * VivantAbsentDeLaPieceException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class VivantAbsentDeLaPieceException extends VivantException {

  public  VivantAbsentDeLaPieceException(){
    super();
  }

  public  VivantAbsentDeLaPieceException(String msg){
    super(msg);
  }
}
