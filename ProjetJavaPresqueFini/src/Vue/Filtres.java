/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import static Vue.Fenetre.AffichageCours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author aurel
 */
public class Filtres {
    //METHODE POUR AFFICHER TOUS LES COURS D'UNE SEMAINE D'UN ENSEIGNANT EN PARTICULIER
  public static void AffichageCoursSemaineFiltreEnseignant(Connection connect,Grille grille, int semaine,int cours)
  {
      try{
          Statement state = connect.createStatement();                
          
          String query = "SELECT * FROM seance WHERE Semaine="+semaine+" AND ID_Cours="+cours;
    
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();                   
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
                  int heuredebut = result.getInt("HeureDebut");
                  int seance = result.getInt("ID_Seance");
                  String jour = result.getString("Date");
//                  int idcours = RecupIDCours(connect,seance);
                  String nomcours = Recup.RecupNomCours(connect,seance);
                  String nomenseignant = Recup.RecupNomEnseignant(connect,seance);
                  String nomtypecours = Recup.RecupNomTypeCours(connect,seance);
                  String nomsalle = Recup.RecupNomSalle(connect,seance);
                  String nomgroupe = Recup.RecupNomGroupe(connect,seance);
                  AffichageCours(grille,heuredebut,jour,nomcours,nomenseignant,nomtypecours,nomsalle,nomgroupe);
              }
          }
          
          result.close();
          state.close();
      }catch (Exception e) {
        e.printStackTrace();
    } 
  }
  public static void SupprimerCours(Connection connect, int idcourssupp)
  {
      try{
          Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          PreparedStatement prepare = connect.prepareStatement("DELETE FROM seance WHERE seance.ID_Seance="+idcourssupp);
          PreparedStatement prepare2 = connect.prepareStatement("DELETE FROM seance_enseignants WHERE seance_enseignants.ID_Seance="+idcourssupp);
          PreparedStatement prepare3 = connect.prepareStatement("DELETE FROM seance_groupes WHERE seance_groupes.ID_Seance="+idcourssupp);
          PreparedStatement prepare4 = connect.prepareStatement("DELETE FROM seance_salles WHERE seance_salles.ID_Seance="+idcourssupp);
          
          prepare.executeUpdate();
          prepare2.executeUpdate();
          prepare3.executeUpdate();
          prepare4.executeUpdate();
          
          prepare.close();
          prepare2.close();
          prepare3.close();
          prepare4.close();
          state.close();
      }catch (Exception e) {
        e.printStackTrace();
    }
  }
}
