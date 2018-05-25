package fr.insarouen.asi.prog.asiaventure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.AllTestElements;


@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestMonde.class,
  AllTestElements.class
})

public class AllTestAsiAventure {}
