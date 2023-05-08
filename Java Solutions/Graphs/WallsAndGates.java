import java.util.LinkedList;
import java.util.Queue;

/**
 * -1 is a wall
 * 0 is a gate
 * 
 * infinity is empty
 * from each empty room, how far is it to the NEAREST gate
 * if you cant reach a gate, leave it as empty
 * 
 * start, 3 empty rooms, gate = 3
 * 
 * update the rooms with the length of the shortest path to a gate
 */

public class WallsAndGates {

    /**
     * 
     * Since we want to find the shortest path, its a hint that we should use BFS
     * We could use DFS, but BFS is faster
     * 
     * One approach is to start at every empty room, and explore until we reach a gate
     * O((n*m)^2)
     * Is there any repeated work with this approach?
     * 
     * Another approach is to start at every gate, 
     * and explore until we hit a wall or another gate
     * 
     * Similar BFS problem is rotting oranges
     * Similar approach is Pacific Altantic Water Flow
     * 
     */
    public void wallsAndGates(int[][] rooms){

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // This matrix will help us explore the neighbors of a cell
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; 

        // Initialize our queue with all the gates in the map
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++)
                if (rooms[i][j] == 0)
                    queue.offer(new int[]{i,j});
        
        /*
         * BFS will search the gates simultaneously
         */
        while (!queue.isEmpty()){

            int[] room = queue.poll();

            int row = room[0];
            int col = room[1];

            for (int[] dir : dirs){
                
                // Explore each neighbour
                int x = row + dir[0];
                int y = col + dir[1];

                // Out of bounds check
                if (x < 0 || y < 0 || x >= rows || y >= cols)
                    continue;

                int neighbor = rooms[x][y];

                // If the neighbor is NOT an empty room, we can't go further
                if (neighbor != Integer.MAX_VALUE)
                    continue;

                /**
                 * If its an empty room, we need to:
                 * 1. Explore it (by adding it to our queue)
                 * 2. Update the path of the room
                 */
                else{
                    queue.add(new int[]{x,y});
                    rooms[x][y] = rooms[row][col] + 1;
                }
                
                /**
                 * If we start at a gate, and explore room A,
                 * How far is it from A to the gate? Obviously, the answer is 1
                 * When we start at room A, and explore room B,
                 * How far is it from B to A? Still 1, 
                 * and the path from B to gate is 1 + A
                 */

            }
        }
    }
}
