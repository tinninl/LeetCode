import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {


    // build the nodes first? then link?
    // keep track of the nodes being built? use hashmap
    public Node copyRandomList(Node head) {

        if (head == null) 
            return null;
        
        Node curr = head;
        // key = og, val = deep copy 
        HashMap<Node, Node> map = new HashMap<>();

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);

    }
}
