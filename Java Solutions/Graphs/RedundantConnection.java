// 684
// UnionFind
/**
 * given n nodes from 1 to n with n edges
 */
public class RedundantConnection {

    /**
     * If you have n nodes and n edges, its guaranteed that there is a cycle
     * How can we find a redundant connection?
     * 
     * Consider a triangle of nodes 1, 2 and 3
     * We could say 2 is a child of 1 and 3 is a child of 1
     * We look at the connection between nodes 2 and 3
     * Since 2 and 3 have the same parent, its a redundant connection
     * 
     * Hint: How can we keep track of a nodes parent?
     * 
     * We should check every connection and check if they have the same parent
     * Also update the parents array as we go along
     */

    // We can use a 0-indexed array, although the nodes start from 1
    int[] parents;

    public int[] findRedundantConnection(int[][] edges){

        int n = edges.length;
        parents = new int[n];
        
        // Initially, the parent of every node is itself
        for (int i = 0; i < n; i++){
            parents[i] = i + 1; // Remember to add one
        }

        // Check all connections
        for (int[] connection : edges){

            // If both nodes have the same parent, we found the redundant conection
            if (findParent(connection[0]) == findParent(connection[1]))
                return connection;

            // The first node becomes the parent of the second node
            else 
                union(connection[0], connection[1]);
        }

        // No redundant conection found? Return empty array
        return new int[2];
    }

    /**
     * How can we find the parent of a node?
     * 
     * 
     */
    private int findParent(int node){

        if (node == parents[node - 1])
            return node;
        else
            return findParent(parents[node - 1]);

    }

    // The parent of node1 becomes the parent of node2
    private void union(int node1, int node2){
        parents[findParent(node2) - 1] = findParent(node1);
    }
}
