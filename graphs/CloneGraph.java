
/*

https://leetcode.com/problems/clone-graph

Runtime: 25 ms, faster than 99.65% of Java online submissions for Clone Graph.
Memory Usage: 39.8 MB, less than 5.88% of Java online submissions for Clone Graph.

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

 

Test case format:

For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.

Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

 

Example 1:

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:

Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.

Example 4:

Input: adjList = [[2],[1]]
Output: [[2],[1]]

 

Constraints:

    1 <= Node.val <= 100
    Node.val is unique for each node.
    Number of Nodes will not exceed 100.
    There is no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.

Accepted
297,532
Submissions
929,899
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

class CloneGraph {
	
	public Node cloneGraph(Node node) {
		if(node == null)
			return null;
		HashMap<Integer, Node> oldNodes = new HashMap<Integer, Node>();
		HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
		Set<Node> visited = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		
		Node tmp;
		queue.add(node);
		visited.add(node);
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			oldNodes.put(tmp.val, tmp);
			nodes.put(tmp.val, new Node(tmp.val));
			for(Node neighbour: tmp.neighbors) {
				if(!visited.contains(neighbour)) {
					visited.add(neighbour);
					queue.add(neighbour);
				}
			}	
		}
		
		Node newNode;
		for(Integer key: oldNodes.keySet()) {
			tmp = oldNodes.get(key);
			newNode = nodes.get(key);
			newNode.neighbors = new ArrayList<Node>();
			for(Node tmpNodeNeighbour: tmp.neighbors) {
				newNode.neighbors.add(nodes.get(tmpNodeNeighbour.val));
			}
		}
		
		return nodes.get(node.val);
		
	}
	
}