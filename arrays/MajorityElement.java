/*
169. Majority Element
Easy

https://leetcode.com/problems/majority-element/

Runtime: 9 ms, faster than 43.38% of Java online submissions for Majority Element.
Memory Usage: 44.8 MB, less than 55.08% of Java online submissions for Majority Element.

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

Accepted
672,328
Submissions
1,145,677
*/
class MajorityElement {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            if(count.containsKey(num))
                count.put(num, count.get(num) + 1);
            else
                count.put(num, 1);
        }
        
        int element = 0;
        for(Integer key: count.keySet()){
            if(count.get(key) > nums.length / 2){
                element = key;
                break;
            }
                
        }
        return element;
    }
}