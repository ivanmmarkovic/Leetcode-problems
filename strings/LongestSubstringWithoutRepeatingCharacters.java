package strings;

import java.util.HashSet;
import java.util.Set;

/*
Longest Substring Without Repeating Characters
Medium

https://leetcode.com/problems/longest-substring-without-repeating-characters/

Runtime: 16 ms, faster than 36.78% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 46.1 MB, less than 29.40% of Java online submissions for Longest Substring Without Repeating Characters.

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


*/

class LongestSubstringWithoutRepeatingCharacters {
	
	// sliding window technique
	public int lengthOfLongestSubstring(String s) {
        int length = 0;
		int i = 0, j = 0;
		Set<Character> chars = new HashSet<>();
		while(j < s.length()) {
			char c = s.charAt(j);
			if(!chars.contains(c)) {
				chars.add(c);
				length = Math.max(length, chars.size());
			}
			else {
				while(true) {
					char r = s.charAt(i++);
					chars.remove(r);
					length = Math.max(length, chars.size());
					if(c == r)
						break;
				}
				chars.add(c);
				length = Math.max(length, chars.size());
			}
			j++;
		}
		return length;

	}
}
