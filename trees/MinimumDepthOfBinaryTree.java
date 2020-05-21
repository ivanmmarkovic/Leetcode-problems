package trees;
/*
111. Minimum Depth of Binary Tree
Easy

https://leetcode.com/problems/minimum-depth-of-binary-tree/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
Memory Usage: 41.3 MB, less than 6.25% of Java online submissions for Minimum Depth of Binary Tree.

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.
Accepted
386,378
Submissions
1,048,329
    
 */
class MinimumDepthOfBinaryTree {


	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1 + minDepth(root.right);
        if(root.right == null)
            return 1 + minDepth(root.left);
        int min = 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return min + Math.min(left, right);
    }

}