package arrays;


/*
1672. Richest Customer Wealth
Easy

https://leetcode.com/problems/richest-customer-wealth/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Richest Customer Wealth.
Memory Usage: 43.2 MB, less than 40.36% of Java online submissions for Richest Customer Wealth.



A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.

Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.

Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17

 

Constraints:

    m == accounts.length
    n == accounts[i].length
    1 <= m, n <= 50
    1 <= accounts[i][j] <= 100

Accepted
242,211
Submissions
270,987

*/


public class RichestCustomerWealth {
	
	public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for(int i = 0; i < accounts.length; i++){
            
            int current = 0;
            for(int j = 0; j < accounts[i].length; j++){
                current += accounts[i][j];
            }
            wealth = Math.max(wealth, current);
        }
        return wealth;
    }

}
