/**
 * 
 * 11. Container With Most Water
 * 
 * You are given an integer array height of length n. 
 * There are n vertical lines drawn such that the two endpoints of the ith line 
 * are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container, 
 * such that the container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 */


public class ContainerWithMostWater {

    /**
     * Solution: Two pointer approach
     * 
     */
    public static int maxArea(int[] heights) {

        int left = 0, right = heights.length - 1; // start and end of the array

        int maxArea = 0, area = 0;

        int height = 0, width = 0;

        while (left < right){

            // Calculate the area of the container
            height = Math.min(heights[right], heights[left]);
            width = right - left;
            area = height * width; 

            // Update maxArea
            if (area > maxArea)
                maxArea = area;
            
            // Shift either the left or right pointer. Which direction should we shift?
            /**
             * Remember: We want to keep the taller height.
             * If the left height is shorter, than we shift the left pointer,
             * and vice versa. If its a tie, it doesn't matter which way we go.
             */
            if (heights[left] < heights[right])
                left++;

            else
                right--;

        }     
        
        return maxArea;

    }    
    
}
