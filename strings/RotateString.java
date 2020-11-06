
/*
796. Rotate String
Easy

https://leetcode.com/problems/rotate-string/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate String.
Memory Usage: 37 MB, less than 18.35% of Java online submissions for Rotate String.

We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false

Note:

    A and B will have length at most 100.

Accepted
80,795
Submissions
163,582

*/
public class RotateString {

	public boolean rotateString(String A, String B) {
        if(A.length() == 0 && B.length() == 0)
            return true;
        if(A.length() == 0)
            return false;
        
        String character = String.valueOf(A.charAt(0));
        int index = B.indexOf(character);
        boolean matches = false;
        String combined = null;
        while(index != -1 && !matches){
            combined = B.substring(index) + B.substring(0, index);
            if(combined.equals(A))
                matches = true;
            else
                index = B.indexOf(character, index + 1);
        }
        return matches;
    }
}
