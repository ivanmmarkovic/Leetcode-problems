package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
15. 3Sum
Medium

https://leetcode.com/problems/3sum/

Runtime: 1187 ms, faster than 7.17% of Java online submissions for 3Sum.
Memory Usage: 45.2 MB, less than 7.10% of Java online submissions for 3Sum.


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

		List<List<Integer>> arrays = new ArrayList<>();
		Set<String> strings = new HashSet<>();
		Arrays.sort(nums);

		for (int left = 0; left < nums.length - 2; left++) {
			int mid = left + 1;
			int right = nums.length - 1;
			while (mid < right) {
				int sum = nums[left] + nums[mid] + nums[right];
				if (sum == 0) {
					int tmp[] = { nums[left], nums[mid], nums[right] };
					Arrays.sort(tmp);
					StringBuilder sb = new StringBuilder();
					List<Integer> list = new ArrayList<>();
					for (int e : tmp) {
						sb.append(e + ",");
						list.add(e);
					}

					if (!strings.contains(sb.toString())) {
						strings.add(sb.toString());
						arrays.add(list);
					}
				}
				if (sum > 0)
					right--;
				else
					mid++;
			}
		}

		return arrays;
	}

}
