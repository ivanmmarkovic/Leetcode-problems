
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer []> stack = new Stack<Integer[]>();
		Integer numbers[] = {0, 0};
		stack.push(numbers);
		
		int matrix[][] = new int[7][7];
		
		// unvisited fields are marked with 0
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = 0;
		
		
		matrix[0][0] = 1; // Must be 1, it's starting position
		// obstacles are marked with number 2
		
		matrix[0][1] = 2;
		matrix[0][2] = 2;
		matrix[1][5] = 2;
		matrix[1][6] = 2;
		matrix[2][2] = 2;
		matrix[2][3] = 2;
		matrix[3][1] = 2;
		matrix[3][6] = 2;
		matrix[4][2] = 2;
		matrix[4][4] = 2;
		matrix[5][1] = 2;
		matrix[5][5] = 2;
		matrix[5][6] = 2;
		matrix[6][1] = 2;
		matrix[6][3] = 2;
		
		
		
		move(stack, matrix, 0, 0);
		
	}
	
	public static void move(Stack<Integer[]> stack, int matrix[][],int row, int col) {
		if(row == matrix.length - 1 && col == matrix[row].length - 1)
			System.out.println("Path found");
		else if(stack.isEmpty())
			System.out.println("No available path");
		else {
			if(col < matrix[row].length - 1 && matrix[row][col + 1] == 0){ // can go right
				matrix[row][col + 1] = 1;
				Integer numbers[] = {row, col + 1};
				stack.push(numbers);
				move(stack, matrix, row, col + 1);
			}
			else if(col > 0 && matrix[row][col -  1] == 0) { // can go left
				matrix[row][col - 1] = 1;
				Integer numbers[] = {row, col - 1};
				stack.push(numbers);
				move(stack, matrix, row, col - 1);
			}
			else if(row > 0 && matrix[row - 1][col] == 0) { // can go up
				matrix[row - 1][col] = 1;
				Integer numbers[] = {row - 1, col};
				stack.push(numbers);
				move(stack, matrix, row - 1, col);
			}
			else if(row < matrix.length - 1 && matrix[row + 1][col] == 0) { // can go down
				matrix[row + 1][col] = 1;
				Integer numbers[] = {row + 1, col};
				stack.push(numbers);
				move(stack, matrix, row + 1, col);
			}
			else {
				stack.pop();
				if(stack.isEmpty()){
					System.out.println("No available path");
					return;
				}
				Integer nums[] = stack.peek();
				move(stack, matrix, nums[0],  nums[1]);
			}
			
		}
	}
	
}
