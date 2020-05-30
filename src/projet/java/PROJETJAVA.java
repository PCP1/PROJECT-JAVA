/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.java;

import DataAcessObject.Connect;
import DataAcessObject.DAO;
import DataAcessObject.DAOcours;
import DataAcessObject.DAOenseignant;
import DataAcessObject.DAOetudiant;
import DataAcessObject.DAOgroupe;
import DataAcessObject.DAOpromotion;
import DataAcessObject.DAOsalle;
import DataAcessObject.DAOseance;
import DataAcessObject.DAOseance_enseignants;
import DataAcessObject.DAOseance_groupe;
import DataAcessObject.DAOseance_salles;
import DataAcessObject.DAOsite;
import DataAcessObject.DAOtype_cours;
import DataAcessObject.DAOutilisateur;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Salle;
import Modele.Seance;
import Modele.Seance_Enseignants;
import Modele.Seance_Groupe;
import Modele.Seance_Salles;
import Modele.Site;
import Modele.Type_Cours;
import Modele.Utilisateur;


/**
 *
 * @author pcane
 */
public class PROJETJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*
       DAO<Site> sitedao;
       sitedao = new DAOsite(new Connect().getConnection());
            
          
           Site site;
           site = sitedao.find(1);
            System.out.println("salle du groupe: "+site.toString());
            */
        
        /*
        DAO<Type_Cours> type_coursdao;
        type_coursdao = new DAOtype_cours(new Connect().getConnection());  
        
        Type_Cours type_cours= new Type_Cours();
        
        type_cours.setnom("Travaux Dirigés");
        type_coursdao.create(type_cours);
       */
        
        
        
        
        
       // System.out.println("Promotion:"+ promotion.toString());
        
        /*
      DAO<Etudiant> etudiantdao;
        etudiantdao = new DAOetudiant(new Connect().getConnection());  
        
        Etudiant etudiant = new Etudiant();
        
        etudiant.setNumero_etudiant(1);
        etudiant.setnom("Canet");
        etudiant.setprenom("Pau");
        
        etudiantdao.create(etudiant);*/
        
        
        
        /*DAO<Enseignant> enseignantdao;
        enseignantdao = new DAOenseignant(new Connect().getConnection());
        
        Enseignant enseignant = new Enseignant();
        //Cours cours = new Cours();
        
        //enseignant.setcours(cours);
        enseignant.setnom("Coudray");
        enseignant.setprenom("Natalie");
        
        enseignantdao.create(enseignant);
        */
        
       /*
        DAOutilisateur utilisateurdao2;
        
        utilisateurdao2 = new DAOutilisateur(new Connect().getConnection());
        Utilisateur utilisateur = utilisateurdao2.findmail("jp.segado@edu.ece.fr");
           */
          DAO<Utilisateur> utilisateurdao=new DAOutilisateur(new Connect().getConnection());  
          
           Utilisateur utilisateur = new Utilisateur();
            utilisateur.setemail("a.mockber@edu.ece.fr");
            utilisateur.setpassword("mdpmockber");
            utilisateur.setnom("Mockber");
            utilisateur.setprenom("Arash");
            utilisateur.setdroit(3);
            utilisateurdao.create(utilisateur);
            
            if(utilisateur.getdroit()==3){
                DAO<Enseignant> enseignantdao;
                enseignantdao = new DAOenseignant(new Connect().getConnection());
               
                Enseignant enseignant = new Enseignant();
                Cours cours = new Cours();
                
                enseignant.setid(utilisateur.getid());
                enseignant.setcours(cours);
                
                
                enseignantdao.create(enseignant);}
          /*  }
            else if(utilisateur.getdroit()==4)
            {
                DAO<Etudiant> etudiantdao;
                etudiantdao = new DAOetudiant(new Connect().getConnection());  
        
                Etudiant etudiant = new Etudiant();
                Groupe groupe= new Groupe();
                
                etudiant.setid(utilisateur.getid());
                etudiant.setNumero_etudiant(1);
                etudiant.
        
            etudiantdao.create(etudiant);
            }
            Utilisateur utilisateur=utilisateurdao.find(400007);
            utilisateur.setid(400004);
            utilisateurdao.create(utilisateur);*/
           
        }
   
    }
        
    

