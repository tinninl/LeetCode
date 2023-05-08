import java.util.HashSet;
import java.util.Set;

/**
 * 904 medium
 * 
 * 
 */

public class FruitsIntoBaskets {
    
    public static int totalFruit(int[] fruits){
        
        int winLen = 0, max = 0;
        int left = 0, right = 0;

        int fruit;

        Set<Integer> set = new HashSet<>();

        for (; right < fruits.length; right++){

            fruit = fruits[right];

            // System.out.println("Right: " + right + ", Left: " + left + ", Fruit: " + fruit);
            // System.out.println("Set size: " + set.size());

            int temp;
        
            if (!set.contains(fruit)){

                if (set.size() == 2){

                    System.out.println("Removing: " + fruits[left]);
                    set.remove(fruits[left]);

                    
                    temp = 0;
                    while(fruits[right-1-temp] == (fruits[right-1])){
                        temp++;
                    }
                    left = right-temp;
                        
                    
                }
            
                set.add(fruits[right]);
                    
            }

            winLen = right - left + 1;
            max = Math.max(max, winLen);

            //System.out.println("winLen: " + winLen + ", max: " + max);
            //System.out.println("");

            

        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        totalFruit(nums);
        System.out.println("main: "+ totalFruit(nums));
    }
}
