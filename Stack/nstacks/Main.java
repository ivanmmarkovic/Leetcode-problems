package nstack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack(5);
		for(int i = 0; i <= 15; i++)
			s.push(i);
		System.out.println("Last added is : " + s.peek());
		
		while(!s.isEmpty()) {
			System.out.println("Out goes : " + s.pop());
		}
		System.out.println(s.peek());
	}

}
