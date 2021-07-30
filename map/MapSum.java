package map;

import java.util.HashMap;

/*
677. Map Sum Pairs
Medium

https://leetcode.com/problems/map-sum-pairs/

Runtime: 12 ms, faster than 56.03% of Java online submissions for Map Sum Pairs.
Memory Usage: 39 MB, less than 54.18% of Java online submissions for Map Sum Pairs.


Implement the MapSum class:

    MapSum() Initializes the MapSum object.
    void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
    int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.

 

Example 1:

Input
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
Output
[null, null, 3, null, 5]

Explanation
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

 

Constraints:

    1 <= key.length, prefix.length <= 50
    key and prefix consist of only lowercase English letters.
    1 <= val <= 1000
    At most 50 calls will be made to insert and sum.

Accepted
65,082
Submissions
115,915
*/

class MapSum {

    /** Initialize your data structure here. */
    HashMap<String, Integer> map;
    public MapSum() {
        this.map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        this.map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String key: this.map.keySet()){
            if(key.startsWith(prefix))
                sum += this.map.get(key);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
