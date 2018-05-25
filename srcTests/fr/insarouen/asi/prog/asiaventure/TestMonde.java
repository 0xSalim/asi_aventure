package fr.insarouen.asi.prog.asiaventure;

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

public class TestMonde {

  public Monde monde;
  public Monde monde2;
  public Entite entite;

  @Before
  public void avantTest()throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("Monde Test");
    monde2 = new Monde("Monde Test2");
    entite = new Entite("Entite Test",monde){};
  }

  @Test
  public void testConstructeurMonde(){
    assertThat(monde.getNom(),equalTo("Monde Test"));
  }

  @Test
  public void testEstPresentNomElement(){
    assertThat(monde.estPresentNomElement("Entite Test"),is(true));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testAjouterNomDEntiteDejaUtiliseDansLeMondeException() throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
    monde.ajouter(entite);
  }

  @Test(expected=EntiteDejaDansUnAutreMondeException.class)
  public void testAjouterEntiteDejaDansUnAutreMondeException() throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
    monde2.ajouter(entite);
  }

  @Test
  public void testGetNom(){
    assertThat(monde.getNom(),equalTo("Monde Test"));
  }

  @Test
  public void testGetEntite(){
    assertThat(monde.getEntite("Entite Test"),equalTo(entite));
  }
}
