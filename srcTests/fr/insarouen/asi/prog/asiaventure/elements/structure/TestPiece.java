package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.After;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TestPiece{

  public Monde monde;
  public Piece piece;
  public PiedDeBiche pieddebiche;
  public Vivant vivant;
  public Vivant vivant2;
  public Piece piece2;
  public PiedDeBiche pieddebiche2;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("Monde Test");
    piece = new Piece("Piece Test", monde);
    piece2 = new Piece("Piece Test 2",monde);
    pieddebiche = new PiedDeBiche("Pied De Biche",monde);
    pieddebiche2 = new PiedDeBiche("Pied De Biche 2",monde);
    vivant = new Vivant("Vivant Test", monde, 10, 15, piece, pieddebiche){};
    vivant2 = new Vivant("Vivant Test2", monde, 10, 15, null, pieddebiche){};
  }

  @Test
  public void testConstructeurPiece(){
    assertThat(piece.getNom(),equalTo("Piece Test"));
    assertThat(piece.getMonde(),equalTo(monde));
  }

  @Test
  public void testEntrer() {
    piece.entrer(vivant2);
    assertThat(piece.getVivants().containsValue(vivant2),is(true));
  }

  @Test
  public void testContientObjet() throws ObjetNonPossedeParLeVivantException{
    vivant.deposer(pieddebiche);
    assertThat(piece.getObjets().containsValue(pieddebiche),is(true));
  }

  @Test
  public void testDeposer(){
    piece.deposer(pieddebiche2);
    assertThat(piece.getObjets().containsValue(pieddebiche2),is(true));
  }

  @Test
  public void testRetirer() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    piece.deposer(pieddebiche2);
    piece.retirer(pieddebiche2);
    assertThat(piece.getObjets().size(),equalTo(0));
  }

  @Test
  public void testGetObjets(){
    piece.deposer(pieddebiche);
    piece.deposer(pieddebiche2);
    assertThat(piece.getObjets().containsValue(pieddebiche),is(true));
  }
}
