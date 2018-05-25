package fr.insarouen.asi.prog.asiaventure.elements.vivants;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;


/**
 * Vivants est une classe qui est une Entite.
 * @see Entite
 *
 * @author Theo Castel et Salim Talout
 * @version 3.0
*/
public abstract class Vivant extends Entite implements Executable{
  private int pointVie;
  private int pointForce;
  private Map <String, Objet> objets; //convertir en Map a la declaration seulement
  private Piece piece;


  /**
   * Constructeur Vivant : cree une instance Vivant
   * @param  String   nom           Nom du vivant.
   * @param  Monde    monde         Monde du vivant.
   * @param  int      pointVie      Points de vie du vivant.
   * @param  int      pointForce    Points de force du vivant.
   * @param  Piece    piece         Piece dans laquelle se trouve le vivant.
   * @param  Objet... objets        Objets que detient le vivant.
   *
   * @see Entite#Entite(String, Monde)
   * @see Objet
   * @see Piece
  */
  public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pointVie=pointVie;
    this.pointForce=pointForce;
    this.objets= new HashMap<String,Objet>();
    for (short i=0;i<objets.length;i++){
      this.objets.put(objets[i].getNom(),objets[i]);
    }
    this.piece=piece;
    //faire entrer le vivant dans la piece
  }

  /**
   * Retourne les informations du vivant.
   * @return Chaine de caractere (les informations du vivant).
  */
  public String toString(){
    StringBuilder s = new  StringBuilder(99999);
    s.append(" \n");
    s.append("Nom : ");
    s.append(this.getNom());
    s.append(" \nMonde : ");
    s.append(this.getMonde().getNom());
    s.append(" \nPiece : ");
    s.append(this.piece.getNom());
    s.append(" \nInventaire :\n ");
    for (String h: objets.keySet()){
      s.append(h);
    }
    return s.toString();
  }

  /**
   * Sert a deposer un objet (a partir de son nom) dans une piece (ajoute a la piece et retire au vivant).
   * @param String nomObj Nom de l'objet a deposer.
  */
  public void deposer(String nomObj) throws ObjetNonPossedeParLeVivantException{
    Objet objTmp=objets.remove(nomObj);
    if (objTmp==null){
      throw new ObjetNonPossedeParLeVivantException("ObjetNonPossedeParLeVivantException");
    }else{
      this.piece.deposer(objTmp);
    }
  }

  /**
   * Sert a deposer un objet dans une piece (ajoute a la piece et retire au vivant).
   * @param Objet obj Objet a deposer.
  */
  public void deposer(Objet obj) throws ObjetNonPossedeParLeVivantException{
    deposer(obj.getNom());
  }

  /**
   * Sert a prendre un objet dans une piece (retire l'objet de la piece et l'ajoute au vivant).
   * @param Objet obj Objet a prendre.
  */
  public void prendre(Objet obj) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    prendre(obj.getNom());
  }

  /**
   * Sert a prendre un objet dans une piece (retire l'objet de la piece et l'ajoute au vivant).
   * @param String nomObj Nom de l'objet a prendre.
  */
  public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{
    if (!this.piece.contientObjet(nomObj)) {
      throw new ObjetAbsentDeLaPieceException("ObjetAbsentDeLaPieceException");
    }else{
      Objet obj = this.piece.retirer(nomObj);
      if (!obj.estDeplacable()){
    	  throw new ObjetNonDeplacableException("ObjetNonDeplacableException");
      }else{
    	  objets.put(nomObj,obj);
      }
    }
  }

  /**
   * Retourne les objets que detient le vivant.
  */
  public Map <String, Objet> getObjets(){
    return this.objets;
  }


  /**
   * Retourne les points de vie que detient le vivant.
  */
  public int getPointVie(){
    return this.pointVie;
  }

  /**
   * Retourne les points de force que detient le vivant.
  */
  public int getPointForce(){
    return this.pointForce;
  }

  public Objet getObjet(String nomObj){
    return objets.get(nomObj);
  }

  /**
   * Retourne la piece ou se trouve le vivant.
  */
  public Piece getPiece(){
    return this.piece;
  }

  /**
   * Sert a franchir une porte.
   * Fait sortir d'une piece, et fait entrer dans une autre.
   * @param  Porte                                porte         Porte a franchir.
   * @throws PorteFermeException                  Si la porte est fermee.
   * @throws PorteInexistanteDansLaPieceException Si la porte n'existe pas dans la piece.
   */
  public void franchir(String porte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
    this.franchir((Porte)this.getMonde().getEntite(porte));
  }

  /**
   * Sert a franchir une porte a partir de son nom.
   * Fait sortir d'une piece, et fait entrer dans une autre.
   * @param  String                               nomPorte        Nom de la porte a franchir.
   * @throws PorteFermeException                  Si la porte est fermee.
   * @throws PorteInexistanteDansLaPieceException Si la porte n'existe pas dans la piece.
  */
  public void franchir(Porte porte) throws PorteFermeException, PorteInexistanteDansLaPieceException{

      if(this.getPiece().aLaPorte(porte.getNom())){
        if(this.getPiece().getPorte(porte.getNom()).getEtat()==Etat.OUVERT || this.getPiece().getPorte(porte.getNom()).getEtat()==Etat.CASSE){
          this.piece=porte.getPieceAutreCote(this.piece);
        }else{
          throw new PorteFermeException("Porte fermee");
        }
      }else{
        throw new PorteInexistanteDansLaPieceException("La porte n'existe pas dans cette piece");
      }
    
  }

  /**
   * Sert a activer un objet activable.
   * @param  Activable           activable     Activable a activer.
   * @throws ActivationException On ne peut pas activer cet activable.
  */
  public void activerActivable(Activable activable)throws ActivationException{
    activable.activer();
  }

  /**
   * Sert a activer un objet activable avec un Objet.
   * @param  Activable           activable     Activable a activer.
   * @param  Objet              objet     Objet permettant l'activation
   * @throws ActivationException On ne peut pas activer l'activable.
  */
  public void activerActivableAvecObjet(Activable activable, Objet objet)throws ActivationException{
    activable.activerAvec(objet);
  }

  /**
   * Permet de fixer les points de vie d'un Vivant.
   * @param int pointVie Points de vie a mettre.
   */
  public void setPointDeVie(int pointVie){
    this.pointVie=pointVie;
  }

  /**
   * Retourne vrai si le vivant est mort.
   * @return boolean : vrai si le vivant est mort.
   */
  public boolean estMort(){
    return this.pointVie<=0;
  }


}
