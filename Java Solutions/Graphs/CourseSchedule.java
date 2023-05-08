import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 207. Topological Sort Graph Medium
 * from 0 to numCourses - 1
 * take prereq[1] if you want to take prereq[0] (2nd one is the prereq)
 * 
 * Can you take all the classes?
 */

public class CourseSchedule {

    /**
     * Using just the matrix is not going to be helpful
     * We want a data structure to keep track of the prereqs for every course
     * We should use an adjacency List!
     * 
     * To set up the adjList, we could use a HashMap, but 
     * conveniently, the indices of a normal List will be fine
     * 
     */
    public boolean canFinish(int numCourses, int[][] prerequisites){

        if (numCourses == 0 || prerequisites.length == 0)
            return true;

        // Index = course. Each list contains the prerequisites for that course
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[numCourses];

        // Create empty lists
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());    

        // Add all the prerequisites to our adjList
        for (int i = 0; i < prerequisites.length; i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);  
        
        // dfs(course 0, adjList)
        
        
        return true;
    }

    private boolean dfs(int course,  List<List<Integer>> adjList, int[] visited){

        if (visited[course] == 2) return false;

        if (adjList.get(course).isEmpty()) 
            return true;
        visited[course]++;
        boolean canTake = false;
        for (int pre : adjList.get(course)){

            canTake = dfs(pre, adjList, visited);
        }

        return canTake;
    }

    
}
