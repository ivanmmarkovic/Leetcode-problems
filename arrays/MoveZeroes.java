
/*

283. Move Zeroes
Easy

https://leetcode.com/problems/move-zeroes/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
Memory Usage: 40 MB, less than 34.55% of Java online submissions for Move Zeroes.

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

Accepted
827,420
Submissions
1,437,280
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        
        int copied[] = new int[nums.length];
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                copied[start] = nums[i];
                start++;
            }
        }
        
        for(int i = 0; i < copied.length; i++){
            nums[i] = copied[i];
        }
    }
    /*
    
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    Memory Usage: 39.5 MB, less than 35.13% of Java online submissions for Move Zeroes.
    
    public void moveZeroes(int[] nums) {

		int start = 0, forward = 0;

		while (forward < nums.length) {
			if (nums[forward] == 0)
				forward++;
			else {
				nums[start++] = nums[forward++];
			}
		}

		while (start < nums.length)
			nums[start++] = 0;

	}
	
	 
	Slower solution 
	
	Runtime: 2 ms, faster than 68.27% of Java online submissions for Move Zeroes.
	Memory Usage: 55.3 MB, less than 5.74% of Java online submissions for Move Zeroes.
	
	public void moveZeroes(int[] nums) {
		int left = 0, right = 0;
		while(right < nums.length) {
			if(nums[right] == 0)
				right++;
			else {
				int tmp = nums[right];
				nums[right] = nums[left];
				nums[left] = tmp;
				left++;
				right++;
			}
		}
	}
	*/
}
