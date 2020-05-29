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
        List<Integer> result = new ArrayList<Integer>();
        
        if(matrix.length == 0)
            return result;
        if(matrix[0].length == 1){
            for(int i = 0; i < matrix.length; i++){
                result.add(matrix[i][0]);
            }
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while(left < right && top < bottom){
            for(int i = left; i <= right; i++){
                result.add(matrix[left][i]);
            }
            top += 1;
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right -= 1;
            for(int i = right; i >= left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom -= 1;
            for(int i = bottom; i >= top; i--){
                result.add(matrix[i][left]);
            }
            left += 1;
        }
        
        if(left == right && top == bottom){
            result.add(matrix[left][top]);
        }
        
        if(top == bottom && left != right){
            for(int i = left; i <= right; i++)
                result.add(matrix[top][i]);
        }
        
        if(left == right && top != bottom){
            for(int i = top; i <= bottom; i++)
                result.add(matrix[i][left]);
        }
        
        return result;
    }
}