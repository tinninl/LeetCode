import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * What makes a valid tree?
 * No redundant connections
 * There can only be one set
 * 
 * Ex. 01 02 03 14
 * 
 */
public class ValidGraphTree {

    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        if (n == 0 || n == 1) return true;

        if (edges.length == 0) return false;

        // Initialize the adjList
        /**
         * 0 - 1 2 3
         * 1 - 0 4
         * 2 - 0
         * 3 - 0
         * 4 - 1
         */
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyList.putIfAbsent(node1, new ArrayList<>());
            adjacencyList.putIfAbsent(node2, new ArrayList<>());
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }

        // If there are no loops and every node was visited, its a valid tree
        // We can start at ANY node, and lets just let prev = -1 to start with
        return depthFirstSearch(0, -1) && visited.size() == n;
    }

    /**
     * If we start at 0 and explore 1,
     * whats to stop us from accidentally going back to 0 
     * and thinking we found a loop?
     * 
     * We need to keep track of the previous node we visited
     * @param node
     * @param previous
     * @return
     */
    private boolean depthFirstSearch(int node, int previous) {

        // If we try to explore a node we already visited, then we are in a loop
        // and the graph is not a valid tree
        if (visited.contains(node)) 
            return false;

        // Process the node (mark the node as visited)
        visited.add(node);

        // Explore all the neighbors
        for (int neighbor : adjacencyList.get(node)) {

            // Except the previous node
            if (neighbor == previous) 
                continue;

            if (!depthFirstSearch(neighbor, node)) 
                return false;

        }

        return true;

    }

}

