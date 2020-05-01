/*
102. Binary Tree Level Order Traversal
Medium

https://leetcode.com/problems/binary-tree-level-order-traversal/

Runtime: 1 ms, faster than 56.60% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 39.9 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
Accepted
560,164
Submissions
1,055,766

*/

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        int depth = maxDepth(root);
        HashMap<Integer, List<Integer>> levels = new HashMap<>();
        for(int i = 1; i <= depth; i++){
            levels.put(i, new ArrayList<>());
        }
        
        traversal(root, 1, levels);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= depth; i++){
            result.add(levels.get(i));
        }
        return result;
        
    }
    
    public void traversal(TreeNode node, int currentLevel, HashMap<Integer, List<Integer>> levels){
        if(node == null)
            return;
        List<Integer> tmpList = levels.get(currentLevel);
        tmpList.add(node.val);
        levels.put(currentLevel, tmpList);
        traversal(node.left, currentLevel + 1, levels);
        traversal(node.right, currentLevel + 1, levels);
    }
    
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
