import java.util.Stack;

public class WordSearch {

    public boolean exist(char[][] board, String word){

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[0].length; j++){

                if (check(stack, board, word, i, j, 0))
                    return true;

            }

        }

        return false;

    }

    private boolean check(
        Stack<Character> stack, 
        char[][] board, 
        String word, 
        int row, 
        int col,
        int index
    ) {

        // We found every character in the word
        if (index >= word.length())
            return true;

        // If the search is out of bounds
        if (
            row < 0 ||
            col < 0 ||
            row >= board.length ||
            col >= board[0].length
        )
            return false;

        boolean exists = false;

        if (board[row][col] == word.charAt(index)){

            // Make sure we don't check the same square twice by nuking it
            board[row][col] += 100;

            // Check the right, bottom, left, and top squares
            exists = 
                check(stack, board, word, row + 1, col, index + 1) ||
                check(stack, board, word, row, col + 1, index + 1) ||
                check(stack, board, word, row - 1, col, index + 1) ||
                check(stack, board, word, row, col- 1, index + 1);

            // Unnuke the squares that we checked
            board[row][col] -= 100;
        }

        return exists;
        
    }

}
