/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcane
 */
public class DAOetudiant extends DAO<Etudiant>{

    @Override
    public boolean create(Etudiant object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Etudiant object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiant object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant find(int id) {
        Etudiant etudiant new Etudiant();
        
        try{
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `etudiant` INNER JOIN utilisateur ON etudiant.IDUtilisateur=utilisateur.IDUtilisateur WHERE Droit=4");
            
            if(result.first())
            {
                etudiant =new Etudiant(
                        new Modele.Cours(),
                        id, 
                        result.getString("utilisateur.Nom"), 
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("Password"),
                        result.getInt("Droit")
                );
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return etudiant;
    }
    
}
