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
    
    private int id;
    private String nom;
    
    /**
     *Constructeur par defaut
     */
    public Promotion () {}
    
    
    public Promotion(int id, String nom)
    {
        this.id=id;
        this.nom=nom;
    }
    
    
    ////////////////////// GETTER AND SETTER /////////////////////////
    
    public int getid()
    {
        return id;
    }
    public void setid(int id)
    {
        this.id=id;
    }
    
    
    public String getnom()
    {
        return nom;
    }
    
    public void setnom(String nom)
    {
        this.nom=nom;
    }
    
    
    
}
