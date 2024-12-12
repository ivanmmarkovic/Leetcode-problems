package trees;

import java.util.ArrayList;
import java.util.List;

/*
653. Two Sum IV - Input is a BST
Easy

https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

Runtime: 8 ms, faster than 11.99% of Java online submissions for Two Sum IV - Input is a BST.
Memory Usage: 40.4 MB, less than 34.63% of Java online submissions for Two Sum IV - Input is a BST.

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:

Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

Example 3:

Input: root = [2,1,3], k = 4
Output: true

Example 4:

Input: root = [2,1,3], k = 1
Output: false

Example 5:

Input: root = [2,1,3], k = 3
Output: true

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -104 <= Node.val <= 104
    root is guaranteed to be a valid binary search tree.
    -105 <= k <= 105

Accepted
226,714
Submissions
395,376
*/
public class TwoSumIVInputIsABST {
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
	
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> vals = new ArrayList<Integer>();
		traverse(root, vals);
		Set<Integer> set = new HashSet<Integer>(vals);
		for(Integer v: vals) {
			int d = k - v;
			if(d == v)
				continue;
			if(set.contains(d))
				return true;
		}
		return false;
	}

	private void traverse(TreeNode root, List<Integer> vals) {
		if(root == null)
			return;
		traverse(root.left, vals);
		vals.add(root.val);
		traverse(root.right, vals);
	}
	/*
	public boolean findTarget(TreeNode root, int k) {
		if(root == null)
			return false;
		List<Integer> nodes = new ArrayList<>();
		inorder(root, nodes);
		for(int i = 0; i < nodes.size(); i++){
			
			for(int j = i + 1; j < nodes.size(); j++){
				if(nodes.get(i) + nodes.get(j) == k)
					return true;
				if(nodes.get(i) + nodes.get(j) > k)
					break;
			}
		}
		return false;
	}

	private void inorder(TreeNode root, List<Integer> nodes) {
		if (root == null)
			return;
		inorder(root.left, nodes);
		nodes.add(root.val);
		inorder(root.right, nodes);
	}
	*/
}
