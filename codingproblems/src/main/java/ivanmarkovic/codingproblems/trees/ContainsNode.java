package ivanmarkovic.codingproblems.trees;

public class ContainsNode {
	
	public static boolean containsNode(TreeNode node, int key) {
		if(node == null)
			return false;
		if(node.key == key)
			return true;
		boolean contains = containsNode(node.leftChild, key);
		if(!contains)
			contains = containsNode(node.rightChild, key);
		return contains;
	}

}
