/**
 * Hard
 * 
 *  1 2 3 4 5 k = 2  if the last group is too small, ignore it
 *  2 1 4 3 5
 */

public class ReverseNodesInKGroup {
    
    public ListNode reverseKGroup(ListNode head, int k){

        if (head == null)
            return null;

        if (k == 1)
            return head;

        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode temp = null;
        ListNode end;

        int count = k;

        while (curr != null) {

            if (count > 1) {

                temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;

                count--;

            } else {

                prev = curr;
                curr = curr.next;
                end = curr;

                for (int i = 0; i < k; ++i) {
                    if (end == null) {
                        return dummy.next;
                    }
                    end = end.next;
                }
                count = k;
            }
        }

        return head;
    }
}
