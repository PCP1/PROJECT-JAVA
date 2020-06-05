package Vue;

import DataAcessObject.Connect;
import DataAcessObject.DAO;
import DataAcessObject.DAOseance;
import Modele.Cours;
import Modele.Seance;
import Modele.Type_Cours;

import java.awt.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Time;

import Update.RechercheInfo;
import Update.*;

import projet.java.*;
 
import javax.swing.JPanel;

public class Grille extends JPanel { 
  public void paintComponent(Graphics g){
    
    int x = 50;
    int y = 50;
      
    g.setColor(new Color(23,128,80));
    g.fillRect(0,0,1200,800);
    g.setColor(new Color(191,224,209));
    g.fillRect(x, y, 780,680); ///rectangle
    g.setColor(Color.black); 
    g.drawRect(x, y, 780,680);
    
    //Lignes Jours
    g.drawLine(x+130,y+0,x+130,y+680);
    g.drawLine(x+260,y+0,x+260,y+680);
    g.drawLine(x+390,y+0,x+390,y+680);
    g.drawLine(x+520,y+0,x+520,y+680);
    g.drawLine(x+650,y+0,x+650,y+680);
    
    //Lignes Horaires
    g.drawLine(x+0,y+80,x+780,y+80);
    g.drawLine(x+0,y+100,x+780,y+100);
    g.drawLine(x+0,y+180,x+780,y+180);
    g.drawLine(x+0,y+200,x+780,y+200);
    g.drawLine(x+0,y+280,x+780,y+280);
    g.drawLine(x+0,y+300,x+780,y+300);
    g.drawLine(x+0,y+380,x+780,y+380);
    g.drawLine(x+0,y+400,x+780,y+400);
    g.drawLine(x+0,y+480,x+780,y+480);
    g.drawLine(x+0,y+500,x+780,y+500);
    g.drawLine(x+0,y+580,x+780,y+580);
    g.drawLine(x+0,y+600,x+780,y+600);
    
    
    //Jours
    g.setColor(Color.WHITE);
    g.drawString("Lundi",100,30);
    g.drawString("Mardi",230,30);
    g.drawString("Mercredi",350,30);
    g.drawString("Jeudi",490,30);
    g.drawString("Vendredi",610,30);
    g.drawString("Samedi",750,30);
    
    //Horaires
    g.setColor(Color.WHITE);
    g.drawString("8h30",10,y);
    g.drawString("10h",10,y+80);
    g.drawString("10h15",10,y+100);
    g.drawString("11h45",10,y+180);
    g.drawString("12h",10,y+200);
    g.drawString("13h30",10,y+280);
    g.drawString("13h45",10,y+300);
    g.drawString("15h15",10,y+380);
    g.drawString("15h30",10,y+400);
    g.drawString("17h",10,y+480);
    g.drawString("17h15",10,y+500);
    g.drawString("18h45",10,y+580);
    g.drawString("19h",10,y+600);
    g.drawString("20h30",10,y+680);
    
  }
}
