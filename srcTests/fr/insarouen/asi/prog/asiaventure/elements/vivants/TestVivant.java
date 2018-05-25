package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.After;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TestVivant{

  public Monde monde;
  public Piece piece;
  public Vivant vivant;
  public PiedDeBiche pieddebiche;
  public PiedDeBiche pieddebiche2;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("Monde Test");
    piece = new Piece("Piece Test",monde);
    pieddebiche = new PiedDeBiche("Pied De Biche",monde);
    pieddebiche2 = new PiedDeBiche("Pied De Biche 2",monde);
    vivant = new Vivant("Vivant Test", monde, 10, 15, piece, pieddebiche){};
  }

  @Test
  public void testConstructeurVivant(){
    assertThat(vivant.getNom(),equalTo("Vivant Test"));
    assertThat(vivant.getMonde(),equalTo(monde));
    assertThat(vivant.getPointVie(),equalTo(10));
    assertThat(vivant.getPointForce(),equalTo(15));
    assertThat(vivant.getPiece(),equalTo(piece));
    assertThat(vivant.getObjets().containsValue(pieddebiche),is(true));
    assertThat(vivant.getObjets().containsValue(pieddebiche2),is(false));
  }

  @Test
  public void testDeposer() throws ObjetNonPossedeParLeVivantException{
    vivant.deposer(pieddebiche);
    assertThat(vivant.getObjets().size(),equalTo(0));
  }

  @Test
  public void testPrendre() throws ObjetNonPossedeParLeVivantException,ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    vivant.deposer(pieddebiche);
    vivant.prendre(pieddebiche);
    assertThat(vivant.getObjets().containsValue(pieddebiche),is(true));
  }

  @Test
  public void testGetObjets(){
    assertThat(vivant.getObjets().containsValue(pieddebiche),is(true));
  }

  @Test
  public void testGetPointVie(){
    assertThat(vivant.getPointVie(),equalTo(10));
  }

  @Test
  public void testGetPointForce(){
    assertThat(vivant.getPointForce(),equalTo(15));
  }

  @Test
  public void testGetPiece(){
    assertThat(vivant.getPiece(),equalTo(piece));
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void testObjetNonPossedeParLeVivantException() throws ObjetNonPossedeParLeVivantException{
    vivant.deposer(pieddebiche2);
  }
}
