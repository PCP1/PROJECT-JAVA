/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Seance_Enseignants;
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
public class DAOseance_enseignants extends DAO<Seance_Enseignants>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM `seance_enseignants` WHERE seance_enseignants.ID_Seance= ?";
    
    private static final String INSERT_QUERY="INSERT INTO seance_enseignants( ID_Seance, ID_Enseignant) VALUES( ? , ? )";

    
    public DAOseance_enseignants(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance_Enseignants seance_enseignants) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setInt(1, seance_enseignants.getid_seance());
            ps.setInt(2, seance_enseignants.getid_enseignant());
            
        
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
       
        
        
    }       catch (SQLException ex) {
                Logger.getLogger(DAOenseignant.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
    }

    @Override
    public boolean delete(Seance_Enseignants seance_enseignants) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, seance_enseignants.getid_seance());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
            /*
            PreparedStatement ps2 = this.connect.prepareStatement(DELETE_QUERY2);
            ps.setInt(1, utilisateur.getid());
            int row2 = ps.executeUpdate();
            System.out.println("ligne efface: " + row2);
            */
            
            
        }   catch (SQLException ex) {
                Logger.getLogger(DAOseance_enseignants.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public boolean update(Seance_Enseignants object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Enseignants find(int id) {
        Seance_Enseignants seance_enseignants = new Seance_Enseignants();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_enseignants` WHERE seance_enseignants.ID_Seance= "+id);
                    
            
            if(result.first())
            {
                
                seance_enseignants = new Seance_Enseignants(
                        id,
                        result.getInt("seance_enseignants.id_enseignant")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seance_enseignants;
    }
    
}
