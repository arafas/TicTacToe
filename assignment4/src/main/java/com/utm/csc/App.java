package com.utm.csc;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App 
{
  
  public static Board game;

    public static void main( String[] args )
    {
        
        System.out.println( "Welcome to Assignment4: Tic Tac Toe!" );
        EventQueue.invokeLater(new Runnable() {
          
          
          public void run() {
            GameGUI ex = new GameGUI();
            ((Component) ex).setVisible(true);
          }
     });
   }

        
        

}

