/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

//import java.awt.List;
import DataAcessObject.Connect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import javax.swing.table.TableColumn;
//import roomtable.Connect;
//import roomtable.Fenetre;

/**
 *
 * @author Lucas
 * 
 * 
 */
public class RoomTable extends JFrame {    
    JFrame f;    
    public RoomTable(String query){    
    f=new JFrame();
            
    try{
    Connect con = new Connect();
    Connection cnx = con.getConnection();
    
    Statement st;
    ResultSet rst;

    
    st=cnx.createStatement();
    rst=st.executeQuery(query);
    ResultSetMetaData resultMeta = rst.getMetaData();
    
    String[] columnNames = new String[resultMeta.getColumnCount()];
    for (int i = 1; i <= resultMeta.getColumnCount(); i++){   
    columnNames[i-1]=resultMeta.getColumnName(i);
    }
    
    List<Object[]> data = new ArrayList<>();
    while(rst.next()) {
    Object[] line = new Object[resultMeta.getColumnCount()]; // on créé un tableau pour stocker la ligne courante
    for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
           line[i-1]=rst.getObject(i);          
    }
    data.add(line); // on ajoute la ligne à la liste
    }
    JTable jt = new JTable( data.stream().toArray(Object[][]::new), columnNames ); // on convertit la liste en tableau pour appeler le constructeur et créer une seule JTable
    jt.setBounds(30,40,200,300);
   jt.setBackground(new Color(175, 186, 188));
   jt.getTableHeader().setBackground(new Color(0, 113, 121));
    JScrollPane sp=new JScrollPane(jt);
    f.add(sp);
    f.setSize(300,400);    
    f.setVisible(true);
    
    //jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        /**
         * fixer la largeur de la première colonne à 200 pixels
         */
       // TableColumn col = jt.getColumnModel().getColumn(0);
        //col.setPreferredWidth(200);
    
    }catch(Exception ex){
      ex.printStackTrace();
  }
}     
public static void main(String[] args) {    
    //new RoomTable(query);
      //Fenetre fen = new Fenetre();


    
}    
}  
