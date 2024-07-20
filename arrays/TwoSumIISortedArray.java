/*

167. Two Sum II - Input array is sorted
Easy

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Runtime: 79 ms, faster than 10.52% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 42.1 MB, less than 5.11% of Java online submissions for Two Sum II - Input array is sorted.

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Accepted
413,274
Submissions
767,885

*/
class TwoSumIISortedArray {
    public int[] twoSum(int[] numbers, int target) {
        /*
        int result[] = new int[2];
        for(int i = 0; i < numbers.length - 1; i++){
            
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] < target)
                    continue;
                if(numbers[i] + numbers[j] == target){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
                break;
            }
            
        }
        return result;
        */

        // 2ms Beats89.76%
        int left = 0, right = numbers.length - 1;
        int l = -1, r = -1;
        while(left < right){
            int one = numbers[left];
            int two = numbers[right];
            if(one + two == target){
                l = left + 1; 
                r = right + 1;
                break;
            }
            else if(one + two > target)
                right--;
            else
                left++;
        }

        int[] coords = {l, r};
        return coords;
    }
}
