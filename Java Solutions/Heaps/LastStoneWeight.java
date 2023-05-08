import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] 
 * is the weight of the ith stone.
 * 
 * We are playing a game with the stones. 
 * On each turn, we choose the heaviest two stones and smash them together. 
 * Suppose the heaviest two stones have weights x and y with x <= y. 
 * 
 * The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, 
 * and the stone of weight y has new weight y - x.
 * 
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. 
 * If there are no stones left, return 0.
 * 
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 */

public class LastStoneWeight {
    
    public int lastStoneWeight(int[] stones){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        int stone1, stone2;

        // Create max heap
        for (int stone: stones)
            maxHeap.offer(-stone);

        while (maxHeap.size() > 1){

            // Get and remove the two biggest stones
            stone1 = -maxHeap.poll(); // positive values
            stone2 = -maxHeap.poll();

            // If they aren't equal, add the remaining pebble to the max heap
            if (stone1 != stone2)
                maxHeap.offer(-(stone1 - stone2));
            
        }

        if (maxHeap.size() == 0)
            return 0;
        else 
            return -maxHeap.poll();
            
    }

}
