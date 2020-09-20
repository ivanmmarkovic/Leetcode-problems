

import java.util.LinkedList;
import java.util.Queue;

/*
785. Is Graph Bipartite?
Medium

https://leetcode.com/problems/is-graph-bipartite/

Runtime: 1 ms, faster than 75.06% of Java online submissions for Is Graph Bipartite?.
Memory Usage: 40.1 MB, less than 66.29% of Java online submissions for Is Graph Bipartite?.

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.

 

Note:

    graph will have length in range [1, 100].
    graph[i] will contain integers in range [0, graph.length - 1].
    graph[i] will not contain i or duplicate values.
    The graph is undirected: if any element j is in graph[i], then i will be in graph[j].

Accepted
132,338
Submissions
277,434

*/
class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        
        int colors[] = new int[graph.length];
        // colors -1 or 1
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int node = 0; node < graph.length; node++){
            
            if(colors[node] != 0)
                continue;
            if(colors[node] == 0)
                colors[node] = -1;
                
            q.add(node);
            while(!q.isEmpty()){
                int tmp = q.poll();
                for(int neighbour: graph[tmp]){
                    if(colors[neighbour] == colors[tmp])
                        return false;
                    if(colors[neighbour] != 0)
                        continue;
                    if(colors[neighbour] == 0){
                        colors[neighbour] = colors[tmp] == -1 ? 1 : -1;
                        q.add(neighbour);
                    }
                    
                }   
            }
        }
            
        return true;
        
    }
    
}
