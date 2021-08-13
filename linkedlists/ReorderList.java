package linkedlists;

import java.util.ArrayList;
import java.util.List;

/*
143. Reorder List
Medium

https://leetcode.com/problems/reorder-list/

Runtime: 9 ms, faster than 7.02% of Java online submissions for Reorder List.
Memory Usage: 52.2 MB, less than 5.38% of Java online submissions for Reorder List.

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000

Accepted
353,699
Submissions
823,801

*/
public class ReorderList {

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
	
public void reorderList(ListNode head) {
        
        List<ListNode> list = new ArrayList<>();
        
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp);
            tmp = tmp.next;
        }
        
        List<ListNode> reordered = new ArrayList<>();
        
        int left = 0, right = list.size() - 1;
        boolean leftFirst = true;
        while(left < right){
            if(leftFirst){
                reordered.add(list.get(left++));
                leftFirst = false;
            }
            else {
                reordered.add(list.get(right--));
                leftFirst = true;
            }
        }
        
        if(left == right)
            reordered.add(list.get(left));
        
        for(int i = 0; i < reordered.size() - 1; i++)
            reordered.get(i).next = reordered.get(i + 1);
        reordered.get(reordered.size() - 1).next = null;
        
        head = reordered.get(0);
        
    }

}
