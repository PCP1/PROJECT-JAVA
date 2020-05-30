/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Utilisateur;
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
public class DAOutilisateur extends DAO<Utilisateur>{
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
        public static final String URL="jdbc:mysql://localhost/hyperplanning";
        public static final String USERNAME="root";
        public static final String PASSWORD="";
        
        private static final String DELETE_QUERY="DELETE FROM `utilisateur` WHERE utilisateur.ID_utilisateur= ?";
        private static final String DELETE_QUERY2="DELETE FROM `enseignant` WHERE enseignant.ID_utilisateur= ?";
        private static final String DELETE_QUERY3="DELETE FROM `etudiant` WHERE etudiant.ID_utilisateur= ?";

        private static final String INSERT_QUERY="INSERT INTO utilisateur(ID_Utilisateur, Email, Password, Nom, Prenom, Droit) VALUES(?, ?, ?, ?, ?, ?)";
        
        private static final String VERIFIE_QUERY="SELECT * utilisateur WHERE EXISTS(SELECT * FROM utilisateur WHERE utilisateur.Email = ?)";
                
                
                
         
    public DAOutilisateur(Connection conn) {
        super(conn);
    }
    

    @Override
    public boolean create(Utilisateur obj) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            ps.setInt(1, obj.getid());
            ps.setString(2, obj.getemail());
            ps.setString(3, obj.getpassword());
            ps.setString(4, obj.getnom());
            ps.setString(5, obj.getprenom());
            ps.setInt(6, obj.getdroit());
            
            int result = ps.executeUpdate();
            
            if(result==1){
                System.out.println("successfull insertion");
                obj.setid(this.findmail(obj.getemail()).getid());
                
                return true;
                
            }
    }catch (SQLException ex){
        Logger.getLogger(DAOutilisateur.class.getName()).log(Level.SEVERE, null, ex);
    }
        return false;  
    }

    @Override
    public boolean delete(Utilisateur obj) {
       try{
           PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
           ps.setInt(1, obj.getid());
           PreparedStatement ps2 = this.connect.prepareStatement(DELETE_QUERY2);
           ps2.setInt(1, obj.getid());
           PreparedStatement ps3 = this.connect.prepareStatement(DELETE_QUERY3);
           ps3.setInt(1, obj.getid());
            
           int row = ps.executeUpdate();
           int row2 = ps2.executeUpdate();
           int row3 = ps3.executeUpdate();
           if(row==0)
           {
              System.out.println("Il n'y a pas d'utilisateur enregistré. Delete inutile");
           }else{
               System.out.println("ligne efface: "+row+" "+row2+" "+row3); 
               
            }

        }catch (SQLException ex) {
              Logger.getLogger(DAOutilisateur.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id) {
        Utilisateur utilisateur = new Utilisateur();
        
        try{
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID_Utilisateur = "+id);
         
            if(result.next())
            {
                utilisateur = new Utilisateur(id, 
                        result.getString("utilisateur.Nom"), 
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("Password"),
                        result.getInt("Droit"));
               
                System.out.println("Utilisateur:" +utilisateur.toString());
            
            } else{
                    System.out.println("L'utilisateur que vous recherchez n'existe pas");
            }
          
        }catch (Exception e) {
         
            e.printStackTrace();
        }
        return utilisateur;
            
     }
    
    /**
     *
     * @param obj
     * @return
     */
    public Utilisateur findmail(String obj){
        Utilisateur utilisateur = new Utilisateur();
        try{
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE Email = '"+obj+"'");
            
            
            
             if(result.next()){
                 utilisateur = new Utilisateur(result.getInt("utilisateur.ID_Utilisateur"), 
                        result.getString("utilisateur.Nom"), 
                        result.getString("Prenom"),
                        obj,
                        result.getString("Password"),
                        result.getInt("Droit"));
                 //System.out.println("Utilisateur:" +utilisateur.toString());
             } else{
                    System.out.println("L'utilisateur que vous recherchez n'existe pas");
            }
            
            
            
        }catch (SQLException ex) {
            Logger.getLogger(DAOutilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
        return utilisateur;
    }
    
    
    
}
