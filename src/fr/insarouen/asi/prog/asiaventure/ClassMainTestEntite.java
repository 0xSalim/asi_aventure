
package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;









public class ClassMainTestEntite {
  public static void main(String[] args){

  	try {
      System.out.println("\n Test Entite \n");
      String nomDuMonde="Narnia";

      Monde monde= new Monde(nomDuMonde);
      Monde monde2= new Monde("chepa");
      String nom="Samurai";
      Entite entite=new Entite(nom,monde){};
      System.out.println("nom : "+nom+" monde : "+monde.toString());
      System.out.println("getNom : "+entite.getNom()+" getMonde : "+entite.getMonde().toString());

      // Entite entite2= new Entite(nom,monde){};
      // if (entite.equals(entite2)) {
      //   System.out.println("Entite et entite2 egales ? = vrai");
      // }
      // System.out.println("test toString : "+entite.toString());



      // System.out.println("\nTEST exception EntiteDejaDansUnAutreMondeException\n");
      // monde2.ajouter(entite);


      System.out.println("\n Test Monde \n");
      System.out.println("getNom: "+monde.getNom());
      Entite entite3=new Entite("Ninja",monde){};

      System.out.println("TestToString:"+monde.toString());

      Objet objet =new Objet("test",monde){
  	    public boolean estDeplacable(){
  		    return false;
  	    }
  	  };
      if (!objet.estDeplacable()){
  	    System.out.println("\n Test objet non déplacable par défaut: Vrai");
      }

      PiedDeBiche pieddebiche =new PiedDeBiche("Pied de Biche 1",monde);
      if (pieddebiche.estDeplacable()){
  	    System.out.println("\n Test pieddebiche deplacable: Vrai");
      }

      ElementStructurel ElemS= new ElementStructurel("ElementS",monde){};

      System.out.println("\ntest ElementStructurel : "+ElemS);

      Piece PieceTest= new Piece("Cuisine",monde);

      System.out.println("\ntest Piece : "+PieceTest);

      PiedDeBiche pieddebiche2 =new PiedDeBiche("Pied de Biche 2",monde);

      System.out.println("\ntest objet present(res attendu : false) : "+PieceTest.contientObjet(pieddebiche));

      System.out.println("\ntest nomObjet present(res attendu : false) : "+PieceTest.contientObjet("Pied de Biche 1"));

      PieceTest.deposer(pieddebiche);
      System.out.println("\ntest objet present(res attendu : true) : "+PieceTest.contientObjet(pieddebiche));

      System.out.println("\ntest nomObjet present(res attendu : true) : "+PieceTest.contientObjet("Pied de Biche 1"));

      System.out.println("\ntest objet present(res attendu : false) : "+PieceTest.contientObjet(pieddebiche2));


      System.out.println("\ntest nomObjet present(res attendu : false) : "+PieceTest.contientObjet("Pied de Biche 2"));



      PieceTest.deposer(pieddebiche2);
      System.out.println("\ntest objet present(res attendu : true) : "+PieceTest.contientObjet(pieddebiche2));

      PiedDeBiche pieddebiche3 =new PiedDeBiche("Pied de Biche 3",monde);
      PieceTest.deposer(pieddebiche3);

      Objet p = PieceTest.retirer("Pied de Biche 1");
      System.out.println("\ntest retirer objet(res attendu : false) : "+PieceTest.contientObjet(pieddebiche));
      System.out.println("\ntest toString Piece : "+PieceTest);

      Piece piece2 = new Piece("piece2",monde);
      Porte porteTest =new Porte("porteTest",monde,piece2,PieceTest);
      System.out.println("TestPorte:\n "+porteTest.toString());

      System.out.println("\n   TEST VIVANT\n");
      // System.out.println("\nTEST exception");
      // testVivant.deposer(pieddebiche2);
      //
      // testVivant.deposer(pieddebiche);
      // System.out.println("test deposer Vivant (res attendu : inventaire vide):\n "+testVivant+"\n"+PieceTest);


      Vivant testVivant=new Vivant("Michel",monde,10,15,PieceTest,pieddebiche){};
      System.out.println("test toString Vivant : "+testVivant);


      // PieceTest.sortir(testVivant);
      // System.out.println("test sortir Vivant :\n "+testVivant+"\n"+PieceTest);


      testVivant.prendre(pieddebiche);
      System.out.println("test prendre Vivant (res attendu : inventaire pieddebiche1):\n "+testVivant+"\n"+PieceTest);



    }
    catch(NomDEntiteDejaUtiliseDansLeMondeException e){
      System.out.println("\n Je suis passe par l'exception "+e.getMessage());
    }
    // catch(EntiteDejaDansUnAutreMondeException e){
    //   System.out.println("\n Je suis passe par l'exception "+e.getMessage());
    // }
    catch(ObjetNonDeplacableException e){
      System.out.println("\n Je suis passe par l'exception "+e.getMessage());
    }
    catch(ObjetAbsentDeLaPieceException e){
      System.out.println("\n Je suis passe par l'exception "+e.getMessage());
    }
    // catch(ObjetNonPossedeParLeVivantException e){
    //   System.out.println("\n Je suis passe par l'exception "+e.getMessage());
    // }
    // catch(VivantAbsentDeLaPieceException e) {
    //   System.out.println("\n Je suis passe par l'exception "+e.getMessage());
    // }
  }

}
