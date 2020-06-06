/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
//import connexion.Connect;
import DataAcessObject.Connect;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Session {
    
    private String login, mdp;
    private int c;
    private JOptionPane jop1, jop2, jop3;
    private int groupe,promo,droit;
    private boolean rep=false;

    /**
     * @return the groupe
     */
    public int getGroupe() {
        return groupe;
    }

    /**
     * @param groupe the groupe to set
     */
    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    /**
     * @return the promo
     */
    public int getPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(int promo) {
        this.promo = promo;
    }

    
    
   

public  Session (String login, String mdp){
    
    try{  
    Connect con = new Connect();
    Connection cnx = con.getConnection();
    Statement st;
    ResultSet rst;
    int n=0;
    
    st=cnx.createStatement();
    String query="SELECT * FROM utilisateur WHERE Email='"+login+"'&& Password='"+mdp+"'";
    rst=st.executeQuery(query);
    
    Statement st2=cnx.createStatement();
    
    
    
    int size=0;
    if (rst != null) 
    {
          rst.last();    // moves cursor to the last row
          size = rst.getRow();
          c=size;// get row id 
          jop1 = new JOptionPane();
          if (size==1){
             System.out.println("connexion reussie");
             ///new RoomTable(query);
             droit =rst.getInt("Droit");
             //setDroit(rst.getInt("Droit"));
             int ID=rst.getInt("ID_Utilisateur");
             System.out.println("ID_user="+ID);
             
             jop1.showMessageDialog(null, "Connexion réussie ! vous etes de droit"+droit, "Information", JOptionPane.INFORMATION_MESSAGE);
             //new RoomTable(query);
             System.out.println("droit ="+droit);
             if (droit == 4){
                
                //String query2="SELECT * FROM groupe INNER JOIN etudiant WHERE ON groupe.ID_grouper=etudiant.ID_groupe WHERE ID_Utilisateur="+ID ;
                //System.out.println("ID_user="+ID2);
                //String query2="SELECT groupe.ID_Groupe,ID_Promotion FROM groupe INNER JOIN etudiant ON groupe.ID_Groupe=etudiant.ID_Groupe WHERE etudiant.ID_Utilisateur=+'"+ID+"'";
             String query2 ="SELECT groupe.ID_Groupe, groupe.Nom_Groupe, groupe.ID_Promotion FROM groupe INNER JOIN etudiant ON groupe.ID_Groupe=etudiant.ID_Groupe WHERE etudiant.ID_Utilisateur="+ID;
               //String query2 ="SELECT * FROM groupe INNER JOIN etudiant WHERE groupe.ID_Groupe=etudiant.ID_Groupe AND ID_Utilisateur="+ID;
                ResultSet rst2=st2.executeQuery(query2);
                //System.out.println("Groupe="+rst2.getInt("groupe.ID_Groupe"));
                //System.out.println("id ="+ID);
               while (rst2.next()){
                groupe=rst2.getInt("groupe.ID_groupe");
                promo=rst2.getInt("ID_Promotion");
                
                //System.out.println("Groupe="+rst2.getString("groupe.Nom_Groupe"));
                System.out.println("ID="+ID);
                
                System.out.println("Promo="+promo);
                System.out.println("Groupe="+groupe);

                //String query3="SELECT * FROM salle";
                //new RoomTable(query3);
                //return groupe;
                
           Connection connect;
            connect = new Connect().getConnection();
            //Fenetre fen2 = new Fenetre(connect/*,groupe,promo,droit*/);
            
                
               }
               
             }
             rep = true;
          }
          else{
              System.out.println("connexion echoué");

              jop1.showMessageDialog(null, "Identifiants incorrects!", "Information", JOptionPane.INFORMATION_MESSAGE);}
              
                  
    }
    else
        System.out.println("connexion echoué");
    


    
  }catch(Exception ex){
      ex.printStackTrace();
  }
        //return 0;
        
    
    
}

    /**
     * @return the rep
     */
    public boolean isRep() {
        return rep;
    }

    /**
     * @param rep the rep to set
     */
    public void setRep(boolean rep) {
        this.rep = rep;
    }

    /**
     * @return the droit
     */
    public int getDroit() {
        return droit;
    }

    /**
     * @param droit the droit to set
     */
    public void setDroit(int droit) {
        this.droit = droit;
    }
}


