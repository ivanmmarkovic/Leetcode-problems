package ivanmarkovic.codingproblems.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PreorderTraversal {
	
	// using Stack
	public static void preorderTraversalStack(TreeNode node) {
		if(node == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		TreeNode tmp;
		while (!stack.isEmpty()) {
			tmp = stack.pop();
			if(tmp.rightChild != null)
				stack.push(tmp.rightChild);
			if(tmp.leftChild != null)
				stack.push(tmp.leftChild);
			System.out.println(tmp.key);
		}
	}
	
	// using Deque
	public static void preorderTraversalDeque(TreeNode node) {
		if(node == null)
			return;
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.addFirst(node);
		TreeNode tmp;
		while(!deque.isEmpty()) {
			tmp = deque.removeFirst();
			if(tmp.rightChild != null)
				deque.addFirst(tmp.rightChild);
			if(tmp.leftChild != null)
				deque.addFirst(tmp.leftChild);
			System.out.println(tmp.key);
		}
	}

}
