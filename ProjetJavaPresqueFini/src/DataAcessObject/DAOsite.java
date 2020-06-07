/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Groupe;
import Modele.Promotion;
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
public class DAOsite extends DAO<Site>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM `site` WHERE site.ID_Site= ?";
    
    private static final String INSERT_QUERY="INSERT INTO site(  Nom_Site) VALUES(  ? )";


    public DAOsite(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Site obj) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            //ps.setInt(1, obj.getid_site());
            ps.setString(1, obj.getnom_site());
                    
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
    }   catch (SQLException ex) {
            Logger.getLogger(DAOsite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Site obj) {
         try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, obj.getid_site());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
    }   catch (SQLException ex) {   
            Logger.getLogger(DAOsite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Site object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Site find(int id) {
        Site site =new Site();
        
        try{
            ResultSet result =this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `site`  WHERE site.ID_Site= "+id);
                    
            
            if(result.first())
            {
                site = new Site (
                        id,
                        result.getString("site.Nom_Site")        
                ); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return site;
    }
    
}
