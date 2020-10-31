

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
107. Binary Tree Level Order Traversal II
Easy

Runtime: 1 ms, faster than 83.99% of Java online submissions for Binary Tree Level Order Traversal II.
Memory Usage: 38.9 MB, less than 10.09% of Java online submissions for Binary Tree Level Order Traversal II.

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

Accepted
381,203
Submissions
702,348

*/
public class BinaryTreeLevelOrderTraversalII {
	
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        traverseTree(root, 0);
        
        List<List<Integer>> result = new ArrayList<>();
        for(Integer key: levels.keySet())
            result.add(key, levels.get(key));
        Collections.reverse(result);
        return result;
    }
    
    private void traverseTree(TreeNode root, int level){
        if(root == null)
            return;
        traverseTree(root.left, level + 1);
        if(!levels.containsKey(level))
            levels.put(level, new ArrayList<>());
        levels.get(level).add(root.val);
        traverseTree(root.right, level + 1);
    }

}

