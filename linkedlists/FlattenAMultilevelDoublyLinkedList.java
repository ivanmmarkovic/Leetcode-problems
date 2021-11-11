package linkedlists;

import java.util.LinkedList;
import java.util.Queue;
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
	
	// the easiest solution
	public Node flatten(Node head) {
        if(head == null)
            return head;
        
        Stack<Node> stack = new Stack<>();
        traversal(head, stack);
        
        while(!stack.isEmpty()){
            head = stack.pop();
            head.child = null;
            if(!stack.isEmpty()){
                head.prev = stack.peek();
                stack.peek().next = head;
            }
            else
                head.prev = null;
        }
        
        return head;
        
    }
    
    void traversal(Node head, Stack<Node> stack){
        if(head == null)
            return;
        stack.push(head);
        if(head.child != null)
            traversal(head.child, stack);
        traversal(head.next, stack);
        
    }
	
	
    public Node flatten1(Node head) {
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
    
    public Node flatten2(Node head) {
        Queue<Node> q = new LinkedList<>();
        addNodes(head, q);
        Node tmp = null;
        while(!q.isEmpty()){
            tmp = q.poll();
            tmp.next = q.peek() != null ? q.peek() : null;
            if(q.peek() != null)
                q.peek().prev = tmp;
        }
        return head;
    }
    
    private void addNodes(Node node, Queue<Node> q){
        if(node == null)
            return;
        q.add(node);
        if(node.child != null){
            addNodes(node.child, q);
            node.child = null;
        }
        addNodes(node.next, q);
    }

    public Node flatten3(Node head) {
        if(head == null)
            return null;
        Stack<Node> stack = new Stack<>();
        flattenHelper(head, stack);
        Node result = new Node();
        Node r = result;
        while (!stack.isEmpty()){
            Node n = stack.pop();
            r.next = n;
            n.prev = r;
            n.next = null;
            r = n;
        }
        result.next.prev = null;
        return result.next;
    }

    private void flattenHelper(Node head, Stack<Node> stack) {
        if(head == null)
            return;
        flattenHelper(head.next, stack);
        if(head.child != null)
            flattenHelper(head.child, stack);
        head.next = head.prev = head.child = null;
        stack.push(head);

    }

    public Node flatten4(Node head) {
        if(head == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        flattenHelper4(head, q);
        Node result = new Node();
        Node r = result;
        while (!q.isEmpty()){
            Node polled = q.poll();
            r.next = polled;
            polled.prev = r;
            r = polled;
        }
        result.next.prev = null;
        return result.next;
    }

    private void flattenHelper4(Node head, Queue<Node> q) {
        if(head == null)
            return;
        q.add(head);
        if(head.child != null)
            flattenHelper4(head.child, q);
        flattenHelper4(head.next, q);
        head.prev = head.next = head.child = null;
    }
    
}
