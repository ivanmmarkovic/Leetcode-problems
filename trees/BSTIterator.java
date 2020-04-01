
/*

Runtime: 14 ms, faster than 100.00% of Java online submissions for Binary Search Tree Iterator.
Memory Usage: 44.9 MB, less than 100.00% of Java online submissions for Binary Search Tree Iterator.

173. Binary Search Tree Iterator
Medium

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

 

Note:

    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.

Accepted
272,643
Submissions
507,656

*/
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class BSTIterator {

    Queue<Integer> queue;
	public BSTIterator(TreeNode root) {
		queue = new LinkedList<Integer>();
        if(root != null)
		    inorder(root);
	}
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public void inorder(TreeNode root) {
		if(root.left != null)
			inorder(root.left);
		queue.add(root.val);
		if(root.right != null)
			inorder(root.right);
	}
}
