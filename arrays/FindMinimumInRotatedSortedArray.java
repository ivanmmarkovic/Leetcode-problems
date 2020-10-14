/*
153. Find Minimum in Rotated Sorted Array
Medium

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
Memory Usage: 38.4 MB, less than 21.65% of Java online submissions for Find Minimum in Rotated Sorted Array.

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1

Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

Accepted
496,142
Submissions
1,093,009

*/

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int nums[], int start, int end){
        if(start > end)
            return Integer.MAX_VALUE;
        else{
            int midpoint = start + (int)((end - start) / 2);
            int min_num = nums[midpoint];
            if(nums[midpoint] < nums[end])
                return Math.min(min_num, helper(nums, start, midpoint - 1));
            else{
                int min_num2 = helper(nums, start, midpoint - 1);
                min_num2 = Math.min(min_num2, helper(nums, midpoint + 1, end));
                return Math.min(min_num, min_num2);
            }
        }
    }
}