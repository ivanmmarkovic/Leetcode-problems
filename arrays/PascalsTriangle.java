

import java.util.ArrayList;
import java.util.List;


/*
118. Pascal's Triangle
Easy

https://leetcode.com/problems/pascals-triangle/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
Memory Usage: 36.9 MB, less than 18.30% of Java online submissions for Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

Accepted
418,991
Submissions
784,208

*/

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        
        
        List<Integer> tmp;
        int size = 1;
        for(int row = 0; row < numRows; row++){
            tmp = new ArrayList<>();
            tmp.add(0, 1);
            
            
            if(row >= 2){
                List<Integer> prev = result.get(row - 1);
                for(int j = 1; j < size - 1; j++){
                    tmp.add(j, prev.get(j - 1) + prev.get(j));
                }
            }
            if(size > 1)
                tmp.add(1);
            result.add(tmp);
            size++;
            
        }
        
        return result;
    }
}
