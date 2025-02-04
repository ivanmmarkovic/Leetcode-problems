package recursiondynamicprogramming;

/*


Runtime 0ms Beats100.00%
Memory 40.68MB Beats29.11%

62. Unique Paths

Medium

https://leetcode.com/problems/unique-paths/

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 

Constraints:

    1 <= m, n <= 100



*/
public class UniquePaths {
	

    public int uniquePaths(int m, int n) {
		
		Integer[][] memo = new Integer[m - 1][n - 1];
		return uniquePathsHelper(memo, m - 1, n - 1);
		
	}

	private int uniquePathsHelper(Integer[][] memo, int m, int n) {
		if(m < 0 || n < 0)
			return 0;
		if(m == 0 && n == 0)
			return 1;
		if(memo[m][n] == null) {
			memo[m][n] = uniquePathsHelper(memo, m - 1, n) + uniquePathsHelper(memo, m, n - 1);
		}
		return memo[m][n];
		
	}
	
	/*
    public int uniquePaths(int m, int n) {
        int matrix[][] = new int[m][n];
        matrix[0][0] = 1;
        traverse(m - 1, n - 1, matrix, m - 1, n - 1);
        return matrix[m - 1][n - 1];
    }

    public int traverse(int x, int y, int matrix[][], int m, int n) {
        if(x < 0 || y < 0)
            return 0;
        if(x == 0 && y == 0)
            return 1;
        if(matrix[x][y] > 0)
            return matrix[x][y];
        matrix[x][y] = traverse(x - 1, y, matrix, m, n) + traverse(x, y - 1, matrix, m, n);
        return matrix[x][y];
    }
	*/

    /*
    
    // This solution works but leads to Time Limit Exceeded with larger values for m and n(m = 19 n = 13)
    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(0, 0, m - 1, n - 1);
    }

    public int uniquePathsHelper(int x, int y, int m, int n) {
        if(x == m && y == n)
            return 1;

        int paths = 0;
        if(x < m)
            paths += uniquePathsHelper(x + 1, y, m, n);
        if(y < n)
            paths += uniquePathsHelper(x, y + 1, m, n);

        return paths;

    }
    */

}
