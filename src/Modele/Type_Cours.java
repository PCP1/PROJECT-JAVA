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
public class Type_Cours {
    
    protected int id_typecours;
    private String nom_typecours;
    
    public Type_Cours() {}
    
    public Type_Cours(int id_typecours, String nom_typecours)
    {
        this.id_typecours=id_typecours;
        this.nom_typecours=nom_typecours;
    }
    
    @Override
    public String toString()
    {
        return "Type Cours : " + this.id_typecours + "Nom du cours : " + this.nom_typecours;
    }
    
     ///////////////////////// GETTER AND SETTER ///////////////////////////////////
    
    public int getid_typecours()
    {
        return id_typecours;
    }
    
    public void setid(int id_typecours)
    {
        this.id_typecours=id_typecours;
    }
    
    public String getnom_typecours()
    {
        return nom_typecours;
    }
    
    public void setnom(String nom_typecours)
    {
        this.nom_typecours=nom_typecours;
    }         
}
