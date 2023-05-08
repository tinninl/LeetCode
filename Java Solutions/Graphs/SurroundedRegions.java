/**
 * 130 medium graph
 * capture all Os surrounded by Xs
 */
public class SurroundedRegions {


    /**
     * Hints:
     * Any O on the borders should be flipped over
     * Any Os connected to border Os should also be flipped over
     * 
     * Similar to the Pacific Atlantic Water Flow problem, 
     * we should start exploring the border cells first and traverse inwards
     * 
     * Follow up: Can we do this without the extra boolean matrix?
     * Hint: How else can we mark cells as visited?
     */
    public void solve(char[][] board){

        int rows = board.length;
        int cols = board[0].length;

        // A boolean matrix represents squares that MUST BE Os
        // False = We can flip this square into an 'X'
        boolean[][] map = new boolean[rows][cols];

        // Explore the top and bottom rows
        for (int i = 0; i < cols; i++){
            dfs(0, i, board, map);
            dfs(rows - 1, i, board, map);
        }

        // Explore the leftmost and rightmost columns
        for (int i = 0; i < rows; i++){
            dfs(i, 0, board, map);
            dfs(i, cols - 1, board, map);
        }

        // Solve the board using our map
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (!map[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] map){

        // Out of bounds check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }

        // We do not need to run dfs if its not a O
        if (board[i][j] != 'O')
            return;

        // If we already visited this O, stop
        if (map[i][j])
            return;

        map[i][j] = true;

        dfs(i - 1, j, board, map);
        dfs(i + 1, j, board, map);
        dfs(i, j - 1, board, map);
        dfs(i, j + 1, board, map);

        return;
    }
}
