/**
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

19. Remove Nth Node From End of List
Medium

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 37.9 MB, less than 6.37% of Java online submissions for Remove Nth Node From End of List.

 */
public class RemoveNthNodeFromEndOfList {
	public class ListNode {
        int val;
 	    ListNode next;     
		ListNode(int x) { val = x; }
 	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        
        int count = 0;
        ListNode tmp = head, prev = null;
        while(tmp != null){
            if(count == n){
                prev = head;
            }
            else if(count > n){
                prev = prev.next;
            }
            tmp = tmp.next;
            count++;
        }
        if(prev == null)
            return head.next;
        if(prev.next != null)
            prev.next = prev.next.next;
        
        return head;
    }

}
