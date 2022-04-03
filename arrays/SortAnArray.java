package arrays;
/*
912. Sort an Array
Medium

https://leetcode.com/problems/sort-an-array/

Runtime: 9 ms, faster than 93.30% of Java online submissions for Sort an Array.
Memory Usage: 51 MB, less than 96.04% of Java online submissions for Sort an Array.


Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]

Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]

 

Constraints:

    1 <= nums.length <= 5 * 104
    -5 * 104 <= nums[i] <= 5 * 104

Accepted
251,767
Submissions
409,062
*/
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public static void quicksort(int numbers[], int start, int end) {
		
		if(start >= end)
			return;
		
		int left = start;
		int right = end;
		int pointer = left;
		
		int pivotIndex = left + (right - left) / 2;
		int pivotValue = numbers[pivotIndex];
		
		int tmp;
		while(pointer <= right) {
			if(numbers[pointer] < pivotValue) {
				tmp = numbers[left];
				numbers[left] = numbers[pointer];
				numbers[pointer] = tmp;
				left++;
				pointer++;
			}
			else if(numbers[pointer] > pivotValue) {
				tmp = numbers[right];
				numbers[right] = numbers[pointer];
				numbers[pointer] = tmp;
				right--;
			}
			else
				pointer++;
		}
		
		quicksort(numbers, start, left);
		if(right > left)
			quicksort(numbers, right, end);
		else
			quicksort(numbers, left + 1, end);
		
		
    }
    
}