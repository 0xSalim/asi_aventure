package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import java.util.HashMap;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;


/**
 * Porte est une classe qui est un ElementStructurel.
 * @see ElementStructurel
 *
 * @author Theo Castel et Salim Talout
 * @version 2.0
*/
public class Porte extends ElementStructurel implements Activable {
  private Piece pieceA, pieceB;
  private Etat etat;
  private Serrure serrure;

  /**
   * Constructeur Porte : Cree une instance Porte (sans serrure)
   * @param  String                                    nom           Nom de la porte.
   * @param  Monde                                     monde         Monde dans lequel se trouve la porte.
   * @param  Piece                                     pieceA        Premiere piece de la porte.
   * @param  Piece                                     pieceB        Seconde piece de la porte.
   * @throws NomDEntiteDejaUtiliseDansLeMondeException Si le nom est deja utilise dans le monde.
  */
  public Porte(String nom, Monde monde, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA=pieceA;
    this.pieceB=pieceB;
    this.etat=Etat.FERME;
    this.pieceA.addPorte(this);
    this.pieceB.addPorte(this);
  }

  /**
   * Constructeur Porte : Cree une instance Porte (avec serrure)
   * @param  String                                    nom           Nom de la porte.
   * @param  Monde                                     monde         Monde dans lequel se trouve la porte.
   * @param  Serrure                                   serrure       Serrure de la porte.
   * @param  Piece                                     pieceA        Premiere piece de la porte.
   * @param  Piece                                     pieceB        Seconde piece de la porte.
   * @throws NomDEntiteDejaUtiliseDansLeMondeException Si le nom est deja utilise dans le monde.
  */
  public Porte(String nom, Monde monde,Serrure serrure, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
    this(nom, monde, pieceA, pieceB);
    this.serrure=serrure;
  }

  /**
   * Retourne l'etat de la porte.
   * @see Etat
   * @return Etat : Retourne l'etat de la porte.
  */
  public Etat getEtat(){
    return this.etat;
  }

  /**
   * Retourne la serrure de la porte.
   * @see Serrure
   * @return Serrure : Retourne la serrure de la porte.
  */
  public Serrure getSerrure(){
    return this.serrure;
  }

  /**
   * Retourne l'autre piece de la porte
   * @param  Piece piece         Premiere piece de la porte
   * @return       Piece : Retourne la seconde piece de la porte.
  */
  public Piece getPieceAutreCote(Piece piece) {
    if (piece==this.pieceA) {
      return pieceB;
    } else {
      return pieceA;
    }
  }

  /**
   * Retourne les informations de la porte.
   * @return String : Les informations de la piece.
  */
  public String toString(){
    StringBuilder s = new  StringBuilder(99999);
    s.append(this.getNom());
    s.append(" \nPieces :\n");
    s.append(this.pieceA.getNom());
    s.append("\n");
    s.append(this.pieceB.getNom());
    s.append(" \nMonde :\n");
    s.append(this.getMonde().getNom());
    return s.toString();
  }

  /**
   * Indique si la porte est activable avec un objet.
   * @param  Objet obj           Objet permettant l'activation.
   * @return       boolean : retourne vrai si la porte est activable avec l'objet.
  */
  public boolean activableAvec(Objet obj){
    return (obj instanceof PiedDeBiche);
  }

  /**
   * Permet d'activer une porte :
   * si la porte est ouverte, alors elle la ferme et inversement.
   * @throws ActivationImpossibleException Si l'activation est impossible : si elle est cassee, ou verouillee.
  */
  public void activer() throws ActivationImpossibleException{
    if (this.etat==Etat.CASSE){
      throw new ActivationImpossibleException("On ne peut pas activer la porte "+this.getNom()+" :elle est cassee");
    }
    if (this.etat==Etat.FERME){
      this.etat=Etat.OUVERT;
    } else if (this.etat==Etat.OUVERT) {
      this.etat=Etat.FERME;
    }
  }

  /**
   * Permet d'activer une porte avec un objet.
   * @param  Objet                                  obj           Objet permettant l'activation.
   * @throws ActivationImpossibleException          Si l'activation est impossible.
   * @throws ActivationImpossibleAvecObjetException Si l'objet ne permet pas l'activation (n'est pas la bonne clef, ou n'est pas un pied de biche).
  */
  public void activerAvec(Objet obj) throws ActivationImpossibleException,ActivationImpossibleAvecObjetException{
    if(this.activableAvec(obj)){
      this.etat=Etat.CASSE;
    }else{
      if(this.serrure.getEtat()==Etat.VERROUILLE){
        if(this.serrure.activableAvec(obj)){
          this.serrure.activerAvec(obj);
        }else{
          throw new ActivationImpossibleAvecObjetException("On ne peut pas activer la porte "+this.getNom()+" avec l'objet "+obj.getNom()+" : elle est verrouillee et l'objet n'est pas sa clef.");
        }
      }else{
        this.activer();
      }
    }
  }
}
