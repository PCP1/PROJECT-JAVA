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
public class Groupe extends Enseignant{
    private int id_groupe;
    private String nom_groupe;
    
    /**
     * Constructeur par defaut
     */
    public Groupe () {}
    
    /**
     * Constructeur surcharge
     * @param id_groupe
     * @param nom_groupe
     */
    public Groupe(int id_groupe, String nom_groupe)
    {
        this.id_groupe = id_groupe;
        this.nom_groupe = nom_groupe;
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
