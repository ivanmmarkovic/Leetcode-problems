
public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {1, 2, 3, 4, 5, 6, 7};
		printArray(numbers);
		reverse(numbers);
		printArray(numbers);
	}
	
	public static void printArray(int numbers[]) {
		for(int i: numbers)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void reverse(int numbers[]) {
		int start = 0;
		int end = numbers.length - 1;
		while(start < end) {
			int tmp = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = tmp;
			start++;
			end--;
		}
	}

}
