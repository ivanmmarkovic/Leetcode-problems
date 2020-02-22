public class TraversalPostorder {
	
	class TreeNode{
		int value;
		TreeNode left, right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void postorderTraversal(TreeNode root) {
		if(root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.println(root.value);
		}
	}
}
