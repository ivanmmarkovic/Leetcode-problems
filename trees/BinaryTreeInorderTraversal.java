/*
https://leetcode.com/problems/binary-tree-inorder-traversal/

94. Binary Tree Inorder Traversal
Medium

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
*/
class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        helper(list, root);
        return list;
            
    }
    
    public void helper(List<Integer> list, TreeNode node){
        if(node == null)
            return;
        helper(list, node.left);
        list.add(node.val);
        helper(list, node.right);
    }
}