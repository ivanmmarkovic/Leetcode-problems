
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(20);
		
		bt.leftChild = new BinaryTree(5);
		bt.leftChild.leftChild = new  BinaryTree(17);
		bt.leftChild.rightChild = new  BinaryTree(14);
		
		bt.leftChild.leftChild.rightChild = new  BinaryTree(4);
		
		bt.rightChild = new BinaryTree(19);
		bt.rightChild.leftChild = new BinaryTree(10);
		bt.rightChild.rightChild = new BinaryTree(3);
		
		preorderTraversalNoRecursion(bt);
		
	}
	
	public static void preorderTraversalNoRecursion(BinaryTree bt) {
		/*
		 * 1. add  to stack
		 * 2. start while loop
		 * 3. pop it
		 * 4. add right
		 * 5. add left
		 */
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		stack.add(bt);
		BinaryTree poped;
		while(!stack.isEmpty()) {
			poped = stack.pop();
			if(poped.rightChild != null)
				stack.push(poped.rightChild);
			if(poped.leftChild != null)
				stack.push(poped.leftChild);
			System.out.print(poped.key + ", ");
		}
	}
	

}
