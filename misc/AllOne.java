

import java.util.HashMap;

/*
432. All O`one Data Structure
Hard

https://leetcode.com/problems/all-oone-data-structure/

Runtime: 14 ms, faster than 99.03% of Java online submissions for All O`one Data Structure.
Memory Usage: 45.3 MB, less than 87.45% of Java online submissions for All O`one Data Structure.

Implement a data structure supporting the following operations:

    Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
    Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
    GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
    GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".

Challenge: Perform all these in O(1) time complexity.
Accepted
32,765
Submissions
100,857

*/
class AllOne {

    private HashMap<String, Integer> map;
    int min, max;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key))
            map.put(key, map.get(key) + 1);
        else
            map.put(key, 1);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key))
            return;
        if(map.get(key) == 1)
            map.remove(key);
        else
            map.put(key, map.get(key) - 1);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(map.isEmpty())
            return "";
        int max = Integer.MIN_VALUE;
        String k = null;
        for(String key: map.keySet())
            if(map.get(key) > max){
                max = map.get(key);
                k = key;
            }
        return k;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.isEmpty())
            return "";
        int min = Integer.MAX_VALUE;
        String k = null;
        for(String key: map.keySet())
            if(map.get(key) < min){
                min = map.get(key);
                k = key;
            }
        return k;
    }
    
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */