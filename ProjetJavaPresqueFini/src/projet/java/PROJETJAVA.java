package projet.java;

import Vue.*;
import DataAcessObject.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JFrame;


/**
 *
 * @author pcane
 */
public class PROJETJAVA {
    
    ResultSet rs = null;
    PreparedStatement pst =null;
    public static void main(String[] args){
     
            FenetreSaisie fen = new FenetreSaisie();
            System.out.println("HYPERPLANNING LANCE");
            Connection connect;
            connect = new Connect().getConnection();
//            Fenetre fen2 = new Fenetre(connect,1,1,0);  

            
                        
            }           
        } 
        
    

