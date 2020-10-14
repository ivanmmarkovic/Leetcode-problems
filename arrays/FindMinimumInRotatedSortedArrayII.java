/*
154. Find Minimum in Rotated Sorted Array II
Hard

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array II.
Memory Usage: 38.9 MB, less than 19.46% of Java online submissions for Find Minimum in Rotated Sorted Array II.

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0

Note:

    This is a follow up problem to Find Minimum in Rotated Sorted Array.
    Would allow duplicates affect the run-time complexity? How and why?

Accepted
217,681
Submissions
522,006

*/

class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int nums[], int start, int end){
        if(start > end)
            return Integer.MAX_VALUE;
        else{
            int midpoint = start + (int)((end - start) / 2);
            int minNum = nums[midpoint];
            if(nums[midpoint] < nums[end])
                return Math.min(minNum, helper(nums, start, midpoint - 1));
            else{
                int minNum2 = helper(nums, start, midpoint - 1);
                minNum2 = Math.min(minNum2, helper(nums, midpoint + 1, end));
                return Math.min(minNum, minNum2);
            }
        }
    }
}