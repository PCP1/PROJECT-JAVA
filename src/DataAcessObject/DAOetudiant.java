/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Etudiant;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author pcane
 */
public class DAOetudiant extends DAO<Etudiant>{

    public DAOetudiant(Connection conn) {
        super(conn);
    }

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
        Etudiant etudiant = null;
        new Etudiant();
        
        try{
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `etudiant` INNER JOIN utilisateur ON etudiant.IDUtilisateur=utilisateur.IDUtilisateur WHERE Droit=4");
            
            if(result.first())
            {
                etudiant =new Etudiant(
                        result.getInt("Numero"),
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
