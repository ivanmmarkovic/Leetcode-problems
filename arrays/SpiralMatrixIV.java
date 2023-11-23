package arrays;

/*

Medium

https://leetcode.com/problems/spiral-matrix-iv/description/


You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:

Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.

Example 2:

Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.

 

Constraints:

    1 <= m, n <= 105
    1 <= m * n <= 105
    The number of nodes in the list is in the range [1, m * n].
    0 <= Node.val <= 1000

Accepted
34.9K
Submissions
46.5K
Acceptance Rate
75.1%

Runtime 5ms Beats 99.25%of users with Java

Memory 61.13MB Beats 25.50%of users with Java

*/
public class SpiralMatrixIV {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public int[][] spiralMatrix(int m, int n, ListNode head) {

		int[][] matrix = new int[m][];
		for (int i = 0; i < m; i++) {
			matrix[i] = new int[n];
		}

		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

		while (left < right && top < bottom) {
			for (int i = left; i <= right; i++) {
				matrix[top][i] = head == null ? -1 : head.val;
				head = head == null ? null : head.next;
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				matrix[i][right] = head == null ? -1 : head.val;
				head = head == null ? null : head.next;
			}
			right--;
			for (int i = right; i >= left; i--) {
				matrix[bottom][i] = head == null ? -1 : head.val;
				head = head == null ? null : head.next;
			}
			bottom--;
			for (int i = bottom; i >= top; i--) {
				matrix[i][left] = head == null ? -1 : head.val;
				head = head == null ? null : head.next;
			}
			left++;
		}

		if (left == right && top == bottom) {
			matrix[left][top] = head == null ? -1 : head.val;
			head = head == null ? null : head.next;
		}

		if (left == right && top < bottom) {
			for (int i = top; i <= bottom; i++) {
				matrix[i][left] = head == null ? -1 : head.val;
				head = head == null ? null : head.next;
			}
		}
		
		if (left < right && top == bottom) {
			for (int i = left; i <= right; i++) {
				matrix[top][i] = head == null ? -1 : head.val;
				head = head == null ? null : head.next;
			}
		}

		return matrix;
	}

}
