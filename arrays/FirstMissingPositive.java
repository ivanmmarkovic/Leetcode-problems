import java.util.TreeSet;

/*
41. First Missing Positive
Hard

https://leetcode.com/problems/first-missing-positive/

Runtime: 2 ms, faster than 9.14% of Java online submissions for First Missing Positive.
Memory Usage: 37.7 MB, less than 6.85% of Java online submissions for First Missing Positive.

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
        if(nums.length == 0)
            return 1;
        
        TreeSet<Integer> visited = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                visited.add(nums[i]);
        
        boolean missingExists = false;
        int prev = 0, result = -1;
        
        if(visited.size() == 0)
            return 1;
        
        for(int e: visited){
            if(prev + 1 != e){
                result = prev + 1;
                missingExists = true;
                break;
            }
            else{
                prev = e;
                result = e;
            }
        }
        return missingExists ? result : result + 1;
    }
}