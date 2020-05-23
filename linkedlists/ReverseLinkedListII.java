/*
92. Reverse Linked List II
Medium

https://leetcode.com/problems/reverse-linked-list-ii/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
Memory Usage: 37.3 MB, less than 11.36% of Java online submissions for Reverse Linked List II.
Next challenges:
Plus One Linked List
Add Two Numbers II
Insert into a Sorted Circular Linked List


Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

Accepted
259,777
Submissions
683,099

*/

class ReverseLinkedListII {

	public class ListNode {
		int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { 
	    	this.val = val; 
	    }
	    ListNode(int val, ListNode next) { 
	    	this.val = val; 
	    	this.next = next; 
	    }
	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        
        ListNode tmp = head;
        ListNode first = null, last = null, before = null, after = null;
        int i = 1;
        while(i <= n){
            if(i < m){
                if(before == null)
                    before = head;
                else
                    before = tmp;
            }
            if(i == m){
                first = tmp;
            }
            if(i == n){
                last = tmp;
                after = tmp.next;
            }
            tmp = tmp.next;
            i++;
        }
        last.next = null;
        if(before == null){
            head = reverseList(first);
            before = head;
        }
        else
            before.next = reverseList(first);
        while(before.next != null)
            before = before.next;
        before.next = after;
        return head;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        else if(head.next == null)
            return head;
        else {
            ListNode next = head.next;
            head.next = null;
            ListNode rest = reverseList(next);
            next.next = head;
            return rest;
        }
    }
}