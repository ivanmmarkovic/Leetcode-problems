package arrays;
import java.util.HashSet;
import java.util.Set;

/*
287. Find the Duplicate Number
Medium

https://leetcode.com/problems/find-the-duplicate-number/

Runtime: 2 ms, faster than 48.70% of Java online submissions for Find the Duplicate Number.
Memory Usage: 40.4 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2

Example 2:

Input: [3,1,3,4,2]
Output: 3

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.



*/

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        Set<Integer> visited = new HashSet<Integer>();
        int result = 0;
        for(int n: nums){
            if(visited.contains(n)){
                result = n;
                break;
            }
            else
                visited.add(n);
        }
        return result;
    }
}