/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.java;

import DataAcessObject.Connect;
import DataAcessObject.DAO;
import DataAcessObject.DAOenseignant;
import DataAcessObject.DAOutilisateur;
import Modele.Enseignant;
import Modele.Utilisateur;
import java.sql.Connection;


/**
 *
 * @author pcane
 */
public class PROJETJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        DAO<Enseignant> enseignantdao;
        enseignantdao = new DAOenseignant(new Connect().getConnection());
        
        for(int i=0; i<10; i++)
        {
            Enseignant enseignant;
            enseignant = enseignantdao.find(i);
            System.out.println("Enseignant:" +enseignant.toString());
        }
   
    }
        
    
}
