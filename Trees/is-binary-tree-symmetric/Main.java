
public class Main {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(25);
		
		bt.leftChild = new BinaryTree(1);
		bt.leftChild.rightChild = new  BinaryTree(2);
		bt.leftChild.rightChild.rightChild = new  BinaryTree(3);
		
		bt.rightChild = new BinaryTree(1);
		bt.rightChild.leftChild = new BinaryTree(2);
		bt.rightChild.leftChild.leftChild = new BinaryTree(3);
		
		System.out.println(isSymmetric(bt));
	}
	
	public static boolean isSymmetric(BinaryTree bt) {
		return isSymmetricHelper(bt.leftChild, bt.rightChild);
	}
	
	public static boolean isSymmetricHelper(BinaryTree btLeft, BinaryTree btRight) {
		if(btLeft == null && btRight== null)
			return true;
		else if(btLeft == null || btRight == null)
			return false;
		else {
			return isSymmetricHelper(btLeft.leftChild, btRight.rightChild) &&
					isSymmetricHelper(btLeft.rightChild, btRight.leftChild);
		}
	}
