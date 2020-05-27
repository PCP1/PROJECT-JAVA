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
public class Promotion {
    
    private int id_Promotion;
    private String nom_Promotion;
    
    /**
     *Constructeur par defaut
     */
    public Promotion () {}
    
    
    public Promotion(int id_Promotion, String nom_Promotion)
    {
        this.id_Promotion=id_Promotion;
        this.nom_Promotion=nom_Promotion;
    }

    

    public String toString()
    {
        return "id_Promotion: "+ this.id_Promotion + "nom: " + this.nom_Promotion;
    }
    
    
    ////////////////////// GETTER AND SETTER /////////////////////////

    /**
     *
     * @return
     */
    
    public int getid_Promotion()
    {
        return id_Promotion;
    }
    public void setid_Promotion(int id_Promotion)
    {
        this.id_Promotion=id_Promotion;
    }
    
    
    public String getnom_Promotion()
    {
        return nom_Promotion;
    }
    
    public void setnom_Promotion(String nom_Promotion)
    {
        this.nom_Promotion=nom_Promotion;
    }
    
    
    
}
