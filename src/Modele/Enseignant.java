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
public class Enseignant extends Utilisateur {

    private Cours nom_cours;
    private Cours id_cours;

    /**
     * Constructeur par defaut
     */
    public Enseignant() {
        super();
    }

    /**
     * Constructeur surcharge
     *
     * @param nom_cours
     * @param id_cours
     * @param id
     * @param nom
     * @param prenom
     * @param email
     * @param password
     * @param droit
     */
    public Enseignant(Cours nom_cours, Cours id_cours, int id, String nom, String prenom, String email, String password, int droit) {
        super(id, nom, prenom, email, password, droit);
        this.nom_cours = nom_cours;
        this.id_cours = id_cours;
    }

    

//////////////////////////// GETTER AND SETTER ///////////////////////////////////////////////////////////
    /**
     *
     * @return
     */
    public Cours getnom_cours() {
        return nom_cours;
    }

    /**
     *
     * @param nom_cours
     */
    public void setnom_cours(Cours nom_cours) {
        this.nom_cours = nom_cours;
    }
    
    /**
     *
     * @return
     */
    public Cours getid_cours()
    {
        return id_cours;
    }
    
    /**
     *
     * @param id_cours
     */
    public void  setid_cours(Cours id_cours)
    {
        this.id_cours=id_cours;
    }
    
    
    
    @Override
    public String toString()
    {
        return "nom_cours: "+ this.nom_cours+ "id: " + this.id + "nom:" + this.nom + "prenom: "+this.prenom + "email: "+ this.email + "password: "+ this.password;
    }

}
