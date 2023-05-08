/**
 * 853
 * 
 * Medium, Stack
 * 
 * n cars going to dest target miles away
 * two arrs, pos and speed, same length
 * 
 * cars cant pass each other, but can catch up and start driving same speed
 * next to each other
 * 
 * car fleet are groups of cars that get to dest at the same time,
 * even if its at the last second
 * 
 * Input:
 * target = 12
 * position = 10 8 0 5 3
 * speed = 2 4 1 1 3
 * 
 * Output = 3
 * 
 * 
 */

public class CarFleet {

    public static int fleets(int target, int[] position, int[] speed){

        int fleets = 0;

        double[] timeArr = new double[target]; 

        for (int i = 0; i < position.length; i++){
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        }

        for(int i = 0; i < target; i++)
            System.out.println("index " + i + ": " + timeArr[i]);

        double curr, prev = 0.0;

        for (int i = target - 1; i >= 0 ; i--) {

            curr = timeArr[i];

            if (curr >= prev){
               
                fleets++;
            }

            prev = curr;

            System.out.println("curr: " + curr + ", prev: " + prev + ", fleets: " + fleets);

        }

        return fleets;   

    }

    public static void main(String[] args) {
        
        int[] positions = {10, 8, 0, 5, 3};
        int[] speeds = {2,4,1,1,3};
        int target = 12;
        fleets(target, positions, speeds);

    }
    
}
