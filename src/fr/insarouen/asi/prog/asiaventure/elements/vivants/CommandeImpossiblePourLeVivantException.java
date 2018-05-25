package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
  * CommandeImpossiblePourLeVivantException est une exception.
  *
  * @author Theo Castel et Salim Talout.
  * @version 1.0
*/

public class CommandeImpossiblePourLeVivantException extends VivantException {
  public CommandeImpossiblePourLeVivantException() {
    super();
  }

  public CommandeImpossiblePourLeVivantException(String msg) {
    super(msg);
  }

  // public CommandeImpossiblePourLeVivantException(String msg, Throwable e) {
  //   super(msg,e);
  // }
}
