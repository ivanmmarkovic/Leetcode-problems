package arrays;

/*
1337. The K Weakest Rows in a Matrix
Easy

https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

Runtime: 0 ms, faster than 100.00% of Java online submissions for The K Weakest Rows in a Matrix.
Memory Usage: 48.7 MB, less than 58.83% of Java online submissions for The K Weakest Rows in a Matrix.


You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

    The number of soldiers in row i is less than the number of soldiers in row j.
    Both rows have the same number of soldiers and i < j.

Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

 

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].

Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].

 

Constraints:

    m == mat.length
    n == mat[i].length
    2 <= n, m <= 100
    1 <= k <= m
    matrix[i][j] is either 0 or 1.

Accepted
150,166
Submissions
201,643

*/
public class TheKWeakestRowsInAMatrix {
	
	public int[] kWeakestRows(int[][] mat, int k) {
        
	    int[] arr = new int[mat.length];
	        int[] ans = new int[k];
	        for(int i=0;i<mat.length;i++){
	            int check = count(i,mat);
	            arr[i]= check;
	        }
	        int flag =0;
	        while (k!=0 && flag<ans.length){
	            int index = findMin(arr);
	            ans[flag] = index;
	            k--;
	            flag++;
	            arr[index] =Integer.MAX_VALUE;
	        }
	        return ans;
	        
	    }
	     public int findMin(int[] arr){
	        int min = Integer.MAX_VALUE;
	        int index =-1;
	        for (int i =0;i<arr.length;i++){
	            if (arr[i]<min){
	                min = arr[i];
	                index = i;
	            }
	        }
	        return index;
	    }
	    public int count(int a, int[][] arr ){
	        int b = arr[a].length;
	        int count=0;
	        for(int i=0;i<b;i++){
	            if(arr[a][i]==0){
	                break;
	            }
	            if(arr[a][i]==1){
	                count++;
	            }
	        }
	        return count;
	    }

}
