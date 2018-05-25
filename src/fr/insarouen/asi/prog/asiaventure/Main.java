package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Simulateur;
import java.io.*;
import java.util.Scanner;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


public class Main{

  public static void main (String[] args) throws FileNotFoundException, NomDEntiteDejaUtiliseDansLeMondeException, IOException, ClassNotFoundException {

    Simulateur sim = null;
    Simulateur sim2 = null;
    String chemin;
    int choix =0;
    char choix2;

    do {
      System.out.println("--- Menu --- \n 1/ jouer \n 2/ charger un fichier de description \n 3/ sauver la partie actuelle \n 4/ charger une partie \n 5/ quitter");
      Scanner sc = new Scanner(System.in);
      choix = sc.nextInt();
      System.out.println("Choix : "+choix);

      switch (choix) {
        case 1:
          do{
            try {
                  sim.executerUnTour();
                }
                catch(Throwable e) {
                  if(e.getMessage() == null)
                    System.out.println(e);
                  else
                    System.out.println(e.getMessage());
                }
                if(sim.getEtatDuJeu()==EtatDuJeu.ENCOURS) {
                  Scanner sc2 = new Scanner(System.in);
                  System.out.println("Voulez-vous rejouez ? Y/N");
                  choix2 = sc2.nextLine().charAt(0);
                } else {
                  choix2='N';
                }
              } while (choix2=='Y' && sim.getEtatDuJeu()==EtatDuJeu.ENCOURS);
              if(sim.getEtatDuJeu()==EtatDuJeu.SUCCES) {
                System.out.println("Vous avez gagné !!! :D");
              }
              if(sim.getEtatDuJeu()==EtatDuJeu.ECHEC) {
                System.out.println("Vous avez perdu !!! :'(");
              }

          break;
        case 2:
          System.out.println("Entrez le chemin du fichier de sauvegarde :");
          chemin = sc.next();
          File file = new File(chemin);
          sim = new Simulateur(new FileReader(file));
          System.out.println("La sauvegarde à été chargée.");
          break;
        case 3:
          if (sim == null) {
            System.out.println("Aucune partie à sauvegarder.");
          } else {
            System.out.println("Entrez le chemin du fichier de sauvegarde :");
            chemin = sc.next();
            sim.enregistrer(new ObjectOutputStream(new FileOutputStream(chemin)));
            System.out.println("La partie à été sauvergardée.");
          }
          break;
        case 4:
          System.out.println("Entrez le chemin du fichier de sauvegarde :");
          chemin = sc.next();
          sim = new Simulateur(new ObjectInputStream(new FileInputStream(chemin)));
          System.out.println("La sauvegarde à été chargée.");
          break;
        case 5:
          break;
        default : break;
      }
  }while(choix != 5);

  }
}
