
/*
https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/

################ 100%

4. Median of Two Sorted Arrays
Hard

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

Accepted
576,133
Submissions
2,047,644

*/
class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total[] = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j])
                total[k++] = nums1[i++];
            else
                total[k++] = nums2[j++];
        }
        while(i < nums1.length){
            total[k++] = nums1[i++];
        }
        while(j < nums2.length){
            total[k++] = nums2[j++];
        }
        return total.length % 2 != 0 ? total[total.length / 2] :
                (total[total.length / 2 - 1] + total[total.length / 2]) / 2.0; 
    }
}
