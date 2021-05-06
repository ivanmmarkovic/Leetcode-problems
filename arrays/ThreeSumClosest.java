package arrays;

import java.util.Arrays;

/*
16. 3Sum Closest
Medium

https://leetcode.com/problems/3sum-closest/
 
Runtime: 4 ms, faster than 84.51% of Java online submissions for 3Sum Closest.
Memory Usage: 39 MB, less than 15.79% of Java online submissions for 3Sum Closest.


Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 

Constraints:

    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4

Accepted
580,861
Submissions
1,252,752
*/

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int currentSum = nums[left] + nums[mid] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(diff))
                    diff = target - currentSum;
                if (currentSum == target)
                    return currentSum;
                if (currentSum < target)
                    mid++;
                else
                    right--;
            }
        }

        return target - diff;

    }

}
