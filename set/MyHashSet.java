

import java.util.ArrayList;


/*
705. Design HashSet
Easy

https://leetcode.com/problems/design-hashset/

Runtime: 65 ms, faster than 17.52% of Java online submissions for Design HashSet.
Memory Usage: 45.6 MB, less than 95.93% of Java online submissions for Design HashSet.

Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

    add(value): Insert a value into the HashSet. 
    contains(value) : Return whether the value exists in the HashSet or not.
    remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.


Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)


Note:

    All values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashSet library.

Accepted
94,321
Submissions
146,695

*/
class MyHashSet {

    private ArrayList<ArrayList<Integer>> set;
    private int length;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.length = 11;
        this.set = new ArrayList<>(this.length);
        for(int i = 0; i < this.length; i++)
            this.set.add(i, new ArrayList<>());
    }
    
    public void add(int key) {
        if(contains(key))
            return;
        int index = hash(key);
        if(this.set.get(index).size() == 0){
            this.set.get(index).add(key);
        }
        else{
            this.set.get(index).add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(this.set.get(index).size() > 0){
            int i = 0;
            boolean found = false;
            while(i < this.set.get(index).size() && !found){
                if(this.set.get(index).get(i) == key)
                    found = true;
                else
                    i++;
            }
            if(found)
                this.set.get(index).remove(i);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        if(this.set.get(index).size() > 0){
            int i = 0;
            boolean found = false;
            while(i < this.set.get(index).size() && !found){
                if(this.set.get(index).get(i) == key)
                    found = true;
                else
                    i++;
            }
            return found;
        }
        else
            return false;
    }
    
    private int hash(int key){
        return key % this.length;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */