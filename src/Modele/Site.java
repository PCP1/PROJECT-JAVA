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
public class Site {
    protected int id_site;
    private String nom_site;
    
    /**
     *Constructeur par defaut
     */
    public Site()
    {
    }
    
    /**
     *Constructeur surcharge
     * @param id_site
     * @param nom_site
     */
    public Site(int id_site, String nom_site)
    {
        this.nom_site=nom_site;
        this.id_site=id_site;
        
    }
    
    ////////////////// GETTER AND SETTER ////////////////////////
    
    public int getid_site()
    {
        return id_site;
    }
    public void setid_site(int id_site)
    {
        this.id_site=id_site;
    }
    
    public String getnom_site()
    {
        return nom_site;
    }
    public void stenom_site(String nom_site)
    {
        this.nom_site=nom_site;
    }
    
}
