package linkedlists;

/*
143. Reorder List
Medium

https://leetcode.com/problems/reorder-list/

Runtime: 1 ms, faster than 99.94% of Java online submissions for Reorder List.
Memory Usage: 45 MB, less than 90.16% of Java online submissions for Reorder List.

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000

Accepted
353,699
Submissions
823,801

*/
public class ReorderList {

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
	
	public void reorderList(ListNode head) {
        if(head == null)
			return;
		ListNode current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		ListNode[] nodes = new ListNode[count];
		
		int index = 0;
		current = head;
		while(current != null) {
			nodes[index++] = current;
			current = current.next;
		}
		
		ListNode[] ordered = new ListNode[nodes.length];
		int left = 0, right = nodes.length - 1;
		index = 0;
		while (left < right) {
			ordered[index++] = nodes[left++];
			ordered[index++] = nodes[right--];
		}
		if(left == right) 
			ordered[index] = nodes[left];
		
		for(int i = 0; i < ordered.length - 1; i++)
			ordered[i].next = ordered[i + 1];
		ordered[ordered.length - 1].next = null;
		
		head = ordered[0];
    }

    /*
	// slower
	public void reorderList(ListNode head) {
		if(head == null)
			return;
		
		ListNode current = head;
		List<ListNode> nodes = new ArrayList<>();
		while(current != null) {
			nodes.add(current);
			current = current.next;
		}
		
		int left = 0, right = nodes.size() - 1;
		List<ListNode> reordered = new ArrayList<>();
		while(left < right) {
			reordered.add(nodes.get(left++));
			reordered.add(nodes.get(right--));
		}
		if(left == right)
			reordered.add(nodes.get(left));
		
		for (int i = 0; i < reordered.size() - 1; i++) {
			reordered.get(i).next = reordered.get(i + 1);
		}
		reordered.get(reordered.size() - 1).next = null;
		head = reordered.get(0);
	}
	*/

}
