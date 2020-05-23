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
public class Utilisateur {
    
    protected int id;
    protected String email;
    protected String password;
    protected String nom; 
    protected String prenom;
    protected int droit;
    
    /**
     *Constructeur par defaut
     */
    public Utilisateur() {};
    
    
    /**
     *Constructeur surchargé
     * @param id
     * @param email
     * @param password
     * @param nom
     * @param prenom
     * @param droit
     */
    public Utilisateur(int id, String email, String password, String nom, String prenom, int droit)
    {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
        this.droit=droit;
    }
    
    /**
     *Constructeur surchargé
     * @param utilisateur
     */
  /*  public Utilisateur( Utilisateur utilisateur)
    {
        this.id = utilisateur.id;
        this.nom = utilisateur.nom;
        this.prenom= utilisateur.prenom;
        this.email = utilisateur.email;
        this.password = utilisateur.password;
        this.droit = utilisateur.droit;
    }*/

   

    
    
    //////////////////////////////// GET AND SET///////////////////////////////////
    
    /**
     *
     * @return getid
     */
    public int getid(){
        return id;
    }
    
    /**
     * setid
     * @param id
     */
    public void setid(int id){
        this.id=id;
    }
    
    /**
     * getnom
     * @return
     */
    public String getnom()
    {
        return nom;
    }
    
    /**
     *
     * @param nom
     */
    public void setnom(String nom)
    {
        this.nom=nom;
    }
    
    /**
     *
     * @return
     */
    public String getprenom()
    {
        return prenom;
    }
    
    /**
     *
     * @param prenom
     */
    public void setprenom(String prenom)
    {
        this.prenom=prenom;
    }
    
    /**
     *
     * @return
     */
    public String getemail()
    {
        return email;
    }
    
    /**
     *
     * @param email
     */
    public void setemail(String email)
    {
        this.email=email;
    }
    
     public String getpassword()
    {
        return password;
    }
    
    /**
     *
     * @param password
     */
    public void setpassword(String password)
    {
        this.password=password;
    }
    
    public int getdroit()
    {
        return droit;
    }
    
    public void setdroit(int droit)
    {
        this.droit=droit;
    }
    
}
