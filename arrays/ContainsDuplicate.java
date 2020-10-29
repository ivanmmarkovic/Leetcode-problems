
import java.util.Arrays;

/*
217. Contains Duplicate
Easy

https://leetcode.com/problems/contains-duplicate/

Runtime: 3 ms, faster than 99.70% of Java online submissions for Contains Duplicate.
Memory Usage: 42.7 MB, less than 7.12% of Java online submissions for Contains Duplicate.

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true

Example 2:

Input: [1,2,3,4]
Output: false

Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

Accepted
657,678
Submissions
1,168,019
*/
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

}
