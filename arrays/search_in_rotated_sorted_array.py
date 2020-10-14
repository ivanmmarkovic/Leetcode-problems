'''

Runtime: 28 ms, faster than 99.65% of Python3 online submissions for Search in Rotated Sorted Array.
Memory Usage: 14.3 MB, less than 7.05% of Python3 online submissions for Search in Rotated Sorted Array.

'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.helper(nums, target, 0, len(nums) - 1)
    
    def helper(self, nums: list, target: int, start: int, end: int) -> int:
        if start > end:
            return -1
        else:
            midpoint: int = start + (end - start) // 2
            if nums[midpoint] == target:
                return midpoint
            elif nums[midpoint] > target and target > nums[start]:
                return self.helper(nums, target, start, midpoint - 1)
            elif nums[midpoint] < target and target < nums[end]:
                return self.helper(nums, target, midpoint + 1, end)
            else:
                index: int = self.helper(nums, target, start, midpoint - 1)
                if index == -1:
                    index = self.helper(nums, target, midpoint + 1, end)
                return index