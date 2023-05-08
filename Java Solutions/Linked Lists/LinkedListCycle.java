/**
 * 
 */
public class LinkedListCycle {
    
    // fast and slow pointer
    // fast moves 2 steps, slow moves 1 step
    // if its a cycle, they are guaranteed to meet at some point
    public boolean hasCycle(ListNode head){

        ListNode slow = head, fast = head;

        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
