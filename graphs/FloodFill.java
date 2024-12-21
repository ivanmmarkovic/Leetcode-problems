package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
733. Flood Fill
Easy

https://leetcode.com/problems/flood-fill/description/


Runtime 1ms Beats 44.44%
Memory 44.95MB Beats 48.36%

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

    Begin with the starting pixel and change its color to color.
    Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
    Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
    The process stops when there are no more adjacent pixels of the original color to update.

Return the modified image after performing the flood fill.

 

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation:

From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

Output: [[0,0,0],[0,0,0]]

Explanation:

The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.


*/
public class FloodFill {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int[] pos = new int[]{sr, sc};
        q.add(pos);
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        boolean[][] visited = new boolean[image.length][];
        for(int i = 0; i < image.length; i++)
            visited[i] = new boolean[image[i].length];

        visited[sr][sc] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0], y = p[1];
            checkFields(image, x, y, q, color, oldColor, visited);
        }

        return image;

    }

    private void checkFields(int[][] image, int x, int y, Queue<int[]> q, int color, int oldColor, boolean[][] visited) {
        if(y < image[x].length - 1 && image[x][y + 1] == oldColor && !visited[x][y + 1]){
            image[x][y + 1] = color;
            visited[x][y + 1] = true;
            q.add(new int[] {x, y + 1});
        }
        if(y > 0 && image[x][y - 1] == oldColor && !visited[x][y - 1]){
            image[x][y - 1] = color;
            visited[x][y - 1] = true;
            q.add(new int[] {x, y - 1});
        }
        if(x < image.length - 1 && image[x + 1][y] == oldColor && !visited[x + 1][y]){
            image[x + 1][y] = color;
            visited[x + 1][y] = true;
            q.add(new int[] {x + 1, y});
        }
        if(x > 0 && image[x - 1][y] == oldColor && !visited[x - 1][y]){
            image[x - 1][y] = color;
            visited[x - 1][y] = true;
            q.add(new int[] {x - 1, y});
        }
    }

}
