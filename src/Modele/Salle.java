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
public class Salle extends Site
{
    protected int id_salle;
    private String nom_salle;
    private int capacite_salle;
    
    
    /**
     *Constructeur par defaut
     */
    public Salle()
    {
        super();
    }
    
    
    public Salle(int id_salle, String nom_salle, int capacite_salle){
        
    }
    
    
    
///////////////// GETTER AND SETTER /////////////////////
    
    public int getid()
    {
        return id_salle;
    }
    
    public void setid_salle( int id_salle)
    {
        this.id_salle=id_salle;
    }
    
    public String getnom_salle()
    {
        return nom_salle;
    }
    public void setnom_salle(String nom_salle)
    {
        this.nom_salle=nom_salle;
    }
    
    public int getcapacite_salle()
    {
        return capacite_salle;
    }
    
    public void setcapacite_salle(int capacite_salle)
    {
        this.capacite_salle=capacite_salle;
    }
}
