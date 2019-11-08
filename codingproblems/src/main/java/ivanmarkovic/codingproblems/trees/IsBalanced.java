package ivanmarkovic.codingproblems.trees;

public class IsBalanced {
	
	public static boolean isBalanced(TreeNode node) {
		if(node == null)
			return true;
		int left = getTreeHeight(node.leftChild);
		int right = getTreeHeight(node.rightChild);
		if(Math.abs(left - right) <= 1)
			return isBalanced(node.leftChild) && isBalanced(node.rightChild);
		else
			return false;
	}
	
	public static int getTreeHeight(TreeNode node) {
		if(node == null)
			return 0;
		int left = 0, right = 0;
		if(node.leftChild != null)
			left = getTreeHeight(node.leftChild);
		if(node.rightChild != null)
			right = getTreeHeight(node.rightChild);
		return Math.max(left, right) + 1;
		
	}

}
