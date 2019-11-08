package ivanmarkovic.codingproblems.trees;

public class LowestCommonAncestor {
	
	public static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null)
			return null;
		if(root.key == node1.key || root.key == node2.key)
			return root;
		TreeNode left = lowestCommonAncestorRecursive(root.leftChild, node1, node2);
		TreeNode right = lowestCommonAncestorRecursive(root.rightChild, node1, node2);
		if(left != null && right != null)
			return root;
		else if(left == null)
			return right;
		else
			return left;
	}
	
	public static TreeNode commonAncestorIterative(TreeNode bt1, TreeNode bt2) {
        TreeNode tmp = bt2;
        boolean found = false;
        while(bt1 != null && !found) {
            while(tmp != null && !found) {
                if(bt1 == tmp)
                    found = true;
                else
                    tmp = tmp.parent;
            }
            if(!found) {
                bt1 = bt1.parent;
                tmp = bt2;
            }
        }
        if(found)
            return bt1; 
        else
            return null;
    }

}
