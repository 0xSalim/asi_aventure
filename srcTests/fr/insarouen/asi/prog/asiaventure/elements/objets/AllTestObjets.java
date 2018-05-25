package fr.insarouen.asi.prog.asiaventure.elements.objets;

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

public class AllTestObjets{

  public Monde monde;
  public PiedDeBiche pieddebiche;

  @Before
  public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("Monde Test");
    pieddebiche = new PiedDeBiche("Pied De Biche",monde);
  }

  @Test
  public void testConstructeurPiedDeBiche(){
    assertThat(pieddebiche.getNom(),equalTo("Pied De Biche"));
    assertThat(pieddebiche.getMonde(),equalTo(monde));
  }

  @Test
  public void testEstDeplacable(){
    assertThat(pieddebiche.estDeplacable(),is(true));
  }
}
