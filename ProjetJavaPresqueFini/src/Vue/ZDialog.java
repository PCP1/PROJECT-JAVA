package Vue;

import Update.Actualiser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

/**
 *
 * @author aurel
 */
public class ZDialog extends JDialog {
    private ZDialogInfo zInfo = new ZDialogInfo();
    private boolean sendData;
    private JLabel dateLabel, HeureDebutLabel,groupeLabel,enseignantLabel,salleLabel,coursLabel,typecoursLabel,semaineLabel,capaciteLabel;
    private JComboBox date, HeureDebut,typecours,cours,salle,groupe,enseignant;
    private JTextField semaine,capacite;
    public ZDialog(JFrame parent,String title, boolean modal,Connection connect)
    {
        super(parent,title,modal);
        this.setSize(700,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent(connect);
    }
    
    public ZDialogInfo showZDialog()
    {
        this.sendData = false;
        this.setVisible(true);
        return this.zInfo;
    }
    
    private void initComponent(Connection connect)
    {
        //CHOIX DATE
        JPanel panDate = new JPanel();
        panDate.setBackground(Color.WHITE);
        panDate.setPreferredSize(new Dimension(220,80));
        panDate.setBorder(BorderFactory.createTitledBorder("Choix du jour"));
        date = new JComboBox();
        date.addItem("Lundi");
        date.addItem("Mardi");
        date.addItem("Mercredi");
        date.addItem("Jeudi");
        date.addItem("Vendredi");
        dateLabel = new JLabel("Date : ");
        panDate.add(dateLabel);
        panDate.add(date);
        
        //CHOIX HEURE DEBUT
        JPanel panHeureDebut = new JPanel();
        panHeureDebut.setBackground(Color.WHITE);
        panHeureDebut.setPreferredSize(new Dimension(220,80));
        panHeureDebut.setBorder(BorderFactory.createTitledBorder("Choix de l'heure début"));
        HeureDebut = new JComboBox();
        HeureDebut.addItem(830);
        HeureDebut.addItem(1015);
        HeureDebut.addItem(12);
        HeureDebut.addItem(1345);
        HeureDebut.addItem(1530);
        HeureDebut.addItem(1715);
        HeureDebut.addItem(19);
        HeureDebutLabel = new JLabel("Heure Début : ");
        panHeureDebut.add(HeureDebutLabel);
        panHeureDebut.add(HeureDebut);
        
        //CHOIX GROUPE
        JPanel panGroupe = new JPanel();
        panGroupe.setBackground(Color.WHITE);
        panGroupe.setPreferredSize(new Dimension(220,80));
        panGroupe.setBorder(BorderFactory.createTitledBorder("Choix du groupe"));
        groupe = new JComboBox();
        groupe.addItem("TD01");
        groupe.addItem("TD02");
        groupe.addItem("TD03");
        groupe.addItem("TD04");
        groupeLabel = new JLabel("Choisir le groupe : ");
        panGroupe.add(groupeLabel);
        panGroupe.add(groupe);
        
        //CHOIX ENSEIGNANT       
        JPanel panEnseignant = new JPanel();
        panEnseignant.setBackground(Color.WHITE);
        panEnseignant.setPreferredSize(new Dimension(220,80));
        panEnseignant.setBorder(BorderFactory.createTitledBorder("Choix de l'enseignant"));
        enseignant = new JComboBox();
        enseignant.addItem("Segado");
        enseignant.addItem("Mockber");
        enseignant.addItem("Palasi");
        enseignant.addItem("Hina");
        enseignantLabel = new JLabel("Choisir l'enseignant : ");
        panEnseignant.add(enseignantLabel);
        panEnseignant.add(enseignant);
        
        //Choix de salle        
        JPanel panSalle = new JPanel();
        panSalle.setBackground(Color.WHITE);
        panSalle.setPreferredSize(new Dimension(220,80));
        panSalle.setBorder(BorderFactory.createTitledBorder("Choix de la salle"));
        salle = new JComboBox();
        salle.addItem("P330");
        salle.addItem("P445");
        salle.addItem("E145");
        salle.addItem("L225");
        salle.addItem("306");
        salleLabel = new JLabel("Choisir la salle : ");
        panSalle.add(salleLabel);
        panSalle.add(salle);
        
        //Choix du cours
        JPanel panCours = new JPanel();
        panCours.setBackground(Color.WHITE);
        panCours.setPreferredSize(new Dimension(220,80));
        panCours.setBorder(BorderFactory.createTitledBorder("Choix du cours"));
        cours = new JComboBox();
        cours.addItem("Traitement du signal");
        cours.addItem("MOOC Nano");
        cours.addItem("POO Java");
        cours.addItem("Droit du travail");
        cours.addItem("Anthropologie");
        coursLabel = new JLabel("Choisir le cours : ");
        panCours.add(coursLabel);
        panCours.add(cours);
        
        //Choix du type de cours
        JPanel panTypeCours = new JPanel();
        panTypeCours.setBackground(Color.WHITE);
        panTypeCours.setPreferredSize(new Dimension(220,80));
        panTypeCours.setBorder(BorderFactory.createTitledBorder("Choix du type de cours"));
        typecours = new JComboBox();
        typecours.addItem("Travaux Dirigés");
        typecours.addItem("Cours Magistral");
        typecours.addItem("Devoir Surveillé");
        typecours.addItem("Travaux Pratiques");
        typecoursLabel = new JLabel("Type de cours : ");
        panTypeCours.add(typecoursLabel);
        panTypeCours.add(typecours);
        
        //Choix de la semaine
        JPanel panSemaine = new JPanel();
        panSemaine.setBackground(Color.white);
        panSemaine.setPreferredSize(new Dimension(220, 80));
        semaine = new JTextField();
        semaine.setPreferredSize(new Dimension(100, 25));
        panSemaine.setBorder(BorderFactory.createTitledBorder("Choix de la semaine"));
        semaineLabel = new JLabel("Saisir la semaine :");
        panSemaine.add(semaineLabel);
        panSemaine.add(semaine);
        
        //Choix de la capacité
        JPanel panCapacite = new JPanel();
        panCapacite.setBackground(Color.white);
        panCapacite.setPreferredSize(new Dimension(220, 80));
        capacite = new JTextField();
        capacite.setPreferredSize(new Dimension(100, 25));
        panCapacite.setBorder(BorderFactory.createTitledBorder("Choix de la capacité"));
        capaciteLabel = new JLabel("Saisir la capacité :");
        panCapacite.add(capaciteLabel);
        panCapacite.add(capacite);
        
        JPanel content= new JPanel();
        content.setBackground(Color.WHITE);
        content.add(panDate);
        content.add(panHeureDebut);
        content.add(panGroupe);
        content.add(panEnseignant);
        content.add(panSalle);
        content.add(panCours);
        content.add(panTypeCours);
        content.add(panSemaine);
        content.add(panCapacite);
        
        JPanel control = new JPanel();
        JButton okBouton = new JButton("Ajouter");
        
        okBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                //ENSEIGNANT
                int idenseignant = Recup.RecupIDUtilisateurNomEnseignant(connect,(String)enseignant.getSelectedItem());
                //SALLE
                int idsalle = Recup.RecupIDSalleNom(connect, (String)salle.getSelectedItem());
                //HEURE DEBUT
                int heuredebut = (int)HeureDebut.getSelectedItem();
                //CAPACITE
                String Scapacite = (String)capacite.getText();
                int Icapacite = Integer.parseInt(Scapacite);
                //DATE
                String Sdate = (String)date.getSelectedItem();
                //SEMAINE
                String Ssemaine = (String)semaine.getText();
                int Isemaine = Integer.parseInt(Ssemaine);
                //NOMCOURS
                String Scours = (String)cours.getSelectedItem();
                int idcours = Recup.RecupIDCoursNomCours(connect, Scours);
                //TYPECOURS
                String Sidtypecours = (String)typecours.getSelectedItem();
                int idtypecours = Recup.RecupIDTypeCoursNom(connect, Sidtypecours);
                //IDGROUPE
                String Sidgroupe = (String)groupe.getSelectedItem();
                int idgroupe = Recup.RecupIDGroupeNom(connect,Sidgroupe);
                        
                try {
                    Actualiser.AjoutSeance(idsalle,Icapacite,heuredebut,Sdate,Isemaine,idcours,idtypecours,idenseignant,idgroupe);
                } catch (SQLException ex) {
                    Logger.getLogger(ZDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                zInfo = new ZDialogInfo((String)date.getSelectedItem(),(int)HeureDebut.getSelectedItem(), (String)groupe.getSelectedItem(),(String)enseignant.getSelectedItem(),(String)salle.getSelectedItem(),(String)cours.getSelectedItem(),(String)typecours.getSelectedItem(),semaine.getText(),capacite.getText());
                setVisible(false);
            }
        });
        
        JButton cancelBouton = new JButton("Annuler");
        cancelBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                setVisible(false);
            }
        });
        
        control.add(okBouton);
        control.add(cancelBouton);
        
        
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);           
    }                           
}
