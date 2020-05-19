
import java.util.HashSet;
import java.util.Set;

/*

/*
73. Set Matrix Zeroes
Medium

https://leetcode.com/problems/set-matrix-zeroes/

Medium

Runtime: 2 ms, faster than 40.64% of Java online submissions for Set Matrix Zeroes.
Memory Usage: 42.8 MB, less than 95.71% 
of Java online submissions for Set Matrix Zeroes.

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?

Accepted
297,505
Submissions
699,931
*/


public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void zeroMatrix(int matrix[][]) {
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		for(int i = 0; i < matrix.length; i++) {
			for(int j= 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int i= 0; i < matrix.length; i++) {
			for(int j= 0; j < matrix[i].length; j++) {
				if(rows.contains(i))
					matrix[i][j] = 0;
				else if(cols.contains(j))
					matrix[i][j] = 0;
			}
		}
	}

}