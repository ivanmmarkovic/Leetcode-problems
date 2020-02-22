
public class TraversalInorder {

	class TreeNode{
		int value;
		TreeNode left, right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void inorderTraversal(TreeNode root) {
		if(root != null) {
			inorderTraversal(root.left);
			System.out.println(root.value);
			inorderTraversal(root.right);
		}
	}
}