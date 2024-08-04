package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum
Medium

https://leetcode.com/problems/3sum/

Runtime 32ms Beats 49.12%
Memory 52.22MB Beats 29.54%

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

 

Constraints:

    0 <= nums.length <= 3000
    -105 <= nums[i] <= 105

Accepted
1,285,553
Submissions
4,524,756
*/
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

	        Arrays.sort(nums);
	        List<List<Integer>> triplets = new ArrayList<>();
	        int i = 0;
	        while(i < nums.length){
	            if(i > 0 && nums[i] == nums[i - 1]){
	                i++;
	                continue;
	            }
	            int j = i + 1;
	            int k = nums.length - 1;
	            while(j < k){
	                int current = nums[i] + nums[j] + nums[k];
	                if(current == 0){
	                    List<Integer> vals = new ArrayList<>();
	                    vals.add(nums[i]);
	                    vals.add(nums[j]);
	                    vals.add(nums[k]);
	                    triplets.add(vals);
	                    j += 1;
	                    k -= 1;
	                    while(j < k && nums[j] == nums[j - 1])
	                        j++;
	                    while(j < k && nums[k] == nums[k + 1])
	                        k--;
	                }
	                else if(current > 0)
	                    k--;
	                else
	                    j++;
	            }
	            i++;
	        }

                return triplets;
	}

}
