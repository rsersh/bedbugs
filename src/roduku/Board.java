package roduku;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rrs
 */
public class Board {
 
    private static int rows;
    private static int cols;
    private static int [][]boardmatrix;
    int[] numberArray = new int[9];
    //int magicnumber = 9;
        
    public Board(int rownum, int colnum) {
        Board.rows = rownum;
        //check values of rows and columns are either 3 or 9 ?
        Board.cols = colnum;
        initializeBoard(rows,cols);
        
    } 
    
    public static void initializeBoard(int r, int c) {
        boardmatrix = new int[r][c];
        int i = 0;
        int j = 0;
        while (i < r-1) {
            while (j < c-1) {
                boardmatrix[i][j] = 0;
                j++;
            }
            i++;
        }
    } 
    
    //returns true if successful

    /**
     *
     * @param num
     * @param row
     * @param col
     */
   public void addEntry(int num, int row, int col) {
        if ( (num < 10) && (num > 0)) {
            boardmatrix[row][col]=num;
        }
        
    }
    
    public void setBoard() {
        /*ideally it will create a board of numbers
          randomly and then make sure it hasn't already
          been used
        */
        genNumbers();
        int k=0;
        while (k<9) {
            for (int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    addEntry(numberArray[k], i, j);
                    k++;
                }
            }
            //k++;
        }
        /*
        addEntry(3, 0, 0);
        addEntry(9, 0, 1);
        addEntry(4, 0, 2);
        addEntry(1, 1, 0);
        addEntry(7, 1, 1);
        addEntry(5, 1, 2);
        addEntry(6, 2, 0);
        addEntry(2, 2, 1);
        addEntry(8, 2, 2);
        */
        viewBoard();
    }
    
    /*
      called by genNumbers();
    */
    public void initializeArray() {
        int len = numberArray.length;
        for (int j=0; j<len; j++) {
            numberArray[j] = 0;
            //System.out.println(numberArray[j]);
        }
        
    }
        
    /*returns 1 if num is in array
      called by genNumbers();
    */
    public int checkArray(int num) {
        if (num == 0) {
            return 0;
        }
        int len = numberArray.length;
        for (int i = 0; i < len; i++) {
            if (numberArray[i] == num) {
                return 1;
            }
        }
        return 0;
    }
    
    /*
       called by setBoard();
    */
    public void genNumbers() {
        /*ideally it will create a board of numbers
          randomly and then make sure it hasn't already
          been used
        */
        
        //needs to be seeded for a random set of randoms
        Random numberGen = new Random();
        
        initializeArray();
        
        for (int i = 0; i < 9; i++) {
            int number = numberGen.nextInt(9) + 1;
            while (checkArray(number) == 1) {
                number = numberGen.nextInt(9) + 1;
                //numberArray[i] = number;
            }
                numberArray[i] = number;
            }
            //System.out.println(number);
        
        //for testing
        for (int k=0; k<9; k++) {
            System.out.println(numberArray[k]);
        }

    }
   
    /*
    need function that would define small medium and hard
    levels that will create holes or "disappear" some numbers
    on the board based on the level. should end with viewBoard
    ? leaves ready for user to enter a number
    */
    
    public static void viewBoard(){
        int i = 0;
        
        while (i < rows) {
            int j = 0;
            while (j < cols) {
                
                System.out.printf("  %d", boardmatrix[i][j]);
                
                if ((j==2) || (j==5) || (j==8)) {
                    System.out.println();
                    System.out.println("-----------");
                }
                j++;
            }
            i++;
            
        }      
    }

    

    public static void main(String[] args) {
        Board newBoard = new Board(3,3);
        //int testnum = boardmatrix[1][1];
       // System.out.println(testnum);
        //Board.viewBoard();
       // newBoard.setBoard(); 
       // newBoard.genNumbers();
        newBoard.setBoard();
        
    }
  
}