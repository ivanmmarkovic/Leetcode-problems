
/*
641. Design Circular Deque
Medium

https://leetcode.com/problems/design-circular-deque/

Runtime: 4 ms, faster than 98.93% of Java online submissions for Design Circular Deque.
Memory Usage: 40 MB, less than 5.07% of Java online submissions for Design Circular Deque.

Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

    MyCircularDeque(k): Constructor, set the size of the deque to be k.
    insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
    insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
    deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
    deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
    getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
    getRear(): Gets the last item from Deque. If the deque is empty, return -1.
    isEmpty(): Checks whether Deque is empty or not. 
    isFull(): Checks whether Deque is full or not.

 

Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			// return 2
circularDeque.isFull();				// return true
circularDeque.deleteLast();			// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			// return 4

 

Note:

    All values will be in the range of [0, 1000].
    The number of operations will be in the range of [1, 1000].
    Please do not use the built-in Deque library.

Accepted
21,119
Submissions
38,779

*/
class MyCircularDeque {
    
    class Node {
        int value;
        Node prev, next;
        Node(int value){
            this.value = value;
        }
        Node(int value, Node prev, Node next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    int count, length;
    Node head, tail;
    public MyCircularDeque(int k) {
        this.count = 0;
        this.length = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.isFull())
            return false;
        if(this.isEmpty()){
            this.head = this.tail = new Node(value);
            this.tail.next = this.head;
            this.head.prev = this.tail;
        }
        else{
            this.head = new Node(value, this.tail, this.head);
            this.tail.next = this.head;
            this.head.next.prev = this.head;
        }
        this.count++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.isFull())
            return false;
        if(this.isEmpty()){
            this.head = this.tail = new Node(value);
            this.tail.next = this.head;
            this.head.prev = this.tail;
        }
        else{
            this.tail.next = new Node(value, this.tail, this.head);
            this.tail = this.tail.next;
            this.head.prev = this.tail;
        }
        this.count++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.isEmpty())
            return false;
        if(this.head == this.tail){
            this.head = this.tail = null;
        }
        else{
            this.head = this.head.next;
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }
        this.count--;
        return true;
            
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.isEmpty())
            return false;
        if(this.head == this.tail){
            this.head = this.tail = null;
        }
        else{
            this.tail = this.tail.prev;
            this.tail.next = this.head;
            this.head.prev = this.tail;
        }
        this.count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(this.isEmpty())
            return -1;
        return this.head.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(this.isEmpty())
            return -1;
        return this.tail.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.head == null;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.count == this.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
