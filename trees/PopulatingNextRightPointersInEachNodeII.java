/*
117. Populating Next Right Pointers in Each Node II
Medium

https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

Runtime: 2 ms, faster than 18.63% of Java online submissions for Populating Next Right Pointers in Each Node II.
Memory Usage: 39 MB, less than 7.89% of Java online submissions for Populating Next Right Pointers in Each Node II.

iven a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

 

Example 1:

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

 

Constraints:

    The number of nodes in the given tree is less than 6000.
    -100 <= node.val <= 100

Accepted
275,612
Submissions
689,472
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class PopulatingNextRightPointersInEachNodeII {

    class Node {
        public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
    }
    public Node connect(Node root) {
        HashMap<Integer, List<Node>> levels = new HashMap<>();
        helper(root, 0, levels);
        for(Integer key: levels.keySet()){
            List<Node> currentLevel = levels.get(key);
            for(int i = 0; i < currentLevel.size() - 1; i++)
                currentLevel.get(i).next = currentLevel.get(i + 1);
        }
        return root;
    }
    
    private void helper(Node root, int level, HashMap<Integer, List<Node>> levels){
        if(root == null)
            return;
        if(!levels.containsKey(level))
            levels.put(level, new ArrayList<>());
        levels.get(level).add(root);
        helper(root.left, level + 1, levels);
        helper(root.right, level + 1, levels);
    }
}
