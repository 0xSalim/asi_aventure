package fr.insarouen.asi.prog.asiaventure;

public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFin{
  private EtatDuJeu etatDuJeu;

  ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece,  Objet... objets){
    private boolean present=true;
    private int i=0;
    While (present && objets[i]!=null){
      present=vivant.objets.containsValue(objets[i]);
      i++;
    }
    if (present && vivant.getPiece()==piece){
      EtatDuJeu=etatConditionVerifiee;
    }
  }

  public EtatDuJeu verifierCondition(){
    return this.etatDuJeu;
  }
}
