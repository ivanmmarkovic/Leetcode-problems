/*

46. Permutations
Medium

https://leetcode.com/problems/permutations/

Runtime: 6 ms, faster than 6.48% of Java online submissions for Permutations.
Memory Usage: 40.2 MB, less than 5.68% of Java online submissions for Permutations.

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

Accepted
547,810
Submissions
894,406
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> total = new ArrayList<List<Integer>>();
        List<Integer> listnums = new ArrayList<Integer>();
        for(int i: nums)
        	listnums.add(i);
        
        helper(total, listnums, new ArrayList<Integer>());
        return total;
        
    }
    
    public void helper(List<List <Integer>> total, List<Integer> nums, List<Integer> result){
        if(nums.size() == 0)
            total.add(result);
        else{
            for(int i = 0; i < nums.size(); i++){
            	List<Integer> tmp = nums.stream().collect(Collectors.toList());
            	tmp.remove(i);
            	List<Integer> tmpresult = result.stream().collect(Collectors.toList());
            	tmpresult.add(nums.get(i));
                helper(
                	total,
                	tmp,
                	tmpresult
                );
            }
        }
    }
}