import java.util.Stack;

/*
430. Flatten a Multilevel Doubly Linked List
Medium

https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
Memory Usage: 37.9 MB, less than 57.60% of Java online submissions for Flatten a Multilevel Doubly Linked List.
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation:

*/

class FlattenAMultilevelDoublyLinkedList {

	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	}

    public Node flatten(Node head) {
        if(head == null)
            return head;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        Node tmp = head;
        while(!stack.isEmpty()){
            tmp = stack.pop();
            if(tmp.next != null)
                stack.push(tmp.next);
            if(tmp.child != null){
                stack.push(tmp.child);
                tmp.child = null;
            }
            if(!stack.isEmpty()){
                stack.peek().prev = tmp;
                tmp.next = stack.peek();
            }
            else
                tmp.next = null;
        }
        return head;
    }
    
}