
/*
977. Squares of a Sorted Array
Easy

https://leetcode.com/problems/squares-of-a-sorted-array/

Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
Memory Usage: 40.9 MB, less than 9.19% of Java online submissions for Squares of a Sorted Array.

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 

Note:

    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.

Accepted
313,146
Submissions
433,952
*/

class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        
        int start = 0, end = A.length - 1;
        int B[] = new int[A.length];
        
        int pointer = A.length - 1;
        
        while(start <= end){
            if(Math.abs(A[start]) > Math.abs(A[end]))
                B[pointer] = (int)Math.pow(A[start++], 2);
            else
                B[pointer] = (int)Math.pow(A[end--], 2);
            pointer--;
        }
        
        return B;
        
    }
}
