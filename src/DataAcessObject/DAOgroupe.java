/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Cours;
import Modele.Enseignant;
import Modele.Groupe;
import Modele.Promotion;
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
public class DAOgroupe extends DAO<Groupe>{
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
        public static final String URL="jdbc:mysql://localhost/hyperplanning";
        public static final String USERNAME="root";
        public static final String PASSWORD="";

        private static final String INSERT_QUERY="INSERT INTO groupe( Nom_Groupe, ID_Promotion) VALUES( ? , ? )";
        
        private static final String DELETE_QUERY="DELETE FROM `groupe` WHERE groupe.ID_Groupe= ?";
        
    public DAOgroupe(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Groupe groupe) {
       try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            
            ps.setString(1, groupe.getnom_groupe());
            ps.setInt(2,5);
           
        
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
        
    }   catch (SQLException ex) {
            Logger.getLogger(DAOetudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Groupe groupe) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, groupe.getid_groupe());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
    }       catch (SQLException ex) {
                Logger.getLogger(DAOgroupe.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
    }

    @Override
    public boolean update(Groupe object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe find(int id) {
       Groupe groupe =new Groupe();
        
        try{
            ResultSet result =this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `groupe` INNER JOIN promotion ON groupe.ID_Groupe=promotion.ID_Promotion WHERE groupe.ID_Groupe= "+id);
                    
            
            if(result.first())
            {
                groupe = new Groupe (
                        new Promotion (result.getInt("ID_Promotion"), result.getString("Nom_Promotion")),
                        id,
                        result.getString("groupe.Nom_Groupe")
                        
                ); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupe;
    }
    
}
