/**
 * last blind 75 question
 */
public class SumOfTwoIntegers {

    /**
     * How to add 0 and 1?
     * xor 
     * How do we handle a carry? ie if we have two 1s
     * we can use AND
     * 
     * 
     */
    public int getSum(int a, int b){

        while (b != 0){

            a = a ^ b; // XOR
            int temp = (a & b) << 1; // AND + shift left 
            b = temp;
        }

        return a;
    }

}
