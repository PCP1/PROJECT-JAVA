/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Cours;
import Modele.Enseignant;
import Modele.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcane
 */
public class DAOenseignant extends DAO<Enseignant>{
    
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
        public static final String URL="jdbc:mysql://localhost/hyperplanning";
        public static final String USERNAME="root";
        public static final String PASSWORD="";
        
        private static final String DELETE_QUERY="DELETE FROM `enseignant` WHERE enseignant.ID_utilisateur= ?";
        private static final String DELETE_QUERY2="DELETE FROM `utilisateur` WHERE utilisateur.ID_utilisateur= ?";
        
        private static final String INSERT_QUERY="INSERT INTO enseignant( ID_Utilisateur, ID_cours) VALUES(?, ? )";
        
    public DAOenseignant(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignant enseignant) {
           
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setInt(1, enseignant.getid());
            ps.setInt(2, 1);
            
        
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
       
        
        
    }       catch (SQLException ex) {
                Logger.getLogger(DAOenseignant.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean delete (Enseignant enseignant){
            
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, enseignant.getid());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
            /*
            PreparedStatement ps2 = this.connect.prepareStatement(DELETE_QUERY2);
            ps.setInt(1, utilisateur.getid());
            int row2 = ps.executeUpdate();
            System.out.println("ligne efface: " + row2);
            */
            
            
        }   catch (SQLException ex) {
                Logger.getLogger(DAOenseignant.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `enseignant` INNER JOIN utilisateur ON enseignant.ID_Utilisateur=utilisateur.ID_Utilisateur WHERE enseignant.ID_utilisateur= "+id);
                    
            
            if(result.first())
            {
                
                enseignant = new Enseignant(
                        
                        new Cours(result.getInt("ID_Cours"), "Traitement du signal"),
                        id,
                        result.getString("utilisateur.Nom"),
                        result.getString("utilisateur.Prenom"),
                        result.getString("utilisateur.Email"),
                        result.getString("utilisateur.Password"),
                        result.getInt("utilisateur.Droit")
                        ); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enseignant;
    }

    
}
