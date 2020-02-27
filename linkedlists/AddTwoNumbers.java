/*
2. Add Two Numbers
Medium

https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class AddTwoNumbers {
	
	public class ListNode {
        int val;
 	    ListNode next;     
		ListNode(int x) { val = x; }
 	}
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(0); // dummy head node
        ListNode tmp = result;
        int one = 0, two = 0, rest = 0;
        while(l1 != null || l2 != null){
            one = (l1 != null) ? l1.val : 0;
            two = (l2 != null) ? l2.val : 0;
            tmp.next = new ListNode((one + two + rest) % 10);
            rest = (one + two + rest) / 10;
            tmp = tmp.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(rest > 0){
            tmp.next = new ListNode(rest);
        }
        return result.next; // skip dummy head node
        
    }
}
