package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import java.util.Random;

/**
 * Serrure est une classe qui est un Objet.
 * @see Objet
 * @see Activable
 * @author Theo Castel et Salim Talout
 * @version 1.0
*/
public class Serrure extends Objet implements Activable{

  /**
   * Clef permettant de deverouiller la serrure.
   */
  private Clef clef;

  /**
   * Etat de la serrure (VERROUILLE ou DEVERROUILLE)
   */
  private Etat etat;

  /**
   * Contructeur Serrure
   * @param  String                                    nom           Nom de la serrure
   * @param  Monde                                     monde         Monde dans lequel se trouve la serrure
   * @throws NomDEntiteDejaUtiliseDansLeMondeException Si le nom donne a la serrure est deja utilise par une entite du monde.
   */
  public Serrure(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde);
    this.clef=null;
    this.etat=Etat.VERROUILLE;
  }

  /**
   * Contructeur Serrure
   * @param  Monde                                     monde         Monde dans lequel se trouve la serrure
   * @throws NomDEntiteDejaUtiliseDansLeMondeException Si le nom donne a la serrure est deja utilise par une entite du monde (n'arrive jamais).
   */
  public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    this(creerNom("Serrure"),monde);
  }

  /**
   * Permet de savoir si la serrure est deplacable (retourne toujours faux).
   * @return Faux
  */
  public boolean estDeplacable(){
    return false;
  }

  /**
   * Permet d'activer la serrure (inutile).
   * @throws ActivationException Si l'activation est impossible.
  */
  public void activer()throws ActivationImpossibleException{}

  /**
   * Permet d'activer la serrure avec un objet (verrouiller ou deverrouiller)
   * @param Objet obj Objet permattant l'activation.
  */
  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException {
    if (this.activableAvec(obj)){
      if (this.getEtat()==Etat.VERROUILLE){
        this.etat=Etat.DEVERROUILLE;
      }else{
        if (this.getEtat()==Etat.DEVERROUILLE){
          this.etat=Etat.VERROUILLE;
        }
      }
    }else{
      throw new ActivationImpossibleAvecObjetException("La serrure "+this.getNom()+" n'est pas activable avec l'objet "+obj.getNom());
    }
  }

  /**
   * Permet de savoir si la serrure est activable avec un objet.
   * @param  Objet obj           Objet permettant l'activation a tester.
   * @return       boolean : vrai si l'objet correspond a la bonne clef.
  */
  public boolean activableAvec(Objet obj){
    return (obj==this.clef);
  }

  /**
   * Permet de creer une clef, et de l'assigner a la serrure.
   * @return Clef
  */
  public final Clef creerClef(){
    if (this.clef==null){
      try{
        this.clef =new Clef(this.creerNom("Clef"),this.getMonde());
      }catch(NomDEntiteDejaUtiliseDansLeMondeException e){
        System.err.println("Ne doit jamais arriver");
      }
    }
    return this.clef;
  }

  /**
   * Permet d'obtenir l'etat de la serrure.
   * @return Etat
  */
  public Etat getEtat(){
    return this.etat;
  }

  /**
   * Permet de generer un nom unique a partir d'une chaine de caractere de depart.
   * @param  String typeDeNom     Chaine de caractere de depart.
   * @return        String : Nom unique
  */
  private static String creerNom(String typeDeNom){
    Random rn = new Random();
    return typeDeNom+"no"+String.valueOf(rn.nextInt());
  }
}
