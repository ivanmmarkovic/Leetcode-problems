import java.util.LinkedHashMap;

/*
https://leetcode.com/problems/lru-cache/

146. LRU Cache
Medium

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); // capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Runtime: 16 ms, faster than 49.05% of Java online submissions for LRU Cache.
Memory Usage: 53.7 MB, less than 81.59% of Java online submissions for LRU Cache.
Next challenges: 


*/

class LRUCache {
    
	private LinkedHashMap<Integer, Integer> cache;
    private int currentCapacity;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)) {
        	int retValue = this.cache.get(key);
        	this.cache.remove(key);
            this.cache.put(key, retValue);
            return retValue;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
        	this.cache.remove(key);
            this.cache.put(key, value);
            return;
        }
        if(this.currentCapacity == this.capacity){
            Integer tmpKey = null;
            for(int currentKey: cache.keySet()) {
            	if(tmpKey == null) {
            		tmpKey = currentKey;
            		break;
            	}
            }
            this.cache.remove(tmpKey);
            this.currentCapacity -= 1;
        }
        this.cache.put(key, value);
        this.currentCapacity += 1;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
