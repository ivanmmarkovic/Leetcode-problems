package ivanmarkovic.codingproblems.trees;

public class GetNode {
	
	public static TreeNode getNode(TreeNode node, int key) {
		if(node == null)
			return null;
		if(node.key == key)
			return node;
		TreeNode tmp = getNode(node.leftChild, key);
		if(tmp == null)
			tmp = getNode(node.rightChild, key);
		return tmp;
		
	}

}
