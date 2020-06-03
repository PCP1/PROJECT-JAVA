/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Seance_Enseignants;
import Modele.Seance_Salles;
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
public class DAOseance_salles extends DAO<Seance_Salles>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM `seance_salles` WHERE seance_salles.ID_Salle= ?";

    private static final String INSERT_QUERY="INSERT INTO seance_salles( ID_Seance, ID_Salle) VALUES( ? , ? )";

    
    
    public DAOseance_salles(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance_Salles seance_salles) {
         try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setInt(1, seance_salles.getid_seance());
            ps.setInt(2, seance_salles.getid_salle());
            
            
            int result=ps.executeUpdate();
            
            if(result==1){
                System.out.println("successfull insertion");
                return true;
            }
            
            
       
    }   catch (SQLException ex) {
            Logger.getLogger(DAOseance_salles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Seance_Salles seance_salles) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, seance_salles.getid_salle());
            int row = ps.executeUpdate();
            System.out.println("ligne efface: "+row);
            /*
            PreparedStatement ps2 = this.connect.prepareStatement(DELETE_QUERY2);
            ps.setInt(1, utilisateur.getid());
            int row2 = ps.executeUpdate();
            System.out.println("ligne efface: " + row2);
            */
    }   catch (SQLException ex) {
            Logger.getLogger(DAOseance_salles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Seance_Salles object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Salles find(int id) {
       Seance_Salles seance_salles = new Seance_Salles();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_salles` WHERE seance_salles.ID_Seance= "+id);
                    
            
            if(result.first())
            {
                
                seance_salles = new Seance_Salles(
                        id,
                        result.getInt("seance_salles.id_salle")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seance_salles;
    }
    
    
    ////////////////////////////UPDATE CHERCHER UNE SALLE EST OCCUPÉ OU PAS//////////////////////////////////////
    public boolean findsalle(int id1, int id2, int id3) throws SQLException {
        Seance_Salles seance_salle =new Seance_Salles();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_salles INNER JOIN salle ON seance_salles.ID_Salle=salle.ID_Salle="+id2+" WHERE seance_salles.ID_Seance="+id1);
                    
            
            if(result.next())
            {
               return true;
            }
            else{
                ResultSet result2 =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE salle.ID_Salle="+id2+" AND salle.Capacite_Salle>="+id3);
                if(!result2.next()){
                    return true;
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
                    
        return false;
    }
    ///////////////////////////////////////////////////////////////////////
    
}
