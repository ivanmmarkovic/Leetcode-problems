
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
349. Intersection of Two Arrays
Easy

https://leetcode.com/problems/intersection-of-two-arrays/

Runtime: 2 ms, faster than 98.56% of Java online submissions for Intersection of Two Arrays.
Memory Usage: 39.3 MB, less than 11.74% of Java online submissions for Intersection of Two Arrays.

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:

    Each element in the result must be unique.
    The result can be in any order.

 
Accepted
408,938
Submissions
643,210

*/
public class IntersectionOfTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int e: nums1){
            set1.add(e);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int e: nums2){
            set2.add(e);
        }
        
        List<Integer> nums = new ArrayList<>();
        if(set1.size() < set2.size()){
            for(Integer e: set1){
                if(set2.contains(e))
                    nums.add(e);
            }
        }
        else{
            for(Integer e: set2){
                if(set1.contains(e))
                    nums.add(e);
            }
        }
        
        int result[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++)
            result[i] = nums.get(i);
        return result;
    }

}
