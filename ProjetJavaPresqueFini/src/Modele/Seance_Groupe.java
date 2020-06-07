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
public class Seance_Groupe {
    
    protected int id_seance;
    protected int id_groupe;    
    
    public Seance_Groupe()
    {  
    }
    
    public Seance_Groupe(int id_seance, int id_groupe)
    {        
        this.id_seance=id_seance;
        this.id_groupe=id_groupe;
    }
    
    @Override
    public String toString()
    {
        return "ID Seance:" + this.id_seance + " ID Groupe:" + this.id_groupe;
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
    
    public int getid_groupe()
    {
        return id_groupe;
    }
    
    public void setid_groupe(int id_groupe){
        this.id_groupe=id_groupe;
    }
}

