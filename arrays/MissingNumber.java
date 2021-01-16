package arrays;

import java.util.TreeSet;

/*
268. Missing Number
Easy

https://leetcode.com/problems/missing-number/

Runtime: 18 ms, faster than 5.86% of Java online submissions for Missing Number.
Memory Usage: 40.3 MB, less than 12.42% of Java online submissions for Missing Number.

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

Example 4:

Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.

 

Constraints:

    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.

Accepted
565,543
Submissions
1,059,675

*/
public class MissingNumber {
	public int missingNumber(int[] nums) {
        TreeSet<Integer> vals = new TreeSet<>();
        for(int n: nums)
            vals.add(n);
        
        int prev = -1;
        for(Integer e: vals){
            if(prev + 1 != e)
                return prev + 1;
            else
                prev++;
        }
        return prev + 1;
    }
}
