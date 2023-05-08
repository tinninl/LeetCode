/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head){

        ListNode curr, prev, next; 
        curr = head;
        prev = null;

        // Use three pointers, update one arrow
        while (curr != null){

            next = curr.next; // update next

            curr.next = prev; // curr points behind
            prev = curr; // update prev and curr
            curr = next;

        }

        return prev;
    }

}




