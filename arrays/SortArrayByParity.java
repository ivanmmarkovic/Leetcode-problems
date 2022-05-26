package arrays;

/*
905. Sort Array By Parity
Easy

https://leetcode.com/problems/sort-array-by-parity/

Runtime: 2 ms, faster than 96.61% of Java online submissions for Sort Array By Parity.
Memory Usage: 48 MB, less than 61.99% of Java online submissions for Sort Array By Parity.

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:

Input: nums = [0]
Output: [0]

 

Constraints:

    1 <= nums.length <= 5000
    0 <= nums[i] <= 5000

Accepted
495,779
Submissions
655,008

*/
public class SortArrayByParity {
	
    public int[] sortArrayByParity(int[] nums) {
        
        int index = 0, pointer = 0;
        while(pointer < nums.length){
            if(nums[pointer] % 2 != 0)
                pointer++;
            else {
                int tmp = nums[index];
                nums[index] = nums[pointer];
                nums[pointer] = tmp;
                index++;
                pointer++;
            }
        }
        return nums;
    }
    
    /*
    // This solution is correct too
    public int[] sortArrayByParity(int[] nums) {
        int start = 0, end = nums.length - 1;
		while (start <= end) {
			if(nums[start] % 2 == 0) 
				start++;
			else {
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
				end--;
			}
		}
		return nums;
    }
    */

}
