
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
127. Word Ladder
Medium

https://leetcode.com/problems/word-ladder/

Runtime: 1244 ms, faster than 8.19% of Java online submissions for Word Ladder.
Memory Usage: 40 MB, less than 85.72% of Java online submissions for Word Ladder.

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

Accepted
489,334
Submissions
1,598,609

*/
public class WordLadder {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> previous = new HashMap<>();
        for(String word: wordList){
            previous.put(word, null);
        }
        
        q.add(beginWord);
        visited.add(beginWord);
        String tmp = null;
        
        while(!q.isEmpty()){
            
            tmp = q.poll();
            for(String word: wordList){
                if(!visited.contains(word) && oneCharDiff(tmp, word)){
                    visited.add(word);
                    q.add(word);
                    previous.put(word, tmp);
                    if(word.equals(endWord))
                        break;
                }
            }
        }
        if(!previous.containsKey(endWord) || previous.get(endWord) == null)
            return 0;
        return getTransformCount(previous, endWord);
        
    }
    
    public boolean oneCharDiff(String one, String two){
        if(one.length() != two.length())
            return false;
        int diff = 0;
        for(int i = 0; i < one.length(); i++){
            if(one.charAt(i) != two.charAt(i))
                diff++;
        }
        
        return diff == 1;
    }
    
    public int getTransformCount(Map<String, String> previous, String endWord){
        if(previous.get(endWord) == null)
            return 1;
        else
            return 1 + getTransformCount(previous, previous.get(endWord));
    }

}
