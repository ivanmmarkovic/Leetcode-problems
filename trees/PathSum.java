
/*
https://leetcode.com/problems/path-sum/ 
easy

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
		return pathSumHelper(root, 0, sum);
	}
	
	public boolean pathSumHelper(TreeNode root, int currentSum, int targetSum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null) {
			if(root.val + currentSum == targetSum)
				return true;
			else
				return false;
		}
		boolean exists = pathSumHelper(root.left, currentSum + root.val, targetSum);
		if(!exists)
			exists = pathSumHelper(root.right, currentSum + root.val, targetSum);
		return exists;
	}

}
