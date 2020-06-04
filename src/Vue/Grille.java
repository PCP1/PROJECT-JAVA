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
    
    //Semaines
    g.drawString("Semaine N°:",500,800);
    
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
    
    //Appel BDD
    DAOseance seanceDAO;
    seanceDAO = new DAOseance(new Connect().getConnection());
    int testheure = seanceDAO.find(1).getheure_debut();
    System.out.println("Test heure : "+testheure);
        
    //Affichage d'un cours test
    int largeur = 129;
    int hauteur = 79;
    g.setColor(Color.pink);
    g.fillRect(x+1,y+1,largeur,hauteur);
    g.setColor(Color.BLACK);
    g.drawString("Mathématiques",x+25,y+15); //Nom du cours
    g.drawString("M. TOURNESOL",x+25,y+30); //Nom de l'enseignant
    g.drawString("ING3 Gr04",x+25,y+45); //Nom du groupe
    g.drawString("Salle P445 - E2",x+25,y+60); //Numéro de la Salle + Campus
    g.drawString("COURS",x+25,y+75); //Type de séance
    
    //Affichage  d'un cours BDD
    String cours = "Traitement de Signal";
    String prof = "Duparc";
    String groupe = "ING1";
    String salle = "P300 E1";
    String typecours = "DS";
    
    int heure = testheure;
    int jour = 5;
    int type = 1;
    int X = 0;
    int Y = 0;
    
    //Placement jour
    switch (jour)
    {
        case 1:
            X = x+1;break;
        case 2:
            X = x+131;break;
        case 3:
            X = x+261;break;
        case 4:
            X = x+391;break;
        case 5:
            X = x+521;break;
        case 6:
            X = x+651;break;
    }
    //Placement horaire
    switch (heure)
    {
        case 830:
            Y = y+1;break;
        case 1015:
            Y = y+101;break;
        case 12:
            Y = y+201;break;
        case 1345:
            Y = y+301;break;
        case 1530:
            Y = y+401;break;
        case 1715:
            Y = y+501;break;
        case 19:
            Y = y+601;break;            
    }
    
    //Type Cours
    switch (type)
    {
        case 1:
            typecours = "Devoir Surveillé";break;
        case 2:
            typecours = "Cours";break;
    }
    
    g.setColor(Color.green);
    g.fillRect(X,Y,largeur,hauteur);
    g.setColor(Color.BLACK);
    g.drawString(cours,X,Y+15); //Nom du cours
    g.drawString(prof,X,Y+30); //Nom de l'enseignant
    g.drawString(groupe,X,Y+45); //Nom du groupe
    g.drawString(salle,X,Y+60); //Numéro de la Salle + Campus
    g.drawString(typecours,X,Y+75); //Type de séance
        
  }

  
}
