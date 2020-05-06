
/*
74. Search a 2D Matrix
Medium

https://leetcode.com/problems/search-a-2d-matrix/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
Memory Usage: 39.5 MB, less than 22.73% of Java online submissions for Search a 2D Matrix.

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

Accepted
304,324
Submissions
842,512

*/

public class SearchA2DMatrix {
public boolean searchMatrix(int[][] matrix, int target) {
        
        boolean found = false;
        int i = 0;
        while(i < matrix.length && !found){
            if(matrix[i].length > 0 && matrix[i][0] > target)
                return found;
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
