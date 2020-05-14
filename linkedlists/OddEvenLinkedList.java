package linkedlists;
/*

328. Odd Even Linked List
Medium

Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
Memory Usage: 39.4 MB, less than 5.00% of Java online submissions for Odd Even Linked List.

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
        if(head == null || head.next == null)
			return head;
		ListNode even = head;
		ListNode evenTmp = even;
		ListNode odd = even.next;
		ListNode oddTmp = odd;
		while (evenTmp != null && oddTmp != null) {
			evenTmp.next = oddTmp.next;
			oddTmp.next = oddTmp.next == null ? null : oddTmp.next.next;
			
			evenTmp = evenTmp.next;
			oddTmp = oddTmp.next;
		}
		
		if(evenTmp != null)
			evenTmp.next = odd;
		else {
			evenTmp = even;
			while (evenTmp.next != null) {
				evenTmp = evenTmp.next;
			}
			evenTmp.next = odd;
		}
		return even;
        
    }
}