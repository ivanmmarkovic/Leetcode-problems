package arrays;

import java.util.Random;
/*
384. Shuffle an Array
Medium

https://leetcode.com/problems/shuffle-an-array/

Runtime: 69 ms, faster than 98.11% of Java online submissions for Shuffle an Array.
Memory Usage: 47.5 MB, less than 41.81% of Java online submissions for Shuffle an Array.

Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

    Solution(int[] nums) Initializes the object with the integer array nums.
    int[] reset() Resets the array to its original configuration and returns it.
    int[] shuffle() Returns a random shuffling of the array.

 

Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

 

Constraints:

    1 <= nums.length <= 200
    -106 <= nums[i] <= 106
    All the elements of nums are unique.
    At most 5 * 104 calls in total will be made to reset and shuffle.

Accepted
205,584
Submissions
372,100

*/
public class ShuffleAnArray {
	
	/**
	 * Your ShuffleAnArray object will be instantiated and called as such:
	 * ShuffleAnArray obj = new ShuffleAnArray(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
	
	int nums[];
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int combination[] = new int[this.nums.length];
        for(int i = 0; i < this.nums.length; i++)
            combination[i] = this.nums[i];
        
        Random rand = new Random();
        for(int i = 0; i < this.nums.length; i++){
	    // int index = rand.nextInt(i, this.nums.length);
            int index = i + rand.nextInt(this.nums.length - i);
            int tmp = combination[i];
            combination[i] = combination[index];
            combination[index] = tmp;
        }
        return combination;
    }

}
