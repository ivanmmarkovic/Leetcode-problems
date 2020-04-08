/*
https://leetcode.com/problems/merge-k-sorted-lists

Runtime: 2 ms, faster than 97.71% of Java online submissions for Merge k Sorted Lists.
Memory Usage: 40.9 MB, less than 46.45% of Java online submissions for Merge k Sorted Lists.

23. Merge k Sorted Lists
Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

Accepted
572,153
Submissions
1,483,686
*/

class MergeKSortedLists {
    class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String args[]) {
		
	}
	
	public ListNode mergeKLists(ListNode lists[]) {
		if(lists == null || lists.length == 0)
			return null;
		return mergeKLists(lists, 0, lists.length - 1);
	}
	
	public ListNode mergeKLists(ListNode lists[], int start, int end) {
		if(start == end)
			return lists[start];
		else if(start < end) {
			int midpoint = start + (end - start) / 2;
			ListNode left = mergeKLists(lists, start, midpoint - 1);
			ListNode right = mergeKLists(lists, midpoint, end);
			return mergeTwoLists(left, right);
		}
		else
			return null;
	}
	
	public ListNode mergeTwoLists(ListNode left, ListNode right) {
		ListNode result = new ListNode(0);
		ListNode pointer = result;
		while (left != null && right != null) {
			if(left.val < right.val) {
				pointer.next = new ListNode(left.val);
				left = left.next;
			}
			else {
				pointer.next = new ListNode(right.val);
				right = right.next;
			}
			pointer = pointer.next;
		}
		
		while (left != null) {
			pointer.next = new ListNode(left.val);
			left = left.next;
			pointer = pointer.next;
		}
		while (right != null) {
			pointer.next = new ListNode(right.val);
			right = right.next;
			pointer = pointer.next;
		}
		return result.next;
	}
}