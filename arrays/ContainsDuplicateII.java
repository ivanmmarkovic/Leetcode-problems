/*
219. Contains Duplicate II
Easy

https://leetcode.com/problems/contains-duplicate-ii/

Runtime: 1204 ms, faster than 13.25% of Java online submissions for Contains Duplicate II.
Memory Usage: 41.6 MB, less than 7.89% of Java online submissions for Contains Duplicate II.

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Accepted
295,838
Submissions
774,672

*/
public class ContainsDuplicateII {
public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        for(int i = 0; i < nums.length; i++){
            if(i + k < nums.length){
                for(int j = i + 1; j <= i + k; j++){
                    if(nums[i] == nums[j])
                        return true;
                }
            }
            else{
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] == nums[j])
                        return true;
                }
            }
        }
        
        return false;
    }

}
