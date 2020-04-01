
/*

110. Balanced Binary Tree
Easy

https://leetcode.com/problems/balanced-binary-tree/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Balanced Binary Tree.
Memory Usage: 40.1 MB, less than 62.96% of Java online submissions for Balanced Binary Tree.


Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

Return false.
Accepted
411,312
Submissions
963,021

*/
public class BalancedBinaryTree {

	class TreeNode {
		int value;
		TreeNode left, right;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (Math.abs(left - right) <= 1)
			return isBalanced(root.left) && isBalanced(root.right);
		else
			return false;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		else {
			int left = getHeight(root.left);
			int right = getHeight(root.right);
			return Math.max(left, right) + 1;
		}
	}
}
