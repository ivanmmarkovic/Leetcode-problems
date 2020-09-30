
/*

https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

*/
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	
	public class ListNode {
		int val;
		ListNode prev;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
	public ListNode convert(TreeNode root) {
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		inorder(root, tmp);
		head = head.next;
		ListNode prev = null;
		tmp = head;
		while (tmp != null) {
			if(prev != null)
				tmp.prev = prev;
			prev = tmp;
			tmp = tmp.next;
		}
		return head;
	}

	private void inorder(TreeNode root, ListNode tmp) {
		if(root != null) {
			inorder(root.left, tmp);
			tmp.next = new ListNode(root.val);
			inorder(root.right, tmp);
		}
	}
	
	

}
