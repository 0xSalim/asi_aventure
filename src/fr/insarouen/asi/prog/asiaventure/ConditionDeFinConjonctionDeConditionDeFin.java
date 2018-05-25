package fr.insarouen.asi.prog.asiaventure;

public class ConditionDeFinConjonctionConditionDeFin extends ConditionDeFin{
  private EtatDuJeu etatDuJeu;

  ConditionDeFinConjonctionConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs) {
    private boolean tousEnCours=true;
    for (cf: cfs){
      if (cf.verifierCondition()!=EtatDuJeu.ENCOURS){
        tousEnCours=false;
      }
    }
    if(tousEnCours){
      this.etatDuJeu=EtatDuJeu.ENCOURS;
    }else{
      this.etatDuJeu=etatDuJeu;
    }
  }

  public EtatDuJeu verifierCondition(){
    return this.etatDuJeu;
  }
}
