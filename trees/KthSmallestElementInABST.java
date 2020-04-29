
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

230. Kth Smallest Element in a BST
Medium

Runtime: 1 ms, faster than 35.26% of Java online submissions for Kth Smallest Element in a BST.
Memory Usage: 39.8 MB, less than 6.42% of Java online submissions for Kth Smallest Element in a BST.

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
Accepted
323,717
Submissions
570,224
*/


class KthSmallestElementInABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> values = new ArrayList<Integer>();
        inorder(root, values);
        
        return values.get(k - 1);
        
    }
    
    public void inorder(TreeNode root, List<Integer> values){
        if(root != null){
            inorder(root.left, values);
            values.add(root.val);
            inorder(root.right, values);
        }
    }
}