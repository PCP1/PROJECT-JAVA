/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author aurel
 */
public class Recup {
    //COURS COURS COURS COURS COURS COURS COURS COURS COURS COURS COURS COURS  
  //METHODE RECUP NOM DU COURS
  public static String RecupNomCours(Connection connect,int seance)
  {
      int idcours;
      String nomcours = "test";
      try{
          Statement state = connect.createStatement();
          
          idcours = RecupIDCours(connect,seance);
          
          String query = "SELECT NOM_COURS FROM cours WHERE ID_Cours="+idcours;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getString("Nom_Cours"));
              nomcours = result.getString("Nom_Cours");
              }
          }    
                   
          result.close();
          state.close();
          return nomcours;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return "FAILED";
  }
  //METHODE POUR RECUP ID COURS
  public static int RecupIDCours(Connection connect,int seance)
  {
      int idcours =0;
      try{
          Statement state = connect.createStatement();
    
          String query = "SELECT ID_Cours FROM seance WHERE ID_Seance="+seance;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Cours"));
              idcours = result.getInt("ID_Cours");
              }
          }    
                   
          result.close();
          state.close();
          return idcours;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
  //ENSEIGNANT ENSEIGNANT ENSEIGNANT ENSEIGNANT ENSEIGNANT ENSEIGNANT ENSEIGNANT 
  //METHODE RECUP NOM DE L'ENSEIGNANT
  public static String RecupNomEnseignant(Connection connect,int seance)
  {
      int idutilisateur;
      String nomenseignant = "VIDE_BDD";
      try{
          Statement state = connect.createStatement();
          
          idutilisateur = RecupIDUtilisateurEnseignant(connect,seance);
          
          String query = "SELECT * FROM utilisateur WHERE ID_Utilisateur="+idutilisateur;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getString("Nom"));
              nomenseignant = result.getString("Nom");
              }
          }    
                   
          result.close();
          state.close();
          return nomenseignant;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return "FAILED";
  }
  //METHODE POUR RECUP ID Utilisateur DE LA SEANCE
  public static int RecupIDUtilisateurEnseignant(Connection connect,int seance)
  {
      int idcours;
      int idutilisateur = 0;
      try{
          Statement state = connect.createStatement();
          
          idcours = Recup.RecupIDCours(connect,seance);
          
          String query = "SELECT ID_Utilisateur FROM enseignant WHERE ID_Cours="+idcours;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Utilisateur"));
              idutilisateur = result.getInt("ID_Utilisateur");
              }
          }    
                   
          result.close();
          state.close();
          return idutilisateur;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
  //METHODE POUR RECUP ID Utilisateur depuis le Nom de l'Enseignant
  public static int RecupIDUtilisateurNomEnseignant(Connection connect,String nom)
  {
      int idutilisateur = 0;
      try{
          Statement state = connect.createStatement();
          
          String query = "SELECT ID_Utilisateur FROM utilisateur WHERE Nom='"+nom+"'";
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Utilisateur"));
              idutilisateur = result.getInt("ID_Utilisateur");
              }
          }    
                   
          result.close();
          state.close();
          return idutilisateur;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
  //METHODE POUR RECUP ID Utilisateur depuis le Nom du cours
  public static int RecupIDCoursNomCours(Connection connect,String nom)
  {
      int idcours = 0;
      try{
          Statement state = connect.createStatement();
          
          String query = "SELECT ID_Cours FROM cours WHERE Nom_Cours='"+nom+"'";
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Cours"));
              idcours = result.getInt("ID_Cours");
              }
          }    
                   
          result.close();
          state.close();
          return idcours;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
  //METHODE POUR RECUP ID du Cours depuis l'ID de l'utilisateur
  public static int RecupIDCoursNomEnseignant(Connection connect, int idutilisateur)
  {
      int idcours=0;
      try{
          Statement state = connect.createStatement();
          
          String query = "SELECT ID_Cours FROM enseignant WHERE ID_Utilisateur="+idutilisateur;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Cours"));
              idcours = result.getInt("ID_Cours");
              }
          }    
                   
          result.close();
          state.close();
          return idcours;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
//TYPE DE COURS TYPE DE COURS TYPE DE COURS TYPE DE COURS TYPE DE COURS 
  //METHODE RECUP NOM DU TYPE DE COURS
  public static String RecupNomTypeCours(Connection connect,int seance)
  {
      int idtypecours;
      String nomtypecours = "VIDE_BDD";
      try{
          Statement state = connect.createStatement();
          
          idtypecours = RecupIDTypeCours(connect,seance);
          
          String query = "SELECT * FROM type_cours WHERE ID_TypeCours="+idtypecours;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getString("Nom_Cours"));
              nomtypecours = result.getString("Nom_Cours");
              }
          }    
                   
          result.close();
          state.close();
          return nomtypecours;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return "FAILED";
  }
  //METHODE POUR RECUP ID TypeCours DE LA SEANCE
  public static int RecupIDTypeCours(Connection connect,int seance)
  {
      int idtypecours = 0;
      try{
          Statement state = connect.createStatement();
          
          String query = "SELECT ID_TypeCours FROM seance WHERE ID_Seance="+seance;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_TypeCours"));
              idtypecours = result.getInt("ID_TypeCours");
              }
          }    
                   
          result.close();
          state.close();
          return idtypecours;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
//SALLE SALLE SALLE SALLE SALLE SALLE SALLE SALLE SALLE SALLE SALLE SALLE SALLE 
  //METHODE RECUP SALLE 
  public static String RecupNomSalle(Connection connect,int seance)
  {
      int idsalle;
      String nomsalle = "VIDE_BDD";
      try{
          Statement state = connect.createStatement();
          
          idsalle = RecupIDSalle(connect,seance);
          
          String query = "SELECT * FROM salle WHERE ID_Salle="+idsalle;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getString("Nom_Salle"));
              nomsalle = result.getString("Nom_Salle");
              }
          }    
                   
          result.close();
          state.close();
          return nomsalle;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return "FAILED";
  }
  //METHODE POUR RECUP ID SALLE DE LA SEANCE
  public static int RecupIDSalle(Connection connect,int seance)
  {
      int idsalle = 0;
      try{
          Statement state = connect.createStatement();
          
          String query = "SELECT ID_Salle FROM seance_salles WHERE ID_Seance="+seance;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Salle"));
              idsalle = result.getInt("ID_Salle");
              }
          }    
                   
          result.close();
          state.close();
          return idsalle;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
//GROUPE GROUPE GROUPE GROUPE GROUPE GROUPE GROUPE GROUPE GROUPE GROUPE GROUPE 
  //METHODE RECUP GROUPE
  public static String RecupNomGroupe(Connection connect,int seance)
  {
      int idgroupe;
      String nomgroupe = "VIDE_BDD";
      try{
          Statement state = connect.createStatement();
          
          idgroupe = RecupIDGroupe(connect,seance);
          
          String query = "SELECT * FROM groupe WHERE ID_Groupe="+idgroupe;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getString("Nom_Groupe"));
              nomgroupe = result.getString("Nom_Groupe");
              }
          }    
                   
          result.close();
          state.close();
          return nomgroupe;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return "FAILED";
  }
  //METHODE POUR RECUP ID GROUPE
  public static int RecupIDGroupe(Connection connect,int seance)
  {
      int idgroupe = 0;
      try{
          Statement state = connect.createStatement();
          
          String query = "SELECT ID_GROUPE FROM seance_groupes WHERE ID_Seance="+seance;
          
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
              System.out.println(result.getInt("ID_Groupe"));
              idgroupe = result.getInt("ID_Groupe");
              }
          }    
                   
          result.close();
          state.close();
          return idgroupe;          
      }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
}
