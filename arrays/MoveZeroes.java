
/*

283. Move Zeroes
Easy

https://leetcode.com/problems/move-zeroes/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
Memory Usage: 40 MB, less than 34.55% of Java online submissions for Move Zeroes.

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

Accepted
827,420
Submissions
1,437,280
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        
        int copied[] = new int[nums.length];
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                copied[start] = nums[i];
                start++;
            }
        }
        
        for(int i = 0; i < copied.length; i++){
            nums[i] = copied[i];
        }
    }
}