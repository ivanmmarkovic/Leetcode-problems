
/*
641. Design Circular Deque
Medium

https://leetcode.com/problems/design-circular-deque/

Runtime: 4 ms, faster than 98.66% of Java online submissions for Design Circular Deque.
Memory Usage: 39.7 MB, less than 11.02% of Java online submissions for Design Circular Deque.

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
21,183
Submissions
38,886

*/
public class MyCircularDequeArray {
	
	int length, left, right;
    int deque[];
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDequeArray(int k) {
        this.length = k;
        this.left = this.right = -1;
        this.deque = new int[this.length];
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.isFull())
            return false;
        if(this.left == -1){
            this.left = this.right = 0;
            this.deque[this.left] = value;
            return true;
        }
        else if(this.left == 0){
            this.left = this.length - 1;
            this.deque[this.left] = value;
            return true;
        }
        else{
            this.left = this.left - 1;
            this.deque[this.left] = value;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.isFull())
            return false;
        if(this.left == -1){
            this.left = this.right = 0;
            this.deque[this.right] = value;
            return true;
        }
        else if(this.right == this.length - 1){
            this.right = (this.right + 1) % this.length;
            this.deque[this.right] = value;
            return true;
        }
        else{
            this.right += 1;
            this.deque[this.right] = value;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.isEmpty())
            return false;
        if(this.left == this.right){
            this.left = this.right = -1;
            return true;
        }
        else{
            if(this.left == this.length - 1)
                this.left = 0;
            else
                this.left += 1;
            return true;
        }
        
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.isEmpty())
            return false;
        if(this.left == this.right){
            this.left = this.right = -1;
            return true;
        }
        else{
            if(this.right == 0)
                this.right = this.length - 1;
            else
                this.right -= 1;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(this.isEmpty())
            return -1;
        return this.deque[this.left];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(this.isEmpty())
            return -1;
        return this.deque[this.right];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.left == -1;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (this.right + 1) % this.length == this.left;
    }

}

/**
 * Your MyCircularDequeArray object will be instantiated and called as such:
 * MyCircularDequeArray obj = new MyCircularDequeArray(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
