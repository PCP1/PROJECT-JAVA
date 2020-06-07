package Vue;


import DataAcessObject.DAOseance;
import Update.RoomTable;
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
        private final JMenuItem itemc3 = new JMenuItem("Fermer");
        private final JMenuItem itemc4 = new JMenuItem("Liste enseignants");
    
    private final JMenu salles = new JMenu("Salles");
        private final JMenuItem items1 = new JMenuItem("Liste Salles");
    
    private final JMenu admin = new JMenu("ADMINISTRATEUR");
        private final JMenuItem itema1 = new JMenuItem("Liste Cours ID");
        private final JMenuItem itema2 = new JMenuItem("VIDE");
        private final JMenuItem itema3 = new JMenuItem("VIDE");
        private final JMenuItem itema4 = new JMenuItem("VIDE");
        private final JMenuItem itema5 = new JMenuItem("VIDE");
        private final JMenuItem itema6 = new JMenuItem("VIDE");
        private final JMenuItem itema7 = new JMenuItem("Ajouter Séance");
        private final JMenuItem itema8 = new JMenuItem("Modifier Séance");
        private final JMenuItem itema9 = new JMenuItem("Supprimer Séance");                    
      
  public Fenetre(Connection connect,int groupe,int promo,int droit){
    
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
    
    //BOUTONS ROOM TABLE
     itemc1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0){
        String query="SELECT cours.Nom_Cours,type_cours.Nom_TypeCours,seance.Date,seance.Semaine,seance.HeureDebut FROM `seance`INNER JOIN cours ON seance.ID_Cours=cours.ID_Cours INNER JOIN type_cours ON seance.ID_TypeCours=type_cours.ID_TypeCours INNER JOIN groupe WHERE groupe.ID_Groupe="+groupe;
        new RoomTable(query);
        }
    });
        //Liste Seance ID
     itema1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0){
        String query="SELECT DISTINCT seance.ID_Seance,seance.Semaine,cours.Nom_Cours,type_cours.Nom_TypeCours,seance.Date,seance.HeureDebut FROM `seance`INNER JOIN cours ON seance.ID_Cours=cours.ID_Cours INNER JOIN type_cours ON seance.ID_TypeCours=type_cours.ID_TypeCours INNER JOIN groupe";
        new RoomTable(query);
        }
    });
     //Liste Salles
     items1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0){
        String query="SELECT DISTINCT salle.Nom_Salle,salle.Capacite_Salle,site.Nom_Site FROM `salle`INNER JOIN site WHERE salle.ID_Site=site.ID_Site";
        new RoomTable(query);
        }
    });
        //Supprimer Seance avec ID
     itema9.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0){
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String idcoursupp = jop.showInputDialog(null,"Séance à supprimer.","Supprimer séance",JOptionPane.QUESTION_MESSAGE);
        int idcourssupp = Integer.parseInt(idcoursupp);
        Filtres.SupprimerCours(connect, idcourssupp);
        jop2.showMessageDialog(null,"ID Séance supprimée : "+idcoursupp,"Suppression : Succès",JOptionPane.INFORMATION_MESSAGE);
        }
    });

    
    itemc4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            String query="SELECT enseignant.ID_Utilisateur,Prenom,Nom,Nom_Cours FROM `utilisateur`INNER JOIN enseignant ON utilisateur.ID_Utilisateur=enseignant.ID_Utilisateur INNER JOIN cours ON enseignant.ID_Cours=cours.ID_Cours WHERE utilisateur.Droit="+3;
            new RoomTable(query);
        }
    });
    
    //Bouton ajout d'un cours
    itema7.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            ZDialog zd = new ZDialog(null,"Ajout d'un cours",true,connect);
            ZDialogInfo zInfo = zd.showZDialog();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null,zInfo.toString(),"Informations du cours ajouté",JOptionPane.INFORMATION_MESSAGE);
            
        }
    });
    
    //BOUTON AFFICHER COURS   
    test.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            AffichageCoursSemaine(connect,grille,semaine,groupe);
            grille.removeAll();
            grille.repaint();
            AffichageCoursSemaine(connect,grille,semaine,groupe);
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
            AffichageCoursSemaine(connect,grille,semaine,groupe);
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
            AffichageCoursSemaine(connect,grille,semaine,groupe);
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
            AffichageCoursSemaine(connect,grille,semaine,groupe);
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
    AffichageBarreMenu(droit);                
    
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
  public static void AffichageCoursSemaine(Connection connect,Grille grille, int semaine,int groupe)
  {
      try{
          Statement state = connect.createStatement();
    
          String query = "SELECT * FROM seance INNER JOIN seance_groupes WHERE seance.Semaine ="+semaine+" AND seance_groupes.ID_Groupe="+groupe;
    
          ResultSet result = state.executeQuery(query);
          ResultSetMetaData resultMeta = result.getMetaData();                   
          
          while(result.next())
          {
              for(int i = 1; i <= resultMeta.getColumnCount();i++)
              {
                  int heuredebut = result.getInt("seance.HeureDebut");
                  int seance = result.getInt("seance.ID_Seance");
                  String jour = result.getString("seance.Date");
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
  public void AffichageBarreMenu(int droit)
  {
        cours.add(itemc1);        
        cours.add(itemc4);
        cours.addSeparator();
        itemc3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                System.exit(0);
            }
        });
        cours.add(itemc3);
        
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
        menuBar.add(salles);
        if(droit==1){
        menuBar.add(admin);
        }
        setJMenuBar(menuBar);
        setVisible(true);
  }
}
