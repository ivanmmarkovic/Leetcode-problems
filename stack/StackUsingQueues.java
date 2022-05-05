package stack;

import java.util.LinkedList;
import java.util.Queue;

/*
225. Implement Stack using Queues
Easy

https://leetcode.com/problems/implement-stack-using-queues/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
Memory Usage: 41 MB, less than 71.91% of Java online submissions for Implement Stack using Queues.

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

    void push(int x) Pushes element x to the top of the stack.
    int pop() Removes the element on the top of the stack and returns it.
    int top() Returns the element on the top of the stack.
    boolean empty() Returns true if the stack is empty, false otherwise.

Notes:

    You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False

 

Constraints:

    1 <= x <= 9
    At most 100 calls will be made to push, pop, top, and empty.
    All the calls to pop and top are valid.

 

Follow-up: Can you implement the stack using only one queue?
Accepted
333,007
Submissions
604,812

*/
public class StackUsingQueues {
	
	class MyStack {
	    
	    Queue<Integer> input;
	    Queue<Integer> output;
	    public MyStack() {
	        this.input = new LinkedList<>();
	        this.output = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	        this.input.add(x);
	    }
	    
	    public int pop() {
	        while(this.input.size() > 1){
	            this.output.add(this.input.poll());
	        }
	        int val = this.input.poll();
	        while(!this.output.isEmpty()){
	            this.input.add(this.output.poll());
	        }
	        return val;
	    }
	    
	    public int top() {
	        while(this.input.size() > 1){
	            this.output.add(this.input.poll());
	        }
	        int val = this.input.peek();
	        this.output.add(this.input.poll());
	        while(!this.output.isEmpty()){
	            this.input.add(this.output.poll());
	        }
	        return val;
	    }
	    
	    public boolean empty() {
	        return this.input.isEmpty();
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
