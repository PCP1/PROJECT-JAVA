/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Salle;
import Modele.Seance_Enseignants;
import Modele.Site;
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
public class DAOsalle extends DAO<Salle>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM salle WHERE salle.Nom_Salle=?";
    
    
    private static final String INSERT_QUERY="INSERT INTO salle( Nom_Salle, Capacite_Salle, ID_Site) VALUES( ? , ?, ? )";
    

    
    
    public DAOsalle(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Salle obj) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setString(1, obj.getnom_salle());
            ps.setInt(2, obj.getcapacite_salle());
            ps.setInt(3, obj.getid_site());
            
        
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
    }   catch (SQLException ex) {
            Logger.getLogger(DAOsalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Salle obj) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            
            ps.setString(1, obj.getnom_salle());
            
            int row = ps.executeUpdate();
            
            System.out.println("ligne effacees: "+row);
    }   catch (SQLException ex) {
            Logger.getLogger(DAOsalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Salle object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle find(int id) {
         Salle salle = new Salle();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle INNER JOIN site ON salle.ID_Site=site.ID_Site WHERE salle.ID_Site="+id);
                    
            
            if(result.first())
            {
                
                salle = new Salle(
                        id,
                        result.getInt("id_site"),
                        result.getString("nom_site"),
                        result.getString("nom_salle"),
                        
                        result.getInt("Capacite_Salle")
                        ); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salle;
    }
    
}
