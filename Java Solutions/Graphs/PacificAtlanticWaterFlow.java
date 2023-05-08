import java.util.ArrayList;
import java.util.List;

/**
 * Suppose the entire map gets coverd in water
 * 
 * Which ones flow into both oceans?
 * water flows to a neighbor if the neighbor is less than or equal height
 * Return the list of square
 * 
 * 
 * pacific covers both top corners and left
 * altantic covers both bottom corners and right
 */

public class PacificAtlanticWaterFlow {
    
    /**
     * Brute force approach:
     * Check EVERY single square and use DFS or BFS 
     * to try and find a path to both oceans
     * 
     * Whats the time complexity?
     * For each sqaure, we might traverse the entire grid again
     * So its O(n*m)^2
     * 
     * Is there any repeated work?
     * Yes
     * 
     * Is there a shortcut we can take?
     * Hint: every square in the top row of the grid can flow into the pacific ocean
     * what other rows and columns are guaranteed to flow into an ocean?
     * 
     * Start from the outer rows and columns of the grid
     * Our question is:
     * "Can we reach the ocean from this cell?"
     * The answer is always yes
     * 
     * When we run DFS, our question is:
     * Can we reach the previous cell from the current one?
     * ie. is curr >= prev?
     * 
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> coordinates;
        
        int rows = heights.length;
        int cols = heights[0].length;

        /**
         * How can we keep track of which squares can flow into the oceans?
         * We can use a boolean matrix!
         */
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Add the top and bottom rows to the pacific and atlantic, respectively
        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, 0, pacific);
            dfs(heights, rows - 1, i, 0, atlantic);
        }

        // Add the left and right columns to the pacific and atlantic, respectively
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, 0, pacific);
            dfs(heights, i, cols - 1, 0, atlantic);
        }

        // We don't check the inside areas? 
        // No, we will move there from the ouside ones

        // At the end of our dfs
        for (int i = 0; i < rows; i++) 

            for (int j = 0; j < cols; j++) 

                // If the square can reach both oceans, add it to our result
                if (pacific[i][j] && atlantic[i][j]){
                    coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    result.add(coordinates);
                    //one liner
                    //result.add(List.of(i,j)); 
                }
            
        return result;

    }

    /**
     * 
     * @param heights
     * @param row
     * @param col
     * @param prev We need to keep track of the square we last visited
     * @param ocean We need to update our ocean matrices
     */
    private void dfs(int[][] heights, int row, int col, int prev, boolean[][] ocean){

        // Out of bounds check
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length)
            return;

        // If the height of curr is less than the height of prev,
        // then water cannot flow from curr to prev
        if (heights[row][col] < prev)
            return;

        // If this square has already been visited AND we already determined that 
        // it can flow into the ocean, we don't need to keep searching
        if (ocean[row][col] == true){
            return;
        }

        // Mark as visited, this will guarantee that our dfs will return
        ocean[row][col] = true;

        // Use dfs to search all the adjacent cells
        dfs(heights, row - 1, col, heights[row][col], ocean);
        dfs(heights, row, col + 1, heights[row][col], ocean);
        dfs(heights, row + 1, col, heights[row][col], ocean);
        dfs(heights, row, col - 1, heights[row][col], ocean);

    }
  
}

