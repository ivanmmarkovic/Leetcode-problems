package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
103. Binary Tree Zigzag Level Order Traversal
Medium

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Runtime: 2 ms, faster than 33.57% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 39.2 MB, less than 52.83% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100

Accepted
642,308
Submissions
1,217,105

*/
public class BinaryTreeZigzagLevelOrderTraversal {

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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		Map<Integer, List<Integer>> levels = new HashMap<>();
		traverse(root, levels, 0);
		List<List<Integer>> zigzag = new ArrayList<>(levels.size());
		for (Integer level : levels.keySet()) {
			if (level % 2 != 0) {
				Collections.reverse(levels.get(level));
			}
			zigzag.add(level, levels.get(level));
		}
		return zigzag;

	}

	private void traverse(TreeNode root, Map<Integer, List<Integer>> levels, int level) {
		if (root == null)
			return;
		traverse(root.left, levels, level + 1);
		if (!levels.containsKey(level)) {
			levels.put(level, new ArrayList<>());
		}
		levels.get(level).add(root.val);
		traverse(root.right, levels, level + 1);
	}

}
