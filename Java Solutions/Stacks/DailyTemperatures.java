import java.util.Stack;

/**
 * 739. Daily Temperatures
 * 
 * int[] temps
 * 
 * return array of num of days until warmer temps
 * 
 * Example:
 * 
 * Input: 73 74 75 71 69 72 76 73
 * Output: 1 1 4 2 1 1 0 0
 */
public class DailyTemperatures {
    
    /**
     * We need to track the indices
     * Should the stack hold the temps (values) or the days (indices)?
     * 
     */
    public static int[] dailyTemperatures(int[] temps){

        int[] res = new int[temps.length];

        Stack<Integer> stack = new Stack<>();

        for (int day = 0; day < temps.length; day++){


            // Did we find a warmer temperature?
            while (!stack.isEmpty() && temps[day] > temps[stack.peek()]){

                int prevDay = stack.pop(); 
                res[prevDay] = day - prevDay;   

            } 

            stack.push(day);

        }

        return res;

    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temps);
        for (int i = 0; i < res.length; i++) 
            System.out.println("Index " + i + ": " + res[i]);
    }

}

/** Example Walkthrough
 * 
 * 0, 73: push 0
 * 1, 74: 74 > 73, pop 0, res[0] = 1 - 0 = 1, push 1
 * 2, 75: 75 > 74, pop 1, res[1] = 2 - 1 = 1, push 2
 * 3, 71: 71 < 75, push 3
 * 4, 69: 69 < 71, push 4
 * 5, 72: 72 > 71, pop 4, res[4] = 5 - 4 = 1
 *        72 > 69, pop 3, res[3] = 5 -3 = 2, 
 *        72 < 75, push 5
 * 6, 76: 76 > 75, pop 2, res[2] = 6 - 2 = 4, push 6
 * 7, 73: 73 < 76, push 3
 * 
 * In java, array values default to 0, so res[6] and res[7] are already 0
 */
