package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
381. Insert Delete GetRandom O(1) - Duplicates allowed
Hard

https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

Runtime: 65 ms, faster than 28.50% of Java online submissions for Insert Delete GetRandom O(1) - Duplicates allowed.
Memory Usage: 86.8 MB, less than 66.07% of Java online submissions for Insert Delete GetRandom O(1) - Duplicates allowed.

Implement the RandomizedCollection class:

    RandomizedCollection() Initializes the RandomizedCollection object.
    bool insert(int val) Inserts an item val into the multiset if not present. Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the multiset if present. Returns true if the item was present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
    int getRandom() Returns a random element from the current multiset of elements (it's guaranteed that at least one element exists when this method is called). The probability of each element being returned is linearly related to the number of same values the multiset contains.

You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
[[], [1], [1], [2], [], [1], []]
Output
[null, true, false, true, 2, true, 1]

Explanation
RandomizedCollection randomizedCollection = new RandomizedCollection();
randomizedCollection.insert(1);   // return True. Inserts 1 to the collection. Returns true as the collection did not contain 1.
randomizedCollection.insert(1);   // return False. Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
randomizedCollection.insert(2);   // return True. Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
randomizedCollection.getRandom(); // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
randomizedCollection.remove(1);   // return True. Removes 1 from the collection, returns true. Collection now contains [1,2].
randomizedCollection.getRandom(); // getRandom should return 1 and 2 both equally likely.

 

Constraints:

    -231 <= val <= 231 - 1
    At most 2 * 105  calls will be made to insert, remove, and getRandom.
    There will be at least one element in the data structure when getRandom is called.

Accepted
95,389
Submissions
270,658

*/

class RandomizedCollection {
    
    Random rand;
    Map<Integer, List<Integer>> collection;
    List<Integer> randomList;
    public RandomizedCollection() {
        this.collection = new HashMap<>();
        this.randomList = new ArrayList<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean contains = false;
        if(!this.collection.containsKey(val)){
            this.collection.put(val, new ArrayList<>());
            contains = true;
        }
        if(this.collection.get(val).size() == 0)
            contains = true;
        this.collection.get(val).add(val);
        this.randomList.add(val);
        return contains;
    }
    
    public boolean remove(int val) {
        if(!this.collection.containsKey(val) || this.collection.get(val).size() == 0)
            return false;
        this.collection.get(val).remove(new Integer(val));
        this.randomList.remove(new Integer(val));
        return true;
    }
    
    public int getRandom() {
        return this.randomList.get(this.rand.nextInt(this.randomList.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
