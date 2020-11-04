
import java.util.HashMap;

/*
460. LFU Cache
Hard

https://leetcode.com/problems/lfu-cache/

Runtime: 15 ms, faster than 95.22% of Java online submissions for LFU Cache.
Memory Usage: 46.9 MB, less than 6.15% of Java online submissions for LFU Cache.

Design and implement a data structure for Least Frequently Used (LFU) cache.

Implement the LFUCache class:

    LFUCache(int capacity) Initializes the object with the capacity of the data structure.
    int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
    void put(int key, int value) Sets or inserts the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be evicted.

Notice that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.

Follow up:
Could you do both operations in O(1) time complexity?

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
LFUCache lFUCache = new LFUCache(2);
lFUCache.put(1, 1);
lFUCache.put(2, 2);
lFUCache.get(1);      // return 1
lFUCache.put(3, 3);   // evicts key 2
lFUCache.get(2);      // return -1 (not found)
lFUCache.get(3);      // return 3
lFUCache.put(4, 4);   // evicts key 1.
lFUCache.get(1);      // return -1 (not found)
lFUCache.get(3);      // return 3
lFUCache.get(4);      // return 4

 

Constraints:

    0 <= capacity, key, value <= 104
    At most 105 calls will be made to get and put.

Accepted
85,166
Submissions
243,448

*/
class Node {
	
	int key;
	int value;
	int freq;
	public Node next;
	public Node prev;
	public Node(int key, int value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
		this.freq = 1;
	}

}
class FreqNode {
	
	int freq;
	FreqNode next;
	DoublyLinkedListNodes nodes;
	public FreqNode prev;
	public FreqNode(int freq) {
		// TODO Auto-generated constructor stub
		this.freq = freq;
		this.nodes = new DoublyLinkedListNodes();
	}
	

}


class DoublyLinkedListFreqNode {
	
	FreqNode head, tail;

	public void removeFreqNode(FreqNode oldFreqNode) {
		if(this.isEmpty())
			return;
		else if(this.head == oldFreqNode) {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
		}
		else if(this.tail == oldFreqNode) {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		else {
			oldFreqNode.prev.next = oldFreqNode.next;
			oldFreqNode.next.prev = oldFreqNode.prev;
		}
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head == null;
	}

	public void insertAfter(FreqNode oldFreqNode, FreqNode newFreqNode) {
		newFreqNode.next = null;
		newFreqNode.prev = null;
		if(this.tail == oldFreqNode) {
			newFreqNode.prev = this.tail;
			this.tail.next = newFreqNode;
			this.tail = newFreqNode;
		}
		else {
			newFreqNode.prev = oldFreqNode;
			newFreqNode.next = oldFreqNode.next;
			oldFreqNode.next = newFreqNode;
			newFreqNode.next.prev = newFreqNode;
		}
	}

	public void addToHead(FreqNode freqNode) {
		freqNode.next = null;
		freqNode.prev = null;
		if(this.isEmpty())
			this.head = this.tail = freqNode;
		else {
			freqNode.next = this.head;
			this.head.prev = freqNode;
			this.head = freqNode;
		}
	}

	public void deleteFromHead() {
		if(this.isEmpty())
			return;
		else {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
		}
		
	}

}


class DoublyLinkedListNodes {
	
	Node head, tail;

	public void removeNode(Node node) {
		if(node == this.head) {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			node.prev = null;
			node.next = null;
		}
		else if(node == this.tail)
			this.deleteFromTail();
		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void addToHead(Node node) {
		node.next = null;
		node.prev = null;
		if(this.isEmpty()) {
			this.head = this.tail = node;
		}
		else {
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}
	}

	public Node deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			Node retNode = this.tail;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			retNode.next = null;
			retNode.prev = null;
			return retNode;
		}
	}

}


public class LFUCache {
    
    
	
	int count, capacity;
	HashMap<Integer, Node> nodesMap;
	HashMap<Integer, FreqNode> freqNodesMap;
	DoublyLinkedListFreqNode freqNodesList;
	public LFUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.nodesMap = new HashMap<>();
		this.freqNodesMap = new HashMap<>();
		this.freqNodesList = new DoublyLinkedListFreqNode();
    }
    
    public int get(int key) {
		if(this.nodesMap.containsKey(key)) {
			Node node = this.nodesMap.get(key);
			this.updateNodeInFreqNodesList(node);
			return node.value;
		}
		else {
			return -1;
		}
		
    }

	public void put(int key, int value) {
    	Node newNode;
        if(this.nodesMap.containsKey(key)) {
        	newNode = this.nodesMap.get(key);
        	newNode.value = value;
        	this.updateNodeInFreqNodesList(newNode);
        }
        else {
            if(this.capacity == 0)
        		return;
        	if(this.count == this.capacity) {
        		FreqNode headFreqNode = this.freqNodesList.head;
        		Node oldNode = headFreqNode.nodes.deleteFromTail();
        		this.nodesMap.remove(oldNode.key);
        		if(headFreqNode.nodes.isEmpty()) {
        			this.freqNodesMap.remove(headFreqNode.freq);
        			this.freqNodesList.deleteFromHead();
        		}
        		this.count--;
        	}
        	newNode = new Node(key, value);
        	this.nodesMap.put(key, newNode);
        	FreqNode freqNode;
        	if(this.freqNodesMap.containsKey(1)) {
        		freqNode = this.freqNodesMap.get(1);
        		freqNode.nodes.addToHead(newNode);
        	}
        	else {
        		freqNode = new FreqNode(1);
        		freqNode.nodes.addToHead(newNode);
        		this.freqNodesMap.put(1, freqNode);
        		this.freqNodesList.addToHead(freqNode);
        	}
        	
        	
        	this.count++;
        }
    }
	
	private void updateNodeInFreqNodesList(Node node) {
		int oldFreq = node.freq;
		FreqNode oldFreqNode = this.freqNodesMap.get(oldFreq);
		oldFreqNode.nodes.removeNode(node);
		
		node.freq++;
		int newFreq = node.freq;
		FreqNode newFreqNode;
		if(this.freqNodesMap.containsKey(newFreq)) {
			newFreqNode = this.freqNodesMap.get(node.freq);
			newFreqNode.nodes.addToHead(node);
		}
		else {
			newFreqNode = new FreqNode(node.freq);
			newFreqNode.nodes.addToHead(node);
			this.freqNodesMap.put(node.freq, newFreqNode);
			this.freqNodesList.insertAfter(oldFreqNode, newFreqNode);
		}
		
		if(oldFreqNode.nodes.isEmpty()) {
			this.freqNodesList.removeFreqNode(oldFreqNode);
			this.freqNodesMap.remove(oldFreq);
		}
		
	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
