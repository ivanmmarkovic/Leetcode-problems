
/*
1302. Deepest Leaves Sum
Medium

https://leetcode.com/problems/deepest-leaves-sum

Runtime: 1 ms, faster than 79.91% of Java online submissions for Deepest Leaves Sum.
Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.

Given a binary tree, return the sum of values of its deepest leaves.


Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

 

Constraints:

    The number of nodes in the tree is between 1 and 10^4.
    The value of nodes is between 1 and 100.

Accepted
29,010
Submissions
34,756

*/
class DeepestLeavesSum {
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
 	}
	public int deepestLeavesSum(TreeNode root) {
        return helper(root, 1, maxDepth(root));
    }
    
    public int helper(TreeNode root, int currentLevel, int maxLevel){
        if(root == null)
            return 0;
        if(currentLevel == maxLevel)
            return root.val;
        int sum = 0;
        sum += helper(root.left, currentLevel + 1, maxLevel);
        sum += helper(root.right, currentLevel + 1, maxLevel);
        return sum;
    }
    
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}