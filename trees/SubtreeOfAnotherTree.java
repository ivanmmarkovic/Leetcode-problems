

/*
572. Subtree of Another Tree
Easy

https://leetcode.com/problems/subtree-of-another-tree/

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:

   4 
  / \
 1   2

Return true, because t has the same structure and node values with a subtree of s.

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given tree t:

   4
  / \
 1   2

Return false.

Accepted
185,613
Submissions
424,138 

Runtime: 5 ms, faster than 96.08% of Java online submissions for Subtree of Another Tree.
Memory Usage: 38.9 MB, less than 91.70% of Java online submissions for Subtree of Another Tree.
*/
public class SubtreeOfAnotherTree {
	
	class TreeNode{
		int value;
		TreeNode left, right;
	}
	
	public boolean isSubtree(TreeNode root, TreeNode subtree) {
		if(root == null && subtree == null)
			return true;
        if(root == null || subRoot == null)
            return false;
		boolean matches = helper(root, subtree);
		if(!matches)
			matches = isSubtree(root.right, subtree) || isSubtree(root.left, subtree);
		return matches;
	}

	private boolean helper(TreeNode root, TreeNode subtree) {
		if(root == null && subtree == null)
			return true;
		if(root == null)
			return false;
		if(subtree == null)
			return false;
		if(root.value != subtree.value)
			return false;
		return helper(root.left, subtree.left) && helper(root.right, subtree.right);
	}
	
}
