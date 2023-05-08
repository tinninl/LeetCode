import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// each node value is UNIQUE
// no repeat edges and no self loops
// entire graph is connected, doesnt matter where we start
// return DEEP COPY
public class CloneGraph {

    /**
     * How can we keep track of the nodes we already cloned?
     * We don't want to create duplicate clones
     * 
     * We can use a HashMap to keep track of cloned nodes
     * Since we know that node values are UNIQUE, 
     * we can use them as the key in our map
     * 
     * We can use DFS to create clones and fill their neighbors list
     * 
     * 
     */
    public Node cloneGraph(Node node){

        if (node == null)
            return null;

        // key = value, value = cloned node reference
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        Node clone = dfs(node, map);

        return clone;

    }

    // Return a deep copy of the original node 
    private Node dfs(Node original, HashMap<Integer, Node> map){

        // Did we already clone this node?
        if (map.containsKey(original.val))
            return map.get(original.val);

        // Create the clone and add it to our map
        Node clone = new Node(original.val);
        map.put(original.val, clone);
        
        /**
         * We need to copy the neighbors list of the original
         * Use dfs to create clones of the neighbors
         * And remember to add them to our clones.neightbors list
         */
        for (int i = 0; i < original.neighbors.size(); i++) {
            Node neighbor = dfs(original.neighbors.get(i), map);
            clone.neighbors.add(neighbor);
        }
        
        return clone;

    }

}






class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}