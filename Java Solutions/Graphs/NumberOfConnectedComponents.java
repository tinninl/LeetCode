/**
 * 3651 Union Find
 * 
 * How many separate graphs?
 * n 
 * 
 * Use union find to create connected components
 * 
 * Ex. 0-1-2 3-4
 * Two components
 * 
 * 
 */
public class NumberOfConnectedComponents {

    /**
     * How do we keep track of the sets? 
     * We need some way to id them
     * We can pick one node as a 'parent' node
     * ex. we could say we have sets 1 and 3
     * We also want to know how many children does a parent have?
     * ie. how many nodes in a set?
     * 
     * We can use arrays to keep track of this information
     * Since the nodes are labelled from 0 to n-1, this makes it easy to follow
     */
    
    // These arrays will track the parent of number of children of each node
    // The index will tell us what node we are looking at
    int[] parent;
    int[] children;

    public int countComponents(int n, int[][] edges) {

        parent = new int[n];
        children = new int[n];

        // Initially, each node is the parent of itself 
        // We will consider each node as having one child (itself)
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
            children[i] = 1;
        }

        // Initially, we have n connected components
        int result = n;
    
        /**
         * How can we union (join) components together?
         * We need to make sure the connection is not redundant first
         * 
         * 
         */
        for (int[] edge : edges) 
            if (union(edge[0], edge[1]) == 1)
                result--;
            
        return result;


    }

    /**
     * How can we find the parent of a node?
     * Suppose we have [0 0 1 3 4] and we wanna find p[2]
     * Check p[2], is it 2?
     * No, its parent is 1
     * Check p[1], is it 1?
     * No, its parent is 0
     * Check p[0], is it 0?
     * Yes, therefore the parent is 2 is 0
     */
    private int find(int node) {

        if (parent[node] == node) 
            return node;

        else
            return find(parent[node]);

    }

    /**
     * How can join two nodes?
     * First, find their parents
     * @param x
     * @param y
     * @return 1 if we can join them, 0 if it is a redundant connection
     */
    private int union(int x, int y){

        // First, find their parents
        int p1 = find(x);
        int p2 = find(y);

        // If they have the same parents, then they belong to the same set
        // and it is a redundant connection
        // Therefore, we should do nothing
        if (p1 == p2)
            return 0;

        // Which node should become the parent?
        // The node with more children should become the parent
        if (children[p1] > children[p2]){
            parent[p2] = parent[p1];
            children[p1] += children[p2]; 
        }

        else{
            parent[p1] = parent[p2];
            children[p2] += children[p2];
        }

        return 1;
    }

}
