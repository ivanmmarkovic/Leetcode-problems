package misc;

/*
258. Add Digits
Easy

https://leetcode.com/problems/add-digits/

Runtime: 1 ms, faster than 95.61% of Java online submissions for Add Digits.
Memory Usage: 41.8 MB, less than 20.61% of Java online submissions for Add Digits.


Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.


Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:

Input: num = 0
Output: 0

 

Constraints:

    0 <= num <= 231 - 1

 

Follow up: Could you do it without any loop/recursion in O(1) runtime?
Accepted
451,570
Submissions
727,016

*/
public class AddDigits {
	
	public int addDigits(int num) {

		if (num == 0)
			return 0;
		if (num % 9 == 0)
			return 9;
		else
			return num % 9;

	}

}
