
import java.util.HashMap;
/*
146. LRU Cache
Medium

https://leetcode.com/problems/lru-cache/
 
Runtime: 13 ms, faster than 72.90% of Java online submissions for LRU Cache.
Memory Usage: 47.1 MB, less than 9.10% of Java online submissions for LRU Cache.

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

Follow up:
Could you do get and put in O(1) time complexity?

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

 

Constraints:

    1 <= capacity <= 3000
    0 <= key <= 3000
    0 <= value <= 104
    At most 3 * 104 calls will be made to get and put.

Accepted
636,103
Submissions
1,851,216
*/

class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    class DoublyLinkedList {
        Node head;
        Node tail;
        
        public boolean isEmpty(){
            return this.head == null;
        }
        
        public void addToHead(Node node){
            if(this.isEmpty()){
                this.head = this.tail = node;
                node.prev = null;
                node.next = null;
            }
            else{
                node.prev = null;
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
            }
        }
        
        public Node deleteFromTail(){
            Node node = this.tail;
            if(this.head == this.tail){
                this.head = this.tail = null;
            }
            else{
                this.tail = this.tail.prev;
                this.tail.next = null;   
            }
            return node;
        }
        
        public void moveToHead(Node node){
            if(this.head == node)
                return;
            else if(this.tail == node){
                this.deleteFromTail();
                this.addToHead(node);
            }
            else{
                node.prev.next = node.next;
                if(node.next != null)
                    node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                this.addToHead(node);
            }
        }
    }
    
    HashMap<Integer, Node> nodes;
    DoublyLinkedList list;
    int count, capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.nodes = new HashMap<>();
        this.list = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(nodes.containsKey(key)){
            Node node = nodes.get(key);
            this.list.moveToHead(node);
            return node.value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(nodes.containsKey(key)){
            Node node = nodes.get(key);
            node.value = value;
            this.list.moveToHead(node);
        }
        else{
            Node node = new Node(key, value);
            nodes.put(key, node);
            this.count++;
            this.list.addToHead(node);
            if(this.count > this.capacity){
                Node toDelete = this.list.deleteFromTail();
                this.nodes.remove(toDelete.key);
                this.count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
