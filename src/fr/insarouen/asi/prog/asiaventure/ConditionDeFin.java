package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

public abstract class ConditionDeFin extends Object implements Serializable {
  private EtatDuJeu etatDuJeu;

  ConditionDeFin(EtatDuJeu etatDuJeu){};

  public EtatDuJeu getEtatConditionVerifiee(){
    return this.etatDuJeu;
  };

  public abstract EtatDuJeu verifierCondition();

}
