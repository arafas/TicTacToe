package com.utm.csc;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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
  
    public static void console(){
      
      
      System.out.println( "Welcome to Assignment3" );
      System.out.println( "Enter ’<row>,<col>’ to play a position. For example, ’0,2’." );
      
      Board.setupBoard();
      
      while (Board.isplaying == 1){
        try{
      
          String playerx_input;
        
          String player0_input;
          List <String> playerx_coord, playery_coord;
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
          System.out.println( "Player X [row,col]:" );
          playerx_input = br.readLine();
          playerx_coord = Arrays.asList(playerx_input.split(","));
        
          if (Board.onBoard(playerx_coord) == false){
            System.out.println("(" + playerx_input + ") is not on the board. Enter ’<row>,<col>’ to play a position. For example, ’0,2’.");
            System.out.println( "Player X [row,col]:" );
            playerx_input = br.readLine();
            playerx_coord = Arrays.asList(playerx_input.split(","));
          }
          
          if (Board.inputCheck(playerx_coord) == false){
            System.out.println("Invalid input. Quitting Game.");
            System.exit(0);
            
          }
        
          System.out.println( "Coordinate x is " + playerx_coord.get(0) + ". Coordinate y is "  +playerx_coord.get(1) );
          Board.markXBoard(playerx_coord);
          Board.gameCondition("x", Integer.parseInt(playerx_coord.get(0)), Integer.parseInt(playerx_coord.get(1)));
          
          if (Board.is_x_win == 1){
            Board.printBoard();
            System.out.println("GAME OVER WE HAVE A WINNER: PLAYER X");
            break;
          }
          
          if (Board.isdraw == 1){
            Board.printBoard();
            System.out.println("GAME OVER DRAW!!");
            break;
            
          }
          
          
          System.out.println( "Player 0 [row,col]:" );
          player0_input = br.readLine();
          playery_coord = Arrays.asList(player0_input.split(","));
          
          if (Board.onBoard(playery_coord) == false){
            System.out.println("(" + player0_input + ") is not on the board. Enter ’<row>,<col>’ to play a position. For example, ’0,2’.");
            System.out.println( "Player Y [row,col]:" );
            player0_input = br.readLine();
            playery_coord = Arrays.asList(player0_input.split(","));
          }
          
          
          if (Board.inputCheck(playery_coord) == false){
            System.out.println("Invalid input: Quitting Game");
            System.exit(0);
          }
        
          System.out.println( "Coordinate x is " + playery_coord.get(0) + ". Coordinate y is "  +playery_coord.get(1) );
          Board.mark0Board(playery_coord);
          Board.gameCondition("0", Integer.parseInt(playery_coord.get(0)), Integer.parseInt(playery_coord.get(1)));
          
          if (Board.is_o_win == 1){
            Board.printBoard();
            System.out.println("GAME OVER WE HAVE A WINNER: PLAYER 0");
            break;
          }
          
          if (Board.isdraw == 1){
            Board.printBoard();
            System.out.println("GAME OVER DRAW!!");
            break;
          }
        
        
          Board.printBoard();
          //System.out.println("is x win: " + Board.is_x_win);
         // System.out.println("is y win: " + Board.is_o_win);
          //System.out.println("Is draw: "+ Board.isdraw);
          

      
        }
        
        
    catch(IOException io){
        io.printStackTrace();
    }     
   }
      
 } 
  


    public static void main( String[] args ) throws IOException
    {
        
        System.out.println( "Welcome to Assignment4: Tic Tac Toe!" );
        System.out.println( "Enter c for console or g for gui" );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = br.readLine();
        
        if (response.equals("g")){
        
          EventQueue.invokeLater(new Runnable() {
          
          
            public void run() {
              GameGUI ex = new GameGUI();
              ((Component) ex).setVisible(true);
            }
         });
        }
        
        if (response.equals("c")){
          console();
          
        }
        
        else{
          System.out.println( "Invalid argument" );
          System.exit(0);
        }
   }

        
        

}

