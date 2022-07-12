package graph;

/*
547. Number of Provinces
Medium

https://leetcode.com/problems/number-of-provinces/

Runtime: 5 ms, faster than 23.12% of Java online submissions for Number of Provinces.
Memory Usage: 39.8 MB, less than 78.57% of Java online submissions for Number of Provinces.

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

 

Constraints:

    1 <= n <= 200
    n == isConnected.length
    n == isConnected[i].length
    isConnected[i][j] is 1 or 0.
    isConnected[i][i] == 1
    isConnected[i][j] == isConnected[j][i]

Accepted
249,117
Submissions
411,408

*/
public class NumberOfProvinces {

public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int cities[] = new int[n];
        for(int i = 0; i < n; i++)
            cities[i] = i;
        
        int provinces = n;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                
                if(isConnected[i][j] == 1){
                    
                    int root1 = findRoot(i, cities);
                    int root2 = findRoot(j, cities);
                    
                    if(root1 != root2){
                        cities[root1] = root2;
                        provinces--;
                    }
                }
    
            }
        }
        
        return provinces;
        
    }

	/*
	Runtime: 2 ms, faster than 67.71% of Java online submissions for Number of Provinces.
	Memory Usage: 54.1 MB, less than 41.17% of Java online submissions for Number of Provinces.
	*/
	private int findRoot(int i, int[] cities) {
		if(cities[i] != i)
			cities[i] = findRoot(cities[i], cities);
		return cities[i];
	}
    
	/*
    public int findRoot(int i, int cities[]){
        while(i != cities[i])
            i = cities[i];
        return i;
    }
    */
}
