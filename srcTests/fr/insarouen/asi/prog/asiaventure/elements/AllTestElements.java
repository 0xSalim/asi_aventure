package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.TestEntite;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.TestVivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPiece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.AllTestObjets;


@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestEntite.class,
  TestVivant.class,
  TestPiece.class,
  AllTestObjets.class
})

public class AllTestElements {}
