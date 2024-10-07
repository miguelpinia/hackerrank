# 201. Bitwise AND of Numbers Range
# Solved
# Medium

# Topics
# Bit Manipulation

# Companies
# Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.



# Example 1:

# Input: left = 5, right = 7
# Output: 4
# Example 2:

# Input: left = 0, right = 0
# Output: 0
# Example 3:

# Input: left = 1, right = 2147483647
# Output: 0


# Constraints:

# 0 <= left <= right <= 231 - 1

class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        res = 0
        valid = True
        for i in range(32):
            res <<= 1
            if valid and left & (1 << 31 - i) == right & (1 << 31 - i):
                if left & (1 << 31 - i):
                    res ^= 1
                else:
                    res ^= 0
            elif valid:
                valid = False
        return res

    def rangeBitwiseAnd2(self, left: int, right: int) -> int:
        if (left > right): left, right = right, left
        while (left < right):
            right &= right - 1
        return right
