/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roduku;

/**
 *
 * @author rrs
 */
public class SmallBoard extends Board {

    private static int rows;
    private static int cols;
    private static int [][]boardmatrix;

    public SmallBoard(int rownum, int colnum) {
        super(rownum, colnum);
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
    

    public static void main(String[] args) {
        SmallBoard newBoard = new SmallBoard(3,3);
        int testnum = boardmatrix[1][1];
        System.out.println(testnum);
        viewBoard();
    }
  
    
    
}
