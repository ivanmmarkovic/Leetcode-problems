import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class VirtualMachineError {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(20);
		
		bt.leftChild = new BinaryTree(5);
		bt.leftChild.leftChild = new  BinaryTree(17);
		bt.leftChild.rightChild = new  BinaryTree(14);
		
		bt.leftChild.leftChild.rightChild = new  BinaryTree(4);
		
		bt.rightChild = new BinaryTree(19);
		bt.rightChild.leftChild = new BinaryTree(10);
		bt.rightChild.rightChild = new BinaryTree(3);
		
		postorderTraversalNoRecursion(bt);
		
	}
	
	public static void postorderTraversalNoRecursion(BinaryTree bt) {
		/*
		 * 1. add  to dequeue
		 * 2. start while loop
		 * 3. remove it
		 * 4. add right as first
		 * 5. add left as first
		 */
		Deque<BinaryTree> dequeue = new LinkedList<BinaryTree>();
		dequeue.add(bt);
		BinaryTree removed;
		while(!dequeue.isEmpty()) {
			removed = dequeue.removeFirst();
			System.out.print(removed.key + ", ");
			if(removed.rightChild != null)
				dequeue.addFirst(removed.rightChild);
			if(removed.leftChild != null)
				dequeue.addFirst(removed.leftChild);
		}
	}
	

}
