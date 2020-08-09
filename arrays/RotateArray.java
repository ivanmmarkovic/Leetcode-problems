/*
189. Rotate Array
Easy

https://leetcode.com/problems/rotate-array/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
Memory Usage: 40.3 MB, less than 49.48% of Java online submissions for Rotate Array.

Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 

Constraints:

    1 <= nums.length <= 2 * 10^4
    It's guaranteed that nums[i] fits in a 32 bit-signed integer.
    k >= 0

Accepted
512,326
Submissions
1,476,825

*/
class RotateArray {
    public void rotate(int[] nums, int k) {
        int copy[] = Arrays.copyOfRange(nums, 0, nums.length);
        for(int i = 0; i < copy.length; i++)
        	nums[(i + k) % nums.length] = copy[i];
    }
}