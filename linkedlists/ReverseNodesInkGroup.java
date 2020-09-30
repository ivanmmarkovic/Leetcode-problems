
import java.util.Stack;

/*
25. Reverse Nodes in k-Group
Hard

https://leetcode.com/problems/reverse-nodes-in-k-group/

Runtime: 1 ms, faster than 28.02% of Java online submissions for Reverse Nodes in k-Group.
Memory Usage: 39.2 MB, less than 95.73% of Java online submissions for Reverse Nodes in k-Group.

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.

Accepted
292,338
Submissions
681,338

*/
public class ReverseNodesInkGroup {

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
	
public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode tmp = head;
        ListNode first = null, last = null, prev = null, after = null;
        int count = 1;
        while(tmp != null){
            if(count == 1){
                first = tmp;
            }
            if(count == k){
                last = tmp;
                after = last.next;
                last.next = null;
                ListNode reversed = reverseList(first);
                if(prev != null)
                    prev.next = reversed;
                else
                    head = reversed;
                while(reversed.next != null)
                    reversed = reversed.next;
                reversed.next = after;
                prev = reversed;
                tmp = after;
                count = 1;
            }
            else{
                tmp = tmp.next;
                count++;
            }
        }
        return head;
        
    }
    
    public ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		ListNode result = new ListNode(0);
		ListNode resultTmp = result;
		while (!stack.isEmpty()) {
			resultTmp.next = stack.pop();
			resultTmp = resultTmp.next;
		}
        resultTmp.next = null; // avoid cycle
		return result.next;
	}
}
