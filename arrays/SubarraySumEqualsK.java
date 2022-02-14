package arrays;

import java.util.HashMap;

/*
560. Subarray Sum Equals K
Medium

https://leetcode.com/problems/subarray-sum-equals-k/

Runtime: 17 ms, faster than 97.52% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 45 MB, less than 77.00% of Java online submissions for Subarray Sum Equals K.

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 

Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107

Accepted
712,308
Submissions
1,615,561

*/
public class SubarraySumEqualsK {
	
public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);   
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

}
