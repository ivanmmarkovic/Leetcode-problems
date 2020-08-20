/*
450. Delete Node in a BST
Medium

https://leetcode.com/problems/delete-node-in-a-bst/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
Memory Usage: 39.9 MB, less than 71.92% of Java online submissions for Delete Node in a BST.

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

Accepted
116,705
Submissions
270,273

*/


import java.util.HashMap;

class DeleteNodeInABST {
	
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        HashMap<String, TreeNode> nodes = new HashMap<>();
        findNode(root, key, nodes);
        TreeNode node = nodes.get("node");
        TreeNode parent = nodes.get("parent");
        if(node == null)
            return root;
        if(node == root){
            if(root.left == null && root.right == null)
                return null;
            else if(node.left != null && node.right != null){
                TreeNode max = findMax(node.left);
                int tmpVal = max.val;
                deleteNode(root, max.val);
                node.val = tmpVal;
                return root;
            }
            else if(root.left == null){
                return root.right;
            }
            else
                return root.left;
        }
        else{
            if(node.left == null && node.right == null){
                if(parent.left == node)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else if(node.left != null && node.right != null){
                TreeNode max = findMax(node.left);
                int tmpVal = max.val;
                deleteNode(root, max.val);
                node.val = tmpVal;
            }
            else if(node.left == null){
                if(parent.left == node)
                    parent.left = node.right;
                else
                    parent.right = node.right;
            }
            else{
                if(parent.left == node)
                    parent.left = node.left;
                else
                    parent.right = node.left;
            }
            return root;
        }
    }
    
    private void findNode(TreeNode root, int key, HashMap<String, TreeNode> nodes){
        if(root == null)
            return;
        TreeNode parent = null;
        boolean found = false;
        while(root != null && !found){
            if(root.val == key)
                found = true;
            else if(key < root.val){
                parent = root;
                root = root.left;
            }
            else{
                parent = root;
                root = root.right;
            }
        }
        if(!found)
            root = null;
        nodes.put("parent", parent);
        nodes.put("node", root);
    }
    
    private TreeNode findMax(TreeNode root){
        if(root == null)
            return null;
        while(root.right != null)
            root = root.right;
        return root;
    }
}