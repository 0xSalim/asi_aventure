package fr.insarouen.asi.prog.asiaventure.elements.structure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import java.util.HashMap;



/**
 * Piece est une classe qui est un ElementStructurel.
 * @see ElementStructurel
 *
 * @author Theo Castel et Salim Talout
 * @version 2.0
*/
public class Piece extends ElementStructurel{

  /**
   * Les objets quisont dans la piece.
   * @see Piece#getObjets()
  */
  private HashMap <String,Objet> objets;

  /**
   * Les vivants qui sont dans la piece.
  */
  private HashMap <String,Vivant> vivants;

  /**
   * Les portes dans la piece.
  */
  private HashMap <String, Porte> portes;

  /**
   * Constructeur Piece.
   *
   * @param nom Nom de la piece.
   * @param monde Monde de la piece.
   *
   * @see ElementStructurel#ElementStructurel(String, Monde)
   * @see Entite#nom
   * @see Entite#monde
  */
  public Piece(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
  	super(nom,monde);
    this.objets= new HashMap<String,Objet>();
    this.vivants= new HashMap<String,Vivant>();
    this.portes= new HashMap<String,Porte>();
  }


  /**
   * Sert a faire entrer un vivant dans la piece.
   *
   * @param vivant Vivant qui entre dans la piece.
   *
   * @see Porte
  */
  public void entrer(Vivant vivant) {
    vivants.put(vivant.getNom(),vivant);
  }


  /**
   * Retourne vrai si l'objet est present dans la piece.
   * @param  Objet obj           Objet a tester.
   * @return       Booleen (vrai si l'objet est present dans la piece).
  */
  public boolean contientObjet(Objet obj){
    return contientObjet(obj.getNom());
  }


  /**
   * Retourne vrai si l'objet est present dans la piece a partir du nom.
   * @param  String nomObj        Nom de l'objet a tester
   * @return        Booleen (vrai si l'objet est present dans la piece).
  */
  public boolean contientObjet(String nomObj){
    return objets.containsKey(nomObj);
  }

  /**
   * Permet de deposer (ajouter) un objet dans la piece.
   * @param Objet obj Objet a deposer.
  */
  public  void deposer(Objet obj){
    objets.put(obj.getNom(),obj);
  }

  /**
   * Retourne les objets de la piece.
   * @see Objet
  */
  public HashMap <String,Objet> getObjets(){
    return this.objets;
  }

  /**
   * Permet d'obtenir les vivants de la piece.
   * @return HashMap<String,Vivant> : HashMap contenant la liste des vivants avec leurs noms.
   */
  HashMap <String,Vivant> getVivants(){
    return this.vivants;
  }

  /**
   * Permet de retirer (supprimer) un objet de la piece.
   * @param  Objet obj           Objet a supprimer.
   * @return       Retourne l'objet retire.
  */
  public Objet retirer(Objet obj) throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
    return retirer(obj.getNom());
  }

  /**
   * Permet de retirer (supprimer) un objet de la piece a partir de son nom.
   * @param  String nomObj        Nom de l'objet a retirer.
   * @return        Retourne l'objet retire.
  */
  public Objet retirer(String nomObj) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    Objet objTemp=objets.remove(nomObj);
    if (!objTemp.estDeplacable()){
      throw new ObjetNonDeplacableException("ObjetNonDeplacableException");
    }else{
      return objTemp ;
    }
  }

  /**
   * Permet de faire sortir un vivant de la piece a partir du nom du vivant.
   * @param  java.lang.String               nomVivant     Nom du vivant a faire sortir.
   * @return                                Vivant : Retourne le vivant sorti.
   * @throws VivantAbsentDeLaPieceException Si le vivant n'est pas dans la piece.
  */
  public Vivant sortir(java.lang.String nomVivant) throws VivantAbsentDeLaPieceException{
    Vivant vivantTmp=vivants.remove(nomVivant);
    if (vivantTmp==null){
      throw new VivantAbsentDeLaPieceException("VivantAbsentDeLaPieceException");
    }else{
      return vivantTmp ;
    }
  }

  /**
   * Permet de faire sortir un vivant de la piece a partir du vivant.
   * @param  java.lang.String               vivant     Vivant a faire sortir.
   * @return                                Vivant : Retourne le vivant sorti.
   * @throws VivantAbsentDeLaPieceException Si le vivant n'est pas dans la piece.
  */
  public Vivant sortir(Vivant vivant) throws VivantAbsentDeLaPieceException{
    return sortir(vivant.getNom());
  }

  /**
   * Retourne un ensemble d'informations sur une piece.
   * @return Chaine de caractere : l'ensemble des informations de la piece.
  */
  public String toString(){
    StringBuilder s = new  StringBuilder(99999);
    s.append(this.getNom());
    s.append(" \nObjets :\n");
    for (String h: objets.keySet()){
      s.append(h);
    }
    s.append(" \nVivants :\n");
    for (String h: vivants.keySet()){
      s.append(h);
    }
    return s.toString();
  }

  /**
   * Permet d'obtenir les portes de la piece.
   * @return HashMap <String, Porte> : Retourne un HashMap contenant les portes de la piece avec leurs noms.
  */
  public HashMap <String, Porte> getPortes(){
    return this.portes;
  }

  /**
   * Permet d'obtenir une porte de la piece a partir de son nom.
   * @param  String nomPorte      Nom de la porte a obtenir.
   * @return        Porte : Retourne une porte.
  */
  public Porte getPorte(String nomPorte){
    return portes.get(nomPorte);
  }

  /**
   * Permet d'ajouter une porte a la piece.
   * @param Porte porte Porte a ajouter a la piece.
  */
  protected void addPorte(Porte porte){
    this.portes.put(porte.getNom(),porte);
  }

  /**
   * Permet de savoir si une porte est presente dans la piece, a partir du nom de la porte.
   * @param  String nomPorte      Nom de la porte a tester.
   * @return        boolean : vrai si la porte est presente.
  */
  public boolean aLaPorte(String nomPorte){
    return portes.containsKey(nomPorte);
  }

  /**
   * Permet de savoir si une porte est presente dans la piece.
   * @param  Porte porte      Porte a tester.
   * @return        boolean : vrai si la porte est presente.
  */
  public boolean aLaPorte(Porte porte){
    return portes.containsValue(porte);
  }
}
