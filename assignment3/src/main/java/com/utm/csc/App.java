package com.utm.csc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;




/**
 * Hello world!
 *
 */
public class App {
  
  public static String board[][];
  public static int isplaying;
  public static int is_x_win;
  public static int is_o_win;
  public static int isdraw;
  
  
    public static void main( String[] args )
    {
      
  
        System.out.println( "Welcome to Assignment3" );
        System.out.println( "Enter ’<row>,<col>’ to play a position. For example, ’0,2’." );
        
        setupBoard();
        isplaying = 1;
        
        while (isplaying == 1){
          try{
        
            String playerx_input;
          
            String player0_input;
            List <String> playerx_coord, playery_coord;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
            System.out.println( "Player X [row,col]:" );
            playerx_input = br.readLine();
            playerx_coord = Arrays.asList(playerx_input.split(","));
          
            if (inputCheck(playerx_coord) == false){
              System.out.println("Invalid input");
              System.exit(0);
            }
          
            System.out.println( "Coordinate x is " + playerx_coord.get(0) + ". Coordinate y is "  +playerx_coord.get(1) );
            markXBoard(playerx_coord);
            gameCondition("x", Integer.parseInt(playerx_coord.get(0)), Integer.parseInt(playerx_coord.get(1)));
            
            if (is_x_win == 1){
              System.out.println("GAME OVER WE HAVE A WINNER: PLAYER X");
              break;
            }
            
            if (isdraw == 1){
              System.out.println("GAME OVER DRAW!!");
              break;
              
            }
            
            
            System.out.println( "Player 0 [row,col]:" );
            player0_input = br.readLine();
            playery_coord = Arrays.asList(player0_input.split(","));
            if (inputCheck(playery_coord) == false){
              System.out.println("Invalid input");
              System.exit(0);
            }
          
            System.out.println( "Coordinate x is " + playery_coord.get(0) + ". Coordinate y is "  +playery_coord.get(1) );
            mark0Board(playery_coord);
            gameCondition("0", Integer.parseInt(playery_coord.get(0)), Integer.parseInt(playery_coord.get(1)));
            
            if (is_o_win == 1){
              System.out.println("GAME OVER WE HAVE A WINNER: PLAYER 0");
              break;
            }
            
            if (isdraw == 1){
              System.out.println("GAME OVER DRAW!!");
              break;
            }
          
          
            printBoard();
            System.out.println("is x win: " + is_x_win);
            System.out.println("is y win: " + is_o_win);
            System.out.println("Is draw: "+ isdraw);
            
  
          
      }catch(IOException io){
          io.printStackTrace();
      }     
     }
        
    }
    
    
    public static void markXBoard(List <String> coordinates){
      
      for (int row=0; row < 3; row++) {
        for (int col=0; col < 3; col++) {
          if ((String.valueOf(row).equals(coordinates.get(0))) && (String.valueOf(col).equals(coordinates.get(1)))){
            board[row][col]="x";
          }
         
        }
      }
      
      
      
    }
    
    
    public static void mark0Board(List <String> coordinates){
      
      for (int row=0; row < 3; row++) {
        for (int col=0; col < 3; col++) {
          if ((String.valueOf(row).equals(coordinates.get(0))) && (String.valueOf(col).equals(coordinates.get(1)))){
            board[row][col]="0";
          }
         
        }
      }
      
    }
    
    public static void setupBoard(){
      
      board = new String[3][3];
      for (int row=0; row < 3; row++) {
        for (int col=0; col < 3; col++) {  
            board[row][col]=" ";   
        }
      }
      
    }
    
    public static boolean inputCheck(List <String> coordinates){
      int conditions = 0;
      /*if ((coordinates.get(0).equals("1") || coordinates.get(0).equals("0")) && (coordinates.get(1).equals("1")||coordinates.get(1).equals("0"))){
        conditions++;
      }*/
      
      for (String point : coordinates) {
        int check = Integer.parseInt(point);
        if (check == 0 || check == 1 || check ==2 ){
          conditions++;
        }
    }
      
      for (int row=0; row < 3; row++) {
        for (int col=0; col < 3; col++) {
          if (String.valueOf(col).equals(coordinates.get(1)) && String.valueOf(row).equals(coordinates.get(0))){
            if (board[row][col].equals(" ")){
                conditions++;  
            }
          }
         
        }
      }
      //System.out.println(String.valueOf(conditions));
      if (conditions == 3){
        return true;
      }
      return false;
      
    }
    
    
    public static void printBoard(){
      
      for (int row=0; row < 3; row++) {
        
        for (int col=0; col < 3; col++) {
          System.out.print(board[row][col]);
          System.out.print("|");
         
          }
        System.out.println("");
        System.out.println("______");
        System.out.println("");
         
        }
      }
    
    public static void gameCondition(String mark, int row, int col ){
      
      if (board[row][0].equals(mark)         // 3-in-the-row
          && board[row][1].equals(mark)
          && board[row][2].equals(mark)
     || board[0][col].equals(mark)     // 3-in-the-column
          && board[1][col].equals(mark)
          && board[2][col].equals(mark)
     || row == col            // 3-in-the-diagonal
          && board[0][0].equals(mark)
          && board[1][1].equals(mark)
          && board[2][2].equals(mark)
     || row + col == 2  // 3-in-the-opposite-diagonal
          && board[0][2].equals(mark)
          && board[1][1].equals(mark)
          && board[2][0].equals(mark)){
        if (mark.equals("x")){
          is_x_win = 1;
          isplaying = 0;
        }
        if (mark.equals("0")){
          is_o_win = 1;
          isplaying = 0;
        }
      }else{
        int notComplete = 0;
        for (row = 0; row < 3; row++) {
          for (col = 0; col < 3; col++) {
             if (board[row][col].equals(" ")) {
                notComplete = 1;  //game not complete. still empty cell
             }
          }
       }
        
        if (notComplete == 0){
          isdraw = 1;
          isplaying = 0;
        }
        
      }
      
    }
      
    
}
