

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
637. Average of Levels in Binary Tree
Easy

https://leetcode.com/problems/average-of-levels-in-binary-tree/

Runtime: 3 ms, faster than 25.90% of Java online submissions for Average of Levels in Binary Tree.
Memory Usage: 41.8 MB, less than 12.13% of Java online submissions for Average of Levels in Binary Tree.

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:

    The range of node's value is in the range of 32-bit signed integer.

Accepted
142,222
Submissions
222,589
*/
public class AverageOfLevelsInBinaryTree {

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

	HashMap<Integer, List<Integer>> levels = new HashMap<>();

	public List<Double> averageOfLevels(TreeNode root) {
		traverseTree(root, 0);
		List<Double> result = new ArrayList<>();
		for (Integer key : levels.keySet())
			result.add(key, averageOfList(levels.get(key)));
		return result;
	}

	private void traverseTree(TreeNode root, int level) {
		if (root == null)
			return;
		traverseTree(root.left, level + 1);
		if (!levels.containsKey(level))
			levels.put(level, new ArrayList<>());
		levels.get(level).add(root.val);
		traverseTree(root.right, level + 1);
	}

	private double averageOfList(List<Integer> list) {
		double sum = 0.0;
		for (Integer e : list)
			sum += e;
		return sum / list.size();
	}
}

