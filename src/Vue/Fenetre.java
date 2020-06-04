package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
  
    //Déclaration MENUBAR
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu cours = new JMenu("Cours");
    private JMenu vies = new JMenu("Vie Scolaire");
    private JMenu promo = new JMenu("Promotions");
    private JMenu salles = new JMenu("Salles");
    
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
    
    
    private JMenuItem itemc1 = new JMenuItem("Emploi du temps");
    private JMenuItem itemc2 = new JMenuItem("Récapitulatif des cours");
    private JMenuItem itemc3 = new JMenuItem("Fermer");
    
    private JMenuItem itemv1 = new JMenuItem("Relevé d'absences");
    private JMenuItem itemv2 = new JMenuItem("Liste d'intervenants");
    private JMenuItem itemv3 = new JMenuItem("Scolarité");
    private JMenuItem itemv4 = new JMenuItem("Calendrier Scolaire");
    
    private JMenuItem itemp1 = new JMenuItem("Intervenants");
    
    private JMenuItem items1 = new JMenuItem("Emploi du temps");
      
  public Fenetre(){
    
    this.setTitle("Hyperplanning");  
    this.setSize(1200, 1000);
    this.setResizable(true);//Empèche le reddimensionement
//    this.setLocation(800,600); //Définis la position de la fenetre
    this.setLocationRelativeTo(null);//Fenetre au centre de l'écran
    this.setAlwaysOnTop(false);// Garde la fenetre au premier plan
    this.setUndecorated(false);//Retire les contours & boutons de contrôle
    
    //Instanciation d'un objet JPanel
    Grille grille = new Grille();
    grille.setLayout(null);
    
    //Barre Menu
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
        
    this.cours.add(itemc1);        
    this.cours.add(itemc2);
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
    
    //TestBouton
    JButton test = new JButton("Test cours");
    test.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
            AffichageCours(grille);
        }
    });
    test.setBounds(400,800,200,50);
    grille.add(test);
    
    //Boutons Semaine
    JButton SP = new JButton("Semaine Précédente");
    SP.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
//            Grille grille2 = new Grille();
//            grille2.setLayout(null);
//            this.setContentPane(grille2);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(300,300);
//            frame.setVisible(true);
//            frame.dispose();
        }
    });
    JButton SS = new JButton("Semaine Suivante");
    SP.setBounds(100,800,200,50);

    SS.setBounds(850,800,200,50);
    grille.add(SP);
    grille.add(SS);
    
    this.setContentPane(grille);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //stop le programme lorsqu'on ferme la fenetre          
    this.setVisible(true); //rend la fentre visible 

  }
  
  
  public void AffichageCours(Grille affichage)
  {      
    int x = 50;
    int y = 50;
    
    JTextPane textPane = new JTextPane();
    
    //Affichage d'un cours test
    int largeur = 129;
    int hauteur = 79;
    
    //Affichage  d'un cours BDD
    String cours = "Traitement de Signal";
    String prof = "Duparc";
    String groupe = "ING1";
    String salle = "P300 E1";
    String typecours = "DS";
    
    int heure = 12;
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
    
//    textPane.setColor(Color.green);
//    g.fillRect(X,Y,largeur,hauteur);
//    g.setColor(Color.BLACK);
      textPane.setText(cours);
//    textPane.setText(cours,X,Y+15); //Nom du cours
//    g.drawString(prof,X,Y+30); //Nom de l'enseignant
//    g.drawString(groupe,X,Y+45); //Nom du groupe
//    g.drawString(salle,X,Y+60); //Numéro de la Salle + Campus
//    g.drawString(typecours,X,Y+75); //Type de séance
        
  }
   
}
