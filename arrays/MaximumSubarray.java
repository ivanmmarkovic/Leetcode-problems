/*
53. Maximum Subarray
Easy

https://leetcode.com/problems/maximum-subarray/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
Memory Usage: 39 MB, less than 12.20% of Java online submissions for Maximum Subarray.

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
Accepted
880,226
Submissions
1,915,709

*/
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int currentSum = nums[0], sum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            sum = Math.max(currentSum, sum);
        }
        
        return sum;
    }
}