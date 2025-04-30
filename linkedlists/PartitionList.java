package linkedlists;
/*
86. Partition List
Medium

https://leetcode.com/problems/partition-list/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
Memory Usage: 39.2 MB, less than 5.77% of Java online submissions for Partition List.

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

Accepted
200,192
Submissions
499,192

*/

class PartitionList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}

    public ListNode partition(ListNode head, int x) {

	/*
        ListNode leftNode = new ListNode(0), left = leftNode;
		ListNode rightNode = new ListNode(0), right = rightNode;
		
		while(head != null) {
			if(head.val < x) {
				left.next = head;
				left = left.next; 
                head = head.next;
                left.next = null; // break cycle
			}
			else {
				right.next = head;
				right = right.next;
                head= head.next;
                right.next = null; // break cycle
			}
		}
		
		left.next = rightNode.next;
		return leftNode.next;
        
        */
        
        ListNode left = new ListNode(), l = left;
        ListNode right = new ListNode(), r = right;

        while(head != null){
            if(head.val < x){
                l.next = head;
                l = l.next;
            }
            else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }

        r.next = null;
        l.next = right.next;
        return left.next;
	    
    }
    /*
    public ListNode partition(ListNode head, int x) {
        
    	ListNode left = new ListNode(0);
		ListNode tmpLeft = left;
		ListNode right = new ListNode(0);
		ListNode tmpRight = right;
		ListNode tmp = head;
		while (tmp != null) {
			if(tmp.val < x) {
				tmpLeft.next = new ListNode(tmp.val);
				tmpLeft = tmpLeft.next;
			}
			else {
				tmpRight.next = new ListNode(tmp.val);
				tmpRight = tmpRight.next;
			}
			tmp = tmp.next;
		}
		tmpLeft.next = right.next;
		return left.next;
        
    }
    */
}
