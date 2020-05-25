/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author pcane
 */
public class DAOutilisateur extends DAO<Utilisateur>{

    public DAOutilisateur(Connection conn) {
        super(conn);
    }
    

    @Override
    public boolean create(Utilisateur obj) {
        return false;
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id) {
        Utilisateur utilisateur = new Utilisateur();
        
        try{
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID_Utilisateur ="+id);
            if(result.first())
            {
                
                utilisateur = new Utilisateur(id, result.getString("utilisateur.Nom"), 
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("Password"),
                        result.getInt("Droit"));
            }
            
        }catch (Exception e) {
         
            e.printStackTrace();
        }
        return utilisateur;
            
     }

    
}

 