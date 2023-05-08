import java.util.LinkedList;
import java.util.Queue;

/**
 * 994 bfs graph
 * 2 = rotten
 * 1 = fresh
 * 0 = empty cell
 * 
 * Return minimum time for all oranges to turn rotten
 * or -1 if impossible
 */

public class RottingOranges {

    /**
     * Starting from a rotten orange, we want to exlore the nearest cells first
     * This indicates that we should use BFS to explore the ROTTEN oranges
     * 
     * 
     * For BFS, we will set up a queue of rotten oranges
     * We also want to keep track ot the number of fresh oranges
     * 
     * 
     */
    public int orangesRotting(int[][] grid){

        if (grid == null || grid.length == 0) 
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0; // number of fresh oranges

        Queue<int[]> rottenOranges = new LinkedList<>();

        // Initialize our queue with all the rotten oranges
        // And count the number of fresh oranges
        for (int i = 0; i < rows; i++)

            for (int j = 0; j < cols; j++)

                if (grid[i][j] == 2)
                    rottenOranges.offer(new int[]{i, j});             

                else if (grid[i][j] == 1)
                    fresh++;
        
        // Base case: The initial grid has no fresh oranges
        if (fresh == 0)
            return 0;
        
        // We can use this array to help us explore the neighbor cells
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int time = 0;

        // Explore the rotten oranges in the queue
        while (!rottenOranges.isEmpty()){

            int[] square;

            // NOTE: Since we will be adding and removing elements as we
            // explore the queue, we should save the queue size in a variable first
            int size = rottenOranges.size(); 

            // Process each rotten orange
            for (int i = 0; i < size; i++){

                square = rottenOranges.poll();

                // Explore its neighbors
                for (int dir[] : dirs){

                    // Get the neighbor's coordinates
                    int x = square[0] + dir[0];
                    int y = square[1] + dir[1];

                    // Out of bounds check
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
                        continue;              

                    // If the square is empty or already rotten, do nothing
                    if (grid[x][y] == 0 || grid[x][y] == 2)
                        continue;

                    /**
                     * Otherwise, its a fresh orange and we need to:
                     * 1. Update it to a rotten orange
                     * 2. Put the newly rotten orange in our queue
                     * 3. Update the number of fresh oranges
                     */
                    else {
                        grid[x][y] = 2; 
                        rottenOranges.offer(new int[]{x, y});                     
                        fresh--;
                    }

                }

            }

            // Because this question keeps track of time, we need an extra forloop
            // to make it look like we are processing the entire queue all at once.
            // In which for loop should we update the time?
            time++; 

        }

        if (fresh == 0)
            return time;
        else    
            return -1;

    }

}
