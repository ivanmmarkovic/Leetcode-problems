
import java.util.ArrayList;

/*
66. Plus One
Easy

https://leetcode.com/problems/plus-one/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
Memory Usage: 37.6 MB, less than 92.09% of Java online submissions for Plus One.

Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

Example 3:

Input: digits = [0]
Output: [1]

 

Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9

Accepted
695,312
Submissions
1,618,627

*/
public class PlusOne {
	
	public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();
        int rest = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            result.add(0, (digits[i] + rest) % 10);
            rest = (digits[i] + rest) / 10;
        }
        if(rest != 0)
            result.add(0, rest);
        int sum[] = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            sum[i] = result.get(i);
        return sum;
    }
}
