package arrays;
/*
34. Find First and Last Position of Element in Sorted Array
Medium

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 42.7 MB, less than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Accepted
451,703
Submissions
1,277,072

*/

class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for(int i = 0; i < nums.length && nums[i] <= target; i++){
            if(nums[i] == target){
                if(first == -1)
                    first = i;
                last = i;
            }
        }
        
        int positions[] = {first, last};
        return positions;
    }
}