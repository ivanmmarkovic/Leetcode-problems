
/*

1089. Duplicate Zeros
Easy

https://leetcode.com/problems/duplicate-zeros/

Runtime: 1 ms, faster than 92.44% of Java online submissions for Duplicate Zeros.
Memory Usage: 39.7 MB, less than 54.61% of Java online submissions for Duplicate Zeros.

Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]

 

Note:

    1 <= arr.length <= 10000
    0 <= arr[i] <= 9

Accepted
56,844
Submissions
104,673

*/

public class DuplicateZeroes {
	
	public void duplicateZeros(int[] arr) {
		int result[] = new int[arr.length];
		int start = 0;
		for (int i = 0; i < arr.length && start < arr.length; i++) {
			if(arr[i] == 0)
				start += 2;
			else {
				result[start] = arr[i];
				start++;
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}
	}

}
