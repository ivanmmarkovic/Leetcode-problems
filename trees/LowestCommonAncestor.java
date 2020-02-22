
public class LowestCommonAncestor {
	
	class TreeNode{
		int value;
		TreeNode left, right, parent;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String args[]) {
		
	}
	
	public TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null)
			return root;
		if(root.value == node1.value || root.value == node2.value)
			return root;
		TreeNode left = lca(root.left, node1, node2);
		TreeNode right = lca(root.right, node1, node2);
		if(left != null && right != null)
			return root;
		else if(left == null)
			return right;
		else
			return left;
	}
	
	public TreeNode lcaIterative(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode tmp;
		boolean found = false;
		while(node1 != null && !found) {
			tmp = node2;
			while (tmp != null && !found) {
				if(tmp == node1)
					found = true;
				else
					tmp = tmp.parent;
			}
			if(!found)
				node1 = node1.parent;
		}
		return node1;
	}


}
