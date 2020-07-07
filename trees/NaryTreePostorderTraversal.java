
/*

590. N-ary Tree Postorder Traversal
Easy

https://leetcode.com/problems/n-ary-tree-postorder-traversal/

Runtime: 2 ms, faster than 53.84% of Java online submissions for N-ary Tree Postorder Traversal.
Memory Usage: 43.1 MB, less than 11.51% of Java online submissions for N-ary Tree Postorder Traversal.

Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Follow up:

Recursive solution is trivial, could you do it iteratively?

 

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]

 

Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]

Accepted
90,623
Submissions
126,384

*/

import java.util.ArrayList;
import java.util.List;

class  NaryTreePostorderTraversal {

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
    public List<Integer> preorder(Node root) {
        List<Integer> vals = new ArrayList<>();
        helper(root, vals);
        return vals;
    }
    
    private void helper(Node root, List<Integer> vals){
        while(root != null){
            for(Node child: root.children)
                helper(child, vals);
            vals.add(root.val);
            root = null;
        }
    }
}