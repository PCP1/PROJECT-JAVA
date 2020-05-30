/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Cours;
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
public class DAOcours extends DAO<Cours>{

    
    private static final String DELETE_QUERY="DELETE FROM `cours` WHERE cours.ID_Cours= ?";
    private static final String INSERT_QUERY="INSERT INTO cours( Nom_Cours) VALUES( ?)";
   
    public DAOcours(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Cours cours) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            ps.setString(1, cours.getnom_cours());
            
            ps.executeUpdate();
            System.out.println("successfull insertion");
            
    }   catch (SQLException ex) {
            Logger.getLogger(DAOcours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Cours cours) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, cours.getid_cours());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: " + row);
            
    }   catch (SQLException ex) {
            Logger.getLogger(DAOcours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Cours object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public Cours find(int id) {
        
        Cours cours = new Cours();
        
        try{
            ResultSet result;
            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE id_cours="+id);
             
             if(result.first())
             {
                 cours = new Cours(id, result.getString("Nom"));
                  
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    /*public Cours findid(String obj) 
    {
        Cours cours = new Cours();
         try{
            ResultSet result;
            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `cours` INNER JOIN enseignant ON cours.ID_Cours=enseignant.ID_Cours WHERE Nom_Cours='"+obj+"'");
            if (result.next()){
                cours = new Cours(result.getInt("ID_Cours"), result.getString("Nom_Cours"));
                  System.out.println("Cours:" +cours.toString());
             }else{
                System.out.println("Le cours que vous cherchez n'existe pas");
            }
                
            } catch (SQLException ex) {
            Logger.getLogger(DAOcours.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cours;
    
    }*/
}
