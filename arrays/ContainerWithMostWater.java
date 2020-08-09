/**

11. Container With Most Water
Medium

https://leetcode.com/problems/container-with-most-water/

Runtime: 2 ms, faster than 97.29% of Java online submissions for Container With Most Water.
Memory Usage: 39.8 MB, less than 71.76% of Java online submissions for Container With Most Water.

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

Accepted
686,280
Submissions
1,350,692

**/

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        /*
        This solution works but it is O(n2)
        int area = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int currentArea = (j - i) * Math.min(height[i], height[j]);
                if(currentArea > area)
                    area = currentArea;
            }
        }
        return area;
        */
        int left = 0, right = height.length - 1;
        int area = Integer.MIN_VALUE;
        while(right > left){
            area = Math.max(area, (right - left) * Math.min(height[right], height[left]));
            if(height[right] > height[left])
                left++;
            else
                right--;
        }
        return area;
    }
}