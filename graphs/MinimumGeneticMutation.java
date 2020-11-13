package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
433. Minimum Genetic Mutation
Medium

https://leetcode.com/problems/minimum-genetic-mutation/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Genetic Mutation.
Memory Usage: 36.7 MB, less than 91.01% of Java online submissions for Minimum Genetic Mutation.

A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

    Starting point is assumed to be valid, so it might not be included in the bank.
    If multiple mutations are needed, all mutations during in the sequence must be valid.
    You may assume start and end string is not the same.

 

Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1

 

Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2

 

Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3

 
Accepted
34,477
Submissions
81,038
*/
public class MinimumGeneticMutation {
	
	public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> previous = new HashMap<>();
        for(String word: bank){
            previous.put(word, null);
        }
        
        q.add(start);
        visited.add(start);
        String tmp = null;
        
        while(!q.isEmpty()){
            
            tmp = q.poll();
            for(String word: bank){
                if(!visited.contains(word) && oneCharDiff(tmp, word)){
                    visited.add(word);
                    q.add(word);
                    previous.put(word, tmp);
                    if(word.equals(end))
                        break;
                }
            }
        }
        if(!previous.containsKey(end) || previous.get(end) == null)
            return -1;
        return getTransformCount(previous, end) - 1;   
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
