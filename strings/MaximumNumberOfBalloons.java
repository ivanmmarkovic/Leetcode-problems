package strings;

import java.util.HashMap;
import java.util.Map;

/*
1189. Maximum Number of Balloons
Easy

https://leetcode.com/problems/maximum-number-of-balloons/

Runtime: 19 ms, faster than 5.04% of Java online submissions for Maximum Number of Balloons.
Memory Usage: 39.8 MB, less than 5.44% of Java online submissions for Maximum Number of Balloons.

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:

Input: text = "nlaebolko"
Output: 1

Example 2:

Input: text = "loonbalxballpoon"
Output: 2

Example 3:

Input: text = "leetcode"
Output: 0

 

Constraints:

    1 <= text.length <= 104
    text consists of lower case English letters only.

Accepted
89,510
Submissions
143,163

*/
public class MaximumNumberOfBalloons {

	public int maxNumberOfBalloons(String text) {

		String balloon = "balloon";
		Map<Character, Integer> count = new HashMap<>();
		for (int i = 0; i < balloon.length(); i++) {
			char c = balloon.charAt(i);
			if (!count.containsKey(c))
				count.put(c, 0);
		}

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (!count.containsKey(c))
				count.put(c, 1);
			else
				count.put(c, count.get(c) + 1);
		}
		int lo = Math.min(count.get('o'), count.get('l'));
		lo = lo / 2;
		int ban = Math.min(Math.min(count.get('b'), count.get('a')), count.get('n'));

		return Math.min(ban, lo);

	}

}
