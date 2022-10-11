/**
 * 860. Lemonade Change
 * 
 * Easy
 * 
 * At a lemonade stand, each lemonade costs $5. 
 * Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). 
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. 
 * You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 * 
 * Note that you do not have any change in hand at first.
 * 
 * Given an integer array bills where bills[i] is the bill the ith customer pays, 
 * return true if you can provide every customer with the correct change, or false otherwise.
 */

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        // We need to keep track of how many bills we collect
        // (We don't care about keeping track of the twentys)
        int fives = 0;
        int tens = 0;


        for(int bill : bills){

            if (bill == 5)
                fives++;

            else if (bill == 10){
                tens++;
                fives--;
            }

            else {

                if (tens > 0){
                    tens--;
                    fives--;
                }

                else
                    fives = fives - 3;
            }             

            if (fives < 0)
                return false;            
       
        } 

        return true;
        
    }
    
}
