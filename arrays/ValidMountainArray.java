package arrays;

/*

941. Valid Mountain Array
Easy

https://leetcode.com/problems/valid-mountain-array/

Runtime: 8 ms, faster than 6.87% of Java online submissions for Valid Mountain Array.
Memory Usage: 51.4 MB, less than 35.10% of Java online submissions for Valid Mountain Array.

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true

 

Constraints:

    1 <= arr.length <= 104
    0 <= arr[i] <= 104

Accepted
267,093
Submissions
788,234

*/
public class ValidMountainArray {
	
	public boolean validMountainArray(int[] arr) {
        if(arr == null)
            return false;
        if(arr.length < 3)
            return false;
        
        int index = findMax(arr);
        if(index == 0 || index == arr.length - 1)
            return false;
        
        for(int i = 0; i < index; i++){
            if(arr[i] >= arr[i + 1])
                return false;
        }
        
        for(int i = index; i < arr.length - 1; i++){
            if(arr[i] <= arr[i + 1])
                return false;
        }
        
        return true;
        
    }
    
    private int findMax(int[] arr){
        Integer max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

}
