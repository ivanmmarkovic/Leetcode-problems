package misc;

import java.util.ArrayList;
import java.util.List;

/*
1291. Sequential Digits
Medium

https://leetcode.com/problems/sequential-digits/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Sequential Digits.
Memory Usage: 38.3 MB, less than 27.94% of Java online submissions for Sequential Digits

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]

Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

 

Constraints:

    10 <= low <= high <= 10^9

Accepted
72,627
Submissions
119,473


*/
public class SequentialDigits {
	
	public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int nl = String.valueOf(low).length();
        int nh = String.valueOf(high).length();
        
        for(int i = nl; i <= nh; i++){
            for(int j = 0; j < 10 - i; j++){
                int num = Integer.parseInt(digits.substring(j, j + i));
                if(num >= low && num <= high) res.add(num);
            }
        }
        return res;
        
    }

}
