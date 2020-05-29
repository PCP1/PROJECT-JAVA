/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author pcane
 */
public class Seance {
    private int id_seance;
    private String semaine;
    private String date;
    private int heure_debut;
    private int heure_fin;
    private String etat;
    private Cours cours;
    private Type_Cours type_cours;
    
    public Seance()
    {
        
    };
    public Seance(int id_seance, String semaine, String date, int heure_debut, int heure_fin, String etat, Cours cours, Type_Cours type_cours)
    {
        this.id_seance = id_seance;
        this.semaine=semaine;
        this.date=date;
        this.heure_debut=heure_debut;
        this.heure_fin=heure_fin; 
        this.etat=etat;
        this.cours=cours;
        this.type_cours=type_cours;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "id:"+this.id_seance + " semaine:"+this.semaine+" date:"+this.date+" heure debut:"+this.heure_debut+ " heure fin:"+this.heure_fin+" etat:"+this.etat+" id cours:"+this.cours.id_cours+ " nom du cours:"+this.cours.getnom_cours()+" id type de cours:"+this.type_cours.getid_typecours()+" nom du type:"+this.type_cours.getnom_typecours();
    }

    /**
     * @return the ID
     */
    public int getid_senace() {
        return id_seance;
    }

    /**
     * @param id_seance
     */
    public void setid_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    /**
     * @return the semaine
     */
    public String getSemaine() {
        return semaine;
    }

    /**
     * @param semaine the semaine to set
     */
    public void setSemaine(String semaine) {
        this.semaine = semaine;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the Heure_Debut
     */
    public int getheure_debut() {
        return heure_debut;
    }

    /**
     * @param heure_debut
     */
    public void setheure_debut(int heure_debut) {
        this.heure_debut = heure_debut;
    }

    /**
     * @return the Heure_fin
     */
    public int getheure_fin() {
        return heure_fin;
    }

    /**
     * @param heure_fin
     */
    public void setheure_fin(int heure_fin) {
        this.heure_fin = heure_fin;
    }

    /**
     * @return the Etat
     */
    public String getetat() {
        return etat;
    }

    /**
     * @param etat
     */
    public void setetat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the Cours
     */
    public Cours getcours() {
        return cours;
    }

    /**
     * @param cours
     */
    public void setcours(Cours cours) {
        this.cours = cours;
    }

    /**
     * @return the Type_Cours
     */
    public Type_Cours gettype_cours() {
        return type_cours;
    }

    /**
     * @param type_cours
     */
    public void settype_cours(Type_Cours type_cours) {
        this.type_cours = type_cours;
    }
    
}
