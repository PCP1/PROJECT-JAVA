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
import DataAcessObject.DAOutilisateur;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Groupe;
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
      
       DAO<Groupe> groupedao;
        groupedao = new DAOgroupe(new Connect().getConnection());
        
            
          
            Groupe groupe = new Groupe();
            groupe.setnom_groupe("TD04");
            
            groupedao.create(groupe);            
        
        
        /* DAO<Cours> coursdao;
        coursdao = new DAOcours(new Connect().getConnection());  
        
        Cours cours = new Cours();
        
        cours.setid(4);
        
        
        coursdao.delete(cours);
        
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
        DAO<Utilisateur> utilisateurdao;
        utilisateurdao = new DAOutilisateur(new Connect().getConnection());
        
            
          
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setemail("lucas.marrac@edu.ece.fr");
            utilisateur.setpassword("mdplucas");
            utilisateur.setnom("Marrac");
            utilisateur.setprenom("Lucas");
            utilisateur.setdroit(4);
             utilisateurdao.create(utilisateur);
            System.out.println("Utilisateur:" +utilisateur.toString());*/
        }
   
    }
        
    

