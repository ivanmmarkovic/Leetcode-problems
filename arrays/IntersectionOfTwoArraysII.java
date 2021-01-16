package arrays;

/*
350. Intersection of Two Arrays II
Easy

https://leetcode.com/problems/intersection-of-two-arrays-ii/

Runtime: 4 ms, faster than 28.92% of Java online submissions for Intersection of Two Arrays II.
Memory Usage: 39.1 MB, less than 77.72% of Java online submissions for Intersection of Two Arrays II.

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Accepted
446,180
Submissions
859,598
*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int e: nums1){
            set1.add(e);
            if(map1.containsKey(e))
                map1.put(e, map1.get(e) + 1);
            else
                map1.put(e, 1);
        }
        Set<Integer> set2 = new HashSet<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int e: nums2){
            set2.add(e);
            if(map2.containsKey(e))
                map2.put(e, map2.get(e) + 1);
            else
                map2.put(e, 1);
        }
        
        List<Integer> nums = new ArrayList<>();
        if(set1.size() > set2.size()){
            for(Integer e: set1){
                if(set2.contains(e))
                    for(int i = 0; i < Math.min(map1.get(e), map2.get(e)); i++)
                        nums.add(e);
            }
        }
        else{
            for(Integer e: set2){
                if(set1.contains(e))
                    for(int i = 0; i < Math.min(map1.get(e), map2.get(e)); i++)
                        nums.add(e);
            }
        }
        
        int result[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++)
            result[i] = nums.get(i);
        return result;
    }
}
