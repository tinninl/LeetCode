/**
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. 
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) 
            return list2;
        if (list2 == null)
            return list1;

        ListNode head, curr;

        // Determine the head of the merged list
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        }
                   
        else {
            head = list2;
            list2 = list2.next;
        }
            
        curr = head;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1; 
                list1 = list1.next;
            }
            
            else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;

        }

        // After the while loop, either list1 or list2 will point to null
        if (list1 == null)
            curr.next = list2;
        
        else 
            curr.next = list1; 

        return head;

    }
    
}
