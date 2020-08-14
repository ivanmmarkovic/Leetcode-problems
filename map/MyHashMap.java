
import java.util.ArrayList;

/*
706. Design HashMap
Easy

https://leetcode.com/problems/design-hashmap/

Runtime: 42 ms, faster than 27.68% of Java online submissions for Design HashMap.
Memory Usage: 42.7 MB, less than 94.48% of Java online submissions for Design HashMap.

Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.


Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 


Note:

    All keys and values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashMap library.

Accepted
102,256
Submissions
166,737

*/
class MyHashMap {
    
    class KeyValue{
        int key;
        int value;
        KeyValue(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private ArrayList<ArrayList<KeyValue>> map;
    private int length;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.length = 11;
        this.map = new ArrayList<ArrayList<KeyValue>>(this.length);
        for(int i = 0; i < this.length; i++)
            this.map.add(i, new ArrayList<>());
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        if(this.map.get(index).size() == 0)
            this.map.get(index).add(new KeyValue(key, value));
        else{
            int i = 0;
            boolean found = false;
            while(i < this.map.get(index).size() && !found){
                if(this.map.get(index).get(i).key == key)
                    found = true;
                else
                    i++;
            }
            if(found)
                this.map.get(index).get(i).value = value;
            else
                this.map.get(index).add(new KeyValue(key, value));
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        if(this.map.get(index).size() > 0){
            int i = 0;
            boolean found = false;
            while(i < this.map.get(index).size() && !found){
                if(this.map.get(index).get(i).key == key)
                    found = true;
                else
                    i++;
            }
            return found ? this.map.get(index).get(i).value : -1;
        }
        else
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        if(this.map.get(index).size() > 0){
            int i = 0;
            boolean found = false;
            while(i < this.map.get(index).size() && !found){
                if(this.map.get(index).get(i).key == key)
                    found = true;
                else
                    i++;
            }
            if(found)
                this.map.get(index).remove(i);
        }
    }
    
    private int hash(int key){
        return key % this.length;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */