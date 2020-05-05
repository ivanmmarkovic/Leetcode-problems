
/*

####################### 100

https://leetcode.com/problems/merge-sorted-array/

88. Merge Sorted Array
Easy

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

Accepted
474,370
Submissions
1,253,927

*/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int total[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j])
                total[k++] = nums1[i++];
            else
                total[k++] = nums2[j++];
        }
        while(i < m){
            total[k++] = nums1[i++];
        }
        while(j < n){
            total[k++] = nums2[j++];
        }
        int count = 0;
        while(count < k){
            nums1[count] = total[count];
            count++;
        }
    }
}