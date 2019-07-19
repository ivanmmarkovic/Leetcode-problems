import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(25);
		
		bt.leftChild = new BinaryTree(115);
		bt.leftChild.leftChild = new  BinaryTree(200);
		
		bt.rightChild = new BinaryTree(1000);
		bt.rightChild.leftChild = new BinaryTree(1);
		bt.rightChild.rightChild = new BinaryTree(2);
		
		levelOrderTraversal(bt);
	}
	
	public  static void levelOrderTraversal(BinaryTree bt) {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(bt);
		BinaryTree dequeued;
		while(!queue.isEmpty()) {
			dequeued = queue.poll();
			System.out.print(dequeued.key + ", ");
			if(dequeued.leftChild != null)
				queue.add(dequeued.leftChild);
			if(dequeued.rightChild != null)
				queue.add(dequeued.rightChild);
		}
	}

}