
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
382. Linked List Random Node
Medium

https://leetcode.com/problems/linked-list-random-node/

Runtime: 14 ms, faster than 39.60% of Java online submissions for Linked List Random Node.
Memory Usage: 47.3 MB, less than 8.15% of Java online submissions for Linked List Random Node.

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

Accepted
75,286
Submissions
143,736

*/
class LinkedListRandomNode {


     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { 
            this.val = val; this.next = next; 
        }
    }
    
    private List<Integer> vals;
    private Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        rand = new Random();
        vals = new ArrayList<>();
        while(head != null){
            vals.add(head.val);
            head = head.next;
        }
        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}

/**
 Your Solution object will be instantiated and called as such:
 Solution obj = new Solution(head);
 int param_1 = obj.getRandom();
*/

