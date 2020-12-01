
import java.util.HashMap;

/*
1137. N-th Tribonacci Number
Easy

https://leetcode.com/problems/n-th-tribonacci-number/

Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
Memory Usage: 35.9 MB, less than 30.14% of Java online submissions for N-th Tribonacci Number.


The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:

Input: n = 25
Output: 1389537

 

Constraints:

    0 <= n <= 37
    The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

Accepted
58,579
Submissions
104,345
*/
public class NthTribonacciNumber {
	
	HashMap<Integer, Integer> nums = new HashMap<>();
    public int tribonacci(int n) {
        nums.put(0, 0);
        nums.put(1, 1);
        nums.put(2, 1);
        return helper(n);
    }
    
    public int helper(int n){
        if(n < 3)
            return nums.get(n);
        else{
            if(nums.containsKey(n))
                return nums.get(n);
            nums.put(n, helper(n - 1) + helper(n - 2) + helper(n - 3));
            return nums.get(n);
        }
    }

}
