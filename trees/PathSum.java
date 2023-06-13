package trees;

/*
https://leetcode.com/problems/path-sum/ 
easy

Runtime0 ms
Beats
100%

Memory43.5 MB
Beats
29.20%


Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class PathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
public boolean pathFound(TreeNode root,int sum) {
		
		return pathFoundHelper(root, sum, 0);
		
	}

	private boolean pathFoundHelper(TreeNode root, int sum, int current) {
		if(root == null)
			return false;
		current += root.val;
		if(root.left == null && root.right == null) {
			if(current == sum)
				return true;
			return false;
		}
		return pathFoundHelper(root.left, sum, current) || pathFoundHelper(root.right, sum, current);
	}

}
