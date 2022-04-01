package trees;

import java.util.ArrayList;
import java.util.List;

/*
897. Increasing Order Search Tree
Easy

https://leetcode.com/problems/increasing-order-search-tree/


Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
Memory Usage: 42 MB, less than 27.36% of Java online submissions for Increasing Order Search Tree.
 

Example 1:

Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:

Input: root = [5,1,7]
Output: [1,null,5,null,7]

 

Constraints:

    The number of nodes in the given tree will be in the range [1, 100].
    0 <= Node.val <= 1000

Accepted
165,586
Submissions
217,464



*/
public class IncreasingOrderSearchTree {
	
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
	
	public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        TreeNode tmp = new TreeNode(0), t = tmp;
        for(Integer v: vals){
            t.right = new TreeNode(v);
            t = t.right;
        }
        return tmp.right;
    }
    
    private void inorder(TreeNode root, List<Integer> vals){
        if(root == null)
            return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }

}
