
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
515. Find Largest Value in Each Tree Row
Medium

https://leetcode.com/problems/find-largest-value-in-each-tree-row/

Runtime: 6 ms, faster than 5.78% of Java online submissions for Find Largest Value in Each Tree Row.
Memory Usage: 43 MB, less than 5.01% of Java online submissions for Find Largest Value in Each Tree Row.

You need to find the largest value in each row of a binary tree.

Example:

Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

Accepted
105,809
Submissions
173,017

*/

class FindLargestValueInEachTreeRow {

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

    public List<Integer> largestValues(TreeNode root) {
        HashMap<Integer, List<Integer>> rows = new HashMap<>();
        getAllLevels(root, 0, rows);
        List<Integer> vals = new ArrayList<>();
        for(Integer index: rows.keySet())
            vals.add(index, Collections.max(rows.get(index)));
        return vals;
    }
    
    private void getAllLevels(TreeNode root, int level, HashMap<Integer, List<Integer>> rows){
        if(root == null)
            return;
        if(!rows.containsKey(level))
            rows.put(level, new ArrayList<Integer>());
        rows.get(level).add(root.val);
        getAllLevels(root.left, level + 1, rows);
        getAllLevels(root.right, level + 1, rows);
    }
}