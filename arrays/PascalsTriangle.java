

import java.util.ArrayList;
import java.util.List;


/*
118. Pascal's Triangle
Easy

https://leetcode.com/problems/pascals-triangle/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
Memory Usage: 36.9 MB, less than 18.30% of Java online submissions for Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

Accepted
418,991
Submissions
784,208

*/

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

		List<Integer> row;
		List<Integer> prevRow;
		for (int i = 0; i < numRows; i++) {
			row = new ArrayList<>();
			row.add(0, 1);
			triangle.add(row);
			if (i == 0) // eliminate first row, has only one 1
				continue;
			prevRow = triangle.get(i - 1);
			for (int j = 1; j < i; j++) {
				row.add(j, prevRow.get(j - 1) + prevRow.get(j));
			}
			row.add(1);
		}

		return triangle;
    }
}
