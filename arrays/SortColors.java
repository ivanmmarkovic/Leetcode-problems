
/*

75. Sort Colors
Medium

https://leetcode.com/problems/sort-colors/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
Memory Usage: 38.1 MB, less than 5.51% of Java online submissions for Sort Colors.

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?

Accepted
449,291
Submissions
987,689

*/
class Solution {
    public void sortColors(int[] nums) {
        
        int start = 0; 
        int end = nums.length - 1;
        int mid = 0;
        int tmp;
        while(mid <= end){
            if(nums[mid] < 1){
                tmp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = tmp;
                start++;
                mid++;
            }
            else if(nums[mid] > 1){
                tmp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = tmp;
                end--;
            }
            else{
                mid++;
            }
        }
        
    }
}

