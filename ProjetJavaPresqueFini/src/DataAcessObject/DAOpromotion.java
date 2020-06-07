/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Promotion;
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
public class DAOpromotion extends DAO<Promotion>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM `promotion` WHERE promotion.ID_Promotion= ?";
    
    private static final String INSERT_QUERY="INSERT INTO promotion(  Nom_Promotion) VALUES( ? )";

    
    public DAOpromotion(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Promotion obj) {
         try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            
            ps.setString(1, obj.getnom_Promotion());
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
            
    }   catch (SQLException ex) {
            Logger.getLogger(DAOpromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Promotion obj) {
         try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, obj.getid_Promotion());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
    }   catch (SQLException ex) {
            Logger.getLogger(DAOpromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Promotion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Promotion find(int id) {
        Promotion promotion = new Promotion();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `promotion` WHERE promotion.ID_Promotion= "+id);
                    
            
            if(result.first())
            {
                
                promotion = new Promotion(
                        id,
                        result.getString("promotion.nom_promotion")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotion;
    }
    
}
