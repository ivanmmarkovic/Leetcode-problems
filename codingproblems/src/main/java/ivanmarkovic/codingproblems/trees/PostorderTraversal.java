package ivanmarkovic.codingproblems.trees;

public class PostorderTraversal {
	
	public static void postorderTraversal(TreeNode node) {
		if(node != null) {
			postorderTraversal(node.leftChild);
			postorderTraversal(node.rightChild);
			System.out.println(node.key);
		}
	}

}
