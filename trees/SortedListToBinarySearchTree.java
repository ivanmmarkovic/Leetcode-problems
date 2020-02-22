
import java.util.ArrayList;

/*

https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/ 
Medium 

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/
public class SortedListToBinarySearchTree {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ArrayList<Integer> arrayList = new ArrayList<>();
		while (head != null) {
			arrayList.add(head.val);
			head = head.next;
		}

		return sortedArrayToBST(arrayList);
	}

	public TreeNode sortedArrayToBST(ArrayList<Integer> nums) {
		return helper(nums, 0, nums.size() - 1);
	}

	public TreeNode helper(ArrayList<Integer> nums, int start, int end) {
		if (start > end)
			return null;
		else {
			int midpoint = start + (end - start) / 2;
			TreeNode root = new TreeNode(nums.get(midpoint));
			root.left = helper(nums, start, midpoint - 1);
			root.right = helper(nums, midpoint + 1, end);
			return root;
		}
	}
}