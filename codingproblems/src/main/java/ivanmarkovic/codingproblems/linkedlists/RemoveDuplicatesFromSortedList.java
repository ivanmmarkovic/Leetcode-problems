package ivanmarkovic.codingproblems.linkedlists;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given a sorted linked list, 
 * delete all duplicates such that each element appear only once.
 */

public class RemoveDuplicatesFromSortedList {

	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode tmp = head;
        while(tmp.next != null){
            if(tmp.val == tmp.next.val)
                tmp.next = tmp.next.next;
            else
                tmp = tmp.next;
        }
        return head;
    }
	
}
