import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height 
 * where the width of each bar is 1, 
 * return the area of the largest rectangle in the histogram.
 * 
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 */

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int prevHeight = 0;

        Stack<Integer> s = new Stack<>(); // holding indices of the array

        int maxArea = 0, area = 0, height = 0, width = 0;

        for (int i = 0; i < n; i++){

            // System.out.println("index: " + i);
            // System.out.println("currHeight: " + heights[i]);

            if (!s.isEmpty())
                // System.out.println("prevHeight2: " + prevHeight);
            
            // Push if curr height is greater than or equal to prev height, or if stack is empty
            if (s.isEmpty() || heights[i] >= prevHeight) {
                s.push(i);
                prevHeight = heights[s.peek()];
                // System.out.println("Pushing " + i);
            } 

            else {
                
                // Start popping and calculating areas
                while( !s.isEmpty() && heights[i] < prevHeight){

                    prevHeight = heights[s.peek()];
                    // System.out.println("prevHeight: " + prevHeight);

                    // System.out.println("popping " + s.peek());

                    width = i - s.peek();
                    // System.out.println("width=" + width);
                    
                    height = heights[s.pop()];                 
                    // System.out.println("height=" + height);
                    
                    area = height * width;
                    // System.out.println("area: " + area);

                    maxArea = Math.max(maxArea, area);
                    // System.out.println("maxArea: " + maxArea);                

                }

                s.push(i-width);
                System.out.println("Pushing " + (i-width));
              
                
            }

            

            System.out.println("");

        }

        // Calculate the remaining areas in the stack
        while(!s.isEmpty()){
            
            // System.out.println("prevHeight: " + prevHeight);
            // System.out.println("top of stack: " + s.peek());

            width = n - s.peek();
            // System.out.println("width=" + width);

            prevHeight = heights[s.peek()];

            height = heights[s.pop()];
            // System.out.println("height=" + height);

            area = height * width;
            maxArea = Math.max(maxArea, area);
            
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int x = largestRectangleArea(heights);
        System.out.println("x: " + x);
    }

}
