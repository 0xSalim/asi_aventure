package fr.insarouen.asi.prog.asiaventure;

public class ConditionDeFinVivantMort extends ConditionDeFin{
  private EtatDuJeu etatDuJeu;

  public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee,Vivant vivant){
    if(vivant.estMort()){
      this.etatDuJeu=etatConditionVerifiee;
    }
  }

  public EtatDuJeu verifierCondition(){
    return this.etatDuJeu;
  }
}
