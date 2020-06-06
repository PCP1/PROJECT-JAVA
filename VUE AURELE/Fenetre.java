package Vue;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

 
public class Fenetre extends JFrame {
  
  private final JPanel container = new JPanel();
  private final JComboBox combo = new JComboBox();
  private final JLabel label = new JLabel("Une ComboBox");
  
  int semaine = 0;
    //Déclaration MENUBAR
    private final JMenuBar menuBar = new JMenuBar();
    
    private final JMenu cours = new JMenu("Cours");
        private final JMenuItem itemc1 = new JMenuItem("Emploi du temps");
        private final JMenuItem itemc2 = new JMenuItem("Récapitulatif des cours");
        private final JMenuItem itemc3 = new JMenuItem("Fermer");
        private final JMenuItem itemc4 = new JMenuItem("Liste enseignants");
    
    private final JMenu vies = new JMenu("Vie Scolaire");
        private final JMenuItem itemv1 = new JMenuItem("Relevé d'absences");
        private final JMenuItem itemv2 = new JMenuItem("Liste d'intervenants");
        private final JMenuItem itemv3 = new JMenuItem("Scolarité");
        private final JMenuItem itemv4 = new JMenuItem("Calendrier Scolaire");
    
    private final JMenu promo = new JMenu("Promotions");
        private final JMenuItem itemp1 = new JMenuItem("Intervenants");
    
    private final JMenu salles = new JMenu("Salles");
        private final JMenuItem items1 = new JMenuItem("Emploi du temps");
    
    private final JMenu admin = new JMenu("ADMINISTRATEUR");
        private final JMenuItem itema1 = new JMenuItem("Ajouter enseignant");
        private final JMenuItem itema2 = new JMenuItem("Modifier enseignant");
        private final JMenuItem itema3 = new JMenuItem("Supprimer enseignant");
        private final JMenuItem itema4 = new JMenuItem("Ajouter responsable");
        private final JMenuItem itema5 = new JMenuItem("Modifier responsable");
        private final JMenuItem itema6 = new JMenuItem("Supprimer responsable");
        private final JMenuItem itema7 = new JMenuItem("Ajouter élève");
        private final JMenuItem itema8 = new JMenuItem("Modifier élève");
        private final JMenuItem itema9 = new JMenuItem("Supprimer élève");                    
      
  public Fenetre(Connection connect){
    
    this.setTitle("Hyperplanning");  
    this.setSize(1200, 1000);
    this.setResizable(true);//Empèche le reddimensionement
    this.setLocationRelativeTo(null);//Fenetre au centre de l'écran
    this.setAlwaysOnTop(false);// Garde la fenetre au premier plan
    this.setUndecorated(false);//Retire les contours & boutons de contrôle
    
    //Creation de la grille
    Grille grille = new Grille();
    grille.setLayout(null);
            
//AFFICHAGE DES COURS***********************************************************
    //INIT BUTTON
    JButton test = new JButton("RESTART");
    JButton SP = new JButton("Semaine Précédente");
    JButton SS = new JButton("Semaine Suivante");
    JButton FE = new JButton("Filtre enseignant");
    JButton FEtudiant = new JButton("Filtre étudiant");
    JButton FC = new JButton("Filtre cours");
    
    //BOUTON AFFICHER COURS   
    test.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            AffichageCoursSemaine(connect,grille,semaine);
            grille.removeAll();
            grille.repaint();
            AffichageCoursSemaine(connect,grille,semaine);
            AffichageNumeroSemaine(grille,semaine);
            Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
        }
    });

    //BOUTON SEMAINE PRECEDENTE   
    SP.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            semaine = semaine-1;
            System.out.println("Semaine N°"+semaine);
            grille.removeAll();
            grille.repaint();
            AffichageCoursSemaine(connect,grille,semaine);
            AffichageNumeroSemaine(grille,semaine);          
            Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
        }
    });
       
    //BOUTON SEMAINE SUIVANTE   
    SS.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            semaine = semaine+1;
            System.out.println("Semaine N°"+semaine);
            grille.removeAll();
            grille.repaint();
            AffichageCoursSemaine(connect,grille,semaine);
            AffichageNumeroSemaine(grille,semaine);
            Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
        }
    });
    
    //BOUTON FILTRE ENSEIGNANT  
    FE.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            String prof = Boutons.ChoixCoursEnseignant(grille);
            System.out.println(prof);
            grille.removeAll();
            grille.repaint();
            int IDU = Recup.RecupIDUtilisateurNomEnseignant(connect,prof);
            int IDC = Recup.RecupIDCoursNomEnseignant(connect,IDU);
            Filtres.AffichageCoursSemaineFiltreEnseignant(connect,grille,semaine,IDC);
            AffichageNumeroSemaine(grille,semaine);
            Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
        }
    });
    
    //BOUTON FILTRE ETUDIANT  
    FEtudiant.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            Boutons.ChoixCoursEtudiant(grille);
            grille.removeAll();
            grille.repaint();           
            AffichageCoursSemaine(connect,grille,semaine);
            AffichageNumeroSemaine(grille,semaine);
            Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
        }
    });
    
    //BOUTON FILTRE COURS  
    FC.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            String nomcours = Boutons.ChoixCours(grille);
            grille.removeAll();
            grille.repaint();
            int IDC = Recup.RecupIDCoursNomCours(connect, nomcours);
            Filtres.AffichageCoursSemaineFiltreEnseignant(connect,grille,semaine,IDC);
            AffichageNumeroSemaine(grille,semaine);
            Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
        }
    });
    
    Boutons.AddButton(grille,test,SP,SS,FE,FEtudiant,FC);
//Numero Semaine
    AffichageNumeroSemaine(grille,semaine);
    
//Afficher la barre de menu 
    AffichageBarreMenu();                
    
    setContentPane(grille);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
    setVisible(true);
  }
  
  
  
 //-----------------------------------------------------------------------------
//METHODES UTILISES
 //-----------------------------------------------------------------------------
  
  //METHODE POUR AFFICHER UN COURS
  public static void AffichageCours(Grille grille,int heuredebut,String jour,String nom_cours,String nom_enseignant,String nom_typecours,String nom_salle,String nom_groupe)
  {
      int x = 50;
      int y = 50;
      int X = 0;
      int Y = 0;
      System.out.println("Heure Debut|"+heuredebut+"||Jour|"+jour+"||Nom Cours|"+nom_cours+"||Nom Enseignant||"+nom_enseignant+"||Salle"+nom_salle+"||Groupe"+nom_groupe);
      
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
    
    System.out.println("X:"+X+" Y:"+Y);
      
    JTextPane nomcours = new JTextPane();
    JTextPane nomprof = new JTextPane();
    JTextPane nomgroupe = new JTextPane();
    JTextPane nomtypecours = new JTextPane();
    JTextPane nomsalle = new JTextPane();
    
    nomcours.setBackground(Color.YELLOW);
    nomcours.setBounds(X,Y,129,18);
    nomcours.setText(nom_cours);
    
    nomprof.setBackground(Color.YELLOW);
    nomprof.setBounds(X,Y+15,129,18);
    nomprof.setText(nom_enseignant);
    
    nomgroupe.setBackground(Color.YELLOW);
    nomgroupe.setBounds(X,Y+30,129,18);
    nomgroupe.setText(nom_groupe);
    
    nomtypecours.setBackground(Color.YELLOW);
    nomtypecours.setBounds(X,Y+45,129,18);
    nomtypecours.setText(nom_typecours);
    
    nomsalle.setBackground(Color.YELLOW);
    nomsalle.setBounds(X,Y+60,129,18);
    nomsalle.setText(nom_salle);
    
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
   //METHODE POUR AFFICHER LE NUMERO DE LA SEMAINE
  public static void AffichageNumeroSemaine(Grille grille, int semaine)
  {
    JTextPane numerosemaine = new JTextPane();    
    numerosemaine.setBackground(Color.YELLOW);
    numerosemaine.setBounds(600,800,129,18);
    numerosemaine.setText("SEMAINE N°"+semaine);
    
    grille.add(numerosemaine);
  }
  //METHODE POUR AFFICHER LA BARRE MENU
  public void AffichageBarreMenu()
  {
        cours.add(itemc1);        
        cours.add(itemc2);
        cours.add(itemc4);
        cours.addSeparator();
        itemc3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                System.exit(0);
            }
        });
        cours.add(itemc3);
        
        vies.add(itemv1);
        vies.add(itemv2);
        vies.add(itemv3);
        vies.add(itemv4);
        
        promo.add(itemp1);
        
        salles.add(items1);
    
        admin.add(itema1);
        admin.add(itema2);
        admin.add(itema3);
            admin.addSeparator();
        admin.add(itema4);
        admin.add(itema5);
        admin.add(itema6);
            admin.addSeparator();
        admin.add(itema7);
        admin.add(itema8);
        admin.add(itema9);
    
        menuBar.add(cours);
        menuBar.add(vies);
        menuBar.add(promo);
        menuBar.add(salles);
        menuBar.add(admin);
        setJMenuBar(menuBar);
        setVisible(true);
  }
}
