package arrays;
/*
59. Spiral Matrix II
Medium

https://leetcode.com/problems/spiral-matrix-ii/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
Memory Usage: 37.6 MB, less than 8.33% of Java online submissions for Spiral Matrix II.

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

Accepted
179,947
Submissions
346,073

*/


class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        
        int matrix[][] = new int[n][n];
        
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        
        int number = 1;
        while(left < right && top < bottom){
            for(int i = left; i <= right; i++){
                matrix[left][i] = number++;
            }
            top += 1;
            for(int i = top; i <= bottom; i++){
                matrix[i][right] = number++;
            }
            right -= 1;
            for(int i = right; i >= left; i--){
                matrix[bottom][i] = number++;
            }
            bottom -= 1;
            for(int i = bottom; i >= top; i--){
                matrix[i][left] = number++;
            }
            left += 1;
        }
        if(left == right)
            matrix[left][top] = number;
        
        return matrix;
        
    }
}