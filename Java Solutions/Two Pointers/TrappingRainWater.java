public class TrappingRainWater {

    /**
     * Given a height n, how can we calulcate the area for that column?
     * We only know the tallest heights of the left and right sides
     */
    public int trap(int[] height){

        int n = height.length;

        if (n == 0)
            return 0;

        int totalArea = 0, area = 0;

        // At each index, what is the maximum left and right heights?
        int maxLeft = 0, maxRight = 0;

        // Arrays storing max left and max right heights
        int[] left = new int[n];
        int[] right = new int[n];

        // Fill in the arrays
        for (int i = 0; i < n; i++){

            left[i] = maxLeft;
            
            if (height[i] > maxLeft)
                maxLeft = height[i];

        }

        for (int i = n - 1; i >= 0; i--){

            right[i] = maxRight;
            
            if (height[i] > maxRight)
                maxRight = height[i];

        }

        // Calculate total area
        for (int i = 0; i < n; i++){
            area = Math.min(left[i], right[i]) - height[i];
            if (area > 0) // Dont add negative areas
                totalArea += area;
        }


        return totalArea;

    }


    /*
     * Two pointer solution
     * 
     * Traverse the array and calculate the area of water each index could hold
     * Example: [1 2 1 3 0 2 1] can hold 3 units of water
     * Index 2 can hold 1 unit of water and index 4 can hold 2 units of water
     * 
     * In order to calculate the area of water each index n could hold, we need 
     * the tallest heights on the left and rightsides of n
     * 
     * Imagine we only know the current height, and the maximum left and right heights.
     * We cant see anything else
     */
    public int trap2(int[] height){

        if (height.length == 0)
            return 0;


        int totalArea = 0, area = 0;

        int left = 0, right = height.length - 1;  

        int maxLeft = 0, maxRight = 0; 


        while (left <= right) {

            if (maxLeft < maxRight) {

                area = Math.max(maxLeft - height[left], 0);

                totalArea += area;

                if (height[left] > maxLeft) 
                    maxLeft = height[left];

                left++; 

            }

            else {

                area = Math.max(maxRight - height[right], 0);

                totalArea += area;

                if (height[right] > maxRight)   
                    maxRight = height[right];  

                right--; 

            }

            /* 
            System.out.println("area: " + area);
            System.out.println("totalArea: " + totalArea);
            System.out.println("left: " + left);
            System.out.println("right: " + right);
            System.out.println("maxLeft:" + maxLeft);
            System.out.println("maxRight:" + maxRight);
            System.out.println();
            */


        }

        return totalArea;

    }

}
