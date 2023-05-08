public class ReverseInteger {


    /*
     * 1234
     */
    public int reverse(int x){

        if (x == 0)
            return 0;

        boolean isNegative = (x < 0);

        if (isNegative)
            x *= -1;

        int reverse = 0;

        while (x > 0){
            
            int digit = x % 10;
            reverse *= 10;
            reverse += digit;
            if (reverse > Integer.MAX_VALUE)
                return 0;
            x /= 10;
        }

        if (isNegative)
            return reverse;

        else 
            return -reverse;


    }
}
