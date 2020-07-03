import java.util.Stack;

/*

1047. Remove All Adjacent Duplicates In String
Easy

https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

Runtime: 32 ms, faster than 34.32% of Java online submissions for Remove All Adjacent Duplicates In String.
Memory Usage: 39.8 MB, less than 85.23% of Java online submissions for Remove All Adjacent Duplicates In String.

Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

 

Note:

    1 <= S.length <= 20000
    S consists only of English lowercase letters.

Accepted
74,118
Submissions
108,857

*/

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character>  stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(stack.isEmpty())
                stack.push(S.charAt(i));
            else if(S.charAt(i) == stack.peek())
                stack.pop();
            else
                stack.push(S.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        return sb.toString();
    }
}