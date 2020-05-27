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
public class Seance_Enseignants {
    
    protected int id_seance;
    protected int id_enseignant;    
    
    public Seance_Enseignants()
    {  
    }
    
    public Seance_Enseignants(int id_seance, int id_enseignant)
    {        
        this.id_seance=id_seance;
        this.id_enseignant=id_enseignant;
    }
    
    @Override
    public String toString()
    {
        return "ID Seance : " + this.id_seance + "Enseignant :" + this.id_enseignant;
    }
    
    ///////////////////////// GETTER AND SETTER ///////////////////////////////////
    
    
    public int getid_seance()
    {
        return id_seance;
    }
    
    public void setid_seance(int id_seance)
    {
        this.id_seance=id_seance;
    }
    
    public int getid_enseignant()
    {
        return id_enseignant;
    }
    
    public void setid_enseignant(int id_enseignant){
        this.id_enseignant=id_enseignant;
    }
}
