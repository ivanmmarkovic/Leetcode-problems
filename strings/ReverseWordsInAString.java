
import java.util.ArrayList;
import java.util.List;

/*
151. Reverse Words in a String
Medium

https://leetcode.com/problems/reverse-words-in-a-string/

Runtime: 4 ms, faster than 84.66% of Java online submissions for Reverse Words in a String.
Memory Usage: 39.1 MB, less than 75.72% of Java online submissions for Reverse Words in a String.

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Example 4:

Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"

Example 5:

Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"

 

Constraints:

    1 <= s.length <= 104
    s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    There is at least one word in s.

 

Follow up:

    Could you solve it in-place with O(1) extra space?

 
Accepted
500,689
Submissions
2,113,435

*/
public class ReverseWordsInAString {

	public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        String array[] = s.split(" ");
        
        for(String word: array){
            if(word.length() > 0)
                words.add(word);
        }
        
        
        array = new String[words.size()];
        array = words.toArray(array);
        
        int i = 0, j = array.length - 1;
        while(i < j){
            String tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < array.length; k++){
            sb.append(array[k]);
            if(k != array.length - 1)
                sb.append(" ");
        }
        
        return sb.toString();
    }
}
