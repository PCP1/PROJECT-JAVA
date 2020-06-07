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
public class Groupe {
    protected int id_groupe;
    private String nom_groupe;
    private Promotion promotion;
    
    /**
     * Constructeur par defaut
     */
    public Groupe () {
        
    }
    
    /**
     * Constructeur surcharge
     * @param id_groupe
     * @param nom_groupe
     */
    public Groupe(Promotion promotion, int id_groupe, String nom_groupe)
    {
        this.promotion=promotion;
        this.id_groupe = id_groupe;
        this.nom_groupe = nom_groupe;
    }

    
    
    public String toString(){
        return " id_promotion:" + this.promotion.getid_Promotion() + " nom_promotion:"+ this.promotion.getnom_Promotion()+" id_groupe:" + this.id_groupe + " nom_groupe"+ this.nom_groupe;
    }
    
    
   
   /////////////////////// GETTER AND SETTER /////////////////////////////
    
    public int getid_groupe()
    {
        return id_groupe;
    }
    
    public void setid_groupe(int id_groupe)
    {
        this.id_groupe=id_groupe;
    }
    public String getnom_groupe()
    {
        return nom_groupe;
    }
    
    public void setnom_groupe(String nom_groupe)
    {
        this.nom_groupe=nom_groupe;
    }
}
