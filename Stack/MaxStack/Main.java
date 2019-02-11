/*
 * stack with push, pop and max function
 * which returns the max value in the stack, 
 * all of which run in O(1) time
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxStack s = new MaxStack();
		
		s.push(99);
		s.push(100);
		s.push(1);
		s.push(3);
		s.push(4);
		s.push(100);
		System.out.println("Max in the stack is :" + s.getMax());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Max in the stack is :" + s.getMax());

	}

}
