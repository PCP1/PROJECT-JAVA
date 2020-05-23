/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pcane
**/ 
public class Connect {
    
    public static final String URL="jdbc:mysql://localhost/hyperplanning";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    
     public Connection getConnection()
    {
        
          Statement statement;
          ResultSet result;
          Connection connection=null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                
                connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
                statement = connection.createStatement();
                
                System.out.println("Connexion effective");
                
              // result = statement.executeQuery("SELECT nom, age FROM user");
                
               //System.out.println(result.next());
               //while(result.next()){
               //    System.out.println("Nom: "+result.getString("nom")+ " -Age: "+ result.getInt("age"));
               //}
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        return connection;   
        
    }          
     /* public static void main(String args[]) {
         Connect con=new Connect();
         con.getConnection();
    
      }*/
}
    
