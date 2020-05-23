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

    private Cours cours;

    /**
     * Constructeur par defaut
     */
    public Enseignant() {
        super();
    }

    /**
     * Constructeur surcharge
     *
     * @param cours
     * @param id
     * @param nom
     * @param prenom
     * @param email
     * @param password
     * @param droit
     */
    public Enseignant(Cours cours, int id, String nom, String prenom, String email, String password) {
        super(id, nom, prenom, email, password, 3);
        this.cours = cours;
    }

//////////////////////////// GETTER AND SETTER ///////////////////////////////////////////////////////////
    /**
     *
     * @return
     */
    public Cours getCours() {
        return cours;
    }

    /**
     *
     * @param cours
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    

}