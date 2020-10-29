
import java.util.HashMap;
/*
451. Sort Characters By Frequency
Medium

https://leetcode.com/problems/sort-characters-by-frequency/

Runtime: 11 ms, faster than 72.58% of Java online submissions for Sort Characters By Frequency.
Memory Usage: 39.6 MB, less than 5.21% of Java online submissions for Sort Characters By Frequency.

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Accepted
219,736
Submissions
345,358

*/
public class SortCharactersByFrequency {
	
	public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(count.containsKey(c))
                count.put(c, count.get(c) + 1);
            else
                count.put(c, 1);
        }
        
        KeyVal vals[] = new KeyVal[count.size()];
        int index = 0;
        for(Character key: count.keySet()){
            vals[index++] = new KeyVal(key, count.get(key));
        }
        for(int i = 0; i < vals.length; i++){
            for(int j = 0; j < vals.length - 1; j++){
                if(vals[j].count < vals[j + 1].count){
                    KeyVal tmp = vals[j];
                    vals[j] = vals[j + 1];
                    vals[j + 1] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vals.length; i++)
            for(int j = 0; j < vals[i].count; j++)
                sb.append(vals[i].key);
        return sb.toString();
        
    }
    
    class KeyVal {
        char key;
        int count;
        public KeyVal(char key, int count){
            this.key = key;
            this.count = count;
        }
    }

}
