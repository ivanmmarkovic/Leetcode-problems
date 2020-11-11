

import java.util.Stack;


public class SortStackRecursively {
	
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(17);
		stack.push(3);
		stack.push(100);
		stack.push(1);
		stack.push(20);
		
		for (Integer i: stack) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		sort(stack);
		for (Integer i: stack) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
	}
	
	public static void sort(Stack<Integer> stack) {
		removeElement(stack);
	}
	
	private static void removeElement(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int tmp = stack.pop();
			removeElement(stack);
			insertElement(tmp, stack);
		}
	}

	private static void insertElement(int tmp, Stack<Integer> stack) {
		if(stack.isEmpty() || tmp >= stack.peek()) {
			stack.push(tmp);
		}
		else {
			int poped = stack.pop();
			insertElement(tmp, stack);
			stack.push(poped);
		}
	}

}
