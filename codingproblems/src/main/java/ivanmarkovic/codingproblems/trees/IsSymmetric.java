package ivanmarkovic.codingproblems.trees;

public class IsSymmetric {
	
	public static boolean isSymmetric(TreeNode node) {
		return isSymmetricHelper(node.leftChild, node.rightChild);
	}
	
	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		else if(left.key == right.key)
			return isSymmetricHelper(left.leftChild, right.rightChild) && isSymmetricHelper(left.rightChild, right.leftChild);
		else
			return false;
	}

}
