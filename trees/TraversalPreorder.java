
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TraversalPreorder {
	
	class TreeNode{
		int value;
		TreeNode left, right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void preorderTraversalRecursive(TreeNode root) {
		if(root != null) {
			System.out.println(root.value);
			preorderTraversalRecursive(root.left);
			preorderTraversalRecursive(root.right);
		}
	}
	// Stack
	public static void preorderTraversalIterative(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode current;
		while (!stack.isEmpty()) {
			current = stack.pop();
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
			System.out.println(current.value);
		}
	}
	
	public static void preorderTraversalIterative2(TreeNode root) {
		if(root == null)
			return;
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(root);
		TreeNode current;
		while (!deque.isEmpty()) {
			current = deque.removeFirst();
			if(current.right != null)
				deque.addFirst(root.right);
			if(current.left != null)
				deque.addFirst(root.left);
			System.out.println(current.value);
		}
	}
	
}
