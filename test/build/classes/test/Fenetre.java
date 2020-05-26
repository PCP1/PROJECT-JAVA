/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */

 
public class Fenetre extends JFrame {
  
  private JPanel container = new JPanel();
  private JComboBox combo = new JComboBox();
  private JLabel label = new JLabel("Une ComboBox");
      
  public Fenetre(){
    
    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 400);
    this.setResizable(true);//Empèche le reddimensionement
    //this.setLocation(800,600); //Définis la position de la fenetre
    this.setLocationRelativeTo(null);//Fenetre au centre de l'écran
    this.setAlwaysOnTop(false);// Garde la fenetre au premier plan
    this.setUndecorated(false);//Retire les contours & boutons de contrôle
    
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(new Panneau());

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //stop le programme lorsqu'on ferme la fenetre          
    this.setVisible(true); //rend la fentre visible 
    

  }
}