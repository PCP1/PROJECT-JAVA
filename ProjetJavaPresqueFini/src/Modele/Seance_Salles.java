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
public class Seance_Salles {
    
    protected int id_seance;
    protected int id_salle;    
    
    public Seance_Salles()
    {  
    }
    
    public Seance_Salles(int id_seance, int id_salle)
    {        
        this.id_seance=id_seance;
        this.id_salle=id_salle;
    }
    
    @Override
    public String toString()
    {
        return "ID Seance:" + this.id_seance + " ID Salle:" + this.id_salle;
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
    
    public int getid_salle()
    {
        return id_salle;
    }
    
    public void setid_salle(int id_salle){
        this.id_salle=id_salle;
    }
}
