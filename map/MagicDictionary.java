package map;

import java.util.HashSet;
import java.util.Set;

/*
676. Implement Magic Dictionary
Medium

https://leetcode.com/problems/implement-magic-dictionary/

Runtime: 44 ms, faster than 57.96% of Java online submissions for Implement Magic Dictionary.
Memory Usage: 50.1 MB, less than 14.89% of Java online submissions for Implement Magic Dictionary.

Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.

Implement the MagicDictionary class:

    MagicDictionary() Initializes the object.
    void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
    bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.

 

Example 1:

Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False

 

Constraints:

    1 <= dictionary.length <= 100
    1 <= dictionary[i].length <= 100
    dictionary[i] consists of only lower-case English letters.
    All the strings in dictionary are distinct.
    1 <= searchWord.length <= 100
    searchWord consists of only lower-case English letters.
    buildDict will be called only once before search.
    At most 100 calls will be made to search.

Accepted
54,304
Submissions
97,051

*/
public class MagicDictionary {

    Set<String> dict;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.dict = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word: dictionary)
            this.dict.add(word);
    }
    
    public boolean search(String searchWord) {
        
        for(String word: this.dict){
            if(oneCharDiff(word, searchWord))
                return true;
        }
        return false;
        
    }
    
    private boolean oneCharDiff(String word, String searchWord){
        if(word.length() != searchWord.length())
            return false;
        int diff = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != searchWord.charAt(i))
                diff++;
        }
        
        return diff == 1;
        
    }
    
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
