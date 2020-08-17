/*

78. Subsets
Medium

https://leetcode.com/problems/subsets/

Runtime: 4 ms, faster than 6.09% of Java online submissions for Subsets.
Memory Usage: 39.4 MB, less than 88.74% of Java online submissions for Subsets.

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Accepted
595,957
Submissions
966,296

*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        helper(nums, 0, currentSet, result);
        return result;
    }
    
    public void helper(int nums[], int curr, List<Integer> currentSet, List<List<Integer>> result){
        if(curr == nums.length){
            result.add(currentSet);
        }
        else{
            currentSet.add(nums[curr]);
            helper(nums, curr + 1, currentSet.stream().collect(Collectors.toList()), result);
            currentSet.remove(currentSet.size() - 1);
            helper(nums, curr + 1, currentSet.stream().collect(Collectors.toList()), result);
        }
    }
}