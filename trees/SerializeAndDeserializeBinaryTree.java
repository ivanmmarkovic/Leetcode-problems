/*
297. Serialize and Deserialize Binary Tree
Hard

https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

Runtime: 18 ms, faster than 48.97% of Java online submissions for Serialize and Deserialize Binary Tree.
Memory Usage: 42.9 MB, less than 42.50% of Java online submissions for Serialize and Deserialize Binary Tree.

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
Accepted
337,275
Submissions
710,933

*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

	public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
	}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
        
    }
    
    private TreeNode deserializeHelper(Queue<String> q){
        String val = q.poll();
        if(val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));