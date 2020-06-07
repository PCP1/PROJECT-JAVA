package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class XDialog extends JDialog {
    private XDialogInfo zInfo = new XDialogInfo();
    private boolean sendData;
    private JLabel dateLabel, HeureDebutLabel,groupeLabel,enseignantLabel,salleLabel,coursLabel,typecoursLabel,semaineLabel;
    private JComboBox date, HeureDebut,typecours,cours;
    private JTextField groupe,enseignant,salle,semaine;
    public XDialog(JFrame parent,String title, boolean modal)
    {   
        
      
        super(parent,title,modal);
        this.setSize(700,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }
    
    public XDialogInfo showZDialog()
    {
        this.sendData = false;
        this.setVisible(true);
        return this.zInfo;
    }
    
    private void initComponent()
    {

        
 
        
        //Choix du cours
        JPanel panCours = new JPanel();
        panCours.setBackground(Color.white);
        panCours.setPreferredSize(new Dimension(220, 80));
        cours = new JComboBox();
        cours.addItem("Traitement du signal");
        cours.addItem("MOOC Nano");
        cours.addItem("POO Java");
        cours.addItem("Droit du Travail");
        cours.addItem("Anthropologie");
        coursLabel = new JLabel("Choix du cours");
        panCours.setBorder(BorderFactory.createTitledBorder("Cours"));
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

        
        JPanel content= new JPanel();
        content.setBackground(Color.WHITE);



        content.add(panCours);
        content.add(panTypeCours);
 
        
        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");
        
        okBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                zInfo = new XDialogInfo((String) cours.getSelectedItem(), (String) typecours.getSelectedItem());
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