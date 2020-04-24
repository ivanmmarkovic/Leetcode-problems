/*
695. Max Area of Island
Medium

https://leetcode.com/problems/max-area-of-island/

Runtime: 25 ms, faster than 5.47% of Java online submissions for Max Area of Island.
Memory Usage: 40.6 MB, less than 96.30% of Java online submissions for Max Area of Island.

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
        Set<String> visited = new HashSet<>();
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && !containsCoords(visited, i, j)){
                    Integer coords[] = {i, j};
                    addCoords(visited, i, j);
                    Queue<Integer[]> queue = new LinkedList<>();
                    queue.add(coords);
                    int total = 0;
                    while(!queue.isEmpty()){
                        Integer tmp[] = queue.poll();
                        total += 1;
                        int x = tmp[0];
                        int y = tmp[1];
                        lookForNeighbours(grid, x, y, queue, visited);                     
                    }
                    if(total > result)
                        result = total;
                }
            }
        }
        return result;
    }
    
    private void addCoords(Set<String> visited, int x, int y){
        visited.add("x:" + x +"y:" + y);
    }
    
    private boolean containsCoords(Set<String> visited, int x, int y){
        return visited.contains("x:" + x +"y:" + y);
    }
    
    private void lookForNeighbours(int grid[][], int x, int y, Queue<Integer[]> queue, Set<String> visited){
        if(y < grid[x].length - 1 && grid[x][y + 1] == 1 && !containsCoords(visited, x, y + 1)){
            addCoords(visited, x, y + 1);
            Integer neighbour[] = {x, y + 1};
            queue.add(neighbour);
        }
        if(y > 0 && grid[x][y - 1] == 1 && !containsCoords(visited, x, y - 1)){
            addCoords(visited, x, y - 1);
            Integer neighbour[] = {x, y - 1};
            queue.add(neighbour);
        }
        if(x < grid.length - 1 && grid[x + 1][y] == 1 && !containsCoords(visited, x + 1, y)){
            addCoords(visited, x + 1, y);
            Integer neighbour[] = {x + 1, y};
            queue.add(neighbour);
        }
        if(x > 0 && grid[x - 1][y] == 1 && !containsCoords(visited, x - 1, y)){
            addCoords(visited, x - 1, y);
            Integer neighbour[] = {x - 1, y};
            queue.add(neighbour);
        } 
    }
}