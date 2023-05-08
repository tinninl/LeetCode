import java.util.HashSet;
import java.util.Set;

// Note: " ' " represents blank spots in the sudoku board.

// Have fun doing the calculations for the blocksets!

public class ValidSudoku {
    
    /**
     * For each row, column, and block, 
     * we will make a set to track the numbers 1 throught 9.
     * If we find a single duplicate in a set, then we know its NOT a valid sudoku board
     * 
     * We will traverse the entire board, 
     * checking for duplicates and adding elements to the sets
     */
    public boolean isValidSudoku(char[][] board){

        Set<Character> rowSet;
        Set<Character> colSet;
        Set<Character> blockSet;

        for (int row = 0; row < 9; row++){

            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            blockSet = new HashSet<>();

            for (int col = 0; col < 9; col++){

                if (board[row][col] == ',')
                    continue;
                
                // If there is a duplicate element, the sudoku is NOT valid
                if (rowSet.contains(board[row][col]))
                    return false;
                
                if (colSet.contains(board[col][row]))
                    return false;
                                
                if (blockSet.contains(board[row/3*3+col/3][row%3*3+col%3]))
                    return false;
                
                rowSet.add(board[row][col]);
                colSet.add(board[col][row]);           
                blockSet.add(board[((row/3)*3) + (col/3)][(col%3) + ((row%3)*3)]);

            }

        }
        
        return true;
   
    }

}
