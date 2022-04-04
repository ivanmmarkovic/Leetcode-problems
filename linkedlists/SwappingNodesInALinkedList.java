package linkedlists;

/*
1721. Swapping Nodes in a Linked List
Medium

https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

Runtime: 7 ms, faster than 16.97% of Java online submissions for Swapping Nodes in a Linked List.
Memory Usage: 56.5 MB, less than 98.30% of Java online submissions for Swapping Nodes in a Linked List.

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

 

Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 105
    0 <= Node.val <= 100

Accepted
148,522
Submissions
217,076

*/
public class SwappingNodesInALinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int x) {
			val = x;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode swapNodes(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		ListNode h = head;
		int count = 0;
		while (h != null) {
			count++;
			h = h.next;
		}

		ListNode nodes[] = new ListNode[count];
		h = head;
		count = 0;
		while (h != null) {
			nodes[count++] = h;
			h = h.next;
		}

		if (nodes.length < k)
			return head;

		ListNode left = nodes[k - 1];
		ListNode right = nodes[nodes.length - k];
		nodes[k - 1] = right;
		nodes[nodes.length - k] = left;

		for (int i = 0; i < nodes.length - 1; i++) {
			nodes[i].next = nodes[i + 1];
		}
		nodes[nodes.length - 1].next = null;
		return nodes[0];
	}

}
