package graph;

import java.util.HashMap;
import java.util.Map;

/*
64. Minimum Path Sum

Medium

https://leetcode.com/problems/minimum-path-sum/description/


Runtime 106ms Beats 5.52%

Memory 60.15MB Beats 5.70%


Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200


*/



public class MinimumPathSum {

    class Vertex {
        String label;
        Integer weight;
        Integer index;
        public Vertex(String label){
            this.label = label;
            this.weight = Integer.MAX_VALUE;
        }
    }

    public int minPathSum(int[][] grid) {
        
        Map<String, Vertex> vertices = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for(int i= 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                String key = String.valueOf(i) + "@" + String.valueOf(j);
                vertices.put(key, new Vertex(key));
                prev.put(i + "@" + j, null);
            }
        }

        vertices.get("0@0").weight = grid[0][0];
        BinaryHeap bh = new BinaryHeap(vertices.size() + 1);
        for(Vertex v: vertices.values())
            bh.insert(v);

        while(!bh.isEmpty()){
            Vertex v = bh.deleteMin();
            if(v == null)
                break;
            String[] coords = v.label.split("@");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            /*
            if(x > 0){
                Vertex n = vertices.get((x - 1) + "@" + y);
                if(n.weight > v.weight + grid[x - 1][y]){
                    n.weight = v.weight + grid[x - 1][y];
                    prev.put(n.label, v.label);
                    bh.decreaseKey(n.index);
                }
            }
            */
            if(x < grid.length - 1){
                Vertex n = vertices.get((x + 1) + "@" + y);
                if(n.weight > v.weight + grid[x + 1][y]){
                    n.weight = v.weight + grid[x + 1][y];
                    prev.put(n.label, v.label);
                    bh.decreaseKey(n.index);
                }
            }
            if(y < grid[x].length - 1){
                String key = String.valueOf(x) + "@" + String.valueOf(y + 1);
                Vertex n = vertices.get(key);
                if(n.weight > v.weight + grid[x][y + 1]){
                    n.weight = v.weight + grid[x][y + 1];
                    prev.put(n.label, v.label);
                    bh.decreaseKey(n.index);
                }
            }
            /*
            if(y > 0){
                Vertex n = vertices.get(x + "@" + (y - 1));
                if(n.weight > v.weight + grid[x][y - 1]){
                    n.weight = v.weight + grid[x][y - 1];
                    prev.put(n.label, v.label);
                    bh.decreaseKey(n.index);
                }
            }
            */
        }

        return returnDistance(prev, grid, String.valueOf(grid.length - 1) + "@" + String.valueOf(grid[grid.length - 1].length - 1));

        
    }

    private int returnDistance(Map<String, String> prev, int[][] grid, String label){
        if(label.equals("0@0"))
            return grid[0][0];
        String[] coords = label.split("@");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        return returnDistance(prev, grid, prev.get(label)) + grid[x][y];
    }

    public class BinaryHeap {
	
        private int pointer;
        private int size;
        private Vertex heap[];
        
        public BinaryHeap(int size) {
            this.size = size;
            this.pointer = 0;
            this.heap = new Vertex[this.size];
        }
        
        public boolean isEmpty() {
            return this.pointer == 0;
        }
        
        public void insert(Vertex vertex) {
            if(this.pointer + 1 >= this.size)
                return;
            this.pointer++;
            vertex.index = this.pointer;
            this.heap[this.pointer] = vertex;
            this.percUp(this.pointer);
        }
        
        public void percUp(int index) {
            Vertex tmp;
            while(index / 2 > 0) {
                if(this.heap[index].weight < this.heap[index/2].weight) {
                    tmp = this.heap[index];
                    this.heap[index] = this.heap[index/2];
                    this.heap[index/2] = tmp;
                    this.heap[index].index = index;
                    this.heap[index/2].index = index/2;
                }
                index = index / 2;
            }
        }
        
        public void decreaseKey(int key) {
            this.percUp(key);
        }

        public Vertex deleteMin() {
            if(this.isEmpty())
                return null;
            
            Vertex toDelete = this.heap[1];
            if(this.pointer == 1) {
                this.pointer = 0;
                return toDelete;
            }
            this.heap[1] = this.heap[this.pointer];
            this.heap[1].index = 1;
            this.pointer--;
            this.percDown(1);
            return toDelete;
        }
        
        public void percDown(int index) {
            Vertex tmp;
            while(index * 2 <= this.pointer) {
                int minIndex = this.getMinIndex(index);
                if(this.heap[index].weight > this.heap[minIndex].weight) {
                    tmp = this.heap[index];
                    this.heap[index] = this.heap[minIndex];
                    this.heap[minIndex] = tmp;
                    this.heap[index].index = index;
                    this.heap[minIndex].index = minIndex;
                }
                index = minIndex;
            }
        }
        
        public int getMinIndex(int index) {
            if(index * 2 + 1 > this.pointer)
                return index * 2;
            else {
                if(this.heap[index * 2].weight <= this.heap[index * 2 + 1].weight)
                    return index * 2;
                else
                    return index * 2 + 1;
            }	
        }

    }
    
}
