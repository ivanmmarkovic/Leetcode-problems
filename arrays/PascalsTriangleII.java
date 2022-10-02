
import java.util.ArrayList;
import java.util.List;


/*
119. Pascal's Triangle II
Easy
https://leetcode.com/problems/pascals-triangle-ii/

Runtime: 2 ms, faster than 63.12% of Java online submissions for Pascal's Triangle II.
Memory Usage: 41 MB, less than 83.66% of Java online submissions for Pascal's Triangle II.

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:

Input: rowIndex = 0
Output: [1]

Example 3:

Input: rowIndex = 1
Output: [1,1]

 

Constraints:

    0 <= rowIndex <= 33

 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

*/

class PascalsTriangleII {
    
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> triangle = generate(rowIndex + 1);
        return triangle.get(rowIndex);
        
    }
    
    
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
