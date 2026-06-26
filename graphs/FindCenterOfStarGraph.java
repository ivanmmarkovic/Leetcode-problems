package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*


https://leetcode.com/problems/find-center-of-star-graph/?envType=problem-list-v2&envId=graph

Runtime 62ms Beats 5.72%
Memory 202.59MB Beats 5.11%


There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 

Example 1:

Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1


*/
public class FindCenterOfStarGraph {
	
	
	public int findCenter(int[][] edges) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int x = edge[0], y = edge[1];

            if(!adjacencyList.containsKey(x))
                adjacencyList.put(x, new HashSet<>());
            adjacencyList.get(x).add(y);

            if(!adjacencyList.containsKey(y))
                adjacencyList.put(y, new HashSet<>());
            adjacencyList.get(y).add(x);

        }

        for(Integer v: adjacencyList.keySet()){
            if(adjacencyList.get(v).size() == edges.length)
                return v;
        }

        return -1;
    }

}
