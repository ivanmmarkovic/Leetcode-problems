/*
238. Product of Array Except Self
Medium

https://leetcode.com/problems/product-of-array-except-self/

Runtime: 1897 ms, faster than 5.06% of Java online submissions for Product of Array Except Self.
Memory Usage: 47.8 MB, less than 89.18% of Java online submissions for Product of Array Except Self.

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
Accepted
569,937
Submissions
947,642

*/
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = 0; j < nums.length; j++){
                if(j != i){
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        
        return result;
    }
}