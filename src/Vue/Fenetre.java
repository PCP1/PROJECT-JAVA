package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

 
public class Fenetre extends JFrame {
  
  private JPanel container = new JPanel();
  private JComboBox combo = new JComboBox();
  private JLabel label = new JLabel("Une ComboBox");
  
  int semaine = 0;
    //Déclaration MENUBAR
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu cours = new JMenu("Cours");
        private JMenuItem itemc1 = new JMenuItem("Emploi du temps");
        private JMenuItem itemc2 = new JMenuItem("Récapitulatif des cours");
        private JMenuItem itemc3 = new JMenuItem("Fermer");
        private JMenuItem itemc4 = new JMenuItem("Liste enseignants");
    
    private JMenu vies = new JMenu("Vie Scolaire");
        private JMenuItem itemv1 = new JMenuItem("Relevé d'absences");
        private JMenuItem itemv2 = new JMenuItem("Liste d'intervenants");
        private JMenuItem itemv3 = new JMenuItem("Scolarité");
        private JMenuItem itemv4 = new JMenuItem("Calendrier Scolaire");
    
    private JMenu promo = new JMenu("Promotions");
        private JMenuItem itemp1 = new JMenuItem("Intervenants");
    
    private JMenu salles = new JMenu("Salles");
        private JMenuItem items1 = new JMenuItem("Emploi du temps");
    
    private JMenu admin = new JMenu("ADMINISTRATEUR");
        private JMenuItem itema1 = new JMenuItem("Ajouter enseignant");
        private JMenuItem itema2 = new JMenuItem("Modifier enseignant");
        private JMenuItem itema3 = new JMenuItem("Supprimer enseignant");
        private JMenuItem itema4 = new JMenuItem("Ajouter responsable");
        private JMenuItem itema5 = new JMenuItem("Modifier responsable");
        private JMenuItem itema6 = new JMenuItem("Supprimer responsable");
        private JMenuItem itema7 = new JMenuItem("Ajouter élève");
        private JMenuItem itema8 = new JMenuItem("Modifier élève");
        private JMenuItem itema9 = new JMenuItem("Supprimer élève");                    
      
  public Fenetre(Connection connect){
    
    this.setTitle("Hyperplanning");  
    this.setSize(1200, 1000);
    this.setResizable(true);//Empèche le reddimensionement
//    this.setLocation(800,600); //Définis la position de la fenetre
    this.setLocationRelativeTo(null);//Fenetre au centre de l'écran
    this.setAlwaysOnTop(false);// Garde la fenetre au premier plan
    this.setUndecorated(false);//Retire les contours & boutons de contrôle
    
    //Creation de la grille
    Grille grille = new Grille();
    grille.setLayout(null);
    
    
    
    //AFFICHAGE DES COURS*************************************************
    //BOUTON AFFICHER COURS
    JButton test = new JButton("Afficher Cours");
    test.setBounds(400,800,200,50);
    test.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            AffichageCoursSemaine(connect,grille,semaine);
        }
    });
    grille.add(test);

    //SEMAINE PRECEDENTE
    JButton SP = new JButton("Semaine Précédente");
    SP.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            semaine = semaine-1;
            System.out.println("Semaine N°"+semaine);
            AffichageCoursSemaine(connect,grille,semaine);
        }
    });
    SP.setBounds(100,800,200,50);
    grille.add(SP);
    
    //SEMAINE SUIVANTE
    JButton SS = new JButton("Semaine Suivante");
    SS.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            semaine = semaine+1;
            System.out.println("Semaine N°"+semaine);
            AffichageCoursSemaine(connect,grille,semaine);
        }
    });
    SS.setBounds(800,800,200,50);
    grille.add(SS);
    //Numero Semaine
    JTextPane numerosemaine = new JTextPane();    
    numerosemaine.setBackground(Color.YELLOW);
    numerosemaine.setBounds(600,800,129,18);
    numerosemaine.setText("SEMAINE"+semaine);
    
    grille.add(numerosemaine);
    
    //Barre Menu 00000000000000000000000000000       
        this.cours.add(itemc1);        
        this.cours.add(itemc2);
        this.cours.add(itemc4);
        this.cours.addSeparator();
        itemc3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                System.exit(0);
            }
        });
        this.cours.add(itemc3);
        
        this.vies.add(itemv1);
        this.vies.add(itemv2);
        this.vies.add(itemv3);
        this.vies.add(itemv4);
        
        this.promo.add(itemp1);
        
        this.salles.add(items1);
    
        this.admin.add(itema1);
        this.admin.add(itema2);
        this.admin.add(itema3);
            this.admin.addSeparator();
        this.admin.add(itema4);
        this.admin.add(itema5);
        this.admin.add(itema6);
            this.admin.addSeparator();
        this.admin.add(itema7);
        this.admin.add(itema8);
        this.admin.add(itema9);
    
        this.menuBar.add(cours);
        this.menuBar.add(vies);
        this.menuBar.add(promo);
        this.menuBar.add(salles);
        this.menuBar.add(admin);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    //Fin Barre Menu 00000000000000000000000000000                  
    
    this.setContentPane(grille);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //stop le programme lorsqu'on ferme la fenetre          
    this.setVisible(true); //rend la fentre visible 
  }
  
  //METHODE POUR TROUVER L'HEURE DE DEBUT
  public static int FindHeure(Connection connect, int seance)
  {
     try {
    Statement state = connect.createStatement();
    
    String query = "SELECT HeureDebut FROM seance WHERE ID_Seance ="+seance;
    
    ResultSet result = state.executeQuery(query);
    ResultSetMetaData resultMeta = result.getMetaData();
    
    for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.println("\t *" + resultMeta.getColumnName(i));
    
    result.first();
    int HeureDebut = result.getInt("HeureDebut");
    System.out.println("HeureDebut : " + HeureDebut);    
    
    result.close();
    state.close();
    return HeureDebut;
    }catch (Exception e) {
        e.printStackTrace();
    } 
      return 0;
  }
  
  //METHODE POUR AFFICHER UN COURS
  public static void AffichageCours(Grille grille,int heuredebut,String jour)
  {
      int x = 50;
      int y = 50;
      int X = 0;
      int Y = 0;
      System.out.println(heuredebut);
      System.out.println(jour);
      
    //Placement jour
    switch (jour)
    {
        case "Lundi":
            X = x+1;break;
        case "Mardi":
            X = x+131;break;
        case "Mercredi":
            X = x+261;break;
        case "Jeudi":
            X = x+391;break;
        case "Vendredi":
            X = x+521;break;
        case "Samedi":
            X = x+651;break;
    }  
    //Placement horaire
    switch (heuredebut)
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
    
    System.out.println("X:"+X+"Y:"+Y);
      
    JTextPane nomcours = new JTextPane();
    JTextPane nomprof = new JTextPane();
    JTextPane nomgroupe = new JTextPane();
    JTextPane nomtypecours = new JTextPane();
    JTextPane nomsalle = new JTextPane();
    
    nomcours.setBackground(Color.YELLOW);
    nomcours.setBounds(X,Y,129,18);
    nomcours.setText("COURS");
    
    nomprof.setBackground(Color.YELLOW);
    nomprof.setBounds(X,Y+15,129,18);
    nomprof.setText("PROF");
    
    nomgroupe.setBackground(Color.YELLOW);
    nomgroupe.setBounds(X,Y+30,129,18);
    nomgroupe.setText("GROUPE");
    
    nomtypecours.setBackground(Color.YELLOW);
    nomtypecours.setBounds(X,Y+45,129,18);
    nomtypecours.setText("TYPECOURS");
    
    nomsalle.setBackground(Color.YELLOW);
    nomsalle.setBounds(X,Y+60,129,18);
    nomsalle.setText("SALLE");
    
    grille.add(nomcours);
    grille.add(nomprof);
    grille.add(nomgroupe);
    grille.add(nomtypecours);
    grille.add(nomsalle);
  }
  
  //METHODE POUR AFFICHER TOUS LES COURS D'UNE SEMAINE
  public static void AffichageCoursSemaine(Connection connect,Grille grille, int semaine)
  {
      try{
          Statement state = connect.createStatement();
    
          String query = "SELECT * FROM seance WHERE Semaine ="+semaine;
    
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
                  int seance = result.getInt("HeureDebut");
                  String jour = result.getString("Date");
                  AffichageCours(grille,seance,jour);
              }
          }
          
          result.close();
          state.close();
      }catch (Exception e) {
        e.printStackTrace();
    } 
  }
  
}
