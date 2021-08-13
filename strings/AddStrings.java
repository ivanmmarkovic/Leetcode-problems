package strings;

/*
415. Add Strings
Easy

https://leetcode.com/problems/add-strings/

Runtime: 2 ms, faster than 90.01% of Java online submissions for Add Strings.
Memory Usage: 39.9 MB, less than 7.54% of Java online submissions for Add Strings.

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"

 

Constraints:

    1 <= num1.length, num2.length <= 104
    num1 and num2 consist of only digits.
    num1 and num2 don't have any leading zeros except for the zero itself.

Accepted
355,720
Submissions
710,371


*/
public class AddStrings {
	    public String addStrings(String num1, String num2) {
	        
	        StringBuilder sb = new StringBuilder();
	        int rest = 0;
	        int i1 = num1.length() - 1, i2 = num2.length() - 1;
	        
	        while(i1 > -1 || i2 > -1){
	            
	            char c1 = i1 != -1 ? num1.charAt(i1) : '0'; 
	            char c2 = i2 != -1 ? num2.charAt(i2) : '0'; 
	            i1 = i1 == -1 ? -1 : i1 - 1;
	            i2 = i2 == -1 ? -1 : i2 - 1;
	            
	            int number1 = c1 - '0';
	            int number2 = c2 - '0';
	            
	            sb.append((rest + number1 + number2) % 10);
	            rest = (rest + number1 + number2) / 10;
	        }
	        
	        if(rest > 0)
	            sb.append(rest);
	        sb.reverse();
	        return sb.toString();
	        
	    }
	}
