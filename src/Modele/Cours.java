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
public class Cours {
    protected int id_cours;
    private String nom_cours;
    
    /**
     *Constructeur par defaut
     */
    public Cours()
    {
    }
     
    /**
     *Constructeur surchargé
     * @param id_cours
     * @param nom_cours
     */
    public Cours(int id_cours, String nom_cours)
    {
        this.id_cours=id_cours;
        this.nom_cours=nom_cours;
    }

    @Override
    public String toString()
    {
        return "cours:" + this.id_cours+"nom du cours" + this.nom_cours;
    }

   
    
    ///////////////////////// GETTER AND SETTER ///////////////////////////////////
    
    public int getid_cours()
    {
        return id_cours;
    }
    
    public void setid(int id_cours)
    {
        this.id_cours=id_cours;
    }
    
    public String getnom_cours()
    {
        return nom_cours;
    }
    
    public void setnom(String nom_cours)
    {
        this.nom_cours=nom_cours;
    }
}
