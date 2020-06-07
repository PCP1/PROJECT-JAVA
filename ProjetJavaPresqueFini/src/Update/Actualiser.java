/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

import DataAcessObject.Connect;
import DataAcessObject.DAO;
import DataAcessObject.DAOenseignant;
import DataAcessObject.DAOseance;
import DataAcessObject.DAOseance_enseignants;
import DataAcessObject.DAOseance_groupe;
import DataAcessObject.DAOseance_salles;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Seance;
import Modele.Seance_Enseignants;
import Modele.Seance_Groupe;
import Modele.Seance_Salles;
import Modele.Type_Cours;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
/**
 *
 * @author pcane
 */
public class Actualiser {
    
    /**
     *
     * @param conn
     */
    
    public void EnseignantOK(int id1, int id2)
    {
        DAOseance_enseignants seance_enseignantsdao;
        seance_enseignantsdao = new DAOseance_enseignants(new Connect().getConnection());
        
        boolean seance_enseignant = seance_enseignantsdao.find2(id1, id2);
        
        if(seance_enseignant==true){
            System.out.println("l'enseignant a deja cours");
            
        }
        else{
            System.out.println("l'enseignant n'a pas cours");
            
            
            Seance_Enseignants seance_enseignants = new Seance_Enseignants();
            seance_enseignants.setid_seance(id1);
            seance_enseignants.setid_enseignant(id2);
            
            seance_enseignantsdao.create(seance_enseignants);
            
        }
    }
    
    public void GroupOK(int id1, int id2){
         DAOseance_groupe seance_groupedao;
        seance_groupedao = new DAOseance_groupe(new Connect().getConnection());
        
        boolean seance_groupes = seance_groupedao.findGroupe(id1, id2);
        
        if(seance_groupes==true){
            System.out.println("le group a deja cours");
            
        }
        else{
            System.out.println("le group n'a pas cours");
            
            
            Seance_Groupe seance_groupe = new Seance_Groupe();
            seance_groupe.setid_seance(id1);
            seance_groupe.setid_groupe(id2);
            
            seance_groupedao.create(seance_groupe);
            
        }
    }

        
    /**
     *
     * @param id1
     * @param id2
     */
    public void ChangerTypedeCours(int id1, int id2){
           DAOseance seancedao;
           seancedao= new DAOseance(new Connect().getConnection());
           seancedao.ModifierTypeSeance(id1, id2);
        }
    
    public static void AjoutSeance(int salle, int capacite, int heuredebut, String jour, int semaine, int idcours, int typecours, int enseignant,int groupe) throws SQLException
    {
        DAOseance_salles seance_sallesdao;
        seance_sallesdao = new DAOseance_salles(new Connect().getConnection());
        DAOseance seancedao = new DAOseance(new Connect().getConnection());
        
        DAOseance_enseignants seance_enseignantdao;
        seance_enseignantdao = new DAOseance_enseignants(new Connect().getConnection());
        
        DAOseance_groupe seance_groupesdao;
        seance_groupesdao = new DAOseance_groupe(new Connect().getConnection());
        
        boolean seance_salles = seance_sallesdao.findsalle(salle,capacite,heuredebut,jour,semaine);
        
        if(seance_salles==true){
            System.out.println("Salle occupée ou capacité trop importante");
            
        }
        else{
            System.out.println("Salle libre");
            
            seancedao.AjouterSeance(jour,  heuredebut,  typecours,  idcours,  enseignant,  capacite, semaine);
            
            Seance_Salles seance_salles2 = new Seance_Salles();
            seance_salles2.setid_salle(salle);            
            seance_sallesdao.create(seance_salles2);
            
            Seance_Enseignants seance_enseignant = new Seance_Enseignants();
            seance_enseignant.setid_enseignant(enseignant);            
            seance_enseignantdao.create(seance_enseignant);
            
            Seance_Groupe seance_groupes = new Seance_Groupe();
            seance_groupes.setid_groupe(groupe);            
            seance_groupesdao.create(seance_groupes);
            
        }          
    }
    
   public void ChangerEtatCours(int id1, String etat){
           DAOseance seancedao;
           seancedao= new DAOseance(new Connect().getConnection());
           seancedao.ModifierEtat(id1, etat);
   } 
    
    
   public void ChangerDate(int id, Date date, Time heuredebut, Time heurefin){
   
       
       
       
   }
    
    }
    
    
    
    
    

