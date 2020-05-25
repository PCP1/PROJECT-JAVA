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
    public Enseignant(Cours cours, int id, String nom, String prenom, String email, String password, int droit) {
        super(id, nom, prenom, email, password, droit);
        this.cours=cours;
     
    }

    

    

//////////////////////////// GETTER AND SETTER ///////////////////////////////////////////////////////////
    /**
     *
     * @return
     */
    public Cours getcours() {
        return cours;
    }

    /**
     *
     * @param cours
     */
    public void setcours(Cours cours) {
        this.cours = cours;
    }
    
    
    
    @Override
    public String toString()
    {
        return "cours: "+ this.cours.getid_cours()+"nom du cours: "+this.cours.getnom_cours()+ "id: " + this.id + "nom:" + this.nom + "prenom: "+this.prenom + "email: "+ this.email + "password: "+ this.password;
    }

}
