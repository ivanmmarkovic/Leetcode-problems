package strings;

/*
485. Max Consecutive Ones
Easy

https://leetcode.com/problems/max-consecutive-ones/

Runtime: 2 ms, faster than 63.24% of Java online submissions for Max Consecutive Ones.
Memory Usage: 40.5 MB, less than 53.00% of Java online submissions for Max Consecutive Ones.

Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2

 

Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.

Accepted
505,977
Submissions
935,838

*/
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int connected = 0;
		for (int n : nums) {
			if (n == 1) {
				count++;
				connected = Math.max(connected, count);
			} else
				count = 0;
		}
		return connected;
	}
}
