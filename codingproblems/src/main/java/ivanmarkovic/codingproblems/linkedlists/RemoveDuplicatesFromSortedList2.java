package ivanmarkovic.codingproblems.linkedlists;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
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
        
        HashMap<Integer, Integer> values = new HashMap<>();
        for(ListNode tmp = head; tmp != null; tmp = tmp.next) {
        	if(values.containsKey(tmp.val))
        		values.put(tmp.val, values.get(tmp.val) + 1);
        	else
        		values.put(tmp.val, 1);
        }
        
        ListNode tmp = head;
        while(tmp.next != null) {
        	if(values.get(tmp.next.val) > 1) {
        		tmp.next = tmp.next.next;
        	}
        	else
        		tmp = tmp.next;
        }
        // head remains
        if(values.get(head.val) > 1)
        	head = head.next;
        return head;
    }
	
}
