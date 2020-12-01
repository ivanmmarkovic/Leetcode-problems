
import java.util.HashMap;

/*
387. First Unique Character in a String
Easy

https://leetcode.com/problems/first-unique-character-in-a-string/

Runtime: 29 ms, faster than 14.33% of Java online submissions for First Unique Character in a String.
Memory Usage: 39.8 MB, less than 22.05% of Java online submissions for First Unique Character in a String.

Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

 

Note: You may assume the string contains only lowercase English letters.
Accepted
633,412
Submissions
1,180,801
*/

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(chars.containsKey(s.charAt(i)))
                chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
            else
                chars.put(s.charAt(i), 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(chars.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
