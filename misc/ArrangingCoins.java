package misc;

/*
441. Arranging Coins
Easy

https://leetcode.com/problems/arranging-coins/

Runtime: 6 ms, faster than 41.47% of Java online submissions for Arranging Coins.
Memory Usage: 36.2 MB, less than 59.97% of Java online submissions for Arranging Coins.

You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

 

Example 1:

Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:

Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

 

Constraints:

    1 <= n <= 231 - 1

Accepted
215,500
Submissions
497,097
*/
public class ArrangingCoins {

	public int arrangeCoins(int n) {

		int rows = 0;
		int count = 0;
		while (count < n) {
			count++;
			rows++;
			n -= count;
		}
		return rows;
	}
	
	/*
	public int arrangeCoins(int n) {
		
		int rows = 0;
		int length = 1;
		while(n > 0) {
			if(n - length >= 0)
				rows++;
			n -= length;
			length++;
		}
		return rows;
	}
	*/
}
