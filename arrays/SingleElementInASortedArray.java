/*

540. Single Element in a Sorted Array
Medium

https://leetcode.com/problems/single-element-in-a-sorted-array/


Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
Memory Usage: 42.9 MB, less than 8.00% of Java online submissions for Single Element in a Sorted Array.

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10

 

Note: Your solution should run in O(log n) time and O(1) space.
Accepted
80,287
Submissions
139,280

*/
class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        boolean found = false;
        while(i < nums.length - 1 && !found){
            if(nums[i] != nums[i + 1])
                found = true;
            else
                i += 2;
        }
        return nums[i];

     /*
    	int i;
   		for (i = 0; i < nums.length - 1; i++) {
   			if(nums[i] == nums[i + 1])
   				i++;
   			else
   				return nums[i];
   		}
   		return nums[i];
    	*/
    }
}
