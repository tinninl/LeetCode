/**
 * from top left to bottom right
 * only move right and down
 */
public class UniquePaths {

    public int uniquePaths(int rows, int cols){

        int[][] paths = new int[rows][cols];

        for (int i = 0; i < cols; i++){
            paths[0][i] = 1;
        }
        for (int i = 0; i < rows; i++){
            paths[i][0] = 1;
        }

        for (int i = 1; i < rows; i++){

            for (int j = 1; j < cols; j++){

                int above = paths[i - 1][j];
                int left = paths[i][j - 1];
                paths[i][j] = above + left;

            }
            
        }

        return paths[rows - 1][cols - 1];
    }
}
