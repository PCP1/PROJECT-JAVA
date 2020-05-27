/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Etudiant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcane
 */
public class DAOetudiant extends DAO<Etudiant>{
    
    private static final String DELETE_QUERY="DELETE FROM `etudiant` WHERE etudiant.ID_utilisateur= ?";
    private static final String DELETE_QUERY2="DELETE FROM `utilisateur` WHERE utilisateur.ID_utilisateur= ?";
    private static final String INSERT_QUERY="INSERT INTO etudiant( Numero_Etudiant, ID_Groupe, Nom_etudiant, Prenom_etudiant) VALUES( ? , ? , ? , ?)";
    
    
    public DAOetudiant(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Etudiant etudiant) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setInt(1, etudiant.getNumero_etudiant());
            ps.setInt(2, 1);
            ps.setString(3, etudiant.getnom());
            ps.setString(4, etudiant.getprenom());
        
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
        
    }   catch (SQLException ex) {
            Logger.getLogger(DAOetudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant etudiant) {
         try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, etudiant.getid());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
/*
            PreparedStatement ps2 = this.connect.prepareStatement(DELETE_QUERY2);
            ps.setInt(1, utilisateur.getid());
            int row2 = ps.executeUpdate();
            System.out.println("ligne efface: " + row2);
*/

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   catch (SQLException ex) {
            Logger.getLogger(DAOetudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
