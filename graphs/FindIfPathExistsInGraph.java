package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/find-if-path-exists-in-graph/description


Runtime 608ms Beats 5.06%
Memory 206.81MB Beats 8.32%

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

 

*/
public class FindIfPathExistsInGraph {
	
	public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < n; i++) {
			if(!adjacencyList.containsKey(i))
				adjacencyList.put(i, new HashSet<>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			adjacencyList.get(x).add(y);
			adjacencyList.get(y).add(x);
		}
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		q.add(source);
		visited.add(source);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int neighbour: adjacencyList.get(v)) {
				if(!visited.contains(neighbour)) {
					visited.add(neighbour);
					q.add(neighbour);
				}
			}
		}
		
		return visited.contains(destination);
    }

}
