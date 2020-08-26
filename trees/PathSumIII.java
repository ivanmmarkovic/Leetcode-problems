/*
437. Path Sum III
Medium

https://leetcode.com/problems/path-sum-iii/

Runtime: 20 ms, faster than 50.69% of Java online submissions for Path Sum III.
Memory Usage: 40.7 MB, less than 26.08% of Java online submissions for Path Sum III.

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

Accepted
218,710
Submissions
462,616

*/


class PathSumIII {

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
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int count = 0;
        count += pathSumHelper(root, 0, sum);
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        return count;
    }
    
    public int pathSumHelper(TreeNode root, int current, int target){
        if(root == null)
            return 0;
        current += root.val;
        int count = 0;
        if(current == target)
            count++;
        count += pathSumHelper(root.left, current, target);
        count += pathSumHelper(root.right, current, target);
        return count;
    }
}