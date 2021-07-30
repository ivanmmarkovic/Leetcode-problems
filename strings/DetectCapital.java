package strings;

/*
520. Detect Capital
Easy

https://leetcode.com/problems/detect-capital/
 
Runtime: 1 ms, faster than 99.67% of Java online submissions for Detect Capital.
Memory Usage: 39.1 MB, less than 10.44% of Java online submissions for Detect Capital.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true

Example 2:

Input: word = "FlaG"
Output: false

 

Constraints:

    1 <= word.length <= 100
    word consists of lowercase and uppercase English letters.

Accepted
199,093
Submissions
367,547

*/


public class DetectCapital {
	
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1)
            return true;
        
        char firstLetter = word.charAt(0);
        String first = Character.toString(firstLetter);
        if(first.toLowerCase() == first){
            boolean allSmall = true;
            for(int i = 1; i < word.length(); i++){
                char c = word.charAt(i);
                String s = Character.toString(c);
                if(s.toLowerCase() != s)
                    allSmall = false;
            }
            return allSmall;
        }
        else{
        
            boolean allCapital = true;
            boolean allSmall = true;

            for(int i = 1; i < word.length(); i++){
                char c = word.charAt(i);
                String s = Character.toString(c);
                if(s.toUpperCase() != s)
                    allCapital = false;
                if(s.toLowerCase() != s)
                    allSmall = false;
            }
            return allCapital || allSmall;
            
        }
    }
}
