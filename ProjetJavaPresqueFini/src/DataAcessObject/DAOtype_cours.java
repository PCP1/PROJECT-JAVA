/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Seance_Enseignants;
import Modele.Type_Cours;
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
public class DAOtype_cours extends DAO<Type_Cours>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM `type_cours` WHERE type_cours.ID_TypeCours= ?";
    
    private static final String INSERT_QUERY="INSERT INTO type_cours(  Nom_Cours) VALUES( ? )";

    public DAOtype_cours(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Type_Cours obj) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setString(1, obj.getnom_typecours());
            
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
        
    }       catch (SQLException ex) {
                Logger.getLogger(DAOenseignant.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
    }

    @Override
    public boolean delete(Type_Cours obj) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, obj.getid_typecours());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
    }   catch (SQLException ex) {   
            Logger.getLogger(DAOtype_cours.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return false;
    }

    @Override
    public boolean update(Type_Cours object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type_Cours find(int id) {
        Type_Cours type_cours = new Type_Cours();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `type_cours` WHERE type_cours.ID_TypeCours= "+id);
                    
            
            if(result.first())
            {
                
                type_cours = new Type_Cours(
                        id,
                        result.getString("type_cours.Nom_Cours")
                ); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type_cours;
    }
    
}
