package palindromes;

public class List {

	Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	
	public void printAll() {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.payload + ", ");
		System.out.println();
	}
	
	public int size() {
		int count = 0;
		for(Node tmp =this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void addToHead(String payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.head = new Node(payload, null, this.head);
			this.head.next.prev = this.head;
		}
	}
	public void addToTail(String payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.tail = new Node(payload, this.tail, null);
		}
	}
	public String deleteFromHead() {
		if(this.isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			String toReturn = this.head.payload;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			return toReturn;
		}
	}
	public String deleteFromTail() {
		if(this.isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			String toReturn = this.tail.payload;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else  {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			return toReturn;
		}
	}
}
