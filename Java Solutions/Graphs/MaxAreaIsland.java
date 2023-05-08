/**
 * 695 Medium Graph
 * Similar to Number of Islands problem
 * 1 = land, 0 = water
 * 
 * NOTE: 
 * Number of Islands problem uses a char[] array
 * This problem uses an int[] array
 */

public class MaxAreaIsland {

    /**
     * Similar to the Number of Islands problem, 
     * we check every square of the map to find all the islands
     * 
     */
    public int maxAreaOfIsland(int[][] grid){

        int rows = grid.length;
        int cols = grid[0].length;

        int area = 0;       // The area of an island
        int maxArea = 0;    // The area of the biggest island

        // Check every square in the map
        for (int i = 0; i < rows; i++){

            for (int j = 0; j < cols; j++){
                
                /**
                 * If we found land, 
                 * we can use dfs to find all the neighboring land squares
                 * and return the size of the island
                 */
                if (grid[i][j] == 1){
            
                    area =  dfs(i, j, grid);

                    if (area > maxArea)
                        maxArea = area;

                }
            }
        }
                    
        return maxArea;

    }

    private int dfs(int row, int col, int[][] grid){


        // Out of bounds check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) 
            return 0;

        // If we are on water
        if (grid[row][col] == 0)
            return 0;    

        // Mark the land square as visited by changing its value
        grid[row][col] = 0;

        // Use DFS to check the neighboring cells and calculate the area 
        int area = 1 
                + dfs(row + 1, col, grid)
                + dfs(row - 1, col, grid)
                + dfs(row, col + 1, grid)
                + dfs(row, col - 1, grid);

        return area;              

    }


}
