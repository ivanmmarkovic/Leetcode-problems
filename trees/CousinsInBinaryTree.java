package trees;

import java.util.HashMap;
import java.util.Map;

/*

993. Cousins in Binary Tree
Easy

https://leetcode.com/problems/cousins-in-binary-tree/submissions/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
Memory Usage: 36.7 MB, less than 62.86% of Java online submissions for Cousins in Binary Tree.

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

 

Example 1:

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

 

Constraints:

    The number of nodes in the tree is in the range [2, 100].
    1 <= Node.val <= 100
    Each node has a unique value.
    x != y
    x and y are exist in the tree.

Accepted
181,300
Submissions
339,323

*/
public class CousinsInBinaryTree {

	public class TreeNode {
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

	public boolean isCousins(TreeNode root, int x, int y) {
		
		Map<Integer, Integer> prevs = new HashMap<>();
		Map<Integer, Integer> levels = new HashMap<>();
		
		traverse(root, prevs, levels, null, 0);
		
		return prevs.get(x) != prevs.get(y) && levels.get(x) == levels.get(y); 
		
	}

	private void traverse(TreeNode root, Map<Integer, Integer> prevs, Map<Integer, Integer> levels, TreeNode parent, int level) {
		if(root == null)
			return;
		levels.put(root.val, level);
		prevs.put(root.val, parent == null ? null : parent.val);
		traverse(root.left, prevs, levels, root, level + 1);
		traverse(root.right, prevs, levels, root, level + 1);
	}

}
