

import java.util.LinkedList;
import java.util.Queue;

public class TraversalLevelOrder {

	class TreeNode{
		int value;
		TreeNode left, right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void levelOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode tmp;
		while (!q.isEmpty()) {
			tmp = q.poll();
			if(tmp.left != null)
				q.add(tmp.left);
			if(tmp.right != null)
				q.add(tmp.right);
			System.out.println(tmp.value);
		}
	}
}