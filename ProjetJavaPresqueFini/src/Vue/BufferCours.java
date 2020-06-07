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

public class BufferCours extends JPanel { 
  public void paintComponent(Graphics g){
    
    int x = 50;
    int y = 50;
    
    //Appel BDD
//    int testheure = 0;
//    String q ="SELECT  * FROM 'seance' WHERE ID_SEANCE=1";
//    pst=seanceDAO.prepareStatement(q);
//    testheure=pst.executeQuery();
//    System.out.println("Test heure : "+testheure);
    
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
    g.drawString("BLABLA",x+25,y+75); //Type de séance
    
    //Affichage  d'un cours BDD
    String cours = "Traitement de Signal";
    String prof = "Duparc";
    String groupe = "ING1";
    String salle = "P300 E1";
    String typecours = "DS";
    
    int heure = 19;
    System.out.println("TYOOOOO");
    int jour = 2;
    int type = 2;
    int X = 0;
    int Y = 0;
    
//    Time test = new Time(0,0,0);
//    test.
    
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
            typecours = "TEST";break;
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
