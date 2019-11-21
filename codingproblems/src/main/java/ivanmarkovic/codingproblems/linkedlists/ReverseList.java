package ivanmarkovic.codingproblems.linkedlists;

import java.util.Stack;

public class ReverseList {
	
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}

	public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        
        ListNode result = new ListNode(stack.peek().val);
        stack.pop();
        ListNode tmp = result;
        while(!stack.isEmpty()){
            tmp.next = new ListNode(stack.pop().val); 
            tmp = tmp.next;
        }
        return result;
    }
}
