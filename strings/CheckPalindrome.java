package strings;

/*
680. Valid Palindrome II
Easy

Runtime: 10 ms, faster than 61.35% of Java online submissions for Valid Palindrome II.
Memory Usage: 54.7 MB, less than 37.42% of Java online submissions for Valid Palindrome II.

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

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
419,318
Submissions
1,087,786

*/
public class CheckPalindrome {

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
