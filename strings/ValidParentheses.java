
import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/submissions/

20. Valid Parentheses
Easy

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

Accepted
869,762
Submissions
2,282,382

Runtime: 4 ms, faster than 11.76% of Java online submissions for Valid Parentheses.
Memory Usage: 38.3 MB, less than 5.06% of Java online submissions for Valid Parentheses.
*/

class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        
        Stack<String> stack = new Stack<>();
        
        String openingParenthesis = "([{";
        String closingParenthesis = ")]}";
        String tmp;
        for(int i = 0; i < s.length(); i++){
            tmp = s.charAt(i) + "";
            if(openingParenthesis.indexOf(tmp) != -1)
                stack.push(tmp);
            else if(closingParenthesis.indexOf(tmp) != -1){
                if(stack.isEmpty())
                    return false;
                else if(openingParenthesis.indexOf(stack.peek()) == closingParenthesis.indexOf(tmp))
                    stack.pop();
                else
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}