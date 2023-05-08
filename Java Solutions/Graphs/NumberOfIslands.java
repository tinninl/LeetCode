/**
 * 200 Easy Graph
 * DFS
 * 
 * 1 = land, 0 = water
 */

public class NumberOfIslands {

    /*
     * To find every island on the map,
     * we should check every square to see if its land or water
     * 
     * If its land, then we need to find all the land squares connected to it
     * to determine out how big the island is
     * We can do this using DFS or BFS
     * 
     * We also need to keep track of the areas we already visited
     * to prevent looping through the same squares
     */
    
    public int numIslands(char[][] grid){

        int rows = grid.length;
        int cols = grid[0].length;

        int numIslands = 0;

        // Check the entire map
        for (int i = 0; i < rows; i++)

            for (int j = 0; j < cols; j++)

                // If its land, find all connecting land areas using DFS
                if (grid[i][j] == '1'){
                    numIslands++; // dont forget to increment the number of islands
                    dfs(i, j , grid);
                }

        return numIslands;
        
    }

    private void dfs(int row, int col, char[][] grid){

        // Out of bounds check
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        // If its land, keep searching
        else if (grid[row][col] == '1'){

            // Mark the area as visited
            // We can just change the value to anything
            grid[row][col] = 'v'; 

            // Check the four neighboring squares
            dfs(row + 1, col, grid); 
            dfs(row, col + 1, grid); 
            dfs(row - 1, col, grid);
            dfs(row, col - 1, grid); 

        }  

        // Once we reach an area thats not land OR its land we already checked, 
        // we're done
        else
            return;

    }

}
