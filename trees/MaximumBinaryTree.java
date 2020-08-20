/*
654. Maximum Binary Tree
Medium

https://leetcode.com/problems/maximum-binary-tree/

Runtime: 5 ms, faster than 30.99% of Java online submissions for Maximum Binary Tree.
Memory Usage: 52.2 MB, less than 10.28% of Java online submissions for Maximum Binary Tree.

 Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:

Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1

Note:

    The size of the given array will be in the range [1,1000].

Accepted
136,067
Submissions
170,214

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTreeHelper(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int index = indexOfMaxValue(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTreeHelper(nums, start, index - 1);
        node.right = constructMaximumBinaryTreeHelper(nums, index + 1, end);
        return node;
    }
    
    private int indexOfMaxValue(int nums[], int start, int end){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        return index;  
    }
    
}