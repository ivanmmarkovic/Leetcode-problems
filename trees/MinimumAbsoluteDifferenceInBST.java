package trees;

import java.util.ArrayList;
import java.util.List;

/*
530. Minimum Absolute Difference in BST
Easy

https://leetcode.com/problems/minimum-absolute-difference-in-bst/

Runtime: 4 ms, faster than 17.04% of Java online submissions for Minimum Absolute Difference in BST.
Memory Usage: 43 MB, less than 8.79% of Java online submissions for Minimum Absolute Difference in BST.

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 105

 

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
Accepted
133,296
Submissions
239,254
*/
public class MinimumAbsoluteDifferenceInBST {

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

	public int getMinimumDifference(TreeNode root) {
		if(root == null)
			return 0;
		List<Integer> vals = new ArrayList<Integer>();
		traverse(root, vals);
		
		if(vals.size() == 1)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < vals.size() - 1; i++) {
			min = Math.min(min, Math.abs(vals.get(i) - vals.get(i + 1)));
		}
		
		return min;
	}

	private void traverse(TreeNode root, List<Integer> vals) {
		if(root == null)
			return;
		traverse(root.left, vals);
		vals.add(root.val);
		traverse(root.right, vals);
	}
}
