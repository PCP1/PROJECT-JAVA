/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.GradientPaint;
 
import javax.swing.JPanel;
/**
 *
 * @author Lucas
 */
public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){

    int x1 = this.getWidth()/8;
    int y1 = this.getHeight()/8;
    int l=(int) (this.getWidth()/1.5);
    int h=(int) (this.getHeight()/1.5);
    int y2=9*y1/10+9*h/70;
    int h2=h-y2;
    

    
    //g.fillOval(200, 200, 75, 75); //(position x et y puis diametre en largeur et diametre hauteur
    //g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    //g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    
    
    g.setColor(Color.white);
    g.fillRect(x1, y1, l,h); ///rectangle
    g.setColor(Color.black); 
    g.drawRect(x1, y1, l,h);
    
    g.drawLine(x1+l/6, y1, x1+l/6, y1+h);
    g.drawLine(x1+l/3, y1, x1+l/3, y1+h);
    g.drawLine(x1+l/2, y1, x1+l/2, y1+h);     /// Ligne vertical
    g.drawLine(x1+2*l/3, y1, x1+2*l/3, y1+h);
    g.drawLine(x1+5*l/6, y1, x1+5*l/6, y1+h);
    
    g.drawLine(x1, y1+h/7, x1+l, y1+h/7);//8h30
    g.drawLine(x1,y2,x1+l,y2);//10h
    g.drawLine(x1, y1+2*h/7, x1+l, y1+2*h/7);//10h15
    g.drawLine(x1,y2+h2/5,x1+l,y2+h2/5);//11h45
    g.drawLine(x1, y1+3*h/7, x1+l, y1+3*h/7);//12h
    g.drawLine(x1,y2+2*h2/5,x1+l,y2+2*h2/5);//13h30
    g.drawLine(x1, y1+4*h/7, x1+l, y1+4*h/7);//13h45 
    g.drawLine(x1,y1+20*h/37,x1+l,y1+20*h/37);//15h15/// Ligne horizontal
    g.drawLine(x1, y1+5*h/7, x1+l, y1+5*h/7);//15h30
    g.drawLine(x1,y1+31*h2/32,x1+l,y1+31*h2/32);//17h
    g.drawLine(x1,y2+41*h2/40,x1+l,y2+41*h2/40);//18h45
    g.drawLine(x1, y1+6*h/7, x1+l, y1+6*h/7);//19h
    g.drawLine(x1,y2+34*h/40,x1+l,y2+34*h/40);//20h30
    
    


    //g.fillRect(65, 65, 30, 40);
   // g.drawRoundRect(100, 100, 30, 50, 10, 10);
   // g.fillRoundRect(550, 650, 55, 30, 5, 5);
    //g.drawLine(0, 0, this.getWidth(), this.getHeight());
   // g.drawLine(0, this.getHeight(), this.getWidth(), 0);
    
    //int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
    //int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
    //g.drawPolygon(x, y, 8);
   // g.fillPolygon(x,y,8);
     int xa=(2*x1+l/10)/2;
    
    Font font = new Font("Courier", Font.BOLD, l/50);
    g.setFont(font);
    g.setColor(Color.red);
    g.fillRect(x1, y1, l,h);
    
  
       
    g.drawString("Lundi", xa, y1-y1/10);
    g.drawString("Mardi", l/6+xa , y1-y1/10);
    g.drawString("Mercredi", (int) (l/3+xa), y1-y1/10);
    g.drawString("Jeudi", l/2+xa, y1-y1/10);
    g.drawString("Vendredi", (int) (2*l/3+xa), y1-y1/10);
    g.drawString("Samedi", (int) (l*5/6+xa), y1-y1/10);
    
    int t=x1-l/25;
    //int y2=9/10*((y1+h/7)-y1);
    
    Font font2 = new Font("Courier", Font.BOLD, l/80);
    g.setFont(font2);
    g.setColor(Color.black);
    g.drawString("8h30", t,y1);
    g.drawString("10h00", t,y2);
    g.drawString("10h15", t,y1+h/7);
    g.drawString("11h45", t,y2+h2/5);
    g.drawString("12h", t,y1+2*h/7);
    g.drawString("13h30", t,y2+2*h2/5);
    g.drawString("13h45", t,y1+3*h/7);
    g.drawString("15h15", t,y1+20*h/37);
    g.drawString("15h30", t,y1+4*h/7);
    g.drawString("17h00", t,y1+31*h2/32);
    g.drawString("17h15", t,y1+5*h/7);
    g.drawString("18h45", t,y2+41*h2/40);
    g.drawString("19h", t,y1+6*h/7);
    g.drawString("20h30", t,y2+34*h/40);
    
    
    
     
    /*try {
      Image img = ImageIO.read(new File("images.jpg"));
      g.drawImage(img, 0, 0, this);
      //Pour une image de fond
      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }*/
   /* Graphics2D g2d = (Graphics2D)g;
    GradientPaint gp, gp2, gp3, gp4, gp5, gp6; 
    gp = new GradientPaint(0, 0, Color.RED, 20, 0, Color.magenta, true);
    gp2 = new GradientPaint(20, 0, Color.magenta, 40, 0, Color.blue, true);
    gp3 = new GradientPaint(40, 0, Color.blue, 60, 0, Color.green, true);
    gp4 = new GradientPaint(60, 0, Color.green, 80, 0, Color.yellow, true);
    gp5 = new GradientPaint(80, 0, Color.yellow, 100, 0, Color.orange, true);
    gp6 = new GradientPaint(100, 0, Color.orange, 120, 0, Color.red, true);

    g2d.setPaint(gp);
    g2d.fillRect(0, 0, 20, this.getHeight());               
    g2d.setPaint(gp2);
    g2d.fillRect(20, 0, 40, this.getHeight());
    g2d.setPaint(gp3);
    g2d.fillRect(40, 0, 60, this.getHeight());
    g2d.setPaint(gp4);
    g2d.fillRect(60, 0, 80, this.getHeight());
    g2d.setPaint(gp5);
    g2d.fillRect(80, 0, 100, this.getHeight());
    g2d.setPaint(gp6);
    g2d.fillRect(100, 0, 120, this.getHeight());*/
  }

  
}