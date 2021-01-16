
/*
79. Word Search
Medium

https://leetcode.com/problems/word-search/

Runtime: 5 ms, faster than 83.44% of Java online submissions for Word Search.
Memory Usage: 40.9 MB, less than 68.83% of Java online submissions for Word Search.

Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, 
where "adjacent" cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 

Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 200
    1 <= word.length <= 103
    board and word consists only of lowercase and uppercase English letters.

Accepted
591,371
Submissions
1,617,559
*/
class WordSearch {
    public boolean exist(char[][] board, String word) {       
        
        boolean visited[][] = new boolean[board.length][board[0].length];
        boolean found = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                found = helper(board, word, i, j, 0, visited);
                if(found)
                    return found;
            }
        }
        return found;
    }
    
    private boolean helper(char[][] board, String word, int x, int y, int index, boolean visited[][]){
        if (index == word.length()) 
            return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) 
            return false;
         
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            if(helper(board, word, x, y + 1, index + 1, visited) ||
                helper(board, word, x, y - 1, index + 1, visited) ||
                helper(board, word, x + 1, y, index + 1, visited) ||
                helper(board, word, x - 1, y, index + 1, visited)) return true;
            visited[x][y] = false;
        }
        return false; 
        
    }
}