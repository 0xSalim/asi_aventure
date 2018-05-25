package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.After;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestEntite {

  public Monde monde;
  public Entite entite;

  @Before
  public void avantTest()throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("Monde Test");
    entite = new Entite("Entite Test",monde){};
  }

  @Test
  public void testConstructeurEntite(){
    assertThat(entite.getNom(),equalTo("Entite Test"));
    assertThat(entite.getMonde(),equalTo(monde));
  }

  @Test
  public void testGetNom(){
    assertThat(entite.getNom(),equalTo("Entite Test"));
  }

  @Test
  public void testGetMonde(){
    assertThat(entite.getMonde(),equalTo(monde));
  }

  @Test
  public void testEquals(){
    assertThat(entite.equals(entite),is(true));
  }

  @Test
  public void testHashCode(){

  }

}
