/**
 * Do it in ONE pass
 * two passes is pretty easy right?
 * 
 * 1 2 3 4 5 n=2  1 2 3 5
 */

public class RemoveNthNodeFromEnd {

    /**
     * two pointer
     * 
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null || head.next == null)
            return null;
        
        ListNode slow, fast;
        slow = head;
        fast = head;

        for (int i = 0; i < n; i++) 
            fast = fast.next;

        if (fast.next == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;


    }

    // 1 5 

}
