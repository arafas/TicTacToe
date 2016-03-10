package com.utm.csc;

import java.util.List;

public class Board {
  
  
public static String board[][];

public static int isplaying;
public static int is_x_win;
public static int is_o_win;
public static int isdraw;

  public static void setupBoard(){
    
    isplaying = 1;
    board = new String[3][3];
    for (int row=0; row < 3; row++) {
      for (int col=0; col < 3; col++) {  
          board[row][col]=" ";   
      }
    }
    
  }
  
  public static boolean onBoard(List <String> coordinates){
    /*Return true only if coordinates entered are valid coordinates on the board*/
    
    int conditions = 0;
    for (String point : coordinates) {
      int check = Integer.parseInt(point);
      if (check == 0 || check == 1 || check ==2 ){
        conditions++;
      }
  }
    
    if (conditions == 2){
      return true;
    }
    return false;
    
    
  }
  
  public static boolean inputCheck(List <String> coordinates){
    /*Return true if coordinates entered are valid coordinates on the board and the cell at
     * those coordinates is empty*/
     
    
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
      System.out.println("_+_+_");
      System.out.println("");
       
      }
    }
  
  public static void gameCondition(String mark, int row, int col ){
    /*updates condition of the game to reflect the state the board's cells are in*/
    
    if (board[row][0].equals(mark)         // across a row
        && board[row][1].equals(mark)
        && board[row][2].equals(mark)
   || board[0][col].equals(mark)     // across a column
        && board[1][col].equals(mark)
        && board[2][col].equals(mark)
   || row == col            // diagonal from left down to right
        && board[0][0].equals(mark)
        && board[1][1].equals(mark)
        && board[2][2].equals(mark)
   || row + col == 2  // diagonal from right down to left
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
  

}
