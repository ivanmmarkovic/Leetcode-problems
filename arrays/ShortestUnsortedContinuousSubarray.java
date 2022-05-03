package arrays;

/*
581. Shortest Unsorted Continuous Subarray
Medium

https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

Runtime: 1 ms, faster than 98.93% of Java online submissions for Shortest Unsorted Continuous Subarray.
Memory Usage: 54.9 MB, less than 7.27% of Java online submissions for Shortest Unsorted Continuous Subarray.

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:

Input: nums = [1,2,3,4]
Output: 0

Example 3:

Input: nums = [1]
Output: 0

 

Constraints:

    1 <= nums.length <= 104
    -105 <= nums[i] <= 105

 
Follow up: Can you solve it in O(n) time complexity?
Accepted
249,212
Submissions
703,786

*/
public class ShortestUnsortedContinuousSubarray {

	public int findUnsortedSubarray(int[] nums) {
        int end=-1;
       int max=nums[0];
       
       for(int i=1;i<nums.length;i++)
       {
           if(nums[i]>=max)
               max=nums[i];
           else
               end=i;
       }
       
       int start=0;
       int min=nums[nums.length-1];
       
       for(int i=nums.length-2;i>=0;i--)
       {
           if(nums[i]<=min)
               min=nums[i];
           else
               start=i;
       }
       
       return end-start+1;
       
   }
}
