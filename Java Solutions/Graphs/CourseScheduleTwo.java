import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Queue;

/**
 * We need to take numCourses courses numbered from 0 to numCourses - 1
 * 
 * ex. 01 02 13 32 40 50
 * 
 */
public class CourseScheduleTwo {
    
    /**
     * 
     */
    public int[] findOrder(int numCourses, int[][] prerequisites){

        // The order of the courses we should take
        int[] order = new int[numCourses];

        // This array keeps track of the number of prereqs for each course
        int[] degrees = new int[numCourses];

        // Index: course
        // The list contains the courses that require index as a prereq
        // The list is NOT a list of prerequisites for the course
        List<List<Integer>> adjList = new ArrayList<>(numCourses); 
 
        // Create the adjacency list
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());           

        // Fill in the adjacency list 
        for (int[] courses : prerequisites) {
            degrees[courses[0]]++;
            adjList.get(courses[1]).add(courses[0]);
        }

        // Explore the courses that are ready to take
        Queue<Integer> ready = new LinkedList<>();

        // And keep track of the number of courses we can take
        int coursesTaken = 0;
        
        // Initialize the queue with the courses with NO prerequisites
        // We should explore those courses first
        // In out example, we would start at course 2
        for (int i = 0; i < degrees.length; i++) 
            if (degrees[i] == 0) 
                ready.offer(i);
    
        while (!ready.isEmpty()) {

            int course = ready.poll();

            // Add the course to our result
            order[coursesTaken++] = course; 

            // Now explore the courses that we are now ready to take
            /*
             * Now that we have taken course 2, look at the courses that
             * require 2 as a prereq (0 and 3)
             * 
             * Update the degrees array of these courses
             * and see if they are ready to take
             * 
             */
            for (int post : adjList.get(course)) {

                degrees[post]--;

                if (degrees[post] == 0) 
                    ready.offer(post);

            }

        }

    if (coursesTaken == numCourses) 
        return order;   
    else 
        return new int[0];

        
    }
    
}
