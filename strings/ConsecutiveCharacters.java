package strings;

/*
1446. Consecutive Characters
Easy

https://leetcode.com/problems/consecutive-characters/

Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
Memory Usage: 38.9 MB, less than 46.68% of Java online submissions for Consecutive Characters.

The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

Example 3:

Input: s = "triplepillooooow"
Output: 5

Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11

Example 5:

Input: s = "tourist"
Output: 1

 

Constraints:

    1 <= s.length <= 500
    s consists of only lowercase English letters.

Accepted
79,139
Submissions
129,436

*/
public class ConsecutiveCharacters {
	
	public int maxPower(String s) {
		
		if(s == null || s.length() == 0)
			return 0;
		
		int power = 0;
		char c = s.charAt(0);
		int connected = 1;
		int index = 1;
		
		while(index < s.length()) {
			char ch = s.charAt(index);
			if(ch == c)
				connected++;
			else {
				power = Math.max(power, connected);
				c = ch;
				connected = 1;
			}
			index++;
		}
		power = Math.max(connected, power);
		
		return power;
		
		
	}
	
	/*
	public int maxPower(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int power = 1; 
		int connected = 1;
		char c = s.charAt(0);
		int index = 1;
		while(index < s.length()) {
			if(s.charAt(index) == c) {
				connected++;
				power = Math.max(power, connected);
			}
			else {
				power = Math.max(power, connected);
				c = s.charAt(index);
				connected = 1;
			}
			index++;
		}
		
		return power;
	}
	*/
	/*

	public int maxPower(String s) {

		if (s.length() < 2)
			return s.length();

		int power = 0;
		char currentCharacter = s.charAt(0);
		int connected = 1;
		int i = 1;
		while (i < s.length()) {
			if (currentCharacter == s.charAt(i)) {
				connected++;
				power = Math.max(power, connected);
			} else {
				currentCharacter = s.charAt(i);
				power = Math.max(power, connected);
				connected = 1;
			}

			if (i == s.length() - 1) {
				currentCharacter = s.charAt(i);
				power = Math.max(power, connected);
				connected = 1;
			}
			i++;
		}
		return power;
	}
	
	*/
}
