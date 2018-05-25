package fr.insarouen.asi.prog.asiaventure;

import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.HashMap;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.CommandeImpossiblePourLeVivantException;
import java.util.Collection;
import java.util.List;

public class Simulateur{

  private Monde monde;

  private EtatDuJeu etatDuJeu;

  private List<ConditionDeFin> conditions= new ArrayList<ConditionDeFin>();

  public Simulateur(Monde monde) {
    this.monde = monde;
  }

  public Simulateur(java.io.ObjectInputStream ois) throws IOException, ClassNotFoundException {
    this.monde = (Monde)ois.readObject();
    ois.close();
  }

  public Simulateur(java.io.Reader reader) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException {
    Scanner sc = new Scanner(reader);
    while (sc.hasNext()) {
      switch (sc.next()) {
        case "Monde" :
          construitMonde(sc);
          break;
        case "Piece" :
          construitPiece(sc);
          break;
        case "Porte" :
          construitPorte(sc);
          break;
        case "PorteSerrure" :
          construitPorteSerrure(sc);
          break;
        case "Clef" :
          construitClef(sc);
          break;
        case "JoueurHumain" :
          construitJoueur(sc);
          break;
        case "ConditionDeFinVivantDansPiece" :
          construitCondition(sc);
          break;
      }
      sc.nextLine();
    }
    reader.close();
  }

  public void enregistrer(java.io.ObjectOutputStream oos) throws IOException {
    oos.writeObject(this.monde);
    oos.close();
  }

  public Monde getMonde() {
    return this.monde;
  }

  private void construitMonde(Scanner sc) {
    this.monde = new Monde(sc.next());
  }

  private void construitPiece(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException {
    new Piece(sc.next(), this.monde);
  }

  private void construitPorte(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException {
    new Porte(sc.next(), this.monde, (Piece)this.monde.getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next()));
  }

  private void construitPorteSerrure(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException {
    new Porte(sc.next(), this.monde, new Serrure(this.monde), (Piece)this.monde.getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next()));
  }

  private void construitClef(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException {
    Clef clef = ((Porte)this.monde.getEntite(sc.next())).getSerrure().creerClef();
    ((Piece)this.monde.getEntite(sc.next())).deposer(clef);
  }

  private void construitJoueur(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException {
    new JoueurHumain(sc.next(), this.monde, sc.nextInt(), sc.nextInt(), (Piece)this.monde.getEntite(sc.next()));
  }

  private void construitCondition(Scanner sc) {
    EtatDuJeu etat;
    if (sc.next().equals("SUCCES")){
      etat=EtatDuJeu.SUCCES;
    }
    else {
      etat=EtatDuJeu.ECHEC;
    }
  
    this.conditions.add(new ConditionDeFinVivantDansPiece(etat, (Vivant)this.getMonde().getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next())));
  }

  public EtatDuJeu getEtatDuJeu(){
    return this.etatDuJeu;
  }

  public EtatDuJeu executerUnTour()throws Throwable,IllegalAccessException,CommandeImpossiblePourLeVivantException{
    for(Iterator i = this.monde.getExecutables().iterator(); i.hasNext();) {
       Executable exe = (Executable)i.next();
       if (exe instanceof JoueurHumain) {
         System.out.println(exe.toString());
         System.out.println("Entrez l'ordre");
         Scanner sc = new Scanner(System.in);
         String ordre = sc.nextLine();
         JoueurHumain joueur = (JoueurHumain)exe;
         joueur.setOrdre(ordre);
       }
       exe.executer();
     }
     for (ConditionDeFin c : conditions){
       this.etatDuJeu= c.verifierCondition();
       if (this.etatDuJeu!=EtatDuJeu.ENCOURS){
         break;
       }
     }
     return this.getEtatDuJeu();
  }

  public EtatDuJeu executerNbTours(int n) throws Throwable {
    EtatDuJeu etat = this.getEtatDuJeu();
    int i = 0;
    while((etat == EtatDuJeu.ENCOURS) && (i<n)) {
      etat = this.executerUnTour();
      i++;
    }
    return etat;
  }

  public EtatDuJeu executerJusquaLaFin()throws Throwable,IllegalAccessException,CommandeImpossiblePourLeVivantException {

    EtatDuJeu etat=this.getEtatDuJeu();
    while(etat==EtatDuJeu.ENCOURS){
      etat=this.executerUnTour();
    }
    return etat;
  }
}
