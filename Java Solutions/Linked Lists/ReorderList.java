/**
 * 143 med
 * 
 * 1234 = 1423
 * 
 * 12345 = 15243
 * 
 * first last med
 */
public class ReorderList {

    public void reorderList(ListNode head){

        // Find the middle of the list
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next; // Slow will point to the middle of the list at the end of the loop
            fast = fast.next.next;
        }

        // Reverse the second half of the list (use solution from reverselinkedlist)
        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;
        ListNode next;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // prev should now point to the tail of the list

        // merge the two lists, list1 = head, list2 = the second half
        ListNode first = head;
        ListNode second = prev;
        ListNode tmp1, tmp2;

        while(second != null){

            tmp1 = first.next;
            tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;

        }
    }

}
