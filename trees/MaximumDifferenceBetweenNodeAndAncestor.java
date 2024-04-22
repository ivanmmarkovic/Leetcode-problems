package trees;

/*
1026. Maximum Difference Between Node and Ancestor
Medium

https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

Runtime 0ms Beats100.00%of users with Java
Memory 42.54MB Beats5.54%of users with Java


Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

 

Example 1:

Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Example 2:

Input: root = [1,null,2,null,0,3]
Output: 3

 

Constraints:

    The number of nodes in the tree is in the range [2, 5000].
    0 <= Node.val <= 105

Seen this question in a real interview before?
1/4
Yes
No
Accepted
303.8K
Submissions
388.9K
Acceptance Rate
78.1%
*/


public class MaximumDifferenceBetweenNodeAndAncestor {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public int maxAncestorDiff(TreeNode root) {
		return maxHelper(root, root.val, root.val);
	}

	public int maxHelper(TreeNode root, int min, int max){
		if(root == null)
			return 0;
		int vLeft = maxHelper(root.left, Math.min(min, root.val), Math.max(max, root.val));
		int vRight = maxHelper(root.right, Math.min(min, root.val), Math.max(max, root.val));
		int current = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
		return Math.max(current, Math.max(vLeft, vRight));
	}
	
	/*
	public int maxAncestorDiff(TreeNode root) {
		int min = minAncestorDiffHelper(root, root.val);
		int max = maxAncestorDiffHelper(root, root.val);
		return Math.max(min, max);
	}

	public int maxAncestorDiffHelper(TreeNode root, int currentMaxValue) {
		if (root == null)
			return Integer.MIN_VALUE;
		int currentMaxDiff = Math.abs(currentMaxValue - root.val);

		int left = maxAncestorDiffHelper(root.left, Math.max(currentMaxValue, root.val));
		int right = maxAncestorDiffHelper(root.right, Math.max(currentMaxValue, root.val));

		return Math.max(currentMaxDiff, Math.max(left, right));
	}

	public int minAncestorDiffHelper(TreeNode root, int currentMinValue) {
		if (root == null)
			return Integer.MIN_VALUE;
		int currentMaxDiff = Math.abs(currentMinValue - root.val);

		int left = minAncestorDiffHelper(root.left, Math.min(currentMinValue, root.val));
		int right = minAncestorDiffHelper(root.right, Math.min(currentMinValue, root.val));

		return Math.max(currentMaxDiff, Math.max(left, right));
	}
	*/


	/*
	private static int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        trackMaxValue(root, null);
		trackMinValue(root, null);
		int v = maxDiff;
		maxDiff = Integer.MIN_VALUE;
		return v;
	}

	private void trackMaxValue(TreeNode root, Integer max) {
		if(root == null)
			return;
		if(max == null)
			max = root.val;
		else {
			int currentDiff = Math.abs(max - root.val);
			maxDiff = Math.max(currentDiff, maxDiff);
			max = Math.max(max, root.val);
		}
		trackMaxValue(root.left, max);
		trackMaxValue(root.right, max);
	}
	
	private void trackMinValue(TreeNode root, Integer min) {
		if(root == null)
			return;
		if(min == null)
			min = root.val;
		else {
			int currentDiff = Math.abs(min - root.val);
			maxDiff = Math.max(currentDiff, maxDiff);
			min = Math.min(min, root.val);
		}
		trackMinValue(root.left, min);
		trackMinValue(root.right, min);
    }
	*/
}
