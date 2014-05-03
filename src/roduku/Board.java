package roduku;

import java.util.Random;

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
    
    
    public Board(int rownum, int column) {
        Board.rows = rownum;
        //check values of rows and columns are either 3 or 9 ?
        Board.cols = column;
        initializeBoard(rows,cols);   
    } 
    
    
    /* Creates an empty board of zeros.
     * @param r - number of rows on board
     * @param c - number of cols on board
     */
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

    /**
     * Adds the user's entry to the board.
     * @param num - user number 
     * @param row - row on board in which to input num
     * @param col - column on board in which to input num
     */
   public void addEntry(int num, int row, int col) {
        if ( (num < 10) && (num > 0)) {
            boardmatrix[row][col]=num;
        }
        
    }
    
   /*  Fills a board with non-repeating numbers 
    *  between 1 and 9.
    */
    public void setBoard() {
        genNumbers();
        int k=0;
        while (k<9) {
            for (int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    addEntry(numberArray[k], i, j);
                    k++;
                }
            }
            
        }      
        viewBoard();
    }
    
    /*  Called by genNumbers() to initialize the
     *  numberArray with non-repeating numbers
     *  1-9.
     */
    public void initializeArray() {
        int len = numberArray.length;
        for (int j=0; j<len; j++) {
            numberArray[j] = 0;
            //System.out.println(numberArray[j]);
        }
        
    }
        
    /*  Called by genNumbers(). 
     *  Return: 1 if num is in numberArray
     *          0 if num is not in numberArray
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
    
    /*  Called by setBoard() for generating numbers
     *  for the board.
     */
    public void genNumbers() {
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
           
        
        /* for testing
        for (int k=0; k<9; k++) {
            System.out.println(numberArray[k]);
        }
        */
    }
    
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


 /*
  *  need function that would define small medium and hard
  *  levels that will create holes or "disappear" some numbers
  *  on the board based on the level. should end with viewBoard
  *  ? leaves ready for user to enter a number
  */    

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