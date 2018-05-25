package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

/**
 * PorteInexistanteDansLaPieceException est une Exception
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class PorteInexistanteDansLaPieceException extends PieceException {

  public  PorteInexistanteDansLaPieceException(){
    super();
  }

  public  PorteInexistanteDansLaPieceException(String msg){
    super(msg);
  }
}
