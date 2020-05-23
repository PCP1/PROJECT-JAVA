/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;
import java.sql.Connection;


/**
 *
 * @author pcane
 * @param <T>
 */
public abstract class DAO<T> {
    protected Connection connect=null;
   
    public DAO (Connection conn){
        this.connect=conn;
    }
    
    /**
     *Methode creation
     * @param object
     * @return
     */
    public abstract boolean create(T object);
    
    /**
     *Methode eliminer
     * @param object
     * @return
     */
    public abstract boolean delete (T object);
    
    /**
     *Methode mise a jour
     * @param object
     * @return
     */
    public abstract boolean update (T object);
    
    /**
     *Methode chercher
     * @param id
     * @return
     */
    public abstract T find (int id);
    
    
    
    
    
    
    
}
