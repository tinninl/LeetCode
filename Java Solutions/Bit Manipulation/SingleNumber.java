public class SingleNumber {
    
    /**
     * Two rules for XOR
     * A xor 0 = A
     * A xor A = 0   
     */
    public int singleNumber(int[] nums){

        int single = 0;

        for (int i = 0; i < nums.length; i++)
            single ^= nums[i];

        return single;
        
    }
    
}
