
import java.util.HashMap;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * 
 * medium
 * 
 * Given a sorted linked list, 
 * delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * Example
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 */

public class RemoveDuplicatesFromSortedList2 {

	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		ListNode tmp = head;
		HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
		while(tmp != null) {
			if(elements.containsKey(tmp.val))
				elements.put(tmp.val, elements.get(tmp.val) + 1);
			else
				elements.put(tmp.val, 1);
			tmp = tmp.next;
		}
		ListNode current = head;
		while(current.next != null) {
			if(elements.get(current.next.val) > 1)
				current.next = current.next.next;
			else
				current = current.next;
		}
		// head remains
		if(elements.get(head.val) > 1)
			head = head.next;
		return head;
	}

}
