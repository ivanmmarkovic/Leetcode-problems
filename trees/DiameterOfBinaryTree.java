package trees;

/*
543. Diameter of Binary Tree
Easy

https://leetcode.com/problems/diameter-of-binary-tree/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
Memory Usage: 39 MB, less than 29.85% of Java online submissions for Diameter of Binary Tree.


Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100


*/
public class DiameterOfBinaryTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	private static int diameter = 0; 
    public int diameterOfBinaryTree(TreeNode root) {
    	helper(root);
    	int r = diameter;
    	diameter = 0;
    	return r;
	}
    
    private int helper(TreeNode root) {
		if(root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}

}
