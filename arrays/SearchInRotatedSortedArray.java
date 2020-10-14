/*

33. Search in Rotated Sorted Array
Medium

https://leetcode.com/problems/search-in-rotated-sorted-array/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 38.4 MB, less than 22.09% of Java online submissions for Search in Rotated Sorted Array.

You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 

Constraints:

    1 <= nums.length <= 5000
    -10^4 <= nums[i] <= 10^4
    All values of nums are unique.
    nums is guranteed to be rotated at some pivot.
    -10^4 <= target <= 10^4

Accepted
818,417
Submissions
2,336,558

*/

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    private int helper(int nums[], int target, int start, int end){
        if(start > end)
            return -1;
        else {
            int midpoint = start + (int)((end - start) / 2);
            if(nums[midpoint] == target)
                return midpoint;
            else{
                if(nums[midpoint] > target && target > nums[start])
                    return helper(nums, target, start, midpoint - 1);
                else if(nums[midpoint] < target && target < nums[end])
                    return helper(nums, target, midpoint + 1, end);
                else {
                    int index = helper(nums, target, start, midpoint - 1);
                    if(index == -1)
                        index = helper(nums, target, midpoint + 1, end);
                    return index;
                }
            }
        }
    }
    
}