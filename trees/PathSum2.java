
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*

https://leetcode.com/problems/path-sum-ii/
medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

*/


public class PathSum2 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<Integer>();
        helper(root, result, currentList, 0, sum);
        return result;
    }

	private void helper(TreeNode root, List<List<Integer>> result, List<Integer> currentList, int currentSum, int targetSum) {
		if(root == null)
			return;
		currentSum += root.val;
		currentList.add(root.val);
		if(root.left == null && root.right == null) {
			if(currentSum == targetSum)
				result.add(currentList);
			return;
		}
		List<Integer> leftList = currentList.stream().collect(Collectors.toList());
		List<Integer> rightList = currentList.stream().collect(Collectors.toList());
		helper(root.left, result, leftList, currentSum, targetSum);
		helper(root.right, result, rightList, currentSum, targetSum);
    }

}
