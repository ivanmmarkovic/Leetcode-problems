
public class ValidateBinarySearchTree {

	class TreeNode{
		int value;
		TreeNode left, right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isValid(TreeNode root, Integer min, Integer max) {
		if(root == null)
			return true;
		if(min != null && root.value <= min)
			return false;
		if(max != null && root.value >= max)
			return false;
		if(!isValid(root.left, min, root.value))
			return false;
		if(!isValid(root.right, root.value, max))
			return false;
		return true;
	}

	private boolean isValidII(TreeNode root, Integer min, Integer max) {
		if(root == null)
			return true;
		if(min != null && root.val <= min)
			return false;
		if(max != null && root.val >= max)
			return false;
		return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
	}
}
