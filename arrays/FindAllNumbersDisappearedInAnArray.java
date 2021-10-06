package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

448. Find All Numbers Disappeared in an Array
Easy

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Runtime: 17 ms, faster than 29.69% of Java online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 47.5 MB, less than 93.42% of Java online submissions for Find All Numbers Disappeared in an Array.

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]

 

Constraints:

    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n

 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
Accepted
438,680
Submissions
766,299

*/
public class FindAllNumbersDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {

		int limit = nums.length;
		Set<Integer> exists = new HashSet<>();
		for (int n : nums) {
			exists.add(n);
		}

		List<Integer> disappeared = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (!exists.contains(i))
				disappeared.add(i);
		}
		return disappeared;
	}

}
