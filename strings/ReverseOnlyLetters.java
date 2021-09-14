package strings;

import java.util.HashSet;
import java.util.Set;

/*
917. Reverse Only Letters
Easy

https://leetcode.com/problems/reverse-only-letters/

Runtime: 4 ms, faster than 8.53% of Java online submissions for Reverse Only Letters.
Memory Usage: 39.3 MB, less than 5.15% of Java online submissions for Reverse Only Letters.

Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.

Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"

Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

 

Constraints:

    1 <= s.length <= 100
    s consists of characters with ASCII values in the range [33, 122].
    s does not contain '\"' or '\\'.

Accepted
109,679
Submissions
180,994

*/
public class ReverseOnlyLetters {
	
	public String reverseOnlyLetters(String s) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String letters = upper + lower;
        
        Set<Character> chars = new HashSet<>();
        for(int i = 0; i < letters.length(); i++){
            char c = letters.charAt(i);
            chars.add(c);
        }
        
        
        char arr[] = s.toCharArray();
        int start = 0, end = arr.length - 1;
        while(start < end){
            char left = arr[start];
            char right = arr[end];
            if(chars.contains(left) && chars.contains(right)){
                char tmp = left;
                arr[start] = right;
                arr[end] = tmp;
                start++;
                end--;
            }
            else if(chars.contains(left))
                end--;
            else if(chars.contains(right))
                start++;
            else {
                start++;
                end--;
            }
        }
        return new String(arr);
    }

}
