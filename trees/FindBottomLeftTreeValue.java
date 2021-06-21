package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
513. Find Bottom Left Tree Value
Medium

https://leetcode.com/problems/find-bottom-left-tree-value/

Given the root of a binary tree, return the leftmost value in the last row of the tree.

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1

Accepted
136,600
Submissions
215,960

*/
public class FindBottomLeftTreeValue {
	
	class TreeNode {
		int val;
		TreeNode left, right;
	}
	
	public int findBottomLeftValue(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        inorder(root, levels, 0);
        if(levels.size() == 0)
            return -1;
        return levels.get(levels.size() - 1).get(0);
    }
    
    void inorder(TreeNode root, Map<Integer, List<Integer>> levels, int level){
        if(root == null)
            return;
        inorder(root.left, levels, level + 1);
        if(!levels.containsKey(level))
            levels.put(level, new ArrayList<>());
        levels.get(level).add(root.val);
        inorder(root.right, levels, level + 1);
    }
	
}
