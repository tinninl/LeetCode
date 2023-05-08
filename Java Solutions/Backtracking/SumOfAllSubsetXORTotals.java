/**
 * 
 */

public class SumOfAllSubsetXORTotals {

    public static int subsetXORSum(int[] nums){

        int sum = backtrack(nums, 0, 0);
        return sum;
    }

    public static int backtrack(int[] nums, int sum, int index){

        // Base case: we looked at all elements in nums
        if (index == nums.length)
            return sum;

        // Calculate the xor sum including the current element
        int withElement = backtrack(nums, sum ^ nums[index], index +1);

        // calculate the xor sum excluding the current element
        int withoutElement = backtrack(nums, sum, index + 1);

        return withoutElement + withElement;
      
    }

    public static void main(String[] args) {
        int[] numbers = {5,1,6};
        subsetXORSum(numbers);
    }


}
