
public class IsSymmetric {
	
	class TreeNode{
		int value;
		TreeNode left, right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetricHelper(root.left, root.right);
	}
	
	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		else if(left.value != right.value)
			return false;
		else {
			return isSymmetricHelper(left.left, right.right) && 
					isSymmetricHelper(left.right, right.left);
		}
	}
}
