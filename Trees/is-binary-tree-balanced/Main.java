

public class Main {

	public static void main(String[] args) {
		
		
		
	}
	
	public static boolean isBalanced(BinaryTree bt) {
		if(bt == null)
			return true;
		int left = getTreeHeight(bt.leftChild);
		int right = getTreeHeight(bt.rightChild);
		if(Math.abs(left - right) <= 1)
			return isBalanced(bt.leftChild) && isBalanced(bt.rightChild);
		else
			return false;
	}
	
	public static int getTreeHeight(BinaryTree bt) {
		if(bt == null)
			return 0;
		
		int leftHeight = getTreeHeight(bt.leftChild);
		int rightHeight = getTreeHeight(bt.rightChild);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
