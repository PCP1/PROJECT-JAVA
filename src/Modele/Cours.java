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
    protected int id;
    private String nom;
    
    /**
     *Constructeur par defaut
     */
    public Cours()
    {
    }
     
    /**
     *Constructeur surchargé
     * @param id
     * @param nom
     */
    public Cours(int id, String nom)
    {
        this.id=id;
        this.nom=nom;
    }

    /*public Cours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
   
    
    ///////////////////////// GETTER AND SETTER ///////////////////////////////////
    
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
