package arrays;

import java.util.HashMap;

/*
136. Single Number
Easy

https://leetcode.com/problems/single-number/

Runtime: 13 ms, faster than 16.78% of Java online submissions for Single Number.
Memory Usage: 40 MB, less than 19.21% of Java online submissions for Single Number.

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

 

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1

 

Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.

Accepted
1,060,411
Submissions
1,598,154
*/
public class SingleNumber {
	
	public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int e: nums){
            if(count.containsKey(e))
                count.put(e, count.get(e) + 1);
            else
                count.put(e, 1);
        }
        
        int number = -1;
        for(Integer key: count.keySet()){
            if(count.get(key) == 1){
                number = key;
                break;
            }
        }
        return number;
    }

}
