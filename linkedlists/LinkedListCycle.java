
import java.util.HashSet;
import java.util.Set;

/*
141. Linked List Cycle
Easy

https://leetcode.com/problems/linked-list-cycle/

Runtime: 3 ms, faster than 20.76% of Java online submissions for Linked List Cycle.
Memory Usage: 40.4 MB, less than 5.71% of Java online submissions for Linked List Cycle.

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

 

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
Accepted
561,796
Submissions
1,408,281

*/

public class LinkedListCycle {
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	   }
	}
	
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = head;
        boolean cycleFound = false;
        while(tmp != null && !cycleFound){
            if(visited.contains(tmp))
                cycleFound = true;
            else{
                visited.add(tmp);
                tmp = tmp.next;
            }
        }
        return cycleFound;
    }
	
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
    Memory Usage: 39.3 MB, less than 44.67% of Java online submissions for Linked List Cycle.
    */
    public boolean hasCycleBetter(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
