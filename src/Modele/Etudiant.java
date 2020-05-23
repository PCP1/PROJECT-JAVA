/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 * TESTGIT
 * @author pcane
 */
public class Etudiant extends Utilisateur {
    
    private int numero_etudiant;
    
    /**
     *Constructeur par defaut
     */
    public Etudiant()
    {
        super();
    }
    
    public Etudiant(int numero_etudiant, int id, String nom, String prenom, String email, String password, int droit)
    {
        super(id, nom, prenom, email, password, droit);
        this.numero_etudiant = numero_etudiant;
    }
    
    //////////////////////////// GETTER AND SETTER ///////////////////////////////////////////////////////////
    /**
     *
     * @return
     */
    public int getNumero_etudiant() {
        return numero_etudiant;
    }

    /**
     *
     * @param numero
     */
    public void setNumero_etudiant(int numero_etudiant) {
        this.numero_etudiant = numero_etudiant;
    }
    
    public String toString()
    {
        return "numero_etudiant: "+ this.numero_etudiant+ "id: " + this.id + "nom:" + this.nom + "prenom: "+this.prenom + "email: "+ this.email + "password: "+ this.password;
    }
    
}
