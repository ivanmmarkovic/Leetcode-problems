
public class Main {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(0, null, null, null);
		bt.insertRight(2);
		bt.getRightChild().insertLeft(5);
		bt.getRightChild().insertRight(6);
		
		bt.insertLeft(1);
		bt.getLeftChild().insertLeft(3);
		bt.getLeftChild().insertRight(4);
		
		bt.getLeftChild().getLeftChild().insertLeft(7);
		bt.getLeftChild().getRightChild().insertLeft(8);
		bt.getLeftChild().getRightChild().insertRight(9);
		
		System.out.println("Contains " + containsNode(bt, 4));
		System.out.println("Contains " + containsNode(bt, 40));
	}
	
	public static boolean containsNode(BinaryTree bt, int key) {
		if(bt.key == key)
			return true;
		
		boolean res1 = false, res2 = false;
		if(bt.leftChild != null)
			res1 = containsNode(bt.leftChild, key);
		if(bt.rightChild != null)
			res2 = containsNode(bt.rightChild, key);
		
		return res1 || res2;
	}
	
}
