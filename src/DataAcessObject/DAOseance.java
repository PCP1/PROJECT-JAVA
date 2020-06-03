/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Cours;
import Modele.Enseignant;
import Modele.Seance;
import Modele.Type_Cours;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcane
 */
public class DAOseance extends DAO<Seance>{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
    private static final String DELETE_QUERY="DELETE FROM `seance` WHERE seance.ID_Seance= ?";

    private static final String INSERT_QUERY="INSERT INTO seance( Semaine, Date, HeureDebut, HeureFin, Etat, ID_Cours, ID_TypeCours) VALUES( ? , ? , ?, ?, ?, ?, ?)";

    
    public DAOseance(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance seance) {
        try{
            PreparedStatement ps = this.connect.prepareStatement(INSERT_QUERY);
            //ps.setObject(1, enseignant.getcours().getid_cours());
            //ps.setObject(2, enseignant.getcours().getnom_cours());
            ps.setInt(1, seance.getSemaine());
            ps.setDate(2, seance.getDate());
            ps.setTime(3, seance.getheure_debut());
            ps.setTime(4, seance.getheure_fin());
            ps.setString(5, seance.getetat());
            ps.setInt(6, 2);
            ps.setInt(7,3);
            
            
            ps.executeUpdate();
            
            System.out.println("successfull insertion");
    }   catch (SQLException ex) {
            Logger.getLogger(DAOseance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Seance seance) {
       
            
        try{
            PreparedStatement ps = this.connect.prepareStatement(DELETE_QUERY);
            ps.setInt(1, seance.getid_senace());
            int row = ps.executeUpdate();
            System.out.println("seance effacee: "+row);
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
    public boolean update(Seance object) {
        /*try{
            PreparedStatement ps = this.connect.prepareStatement("UPDATE seance SET ID_Cours=? WHERE ID_Seance=?"+);
        */
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Seance find(int id) {
        Seance seance = new Seance();
        
        try{
            ResultSet result =this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance` WHERE seance.ID_Seance= "+id);
                    
            
            if(result.first())
            {
                
                seance = new Seance(
                        id,
                        result.getInt("seance.Semaine"),
                        result.getDate("seance.Date"),
                        result.getTime("seance.HeureDebut"),
                        result.getTime("seance.HeureFin"),
                        result.getString("seance.Etat"),
                        new Cours(result.getInt("seance.ID_Cours"), "abc"),
                        new Type_Cours(result.getInt("seance.ID_TypeCours"),"abc")
                       ); 
                System.out.println("Seance: " + seance.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seance;
       
    }
    
    ///////////////////////////MODIFIER LE TYPE DE COURS DE LA SEANCE /////////////////////////////
    public void ModifierTypeSeance(int id1, int id2){
         try{
            PreparedStatement ps = this.connect.prepareStatement("UPDATE seance SET ID_TypeCours="+id2+" WHERE ID_Seance="+id1);
            
            ps.executeUpdate();
            
            System.out.println("successfull update");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOseance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //////////////////////////MODIFIER ETAT SEANCE ///////////////////////////////////////////////
    
    public void ModifierEtat(int id1, String etat){
         try{
            PreparedStatement ps = this.connect.prepareStatement("UPDATE seance SET seance.Etat= '"+etat+"'"+" WHERE ID_Seance="+id1);
            
            ps.executeUpdate();
            
            System.out.println("successfull update");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOseance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////MODIFIER JOUR ET/OU HEURE SEANCE////////////////////////////////////////
     public void ModifierDate(int id, Date date, Time heuredebut, Time heurefin){
         try{
            PreparedStatement ps = this.connect.prepareStatement("UPDATE seance SET seance.Date='"+date+"', seance.HeureDebut='"+heuredebut+"', seance.HeureFin='"+heurefin+"' WHERE ID_Seance="+id);
            
            ps.executeUpdate();
            
            System.out.println("successfull update");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOseance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////


}

