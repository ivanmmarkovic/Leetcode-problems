
import java.util.ArrayList;
import java.util.Arrays;

/* 
148. Sort List
Medium

https://leetcode.com/problems/sort-list/

Runtime: 8 ms, faster than 26.86% of Java online submissions for Sort List.
Memory Usage: 40.9 MB, less than 98.59% of Java online submissions for Sort List.

Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []

 

Constraints:

    The number of nodes in the list is in the range [0, 5 * 104].
    -105 <= Node.val <= 105

Accepted
286,709
Submissions
661,653

*/

public class SortList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode sortList(ListNode head) {
        ArrayList<Integer> vals = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            vals.add(tmp.val);
            tmp = tmp.next;
        }
        
        Integer arr[] = new Integer[vals.size()];
        arr = vals.toArray(arr);
        Arrays.sort(arr);
        
        head = new ListNode(0);
        tmp = head;
        for(Integer e: arr){
            tmp.next = new ListNode(e);
            tmp = tmp.next;
        }
        return head.next;
    }
}
