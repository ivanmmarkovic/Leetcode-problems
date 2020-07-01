
import java.util.LinkedList;
import java.util.Queue;

/*
695. Max Area of Island
Medium

https://leetcode.com/problems/max-area-of-island/

Runtime: 4 ms, faster than 30.59% of Java online submissions for Max Area of Island.
Memory Usage: 39.4 MB, less than 97.18% of Java online submissions for Max Area of Island.

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]

Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50.
Accepted
135,101
Submissions
220,947

*/
class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = new boolean[grid[i].length];
		}
		int result = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					Queue<int[]> queue  = new LinkedList<int[]>();
					int coords[] = {i, j};
					queue.add(coords);
					visited[i][j] = true;
					int tmpCount = 0;
					while (!queue.isEmpty()) {
						coords = queue.poll();
						tmpCount += 1;
						addNeighbours(coords, grid, visited, queue);
					}
					if(tmpCount > result)
						result = tmpCount;
				}
			}
		}
		return result;
    }
    
    private void addNeighbours(int[] coords, int[][] grid, boolean[][] visited, Queue<int[]> queue) {
		int x = coords[0];
		int y = coords[1];
		if(y < grid[x].length - 1 &&  grid[x][y + 1] == 1 && !visited[x][y + 1]) {
			addToQueue(x, y + 1, visited, queue);
		}
		if(y > 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
			addToQueue(x, y - 1, visited, queue);
		}
		if(x < grid.length - 1 && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
			addToQueue(x + 1, y, visited, queue);
		}
		if(x > 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
			addToQueue(x - 1, y, visited, queue);
		}
	}

	private void addToQueue(int x, int y, boolean[][] visited, Queue<int[]> queue) {
		visited[x][y] = true;
		int xy[] = {x, y};
		queue.add(xy);
	}
}
