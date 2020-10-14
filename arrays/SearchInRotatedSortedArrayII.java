/*
81. Search in Rotated Sorted Array II
Medium

https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
Memory Usage: 38.5 MB, less than 18.58% of Java online submissions for Search in Rotated Sorted Array II.

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:

    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?

Accepted
257,292
Submissions
779,389

*/
class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    private boolean helper(int nums[], int target, int start, int end){
        if(start > end)
            return false;
        else {
            int midpoint = start + (int)((end - start) / 2);
            if(nums[midpoint] == target)
                return true;
            else{
                if(nums[midpoint] > target && target > nums[start])
                    return helper(nums, target, start, midpoint - 1);
                else if(nums[midpoint] < target && target < nums[end])
                    return helper(nums, target, midpoint + 1, end);
                else {
                    boolean f = helper(nums, target, start, midpoint - 1);
                    if(!f)
                        f = helper(nums, target, midpoint + 1, end);
                    return f;
                }
            }
        }
    }
}