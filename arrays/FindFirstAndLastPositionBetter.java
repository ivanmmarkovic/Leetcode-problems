
/*
34. Find First and Last Position of Element in Sorted Array
Medium

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 42.5 MB, less than 83.10% of Java online submissions for Find First and Last Position of Element in Sorted Array.

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
491,605
Submissions
1,372,929

*/
class FindFirstAndLastPositionBetter {
    public int[] searchRange(int[] nums, int target) {
        int indexes[] = new int[2];
        indexes[0] = getMin(nums, target);
        if(indexes[0] != -1)
            indexes[1] = getMax(nums, target);
        else
            indexes[1] = -1;
        return indexes;
    }
    
    public int getMin(int nums[], int target){
        int start = 0, end = nums.length - 1;
        int midpoint;
        int result = -1;
        while(start <= end){
            midpoint = start + (end - start) / 2;
            if(nums[midpoint] == target){
                result = midpoint;
                end = midpoint - 1;
            }
            else if(nums[midpoint] > target)
                end = midpoint - 1;
            else
                start = midpoint + 1;
        }
        return result;
    }
    
    public int getMax(int nums[], int target){
        int start = 0, end = nums.length - 1;
        int midpoint;
        int result = -1;
        while(start <= end){
            midpoint = start + (end - start) / 2;
            if(nums[midpoint] == target){
                result = midpoint;
                start = midpoint + 1;
            }
            else if(nums[midpoint] > target)
                end = midpoint - 1;
            else
                start = midpoint + 1;
        }
        return result;
    }
    
}
