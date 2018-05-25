package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;



/**
 * Coffre est une classe qui est un Objet.
 * @see Objet
 * @see Activable
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class Coffre extends Objet implements Activable{

  /**
   * Etat du coffre.
   * @see Etat
  */
  private Etat etat;

  /**
   * Constructeur Coffre : cree une instance de Coffre.
   * @param  String                                    nom           Nom du coffre.
   * @param  Monde                                     monde         Monde dans lequel se trouve le coffre
   * @throws NomDEntiteDejaUtiliseDansLeMondeException Si le nom donne au coffre est deja utilise par une entite du monde.
  */
  public Coffre(String nom,Monde monde)throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde);
  }

  /**
   * Permet de savoir si le coffre est deplacable (retourne toujours faux)
   * @return Faux
  */
  public boolean estDeplacable(){
    return false;
  }

  /**
   * Permet d'activer le coffre (l'ouvrir et le fermer)
   * @throws ActivationException Si l'activation est impossible (le coffre n'est ni ouvert ni ferme).
  */
  public void activer()throws ActivationException{
    if (this.getEtat()==Etat.FERME){
      this.etat=Etat.OUVERT;
    }else{
      if (this.getEtat()==Etat.OUVERT){
        this.etat=Etat.FERME;
      }else{
        throw new ActivationException();
      }
    }
  }

  /**
   * Permet d'activer avec un objet (inutile)
   * @param Objet obj Objet permattant l'activation.
  */
  public void activerAvec(Objet obj){}

  /**
   * Permet de savoir si le coffre est activable avec un objet.
   * @param  Objet obj           Objet permettant l'activation a tester.
   * @return       Faux
  */
  public boolean activableAvec(Objet obj){
    return false;
  }

  /**
   * Permet de connaitre l'etat d'un coffre (ouvert ou ferme).
   * @return Etat :l'etat du coffre.
  */
  public Etat getEtat(){
    return this.etat;
  }
}
