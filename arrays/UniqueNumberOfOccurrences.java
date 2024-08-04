package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/* 
1207. Unique Number of Occurrences
Easy

https://leetcode.com/problems/unique-number-of-occurrences/description/

Runtime 2ms Beats 97.78%
Memory 41.84MB Beats 36.46%

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:

Input: arr = [1,2]
Output: false

Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

 

Constraints:

    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000




*/
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int a: arr){
            if(count.containsKey(a))
                count.put(a, count.get(a) + 1);
            else
                count.put(a, 1);
        }

        Set<Integer> unique = new HashSet<>();
        for(Integer v: count.values()){
            if(unique.contains(v))
                return false;
            else
                unique.add(v);
        }
        return true;
    }
    
}
