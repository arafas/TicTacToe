package com.utm.csc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class GameGUI extends JFrame {
  
  private JLabel statusBar;
  private int turnTrack;
  private JButton xturn;
  


  
  public GameGUI(){

    initUI();
  }

  private void initUI() {
    
    Board.setupBoard();
    turnTrack = 1;
    ButtonListener butlist = new ButtonListener();
    
    JPanel basic = new JPanel();
    basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
    add(basic);
    
    statusBar=new JLabel("PlayerX's Turn");
    statusBar.setFocusable(false);
    basic.add(statusBar,BorderLayout.SOUTH);



    
    JPanel panel = new JPanel();

    panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 0));
    panel.setLayout(new GridLayout(3, 3, 3, 0));

    String[] buttons = {
        "","","","","","","","",""
    };
    
    JButton a = new JButton(buttons[0]);
    a.putClientProperty("coordinate", "0,0");
    panel.add(a);
    a.addActionListener(butlist);
    
    JButton b = new JButton(buttons[1]);
    b.putClientProperty("coordinate", "0,1");
    panel.add(b);
    b.addActionListener(butlist);
    
    JButton c = new JButton(buttons[2]);
    c.putClientProperty("coordinate", "0,2");
    panel.add(c);
    c.addActionListener(butlist);
    
    JButton d = new JButton(buttons[3]);
    d.putClientProperty("coordinate", "1,0");
    panel.add(d);
    d.addActionListener(butlist);
    
    JButton e = new JButton(buttons[4]);
    e.putClientProperty("coordinate", "1,1");
    panel.add(e);
    e.addActionListener(butlist);
    
    JButton f = new JButton(buttons[5]);
    f.putClientProperty("coordinate", "1,2");
    panel.add(f);
    f.addActionListener(butlist);
    
    JButton g = new JButton(buttons[6]);
    g.putClientProperty("coordinate", "2,0");
    panel.add(g);
    g.addActionListener(butlist);
    
    JButton h = new JButton(buttons[7]);
    h.putClientProperty("coordinate", "2,1");
    panel.add(h);
    h.addActionListener(butlist);
    
    JButton i = new JButton(buttons[8]);
    i.putClientProperty("coordinate", "2,2");
    panel.add(i);
    i.addActionListener(butlist);
    



    basic.add(panel);



    JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JButton ntip = new JButton("New");
    ntip.setMnemonic(KeyEvent.VK_N);
    xturn = new JButton("Player X");
    xturn.setMnemonic(KeyEvent.VK_N);
    JButton quit = new JButton("Quit");
    quit.setMnemonic(KeyEvent.VK_C);

    bottom.add(ntip);
    bottom.add(xturn);
    bottom.add(quit);
    basic.add(bottom);

    bottom.setMaximumSize(new Dimension(900, 0));
    
    quit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
          System.exit(0);
      }
  });
    
    ntip.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
          Board.setupBoard();
          Board.isplaying = 0;
          Board.is_x_win = 0;
          Board.is_o_win = 0;
          Board.isdraw = 0;
          revalidate();
          repaint();
      }
  });
    
    
    
    ntip.addActionListener(butlist);
    
    
  
    //basic.add(statusbar, BorderLayout.SOUTH);

    setTitle("Tic Tac Toe");
    setSize(new Dimension(450, 350));
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    
  }

   
   
   private class ButtonListener implements ActionListener {

     public void actionPerformed(ActionEvent e) {
      
       String player_input;
       //String player0_input;
       List <String> playerx_coord, playery_coord;
       JButton b=(JButton)e.getSource();
       player_input = (String) b.getClientProperty("coordinate");
       
       
       
       if ((turnTrack % 2) == 0 && Board.isplaying == 1)
       {
           playery_coord = Arrays.asList(player_input.split(","));
           if (Board.inputCheck(playery_coord)){
             Board.mark0Board(playery_coord);
             Board.gameCondition("0", Integer.parseInt(playery_coord.get(0)), Integer.parseInt(playery_coord.get(1)));
             b.setText("o");
             turnTrack++;
           }
           
       }
       else if ((turnTrack % 2) != 0 && Board.isplaying == 1) {
         playerx_coord = Arrays.asList(player_input.split(","));
         if (Board.inputCheck(playerx_coord)){
          
           Board.markXBoard(playerx_coord);
           Board.gameCondition("x", Integer.parseInt(playerx_coord.get(0)), Integer.parseInt(playerx_coord.get(1)));
           b.setText("x");
           turnTrack++;
           
         }
         
       }
       
      

       
       
       
       if ((turnTrack % 2) == 0)
       {
           xturn.setText("PlayerY");
       }
       else{
         xturn.setText("PlayerX");
       }
       
       if (Board.is_x_win == 1){
         Board.printBoard();
         xturn.setText("X WINS");
         
       }
       
       if (Board.isdraw == 1){
         Board.printBoard();
         System.out.println("DRAW");
         
       }
       
       if (Board.is_o_win == 1){
         Board.printBoard();
         xturn.setText("Y WINS");
       }
       
       


         /*JButton o = (JButton) e.getSource();
         String label = o.getText();
         statusbar.setText(" " + label + " button clicked");*/
         //System.exit(0);
     }
     
 }

   public static void main(String[] args) {

     EventQueue.invokeLater(new Runnable() {
       
    
          public void run() {
            GameGUI ex = new GameGUI();
            ((Component) ex).setVisible(true);
          }
     });
   }
}