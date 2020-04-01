
/*

################## 100 and 100

https://leetcode.com/problems/invert-binary-tree/

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/
public class InvertBinaryTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode result = new TreeNode(root.val);
        
        result.right = this.invertTree(root.left);
        result.left = this.invertTree(root.right);
        
        return result;
    }

}
