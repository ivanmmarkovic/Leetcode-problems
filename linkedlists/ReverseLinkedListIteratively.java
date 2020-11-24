
/*
206. Reverse Linked List
Easy

https://leetcode.com/problems/reverse-linked-list/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 38.6 MB, less than 75.42% of Java online submissions for Reverse Linked List.

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
Accepted
1,173,175
Submissions
1,829,760

*/

public class ReverseLinkedListIteratively {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		boolean stopped = false;
		ListNode next = head.next;
		head.next = null;
		ListNode tmp = null;
		while (!stopped) {
			tmp = next.next;
			next.next = head;
			head = next;
			if (tmp != null)
				next = tmp;
			else
				stopped = true;
		}
		return next;
	}

}
