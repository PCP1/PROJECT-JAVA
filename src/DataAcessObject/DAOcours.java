/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Modele.Cours;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pcane
 */
public class DAOcours extends DAO<Cours>{

    public DAOcours(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Cours object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cours object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
