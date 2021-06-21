package trees;

/*
617. Merge Two Binary Trees
Easy

https://leetcode.com/problems/merge-two-binary-trees/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
Memory Usage: 39.6 MB, less than 18.84% of Java online submissions for Merge Two Binary Trees.

You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
 
*/

public class MergeTwoBinaryTrees {

	class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int i) {
			this.val = i;
		}
	}
	
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
        
    }
}
