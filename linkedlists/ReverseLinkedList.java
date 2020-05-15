/*
206. Reverse Linked List
Easy

https://leetcode.com/problems/reverse-linked-list/

Runtime: 1 ms, faster than 7.20% of Java online submissions for Reverse Linked List.
Memory Usage: 39.5 MB, less than 5.04% of Java online submissions for Reverse Linked List.

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
Accepted
923,901
Submissions
1,514,697

*/
class ReverseLinkedList {

    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
    }
    
    public ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		ListNode result = new ListNode(0);
		ListNode resultTmp = result;
		while (!stack.isEmpty()) {
			resultTmp.next = stack.pop();
			resultTmp = resultTmp.next;
		}
        resultTmp.next = null; // avoid cycle
		return result.next;
	}
}