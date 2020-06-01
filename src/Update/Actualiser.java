/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

import DataAcessObject.Connect;
import DataAcessObject.DAO;
import DataAcessObject.DAOenseignant;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Seance_Enseignants;
import java.sql.ResultSet;
import java.sql.Connection;
/**
 *
 * @author pcane
 */
public class Actualiser {
    
    /**
     *
     * @param conn
     */
    
    public void EnseignantOK(Enseignant obj){
        
        DAOenseignant enseignantdao;
        enseignantdao = new DAOenseignant(new Connect().getConnection());
        boolean seance_enseignant = enseignantdao.find2(1, 1);
        if(seance_enseignant==true){
            System.out.println("l'enseignant a deja cours");
            
        }
        else{
            System.out.println("l'enseignant n'a pas cours");
        }    
    }
    
}
