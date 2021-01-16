package arrays;

import java.util.HashMap;

/*
260. Single Number III
Medium

https://leetcode.com/problems/single-number-iii

Runtime: 12 ms, faster than 5.34% of Java online submissions for Single Number III.
Memory Usage: 42.9 MB, less than 5.79% of Java online submissions for Single Number III

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

Follow up: Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:

Input: nums = [-1,0]
Output: [-1,0]

Example 3:

Input: nums = [0,1]
Output: [1,0]

 

Constraints:

    2 <= nums.length <= 3 * 104
    -231 <= nums[i] <= 231 - 1
    Each integer in nums will appear twice, only two integers will appear once.

Accepted
181,171
Submissions
277,710

*/
public class SingleNumberIII {
	
	public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int e: nums){
            if(count.containsKey(e))
                count.put(e, count.get(e) + 1);
            else
                count.put(e, 1);
        }
        
        int result[] = new int[2];
        int pointer = 0;
        for(Integer key: count.keySet()){
            if(count.get(key) == 1){
                result[pointer++] = key;
            }
        }
        return result;
    }

}
