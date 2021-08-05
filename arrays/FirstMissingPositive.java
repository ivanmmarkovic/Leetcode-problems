import java.util.Set;
import java.util.TreeSet;

/*
41. First Missing Positive
Hard

https://leetcode.com/problems/first-missing-positive/

Runtime: 2 ms, faster than 12.32% of Java online submissions for First Missing Positive.
Memory Usage: 37.3 MB, less than 6.85% of Java online submissions for First Missing Positive.

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Note:

Your algorithm should run in O(n) time and uses constant extra space.
Accepted
296,162
Submissions
956,720
*/



class FirstMissingPositive {
    
    public int firstMissingPositive(int[] nums) {
		Set<Integer> vals = new HashSet<>();
		for(int i: nums)
			if(i > 0)
				vals.add(i);
		
		int number = 0;
		for(Integer v: vals) {
			if(vals.contains(number + 1))
				number++;
			else
				return number + 1;
		}
		return ++number;
	}
	
    /*
    public int firstMissingPositive(int[] nums) {
        Set<Integer> positive = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                positive.add(nums[i]);
        }
        
        int start = 0;
        int result = 0;
        for (int item : positive) {
            if(start + 1 != item) {
                result = start + 1;
                break;
            }
            start += 1;
        }
        return result == 0 ? start + 1 : result;
    }
    */
}
