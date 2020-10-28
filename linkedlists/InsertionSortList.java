
/*
147. Insertion Sort List
Medium

https://leetcode.com/problems/insertion-sort-list/

Runtime: 56 ms, faster than 5.16% of Java online submissions for Insertion Sort List.
Memory Usage: 38.7 MB, less than 9.97% of Java online submissions for Insertion Sort List.

Algorithm of Insertion Sort:

    Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
    At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
    It repeats until no input elements remain.


Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

Accepted
192,827
Submissions
462,077

*/
public class InsertionSortList {

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

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		for (ListNode current = head.next; current != null; current = current.next) {
			for (ListNode tmp = head; tmp != current; tmp = tmp.next) {
				if (current.val < tmp.val) {
					int value = current.val;
					current.val = tmp.val;
					tmp.val = value;
				}
			}
		}
		return head;
	}
}
