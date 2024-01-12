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
		int min = minAncestorDiffHelper(root, root.val);
		int max = maxAncestorDiffHelper(root, root.val);
		return Math.max(min, max);
	}

	public int maxAncestorDiffHelper(TreeNode root, int currentMaxValue) {
		if (root == null)
			return Integer.MIN_VALUE;
		int currentMaxDiff = currentMaxValue - root.val;

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

	/*
	public int maxAncestorDiff(TreeNode root) {
        int min = minAncestorDiffHelper(root, root.val, Integer.MIN_VALUE);
        int max = maxAncestorDiffHelper(root, root.val, Integer.MIN_VALUE);
        return Math.max(min, max);
    }


    public int maxAncestorDiffHelper(TreeNode root, int currentMaxValue, int currentMaxDiff) {
        if(root == null)
            return currentMaxDiff;
        currentMaxDiff = Math.max((currentMaxValue - root.val), currentMaxDiff);

        int left = maxAncestorDiffHelper(root.left, Math.max(currentMaxValue, root.val), currentMaxDiff);
        int right = maxAncestorDiffHelper(root.right, Math.max(currentMaxValue, root.val), currentMaxDiff);

        return Math.max(currentMaxDiff, Math.max(left, right));
    }

    public int minAncestorDiffHelper(TreeNode root, int currentMinValue, int currentMaxDiff) {
        if(root == null)
            return currentMaxDiff;
        currentMaxDiff = Math.max(Math.abs(currentMinValue - root.val), currentMaxDiff);

        int left = minAncestorDiffHelper(root.left, Math.min(currentMinValue, root.val), currentMaxDiff);
        int right = minAncestorDiffHelper(root.right, Math.min(currentMinValue, root.val), currentMaxDiff);

        return Math.max(currentMaxDiff, Math.max(left, right));
    }
	*/
}
