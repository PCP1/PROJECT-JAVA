/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author Lucas
 */
//...
import DataAcessObject.Connect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.*;

 
public class FenetreSaisie extends JFrame {
    
	private JTextField login=new JTextField("",10);
        private JLabel labelogin= new JLabel("Login");
        
        private JTextField mdp=new JTextField("",10);
        private JLabel labelmdp= new JLabel("Mot de passe");
        
        public FenetreSaisie(){              
        
        ///login    
        JPanel panlog = new JPanel();
        panlog.setBackground(Color.white);
        panlog.setPreferredSize(new Dimension(220, 60));
        login = new JTextField();
        login.setPreferredSize(new Dimension(150, 25));
        labelogin = new JLabel("Email");
        panlog.add(labelogin);
        panlog.add(login);
        
        //mdp
       JPanel panmdp = new JPanel();
        panmdp.setBackground(Color.white);
        panmdp.setPreferredSize(new Dimension(220, 60));
        mdp = new JTextField();
        mdp.setPreferredSize(new Dimension(100, 25));
        labelmdp = new JLabel("Mot de passe");
        panmdp.add(labelmdp);
        panmdp.add(mdp);
 
        JPanel content = new JPanel();
        content.setBackground(Color.white);
        
        content.add(new JLabel(new ImageIcon("C:\\Users\\aurel\\Pictures\\ece.jpg")));
        
        content.add(panlog);
        content.add(panmdp);
        
        
        
        JPanel control = new JPanel();
        JButton okBouton = new JButton("Se connecter");
        control.add(okBouton);
        
        this.setVisible(true);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
        this.setSize(500, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        
            okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        
          String log = login.getText();
          String mdp2 = mdp.getText();
          
          Session session=new Session(log,mdp2);
          /*Connection connect;
            connect = new Connect().getConnection();
            Fenetre fen = new Fenetre(connect);*/
          int groupe = session.getGroupe();
          int promo = session.getPromo();
          int droit = session.getDroit();
          boolean rep=session.isRep();
          System.out.println("Le groupe est="+groupe);
          System.out.println("Le promo est="+promo);
          if (rep==true){
            Connection connect;
            connect = new Connect().getConnection();
            Fenetre fen2 = new Fenetre(connect,groupe,promo,droit);
          }
          
          
        // String query="SELECT * FROM salle";
       //String query="SELECT salle.Nom,salle.Capacité,site.Nom FROM salle,site WHERE salle.IDSite=site.IDSite  ";
       //String query="SELECT cours.Nom,seance.Semaine,seance.Date,seance.HeureDebut,seance.HeureFin FROM seance,cours WHERE seance.IDCours=cours.IDCours";
       //String query="SELECT * FROM seance INNER JOIN cours ON seance.IDCours=cours.IDCours ";  
        //new RoomTable(query);
     
      }
            });

        
               /*this.setTitle("Ma JFrame");
    this.setSize(500, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);      
    this.getContentPane().setLayout(new FlowLayout());
    this.getContentPane().add(labelogin);
    this.getContentPane().add(login);
    this.getContentPane().add(labelmdp);
    this.getContentPane().add(mdp);*/
    
    
    //login.setColumns(10);

    //this.setVisible(true); 
    
        }
}