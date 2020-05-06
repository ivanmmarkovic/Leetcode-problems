/*
240. Search a 2D Matrix II
Medium

https://leetcode.com/problems/search-a-2d-matrix-ii/

Runtime: 7 ms, faster than 30.55% of Java online submissions for Search a 2D Matrix II.
Memory Usage: 45 MB, less than 94.34% of Java online submissions for Search a 2D Matrix II.

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
Accepted
290,532
Submissions
681,052

*/
public class SearchA2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int i = 0;
        while(i < matrix.length && !found){
            found = binarySearch(matrix[i], target);
            i++;
        }
        return found;
    }
    
    public boolean binarySearch(int row[], int target){
        int start = 0;
        int end = row.length - 1;
        int midpoint;
        boolean found = false;
        while(start <= end && !found){
            midpoint = start + (end -start) / 2;
            if(row[midpoint] == target)
                found = true;
            else {
                if(row[midpoint] > target)
                    end = midpoint - 1;
                else
                    start = midpoint + 1;    
            }
        }
        return found;
    }
}
