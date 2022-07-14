package linkedlists;
/*

328. Odd Even Linked List
Medium

https://leetcode.com/problems/odd-even-linked-list

Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
Memory Usage: 44 MB, less than 71.36% of Java online submissions for Odd Even Linked List.

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:

    The relative order inside both the even and odd groups should remain as it was in the input.
    The first node is considered odd, the second node even and so on ...

Accepted
212,530
Submissions
402,747
*/

class OddEvenLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode oddEvenList(ListNode head) {
		
		ListNode left = new ListNode(0), l = left;
		ListNode right = new ListNode(0), r = right;
		while(head != null) {
			l.next = head;
			r.next = head.next;
			l = l.next;
			r = r.next;
			
			head = head.next == null ? null : head.next.next;
		}
		l.next = right.next;
		return left.next;
	}
	
	/*
	Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
	Memory Usage: 44.8 MB, less than 44.10% of Java online submissions for Odd Even Linked List.
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null)
            return head;
        ListNode even = head, e = even;
    	ListNode odd = head.next, o = odd;
    	
    	while(e != null && o != null) {
    		e.next = e.next.next;
    		o.next = o.next == null ? null : o.next.next;
    		
    		e = e.next;
    		o = o.next;
    	}
    	
    	if(e != null)
    		e.next = odd;
    	else {
    		e = even;
    		while(e.next != null) {
    			e = e.next;
    		}
    		e.next = odd;
    	}
    	return head;
    	
    }
	*/
}
