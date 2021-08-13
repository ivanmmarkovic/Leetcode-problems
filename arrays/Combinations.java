package arrays;

import java.util.ArrayList;
import java.util.List;

/*

77. Combinations
Medium

https://leetcode.com/problems/combinations/


Runtime: 105 ms, faster than 5.04% of Java online submissions for Combinations.
Memory Usage: 167.5 MB, less than 5.06% of Java online submissions for Combinations.

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:

Input: n = 1, k = 1
Output: [[1]]

 

Constraints:

    1 <= n <= 20
    1 <= k <= n

Accepted
395,297
Submissions
662,239

*/
public class Combinations {

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> total = new ArrayList<>();
		List<Integer> current = new ArrayList<>();

		int nums[] = new int[n];
		for (int i = 1; i <= n; i++)
			nums[i - 1] = i;

		subsets(nums, 0, current, total);

		List<List<Integer>> result = new ArrayList<>();
		for (List<Integer> subset : total)
			if (subset.size() == k)
				result.add(subset);

		return result;

	}

	private void subsets(int nums[], int index, List<Integer> current, List<List<Integer>> total) {
		if (index == nums.length)
			total.add(current);
		else {
			current.add(nums[index]);
			subsets(nums, index + 1, new ArrayList<>(current), total);
			current.remove(current.size() - 1);
			subsets(nums, index + 1, new ArrayList<>(current), total);
		}
	}
}
