/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author aurel
 */
public class Boutons {
      //METHODE BOUTONS ADD
  public static void AddButton(Grille grille,JButton A,JButton B,JButton C,JButton D,JButton E,JButton F)
  {     
      A.setBounds(400,800,200,50); //RESTART
      B.setBounds(100,800,200,50); //SEMAINE PRECEDENTE
      C.setBounds(800,800,200,50); //SEMAINE SUIVANTE
      D.setBounds(900,200,200,50); //FILTRE ENSEIGNANT
      E.setBounds(900,400,200,50); //FILTRE ETUDIANT
      F.setBounds(900,600,200,50); //FILTRE COURS
      
      grille.add(A);
      grille.add(B);
      grille.add(C);
      grille.add(D);
      grille.add(E);
      grille.add(F);
  }
//FILTRES+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
  //METHODE CHOIX AFFICHAGE DES COURS D'UN ENSEIGNANT EN PARTICULIER
  public static String ChoixCoursEnseignant(Grille grille)
  {
      JOptionPane jop = new JOptionPane(), jop2 =  new JOptionPane();
      String nom = jop.showInputDialog(null,"Choisir un enseignant :","Filtrage Enseignant",JOptionPane.QUESTION_MESSAGE);
      jop.showMessageDialog(null, "Enseigant choisi : "+ nom,"Filtre choisi",JOptionPane.INFORMATION_MESSAGE);
      String enseignant = nom;
      
      return enseignant;    
  }
  public static void ChoixCoursEtudiant(Grille grille)
  {
      JOptionPane jop = new JOptionPane(), jop2 =  new JOptionPane();
      String nom = jop.showInputDialog(null,"Choisir un étudiant :","Filtrage Etudiant",JOptionPane.QUESTION_MESSAGE);
      jop.showMessageDialog(null, "Etudiant choisi : "+ nom,"Filtre choisi",JOptionPane.INFORMATION_MESSAGE);
      
  }
  public static String ChoixCours(Grille grille)
  {
      JOptionPane jop = new JOptionPane(), jop2 =  new JOptionPane();
      String nom = jop.showInputDialog(null,"Choisir un cours :","Filtrage Cours",JOptionPane.QUESTION_MESSAGE);
      jop.showMessageDialog(null, "Cours choisi : "+ nom,"Filtre choisi",JOptionPane.INFORMATION_MESSAGE);
      String cours = nom;
      
      return cours;
      
  }

}
