package recursiondynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
70. Climbing Stairs
Easy

https://leetcode.com/problems/climbing-stairs/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
Memory Usage: 35.7 MB, less than 48.71% of Java online submissions for Climbing Stairs.


You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 

Constraints:

    1 <= n <= 45

Accepted
823,247
Submissions
1,703,784
*/
public class ClimbingStairs {
	
	private static Map<Integer, Integer> count = new HashMap<>();
	
	public int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		
		if(!count.containsKey(n)) 
			count.put(n, climbStairs(n - 1) + climbStairs(n - 2));

		return count.get(n);
	}
	
	/*
	HashMap<Integer, Integer> counts = new HashMap<>();
   
    
    public int climbStairs(int n) {
        counts.put(1, 1);
        counts.put(2, 2);
        return helper(n);
    }
    
    public int helper(int n){
        if(n < 3)
            return counts.get(n);
        else{
            if(counts.containsKey(n))
                return counts.get(n);
            counts.put(n, helper(n - 1) + helper(n - 2));
            return counts.get(n);
        }
    }
    */

}
