package fr.insarouen.asi.prog.asiaventure;

public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin{
  private EtatDuJeu etatDuJeu;

  ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant,  Objet[] objets){
    private boolean present=true;
    private int i=0;
    While (present && objets[i]!=null){
      present=vivant.objets.containsValue(objets[i]);
      i++;
    }
    if (present){
      EtatDuJeu=etatConditionVerifiee;
    }
  }

  public EtatDuJeu verifierCondition(){
    return this.etatDuJeu;
  }
}
