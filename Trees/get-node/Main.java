
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
		
		System.out.println("get node " + getNode(bt, 5).key);
		System.out.println("get node " + getNode(bt, 49));
		
	}
	
	public static BinaryTree getNode(BinaryTree bt, int key) {
		if(bt.key == key)
			return bt;
		BinaryTree tmp = null;
		if(bt.leftChild != null)
			tmp = getNode(bt.leftChild, key);
		if(tmp == null && bt.rightChild != null)
			tmp = getNode(bt.rightChild, key);
		
		return tmp;
	}

}
