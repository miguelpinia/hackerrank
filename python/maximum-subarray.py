# 53. Maximum Subarray
# Solved
# Medium

# Topics
# Array
# Divide and Conquer
# Dynamic Programming

# Companies
# Given an integer array nums, find the
# subarray
#  with the largest sum, and return its sum.



# Example 1:

# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: The subarray [4,-1,2,1] has the largest sum 6.
# Example 2:

# Input: nums = [1]
# Output: 1
# Explanation: The subarray [1] has the largest sum 1.
# Example 3:

# Input: nums = [5,4,-1,7,8]
# Output: 23
# Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


# Constraints:

# 1 <= nums.length <= 105
# -104 <= nums[i] <= 104


# Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        m = float('-inf')
        current = 0
        for n in nums:
            current += n
            if current > m: m = current
            if current < 0: current = 0

        return m


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        m = nums[0]
        prev = nums[0]
        for i in range(1, len(nums)):
            prev = max(nums[i], nums[i] + prev)
            m = max(m, prev)

        return m
