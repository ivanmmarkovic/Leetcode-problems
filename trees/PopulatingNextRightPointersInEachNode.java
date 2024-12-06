/*
116. Populating Next Right Pointers in Each Node
Medium

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Runtime: 2 ms, faster than 44.88% of Java online submissions for Populating Next Right Pointers in Each Node.
Memory Usage: 39.6 MB, less than 16.52% of Java online submissions for Populating Next Right Pointers in Each Node.

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

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

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

 

Constraints:

    The number of nodes in the given tree is less than 4096.
    -1000 <= node.val <= 1000

Accepted
399,860
Submissions
860,108
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class PopulatingNextRightPointersInEachNode {

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

    /*
	public Node connect(Node root) {
		if(root == null)
			return null;
		List<List<Node>> nodes = new ArrayList<List<Node>>();
		List<Node> current = new ArrayList<Node>();
		current.add(root);
		nodes.add(current);
		
		while(true) {
			List<Node> prev = nodes.get(nodes.size() - 1);
			current = new ArrayList<Node>();
			for(Node node: prev) {
				if(node.left != null)
					current.add(node.left);
				if(node.right != null)
					current.add(node.right);
			}
			if(current.size() > 0)
			    nodes.add(current);
            else
				break;
		}
		
		for(List<Node> level: nodes) {
			for(int i = 0; i < level.size() - 1; i++) {
				level.get(i).next = level.get(i + 1);
			}
		}
		return root;
	}
		
	*/

}
