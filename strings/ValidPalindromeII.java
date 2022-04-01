package strings;

/*
680. Valid Palindrome II
Easy

https://leetcode.com/problems/valid-palindrome-ii/

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Runtime: 13 ms, faster than 28.84% of Java online submissions for Valid Palindrome II.
Memory Usage: 54.5 MB, less than 55.76% of Java online submissions for Valid Palindrome II.

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false

 

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.

Accepted
425,067
Submissions
1,101,664


*/
public class ValidPalindromeII {
	
	
	private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }
            
            i++;
            j--;
        }
        
        return true;
    }

}
