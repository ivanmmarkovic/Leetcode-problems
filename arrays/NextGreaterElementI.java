package arrays;

/*
496. Next Greater Element I
Easy

https://leetcode.com/problems/next-greater-element-i/

Runtime: 12 ms, faster than 6.42% of Java online submissions for Next Greater Element I.
Memory Usage: 38.7 MB, less than 97.92% of Java online submissions for Next Greater Element I.

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

 

Constraints:

    1 <= nums1.length <= nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 104
    All integers in nums1 and nums2 are unique.
    All the integers of nums1 also appear in nums2.

 
Follow up: Could you find an O(nums1.length + nums2.length) solution?
Accepted
252,766
Submissions
375,151

*/
public class NextGreaterElementI {
	
	/* 
	Runtime Details
	3ms
	Beats 91.65%of users with Java
	Memory
	Details
	41.82mb
	Beats 99.52%of users with Java
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int elements[] = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int e = nums1[i];

			int j = 0;
			while(j < nums2.length) {
				if(nums2[j] == e) 
					break;
				else
					j++;
				
			}
			if(j == nums2.length) {
				elements[i] = -1;
				continue;
			}
			
			j++;
			while(j < nums2.length) {
				if(nums2[j] > e)
					break;
				else
					j++;
			}
			if(j == nums2.length)
				elements[i] = -1;
			else
				elements[i] = nums2[j];
				
		}
		return elements;
	}
	
	/*
	Runtime: 4 ms, faster than 80.52% of Java online submissions for Next Greater Element I.
	Memory Usage: 43.6 MB, less than 76.78% of Java online submissions for Next Greater Element I.
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int elements[] = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {
			int n = nums1[i];

			int index = 0;
			boolean found = false;
			while (index < nums2.length && !found) {
				if (nums2[index] == n)
					found = true;
				else
					index++;
			}
			if (!found) {
				elements[i] = -1;
			} else {
				found = false;
				index++;
				while (index < nums2.length && !found) {
					if (nums2[index] > n)
						found = true;
					else
						index++;
				}
				if (!found)
					elements[i] = -1;
				else
					elements[i] = nums2[index];
			}

		}
		return elements;

	}
	
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int res[] = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {

			int index = -1;
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j])
					index = j;
			}
			index++;
			boolean found = false;
			for (; index < nums2.length; index++)
				if (nums2[index] > nums1[i]) {
					res[i] = nums2[index];
					found = true;
					break;
				}
			if (!found)
				res[i] = -1;

		}

		return res;

	}
	*/
}
