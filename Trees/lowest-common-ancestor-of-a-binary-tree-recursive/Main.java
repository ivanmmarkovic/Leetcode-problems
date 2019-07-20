
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
		

	}
	
	public static BinaryTree lowestCommonAncestor(BinaryTree root, BinaryTree bt1, BinaryTree bt2) {
		
		return lowestCommonAncestorHelper(root, bt1, bt2);
		
	}
	
	public static BinaryTree lowestCommonAncestorHelper(BinaryTree root, BinaryTree bt1, BinaryTree bt2) {
		if(root == null)
			return null;
		if(root.key == bt1.key || root.key == bt2.key)
			return root;
		
		BinaryTree leftTree = lowestCommonAncestorHelper(root.leftChild, bt1, bt2);
		BinaryTree rightTree = lowestCommonAncestorHelper(root.rightChild, bt1, bt2);
		if(leftTree != null && rightTree != null)
			return root;
		else if(leftTree == null)
			return rightTree;
		else
			return leftTree;
	}
}