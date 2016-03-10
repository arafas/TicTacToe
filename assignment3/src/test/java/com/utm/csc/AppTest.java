package com.utm.csc;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

//import org.junit.Before;


import junit.framework.TestCase;

import java.util.Arrays;
//import junit.framework.TestSuite;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
  
  
    @Before
    public void setUp(){
          Board.setupBoard();
     
      
    }
    
    
    
    /**
     * 
     *
     * @param Ensure board has been setup and is initially blank
     */
    @Test
    public void testsSetupBoard( )
    {
          //Board.setupBoard();
          int check = 0;
          for (int row=0; row < 3; row++) {
            for (int col=0; col < 3; col++) {  
              if (Board.board[row][col].equals(" ")){
                check++;
              }
          }
        }
          
          
          System.out.println("----------------------------------------------------");
          System.out.println("Testing empty board setup:");
          
          int checkExpected = 9;
          System.out.println("Empty cells expected = " + checkExpected + " and actual empty cells = " + check);
          assertTrue(checkExpected == check);
      
    }
    
    
    @Test
    public void testsRightOnBoardCoordinates(){
      
      List<String> rightcoordinates = Arrays.asList("1","2");
      
      System.out.println("----------------------------------------------------");
      System.out.println("Cell at Column 1 Row 2 Should be Valid");
      assertTrue(Board.onBoard(rightcoordinates));
      
      
      
    }
    
    @Test
    public void testsWrongOnBoardCoordinates(){
      
      
      List<String> wrongcoordinates = Arrays.asList("3","2");
      
      
      System.out.println("----------------------------------------------------");
      System.out.println("Cell at Column 3 Row 2 Should be Invalid");
      assertFalse(Board.onBoard(wrongcoordinates));
      
    }

    @Test
    public void testsCrossMark(){
      
      
      List<String> coordinates = Arrays.asList("1","2");
      Board.markXBoard(coordinates);
      
      String board_compare[][];
      board_compare = new String[3][3];
      
      for (int row=0; row < 3; row++) {
        for (int col=0; col < 3; col++) {  
            if (col == 2 && row == 1){
              board_compare[row][col] = "x";
            }
            else{
              board_compare[row][col] = " ";
            }
        }
      }
      System.out.println("----------------------------------------------------");
      System.out.println("Checking x mark at Column 1 and Row 2");
      System.out.println("Expected board array: " + Arrays.deepToString(board_compare));
      System.out.println("Actual board array: " + Arrays.deepToString(Board.board));
      assertTrue(java.util.Arrays.deepEquals(board_compare, Board.board));
     
      
    }
    
    @Test
    public void testsCircleMark(){
      
      
      List<String> coordinates = Arrays.asList("1","2");
      Board.mark0Board(coordinates);
      
      String board_compare[][];
      board_compare = new String[3][3];
      
      for (int row=0; row < 3; row++) {
        for (int col=0; col < 3; col++) {  
            if (col == 2 && row == 1){
              board_compare[row][col] = "0";
            }
            else{
              board_compare[row][col] = " ";
            }
        }
      }
      
      System.out.println("----------------------------------------------------");
      System.out.println("Checking 0 mark at Column 1 and Row 2");
      System.out.println("Expected board array: " + Arrays.deepToString(board_compare));
      System.out.println("Actual board array: " + Arrays.deepToString(Board.board));
      assertTrue(java.util.Arrays.deepEquals(board_compare, Board.board));
     
      
    }
    
    @Test
    public void testsValidInputCheck(){
      List<String> coordinates = Arrays.asList("1","2");
      System.out.println("----------------------------------------------------");
      assertTrue(Board.inputCheck(coordinates));
      System.out.println("Marking x at row 1 column 2: " + Board.inputCheck(coordinates));
     
      Board.markXBoard(coordinates);
     
      
      assertFalse(Board.inputCheck(coordinates));
      System.out.println("Attempting to mark x at row 1 column 2 again: " + Board.inputCheck(coordinates) );
      
    }
    
    
    @Test
    public void testsWinAcrossGameCondition(){
      
      List<String> coordinates1 = Arrays.asList("0","0");
      List<String> coordinates2 = Arrays.asList("0","1");
      List<String> coordinates3 = Arrays.asList("0","2");
      int lastRow = 0;
      int lastColumn = 1;
      
      Board.mark0Board(coordinates1);
      Board.mark0Board(coordinates2);
      Board.mark0Board(coordinates3);
      
      System.out.println("----------------------------------------------------");
      Board.printBoard();
      System.out.println("Checking if 0 is the winner across");
      Board.gameCondition("0", lastRow, lastColumn);
      assertTrue(Board.is_o_win == 1);
    }
    
    @Test
    public void testsWinDownGameCondition(){
      
      List<String> coordinates1 = Arrays.asList("0","0");
      List<String> coordinates2 = Arrays.asList("1","0");
      List<String> coordinates3 = Arrays.asList("2","0");
      int lastRow = 2;
      int lastColumn = 0;
      
      Board.markXBoard(coordinates1);
      Board.markXBoard(coordinates2);
      Board.markXBoard(coordinates3);
      
      System.out.println("----------------------------------------------------");
      Board.printBoard();
      System.out.println("Checking if x is the winner down");
      Board.gameCondition("x", lastRow, lastColumn);
      assertTrue(Board.is_x_win == 1);
      
    }
    
    @Test
    public void testsDiagonalLRDownCondition(){
      
      List<String> coordinates1 = Arrays.asList("0","0");
      List<String> coordinates2 = Arrays.asList("1","1");
      List<String> coordinates3 = Arrays.asList("2","2");
      int lastRow = 2;
      int lastColumn = 2;
      
      Board.mark0Board(coordinates1);
      Board.mark0Board(coordinates2);
      Board.mark0Board(coordinates3);
      
      System.out.println("----------------------------------------------------");
      Board.printBoard();
      System.out.println("Checking if 0 is the winner diagonally");
      Board.gameCondition("0", lastRow, lastColumn);
      assertTrue(Board.is_o_win == 1);
    }
    
    public void testsDiagonalRLDownCondition(){
      
      List<String> coordinates1 = Arrays.asList("0","2");
      List<String> coordinates2 = Arrays.asList("1","1");
      List<String> coordinates3 = Arrays.asList("2","0");
      int lastRow = 2;
      int lastColumn = 0;
      
      Board.markXBoard(coordinates1);
      Board.markXBoard(coordinates2);
      Board.markXBoard(coordinates3);
      
      System.out.println("----------------------------------------------------");
      Board.printBoard();
      System.out.println("Checking if x is the winner diagonally");
      Board.gameCondition("x", lastRow, lastColumn);
      assertTrue(Board.is_x_win == 1);
    }
    
    public void testsDrawCondition(){
      
      List<String> coordinates1 = Arrays.asList("0","0");
      List<String> coordinates2 = Arrays.asList("0","1");
      List<String> coordinates3 = Arrays.asList("0","2");
      List<String> coordinates4 = Arrays.asList("1","0");
      List<String> coordinates5 = Arrays.asList("1","1");
      List<String> coordinates6 = Arrays.asList("1","2");
      List<String> coordinates7 = Arrays.asList("2","0");
      List<String> coordinates8 = Arrays.asList("2","1");
      List<String> coordinates9 = Arrays.asList("2","2");
      
      
      
      int lastRow = 2;
      int lastColumn = 1;
      
      Board.markXBoard(coordinates1);
      Board.mark0Board(coordinates2);
      Board.markXBoard(coordinates3);
      Board.mark0Board(coordinates4);
      Board.markXBoard(coordinates5);
      Board.mark0Board(coordinates6);
      Board.markXBoard(coordinates7);
      Board.mark0Board(coordinates9);
      Board.markXBoard(coordinates8);
      
      System.out.println("----------------------------------------------------");
      Board.printBoard();
      System.out.println("Checking if draw");
      Board.gameCondition("x", lastRow, lastColumn);
      assertTrue(Board.isdraw == 1);
    }
    
    
    
    
    /**
     * @return the suite of tests being tested
     */
    /*public Test suite()
    {
        return new TestSuite( AppTest.class );
    }*/

    /**
     * Rigourous Test :-)
     */
    /*public void testApp()
    {
        assertTrue( true );
    }*/
}
