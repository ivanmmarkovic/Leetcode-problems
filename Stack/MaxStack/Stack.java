
public class Stack {

	public Node head;
	
	public Stack() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	public void push(int payload) {
		this.head = new Node(payload, this.head);
	}
	public Node pop() {
		if(this.isEmpty())
			return null;
		else {
			Node deleteMe = this.head;
			this.head = this.head.next;
			return deleteMe;
		}
	}
	
}
