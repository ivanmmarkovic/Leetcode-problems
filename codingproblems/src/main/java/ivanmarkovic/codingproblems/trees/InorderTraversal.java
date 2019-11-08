package ivanmarkovic.codingproblems.trees;

public class InorderTraversal {
	
	public static void inorderTraversal(TreeNode node) {
		if(node != null) {
			inorderTraversal(node.leftChild);
			System.out.println(node.key);
			inorderTraversal(node.rightChild);
		}
	}

}
