package nstack;

/*
 * Implement n > 0 stacks using a single array to store
 * all stack data. No stack should be full unless the entire 
 * array is full
 */

public class Stack {
	
	public int stack[];
	private int size, pointer;
	public Stack(int size) {
		this.size = size;
		this.stack = new int[this.size];
		this.pointer = -1;
	}
	
	public int size() {
		return this.pointer + 1;
	}
	
	public boolean isEmpty() {
		return this.pointer == -1;
	}
	
	public Integer peek() {
		if(this.pointer >= 0)
			return this.stack[this.pointer];
		else {
			System.out.println("Stack is empty");
			return  null;
		}
	}
	
	public void push(int element) {
		if(this.pointer < this.size - 1)
			this.stack[++this.pointer] = element;
		else
			System.out.println("Stack is full");
	}
	
	public Integer pop() {
		if(this.pointer < 0) {
			System.out.println("Stack is empty");
			return null;
		}
		else
			return this.stack[this.pointer--];
	}

}
