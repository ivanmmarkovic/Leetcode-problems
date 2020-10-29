package trees;

import java.util.ArrayList;
import java.util.List;

/*
129. Sum Root to Leaf Numbers
Medium

https://leetcode.com/problems/sum-root-to-leaf-numbers/

Runtime: 1 ms, faster than 28.35% of Java online submissions for Sum Root to Leaf Numbers.
Memory Usage: 36.8 MB, less than 13.92% of Java online submissions for Sum Root to Leaf Numbers.

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

Accepted
297,312
Submissions
595,547

*/
public class SumRootToLeafNumbers {

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

	List<String> nums = new ArrayList<>();

	public int sumNumbers(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		int sum = 0;
		for (String num : nums) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}

	private void helper(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			nums.add(sb.toString());
			return;
		}
		helper(root.left, new StringBuilder(sb));
		helper(root.right, new StringBuilder(sb));
	}

}
