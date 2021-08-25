package arrays;

/*
633. Sum of Square Numbers
Medium

https://leetcode.com/problems/sum-of-square-numbers/submissions/

Runtime: 2 ms, faster than 93.80% of Java online submissions for Sum of Square Numbers.
Memory Usage: 35.8 MB, less than 61.60% of Java online submissions for Sum of Square Numbers.

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:

Input: c = 3
Output: false

Example 3:

Input: c = 4
Output: true

Example 4:

Input: c = 2
Output: true

Example 5:

Input: c = 1
Output: true

 

Constraints:

    0 <= c <= 231 - 1

Accepted
107,626
Submissions
313,521

*/
public class SumOfSquareNumbers {

	public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
