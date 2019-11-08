package ivanmarkovic.codingproblems.trees;

public class ValidateBinaryTree {
	
	public static boolean isValid(TreeNode node) {
		return isValidHelper(node, null, null);
	}
	
	public static boolean isValidHelper(TreeNode node, Integer min, Integer max) {
		if(node == null)
			return true;
		if(min != null && node.key <= min)
			return false;
		if(max != null && node.key >= max)
			return false;
		if(!isValidHelper(node.leftChild, min, node.key))
			return false;
		if(!isValidHelper(node.rightChild, node.key, max))
			return false;
		return true;
	}

}
