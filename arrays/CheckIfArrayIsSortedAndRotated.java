package arrays;


/*
1752. Check if Array Is Sorted and Rotated
Easy

https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Array Is Sorted and Rotated.
Memory Usage: 42.2 MB, less than 16.78% of Java online submissions for Check if Array Is Sorted and Rotated.



Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

 

Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

Accepted
32,568
Submissions
68,366

*/
public class CheckIfArrayIsSortedAndRotated {
	
	public boolean check(int[] nums) {
        /*
	int indexOfMin = -1;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minValue){
                minValue = nums[i];
                indexOfMin = i;
            }
        }

        if(indexOfMin == -1)
            return true;

        int count = 0;
        int index = indexOfMin;

        do{
            if(nums[index] > nums[(index + 1) % nums.length])
                count++;
            index = (index + 1) % nums.length;
        }while(index != indexOfMin);

        return count <= 1;

 	//---------------------------------------------------------------------------
 		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i + 1])
				count++;
		}
		if(count > 1)
			return false;
		if(count == 1 && nums[nums.length - 1] <= nums[0])
			return true;
		if(count == 0 && nums[nums.length - 1] >= nums[0])
			return true;
		return false;
		*/
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i + 1])
				count++;
		}
		if(count > 1) return false;
		if(count == 1) return nums[nums.length - 1] <= nums[0];
		return nums[nums.length - 1] >= nums[0];
	}
	
	
	/*
	public boolean check(int[] nums) {
        int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i + 1])
				count++;
		}
        if(count == 0) // [1, 2, 3] [2, 2, 2]
            return true;
		return count <= 1 && nums[nums.length - 1] <= nums[0]; // [5, 1, 5]
    }
    */
	
	/*
	public boolean check(int[] nums) {
        int check=0;

        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i]>nums[i+1])
               check++;

            if(check>1) return false;
        }

        return !(check==1 && nums[0]<nums[nums.length-1]);
    }
    */
}
