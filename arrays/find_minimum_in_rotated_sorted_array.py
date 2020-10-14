'''
Runtime: 44 ms, faster than 41.87% of Python3 online submissions for Find Minimum in Rotated Sorted Array.
Memory Usage: 14.4 MB, less than 100.00% of Python3 online submissions for Find Minimum in Rotated Sorted Array.

'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        return self.helper(nums, 0, len(nums) - 1)
        
    def helper(self, nums: list, start: int, end: int) -> int:
        if start > end:
            return float("inf")
        else:
            midpoint: int = start + (end - start) // 2
            min_num: int = nums[midpoint]
            if nums[midpoint] < nums[end]:
                return min(min_num, self.helper(nums, start, midpoint - 1))
            else:
                min_num2 : int = self.helper(nums, start, midpoint - 1)
                min_num2 = min(min_num2, self.helper(nums, midpoint + 1, end))
                return min(min_num, min_num2)
        