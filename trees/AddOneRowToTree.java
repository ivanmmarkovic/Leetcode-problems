package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
623. Add One Row to Tree
Medium

https://leetcode.com/problems/add-one-row-to-tree/

Runtime: 2 ms, faster than 18.58% of Java online submissions for Add One Row to Tree.
Memory Usage: 42.4 MB, less than 71.65% of Java online submissions for Add One Row to Tree.

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

    Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
    cur's original left subtree should be the left subtree of the new left subtree root.
    cur's original right subtree should be the right subtree of the new right subtree root.
    If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

 

Example 1:

Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]

Example 2:

Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    The depth of the tree is in the range [1, 104].
    -100 <= Node.val <= 100
    -105 <= val <= 105
    1 <= depth <= the depth of tree + 1

Accepted
80,189
Submissions
149,329

*/
public class AddOneRowToTree {

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

	
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if(root == null)
			return root;
		Map<Integer, List<TreeNode>> levels = new HashMap<>();
		traverse(root, levels, 1);
		if (depth == 1) {
			TreeNode r = new TreeNode(val, root, null);
			return r;
		}
		else if (depth == levels.size() + 1) {
			List<TreeNode> nodes = levels.get(levels.size());
			for(TreeNode node: nodes) {
				node.left = new TreeNode(val);
				node.right = new TreeNode(val);
			}
			return root;
		}
		else {
			List<TreeNode> nodes = levels.get(depth - 1);
			for(TreeNode node: nodes) {
				if(node.left != null)
					node.left = new TreeNode(val, node.left, null);
				else 
					node.left = new TreeNode(val);
				if(node.right != null)
					node.right = new TreeNode(val, null, node.right);
				else 
					node.right = new TreeNode(val);
			}
			return root;
		}
		
	}

	/* This solution works
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if(root == null)
			return null;
		Map<Integer, List<TreeNode>> levels = new HashMap<>();
		traverse(levels, root, 1);
		if(depth == 1) {
			TreeNode node = new TreeNode(val, root, null);
			return node;
		}
		else if(depth > levels.size() + 1)
			return root;
		else {
			List<TreeNode> nodes = levels.get(depth - 1);
			for(TreeNode node: nodes) {
				if(node.left != null) 
					node.left = new TreeNode(val, node.left, null);
				else
					node.left = new TreeNode(val);
				if(node.right != null)
					node.right = new TreeNode(val, null, node.right);
				else
					node.right = new TreeNode(val);
			}
			return root;
		}
	}
	*/
	
	private void traverse(TreeNode root, Map<Integer, List<TreeNode>> levels, int level) {
		if(root == null)
			return;
		
		traverse(root.left, levels, level + 1);
		if(!levels.containsKey(level))
			levels.put(level, new ArrayList<>());
		levels.get(level).add(root);
		traverse(root.right, levels, level + 1);
		
	}
	
	
	
	/*
	 
	Runtime: 2 ms, faster than 23.62% of Java online submissions for Add One Row to Tree.
	Memory Usage: 45.7 MB, less than 7.98% of Java online submissions for Add One Row to Tree. 
	
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (root == null)
			return null;
		List<List<TreeNode>> rows = traverse(root);
		if (depth > rows.size() + 1)
			return root;
		List<TreeNode> current;
		if (depth == rows.size() + 1) {
			current = rows.get(rows.size() - 1);
			for (TreeNode node : current) {
				node.left = new TreeNode(val, null, null);
				node.right = new TreeNode(val, null, null);
			}
		} else if (depth == 1) {
			TreeNode node = new TreeNode(val, root, null);
			return node;
		} else {
			current = rows.get(depth - 1);
			if (current == null)
				return root;
			for (TreeNode node : current) {
				if (node.left != null) {
					node.left = new TreeNode(val, node.left, null);
				} else
					node.left = new TreeNode(val, null, null);
				if (node.right != null) {
					node.right = new TreeNode(val, null, node.right);
				} else
					node.right = new TreeNode(val, null, null);
			}
		}

		return root;

	}

	private List<List<TreeNode>> traverse(TreeNode root) {
		List<List<TreeNode>> rows = new ArrayList<>();
		rows.add(null);
		List<TreeNode> current = new ArrayList<>();
		current.add(root);
		rows.add(current);
		while (true) {
			current = new ArrayList<>();
			List<TreeNode> prev = rows.get(rows.size() - 1);
			for (TreeNode node : prev) {
				if (node.left != null)
					current.add(node.left);
				if (node.right != null)
					current.add(node.right);
			}
			if (current.size() == 0)
				break;
			rows.add(current);

		}
		return rows;
	}
	*/

}
