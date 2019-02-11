
public class MaxStack {
	
	Stack membersStack;
	Stack maxStack;
	
	public MaxStack() {
		this.membersStack = new Stack();
		this.maxStack = new Stack();
	}
	
	public void push(int payload) {
		membersStack.push(payload);
		if(maxStack.isEmpty())
			maxStack.push(payload);
		else if(payload >= maxStack.head.payload)
			maxStack.push(payload);
	}
	
	public void pop() {
		if(membersStack.head.payload == maxStack.head.payload)
			maxStack.pop();
		membersStack.pop();
	}
	
	public int getMax() {
		return maxStack.head.payload;
	}

}
