package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import java.util.Random;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import java.util.StringTokenizer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



/**
 * JoueurHumain est une classe qui est un vivant.
 * @see vivant
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/

public class JoueurHumain extends Vivant{
  private String ordre;


  public JoueurHumain(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde, pointVie, pointForce, piece, objets);
    this.ordre="";
  }

  public void setOrdre(String ordre){
    this.ordre=ordre;
  }

  public String getOrdre(){
    return this.ordre;
  }

  private void commandeAfficher(String nomObjet) {
    System.out.println("Voici les objets présents dans la pièce"+this.getMonde().toString() );
  }

  private void commandePrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
    this.prendre(nomObjet);
  }

  private void commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException {
    this.deposer(nomObjet);
  }

  private void commandeFranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException {
    this.franchir(nomPorte);
  }

  private void commandeOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException {
    System.out.println("On rentre dans commandeOuvrirPorte");
    this.getPiece().getPorte(nomPorte).activer();
    System.out.println("On rentre 2");

  }

  private void commandeOuvrirPorte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException,ObjetNonPossedeParLeVivantException {
    this.getPiece().getPorte(nomPorte).activerAvec(this.getObjet(nomObjet));
  }

  public void executer()throws CommandeImpossiblePourLeVivantException,IllegalAccessException,Throwable{

    Object[] paramsEffectifs = this.ordre.split(" ", 2)[1].split(" ");
     int nb = paramsEffectifs.length;
     Class[] paramsFormels = new Class[nb];
     for( int i=0 ; i<nb ; i++) {
       paramsFormels[i] = String.class;
     }
     String nom = "commande"+ordre.split(" ")[0];
     try {
       Method m = (this.getClass()).getDeclaredMethod(nom, paramsFormels);
       m.invoke(this, paramsEffectifs);
     }
     catch(NoSuchMethodException e) {
       throw new CommandeImpossiblePourLeVivantException("La commande rentrée n'existe pas");
     }
     catch(InvocationTargetException e) {
       throw e.getCause();
     }
  }

}
