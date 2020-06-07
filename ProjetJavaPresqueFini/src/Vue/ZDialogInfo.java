package Vue;

public class ZDialogInfo {
  private String date,groupe,enseignant,salle,cours,typecours,semaine,capacite;
  private int HeureDebut;

  public ZDialogInfo(){}
  public ZDialogInfo(String date, int HeureDebut, String groupe, String enseignant, String salle, String cours, String typecours,String semaine,String capacite){
    this.date = date;
    this.HeureDebut = HeureDebut;
    this.groupe = groupe;
    this.enseignant = enseignant;
    this.salle = salle;
    this.cours = cours;
    this.typecours = typecours;
    this.semaine = semaine;
    this.capacite = capacite;
  }

  public String toString(){
    String str;
    if(this.date != null && this.HeureDebut != 0 && this.groupe != null && this.enseignant != null && this.salle != null && this.cours != null && this.typecours != null && this.semaine != null && this.capacite != null){
      str = "Description de la séance ajouté : \n";
      str += "Date : " + this.date + "\n";
      str += "Heure de Début : " + this.HeureDebut + "\n";
      str += "Groupe : " + this.groupe + "\n";
      str += "Enseignant : " + this.enseignant + "\n";
      str += "Salle : " + this.salle + "\n";
      str += "Cours : " + this.cours + "\n";
      str += "Type de cours : " + this.typecours + "\n";
      str += "Semaine : " + this.semaine + "\n";
      str += "Capacite : " + this.capacite + "\n";
      
      String SSemaine = this.semaine;
      System.out.println("Semaine en STRING : "+SSemaine);
      int ISemaine = Integer.parseInt(SSemaine);
      System.out.println("Semaine en INT : "+ISemaine);
      
      String SCapacite = this.semaine;
      System.out.println("Capacité en STRING : "+SCapacite);
      int ICapacite = Integer.parseInt(SCapacite);
      System.out.println("Capacité en INT : "+ICapacite);
      
      
    }
    else{
      str = "Aucune information !";
    }
    return str;
  }
}
