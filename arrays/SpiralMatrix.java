package arrays;

import java.util.ArrayList;
import java.util.List;

/*
54. Spiral Matrix
Medium

https://leetcode.com/problems/spiral-matrix/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
Memory Usage: 37.1 MB, less than 5.21% of Java online submissions for Spiral Matrix.

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Accepted
334,696
Submissions
1,010,976



Tests
[]
[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
[[1,2,3],[4,5,6],[7,8,9]]
[[2,5,8],[4,0,-1]]
[[2,3,4],[5,6,7],[8,9,10],[11,12,13]]

*/
class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> vals = new ArrayList<>();
        if(matrix == null)
         return vals;

        int left = 0, right = matrix[0].length - 1, 
          top = 00, bottom = matrix.length - 1;
        while (left < right && top < bottom) {
         for(int i = left; i <= right; i++)
          vals.add(matrix[top][i]);
         top++;
         for(int i = top; i <= bottom; i++)
          vals.add(matrix[i][right]);
         right--;
         for(int i = right; i >= left; i--)
          vals.add(matrix[bottom][i]);
         bottom--;
         for(int i = bottom; i >= top; i--)
          vals.add(matrix[i][left]);
         left++;
        }

        if(left == right && top == bottom)
         vals.add(matrix[left][top]);
        else if(left == right && top < bottom)
         for(int i = top; i <= bottom; i++)
          vals.add(matrix[i][left]);
        else if(left < right && top == bottom)
         for(int i = left; i <= right; i++)
          vals.add(matrix[top][i]);

        return vals;
    }
}
