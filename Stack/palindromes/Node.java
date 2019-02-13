package palindromes;

public class Node {
	
	String payload;
	Node prev, next;
	public Node(){
		this.payload = null;
		this.prev = this.next = null;
	}
	public Node(String s) {
		this.payload = s;
		this.prev = this.next = null;
	}
	public Node(String s, Node prev, Node next) {
		this.payload = s;
		this.prev = prev;
		this.next = next;
	}
	

}
