import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer []> stack = new Stack<Integer[]>();
		Integer numbers[] = {0, 0};
		stack.push(numbers);
		
		int matrix[][] = new int[5][5];
		matrix[0][0] = 1; // Must be 1, it's starting position

		// obstacles are marked with number 2
		for(int i = 2; i < matrix[0].length; i++)
			matrix[0][i] = 2;
		matrix[1][0] = 2;
		for(int i = 0; i < matrix[2].length; i++)
			if(i != 2)
				matrix[2][i] = 2;
		for(int i = 0; i < matrix[4].length; i++)
			if(i != 4)
				matrix[4][i] = 2;
		
		
		maze(matrix, stack);
	}
	
	public static void maze(int matrix[][], Stack<Integer[]> stack) {
		if(stack.isEmpty())
			System.out.println("Can't find path");
		else {
			Integer coords[] = stack.peek();
			int x = coords[0];
			int y = coords[1];
			Integer newCoords[] = new Integer[2];
			if(x == matrix.length - 1 && y == matrix[x].length - 1) {
				System.out.println("Path found");
			}
			else if(y + 1 < matrix[x].length && matrix[x][y + 1] == 0) {// can go right
				matrix[x][y + 1] = 1;
				newCoords[0] = x;
				newCoords[1] = y + 1;
				stack.push(newCoords);
				maze(matrix, stack);
			}
			else if(y > 0 && matrix[x][y - 1] == 0) {// can go left
				matrix[x][y - 1] = 1;
				newCoords[0] = x;
				newCoords[1] = y - 1;
				stack.push(newCoords);
				maze(matrix, stack);
			}
			else if(x + 1 < matrix.length && matrix[x + 1][y] == 0){// can go down
				matrix[x + 1][y] = 1;
				newCoords[0] = x + 1;
				newCoords[1] = y;
				stack.push(newCoords);
				maze(matrix, stack);
			}
			else if(x > 0 && matrix[x][y] == 0){// can go up
				matrix[x - 1][y] = 1;
				newCoords[0] = x - 1;
				newCoords[1] = y;
				stack.push(newCoords);
				maze(matrix, stack);
			}
			else { // nowhere to go
				stack.pop();
				maze(matrix, stack);
			}
		}
	}

}
