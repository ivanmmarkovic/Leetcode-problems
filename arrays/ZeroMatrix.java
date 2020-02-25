
import java.util.HashSet;
import java.util.Set;

/*
Zero Matrix: 
Write an algorithm such that if an element in an MxN matrix is 0, 
its entire row and column are set to 0

https://leetcode.com/problems/set-matrix-zeroes/submissions/

Medium

Runtime: 2 ms, faster than 40.64% of Java online submissions for Set Matrix Zeroes.
Memory Usage: 42.8 MB, less than 95.71% 
of Java online submissions for Set Matrix Zeroes.
*/

public class ZeroMatrix {

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