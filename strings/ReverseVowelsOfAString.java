
import java.util.HashSet;
import java.util.Set;

/*
345. Reverse Vowels of a String
Easy

https://leetcode.com/problems/reverse-vowels-of-a-string/

Runtime: 3 ms, faster than 79.76% of Java online submissions for Reverse Vowels of a String.
Memory Usage: 38.9 MB, less than 89.34% of Java online submissions for Reverse Vowels of a String.


Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".

 
Accepted
248,270
Submissions
555,546
*/
public class ReverseVowelsOfAString {
	
	public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        
        int i = 0, j = s.length() - 1;
        char chars[] = s.toCharArray();
        while(i < j){
            if(vowels.contains(chars[i]) && vowels.contains(chars[j])){
                char c = chars[i];
                chars[i] = chars[j];
                chars[j]= c;
                i++;
                j--;
            }
            else if(vowels.contains(chars[i]))
                j--;
            else if(vowels.contains(chars[j]))
                i++;
            else{
                i++;
                j--;
            }
        }
        return new String(chars);
    }

}
