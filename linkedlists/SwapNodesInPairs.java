/**

https://leetcode.com/problems/swap-nodes-in-pairs/

medium

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.



Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
Memory Usage: 37.1 MB, less than 5.50% of Java online submissions for Swap Nodes in Pairs.
Next challenges: 
 */
class SwapNodesInPairs {

	public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

     public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode first = head, second = head.next;
        
        while(first != null && second != null){

            first.next = second.next;
            second.next = first;
            if(prev != null)
                prev.next = second;
            if(prev == null)
                head = second;

            prev = first;
            first = prev.next;
            second = first == null ? null : first.next;
        }
        
        return head;
        
    }
}