package Vue;

public class XDialogInfo {
  private String date,groupe,enseignant,salle,cours,typecours,semaine;
  private int HeureDebut;

  public XDialogInfo(){}
  public XDialogInfo(String cours, String typecours){
    this.cours = cours;
    this.typecours = typecours;
  }

  public String toString(){
    String str;
    if(this.cours != null && this.typecours != null){
      str = "Cours : " + this.cours + "\n";
      str += "Type de cours : " + this.typecours + "\n";
      
      /*String SSemaine = this.semaine;
      System.out.println("Semaine en STRING : "+SSemaine);
      int ISemaine = Integer.parseInt(SSemaine);
      System.out.println("Semaine en INT : "+ISemaine);*/
      
      
    }
    else{
      str = "Aucune information !";
    }
    return str;
  }
}