/*

    You are given two non-empty linked lists representing two non-negative integers. 
    The digits are stored in reverse order, and each of their nodes contains a single digit. 
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.


    l1 = 2-4-3 = 342
    l2 = 5-6-4 = 465
    sum = 708
    result = 807

 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        int num1 = 0, num2 = 0, sum;
        ListNode curr;
        ListNode head = new ListNode(); // return head
        int index; // index is used in calculations to build num1 and num2
        // represents what column the digit is in. ex. the ones column, tens, hundreds, etc

        // Traverse list1 and get num1
        curr = l1;
        index = 0; 
        while (curr.next != null){
            num1 += curr.val * 10^index;
            index++;
        }
        
        // Traverse list2 and get num2
        curr = l2;
        index = 0;
        while (curr.next != null){
            num2 += curr.val * 10^index;
            index++;
        }

        // Get the sum
        sum = num1 + num2;

        // Build the resulting linked list, storing digits in REVERSE order
        curr = head;
        while (sum != 0) {
            curr.val = sum % 10;
            sum = sum / 10;
            curr = curr.next;        
        }

        return head;

    }
    
}
