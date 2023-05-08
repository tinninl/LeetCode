public class CountingBits {
    
    /**
     * 0000  0
     * 0001  1
     * 0010  1
     * 0011  2
     * 0100  1
     * 0101  2
     * 0111  3
     * 1000  1
     * 
     * Any patterns? 
     * We can see there is always at least one 1 (except zero)
     * Lets try ANDing and ORing curr with prev
     * 
     */

    public int[] countBits(int n){
        
        int[] res = new int[n + 1];

        for (int i = 1; i < n + 1; i++)
            res[i] = 1 + res[i & (i - 1)];

        return res;
        
    }
}
