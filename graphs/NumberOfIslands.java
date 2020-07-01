

import java.util.LinkedList;
import java.util.Queue;
/*

200. Number of Islands
Medium

https://leetcode.com/problems/number-of-islands/

Runtime: 3 ms, faster than 31.33% of Java online submissions for Number of Islands.
Memory Usage: 42 MB, less than 54.80% of Java online submissions for Number of Islands.

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

Accepted
651,639
Submissions
1,425,254

*/

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        
        Set<String> visited = new HashSet<>();
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && !containsCoords(visited, i, j)){
                    Integer coords[] = {i, j};
                    addCoords(visited, i, j);
                    Queue<Integer[]> queue = new LinkedList<>();
                    queue.add(coords);
                    while(!queue.isEmpty()){
                        Integer tmp[] = queue.poll();
                        int x = tmp[0];
                        int y = tmp[1];
                        lookForNeighbours(grid, x, y, queue, visited);                     
                    }
                    total += 1;
                }
            }
        }
        return total;
    }
    
    private void addCoords(Set<String> visited, int x, int y){
        visited.add("x:" + x +"y:" + y);
    }
    
    private boolean containsCoords(Set<String> visited, int x, int y){
        return visited.contains("x:" + x +"y:" + y);
    }
    
    private void lookForNeighbours(char grid[][], int x, int y, Queue<Integer[]> queue, Set<String> visited){
        if(y < grid[x].length - 1 && grid[x][y + 1] == '1' && !containsCoords(visited, x, y + 1)){
            addCoords(visited, x, y + 1);
            Integer neighbour[] = {x, y + 1};
            queue.add(neighbour);
        }
        if(y > 0 && grid[x][y - 1] == '1' && !containsCoords(visited, x, y - 1)){
            addCoords(visited, x, y - 1);
            Integer neighbour[] = {x, y - 1};
            queue.add(neighbour);
        }
        if(x < grid.length - 1 && grid[x + 1][y] == '1' && !containsCoords(visited, x + 1, y)){
            addCoords(visited, x + 1, y);
            Integer neighbour[] = {x + 1, y};
            queue.add(neighbour);
        }
        if(x > 0 && grid[x - 1][y] == '1' && !containsCoords(visited, x - 1, y)){
            addCoords(visited, x - 1, y);
            Integer neighbour[] = {x - 1, y};
            queue.add(neighbour);
        } 
    }
}
