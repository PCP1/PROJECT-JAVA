/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Cours;
import Modele.Enseignant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcane
 */
public class DAOenseignant extends DAO<Enseignant>{

    public DAOenseignant(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignant object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Enseignant object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Enseignant object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignant find(int id) {
        Enseignant enseignant =new Enseignant();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `enseignant` INNER JOIN utilisateur ON enseignant.IDUtilisateur=utilisateur.IDUtilisateur WHERE Droit=3");
                    
            if(result.first())
            {
                
                enseignant = new Enseignant(
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
        return enseignant;
    }
    
}
