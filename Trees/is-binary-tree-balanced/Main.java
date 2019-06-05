

public class Main {

	public static void main(String[] args) {
		
		
		
	}
	
	public static int getHeight(BinaryTree bt) {
		int left = 0, right = 0;
		if(bt.leftChild != null)
			left += getHeight(bt.leftChild);
		if(bt.rightChild != null)
			right += getHeight(bt.rightChild);
		return Math.max(left, right) + 1;
	}
	public static boolean isBalanced(BinaryTree bt) {
		if(bt == null)
			return true;
		int left = bt.leftChild != null ? getHeight(bt.leftChild) : 0;
		int right = bt.rightChild != null ? getHeight(bt.rightChild) : 0;
		if(Math.abs(left - right) <= 1) {
			return isBalanced(bt.leftChild) && isBalanced(bt.rightChild);
		}
		else {
			return false;
		}
	}
}
