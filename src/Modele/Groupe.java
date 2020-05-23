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
public class Groupe {
    private int id_groupe;
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Groupe () {}
    
    /**
     * Constructeur surcharge
     * @param id_groupe
     * @param nom
     */
    public Groupe(int id_groupe, String nom)
    {
        this.id_groupe = id_groupe;
        this.nom = nom;
    }
    
   
    
    
}
