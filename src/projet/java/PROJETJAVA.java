/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.java;

import DataAcessObject.Connect;
import DataAcessObject.DAO;
import DataAcessObject.DAOenseignant;
import Modele.Enseignant;


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
        
       
        
            Enseignant enseignant = new Enseignant();
            enseignant.setid(1);
             enseignantdao.delete(enseignant);
            System.out.println("Enseignant:" +enseignant.toString());
        }
   
    }
        
    

