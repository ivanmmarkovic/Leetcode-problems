
/*

429. N-ary Tree Level Order Traversal
Medium

https://leetcode.com/problems/n-ary-tree-level-order-traversal/

Runtime: 4 ms, faster than 18.74% of Java online submissions for N-ary Tree Level Order Traversal.
Memory Usage: 44.8 MB, less than 5.11% of Java online submissions for N-ary Tree Level Order Traversal.

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]

Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

 

Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]

Accepted
73,865
Submissions
114,625

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class NaryTreeLevelOrderTraversal {

	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        HashMap<Integer, List<Integer>> levels = new HashMap<>();
        helper(root, 0, levels);
        
        for(Integer key: levels.keySet())
            result.add(key, levels.get(key));
        return result;
    }
    
    private void helper(Node root, int currentLevel, HashMap<Integer, List<Integer>> levels){
        if(root == null)
            return;
        if(levels.containsKey(currentLevel))
            levels.get(currentLevel).add(root.val);
        else{
            levels.put(currentLevel, new ArrayList<>());
            levels.get(currentLevel).add(root.val);
        }
        for(Node child: root.children)
            helper(child, currentLevel + 1, levels);
    }
}