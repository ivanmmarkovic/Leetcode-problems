package ivanmarkovic.codingproblems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void traversal(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode tmp;
		queue.add(node);
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			if(tmp.leftChild != null)
				queue.add(tmp.leftChild);
			if(tmp.rightChild != null)
				queue.add(tmp.rightChild);
			System.out.println(tmp.key);
		}
	}

}
