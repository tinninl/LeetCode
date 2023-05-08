/**
 * Medium
 * 
 * m x n matrix, sorted in ascending order
 * O log m x n 
 * 
 * 123
 * 567
 * 8910
 */
public class SearchA2DMatrix {

    /**
     * Where should we start our search? 
     * Intuition says we should start somewhere in the middle
     * Lets try starting at the bottom left corner (first row, last column)
     * 
     * Could we start at the top right corner instead? How would this change our solution?
     * The while loop conditions would change
     * 
     */
    public boolean searchMatrix(int[][] matrix, int target){

        int row = matrix.length - 1, col = 0;

        while (row >= 0 && col < matrix[0].length) {

            int num = matrix[row][col];

            if (num < target)
                col++;

            if (num > target)
                row--;
            
            else 
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(matrix[1][0]);
    }

}
