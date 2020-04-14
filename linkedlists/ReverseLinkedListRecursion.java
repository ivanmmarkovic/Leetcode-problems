/*

206. Reverse Linked List
Easy

https://leetcode.com/problems/reverse-linked-list/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 39.9 MB, less than 5.04% of Java online submissions for Reverse Linked List.

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
Accepted
886,949
Submissions
1,467,021

*/

class ReverseLinkedListRecursion {

    public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
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