package trees;

/*
1305. All Elements in Two Binary Search Trees
Medium

https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

Runtime: 13 ms, faster than 87.23% of Java online submissions for All Elements in Two Binary Search Trees.
Memory Usage: 42.7 MB, less than 6.19% of Java online submissions for All Elements in Two Binary Search Trees.

Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]


*/
import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

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
	
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        treeToList(root1, first);
        treeToList(root2, second);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < first.size() && j < second.size()){
            if(first.get(i) < second.get(j)){
                result.add(first.get(i));
                i++;
            }
            else{
                result.add(second.get(j));
                j++;
            }
        }
        while(i < first.size()){
            result.add(first.get(i));
            i++;
        }
        while(j < second.size()){
            result.add(second.get(j));
            j++;
        }
        return result;
    }
    
    private void treeToList(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        treeToList(root.left, list);
        list.add(root.val);
        treeToList(root.right, list);
    }
}
