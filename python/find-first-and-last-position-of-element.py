# 34. Find First and Last Position of Element in Sorted Array
# Solved
# Medium

# Topics
# Array
# Binary Search

# Companies
# Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

# If target is not found in the array, return [-1, -1].

# You must write an algorithm with O(log n) runtime complexity.



# Example 1:

# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# Example 2:

# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]
# Example 3:

# Input: nums = [], target = 0
# Output: [-1,-1]


# Constraints:

# 0 <= nums.length <= 105
# -109 <= nums[i] <= 109
# nums is a non-decreasing array.
# -109 <= target <= 109


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums: return [-1, -1]
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if (nums[mid] == target):
                i, j = mid, mid
                while i - 1 >= 0 and nums[i - 1] == target: i -= 1
                while j + 1 < len(nums) and nums[j + 1] == target: j += 1
                return [i, j]
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return [-1, -1]
