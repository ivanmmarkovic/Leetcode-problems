package arrays;

import java.util.ArrayList;
import java.util.List;

/*
228. Summary Ranges
Easy

https://leetcode.com/problems/summary-ranges/

Runtime: 7 ms, faster than 68.57% of Java online submissions for Summary Ranges.
Memory Usage: 42.4 MB, less than 25.93% of Java online submissions for Summary Ranges.


You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b

 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

 

Constraints:

    0 <= nums.length <= 20
    -231 <= nums[i] <= 231 - 1
    All the values of nums are unique.
    nums is sorted in ascending order.

Accepted
280,536
Submissions
609,619
*/
public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
        int i=0, n= nums.length;
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        if(n == 1) {list.add(Integer.toString(nums[0])); return list; }

            while(i <n) {
                StringBuffer sbr = new StringBuffer();
                sbr.append(nums[i]);
                int j = i;
                while(j < n-1 && nums[j]+1 == nums[j+1]) j++;
                if(i !=j ) sbr.append("->"+nums[j]);
                list.add(sbr.toString());
                i=j+1;
            }
            return list;
    }

}
