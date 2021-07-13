package arrays;

/*
162. Find Peak Element
Medium

https://leetcode.com/problems/find-peak-element/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
Memory Usage: 38.9 MB, less than 21.70% of Java online submissions for Find Peak Element.

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

 

Constraints:

    1 <= nums.length <= 1000
    -231 <= nums[i] <= 231 - 1
    nums[i] != nums[i + 1] for all valid i.

Accepted
530,930
Submissions
1,195,212

*/
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums.length == 2)
            if(nums[0] > nums[1])
                return 0;
            else
                return 1;
        return helper(nums, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int start, int end){
        if(start > end)
            return -1;
        else {
            int midpoint = start + (int)((end - start) / 2);
            int l = 0, r = nums.length - 1;
            int result = nums[midpoint];
            if(midpoint == l && result > nums[midpoint + 1])
                return midpoint;
            if(midpoint == r && result > nums[midpoint - 1])
                return midpoint;
            if(midpoint != l && midpoint != r && result > nums[midpoint - 1] && result > nums[midpoint + 1])
                return midpoint;
            else {
                int res = helper(nums, start, midpoint - 1);
                if(res == -1)
                    res = helper(nums, midpoint + 1, end);
                return res;
            }
        }
        
    }
}