'''

Runtime: 44 ms, faster than 98.75% of Python3 online submissions for Search in Rotated Sorted Array II.
Memory Usage: 14.5 MB, less than 19.90% of Python3 online submissions for Search in Rotated Sorted Array II.

'''

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        return self.helper(nums, target, 0, len(nums) - 1)
    
    def helper(self, nums: list, target: int, start: int, end: int) -> bool:
        if start > end:
            return False
        else:
            midpoint: int = start + (end - start) // 2
            if nums[midpoint] == target:
                return True
            elif nums[midpoint] > target and target > nums[start]:
                return self.helper(nums, target, start, midpoint - 1)
            elif nums[midpoint] < target and target < nums[end]:
                return self.helper(nums, target, midpoint + 1, end)
            else:
                f: bool = self.helper(nums, target, start, midpoint - 1)
                if not f:
                    f = self.helper(nums, target, midpoint + 1, end)
                return f