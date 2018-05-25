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

/**
 * Monstre est une classe qui est un vivant.
 * @see Vivant
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class Monstre extends Vivant {

  /**
   * Constructeur Monstre
   * (voir constructeur Vivant)
   * @param  String                                    nom           Nom du monstre.
   * @param  Monde                                     monde         Monde dans lequel se trouve le monstre.
   * @param  int                                       pointVie      Points de vie du monstre.
   * @param  int                                       pointForce    Points de force du monstre.
   * @param  Piece                                     piece         Piece dans laquelle se trouve le monstre.
   * @param  Objet...                                  objets        Objets que possede le monstre.
   * @throws NomDEntiteDejaUtiliseDansLeMondeException S'il existe deja une entite portant le meme nom que celle que l'on veut ajouter au monde.
  */
  public Monstre(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde, pointVie, pointForce, piece, objets);
  }

  /**
   * Permet de changer de Piece de maniere aleatoire, si au moins une porte le permet.
   * Le monstre ne peut pas deverouiller une porte.
   * @see Vivant#franchir(Porte)
   * @see Vivant#setPointDeVie(int)
   * @see Porte
   * @throws ActivationImpossibleException        Si l'activation de la porte est impossible.
   * @throws PorteFermeException                  Si la porte est fermee.
   * @throws PorteInexistanteDansLaPieceException Si la porte n'existe pas dans la piece
   */
  public void changerDePiece()throws ActivationImpossibleException,PorteFermeException, PorteInexistanteDansLaPieceException{
    Porte[] tabPortes=(Porte[])this.getPiece().getPortes().values().toArray();
    Random rnd = new Random();
    int numPorteAFranchir = rnd.nextInt(tabPortes.length);
    Porte porteAFranchir;
    do{
      porteAFranchir=tabPortes[numPorteAFranchir];
    }while(porteAFranchir.getSerrure().getEtat()!=Etat.VERROUILLE);
    if(porteAFranchir.getEtat()==Etat.DEVERROUILLE || porteAFranchir.getEtat()==Etat.FERME){
      porteAFranchir.activer();
    }
    this.franchir(porteAFranchir);
    this.setPointDeVie(this.getPointVie()-1);
  }

  /**
   * Permet au monstre de deposer son inventaire, puis de recuperer tous les objets de la piece dans laquelle il se trouve.
   * @throws ObjetAbsentDeLaPieceException       Si l'objet n'est pas dans la piece.
   * @throws ObjetNonDeplacableException         Si l'objet n'est pas deplacable.
   * @throws ObjetNonPossedeParLeVivantException Si le vivant ne possede pas l'objet.
   */
  public void toutDeposerEtToutPrendre()throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException, ObjetNonPossedeParLeVivantException{
    Collection<Objet> objetsDeLaPiece=this.getPiece().getObjets().values();
    Collection<Objet> objetsDuMonstre=this.getObjets().values();
    for(Iterator<Objet> i=objetsDuMonstre.iterator();i.hasNext();){
      deposer(i.next());
    }
    for(Iterator<Objet> i=objetsDeLaPiece.iterator();i.hasNext();){
      Objet objetAPrendre=i.next();
      if(objetAPrendre.estDeplacable()){
        prendre(objetAPrendre);
      }
    }
  }

  /**
   * Permet de gerer le comportement du monstre :
   * Le monstre se deplace a travers les pieces en franchissant au hasard les portes non verouillees.
   * Le Monstre doit ramasser tout ce qu’il trouve dans une piece et deposer tout ce qu’il avait avant.
   * Le Monstre perd un point de vie a chaque franchissement de porte.
   * Une fois mort le monstre ne peut plus rien faire.
   * @throws ObjetNonDeplacableException          Si l'objet est non deplacable.
   * @throws ObjetAbsentDeLaPieceException        Si l'objet est absent de la piece.
   * @throws ObjetNonPossedeParLeVivantException  Si le vivant ne possede pas l'objet.
   * @throws ActivationImpossibleException        Si l'activation n'est pas possible.
   * @throws PorteFermeException                  Si la porte est fermee.
   * @throws PorteInexistanteDansLaPieceException Si la poste n'existe pas dans la piece.
   */
  public void executer()throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException,ObjetNonPossedeParLeVivantException, ActivationImpossibleException,PorteFermeException,PorteInexistanteDansLaPieceException{
    if(!this.estMort()){
      this.changerDePiece();
      this.toutDeposerEtToutPrendre();
    }
  }
}
