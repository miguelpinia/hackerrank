# 221. Maximal Square
# Solved
# Medium

# Topics
# Array
# Dynamic Programming
# Matrix

# Companies

# Given an m x n binary matrix filled with 0's and 1's, find the
# largest square containing only 1's and return its area.


# Example 1:


# Input: matrix =
# [["1","0","1","0","0"],
#  ["1","0","1","1","1"],
#  ["1","1","1","1","1"],
#  ["1","0","0","1","0"]]
# Output: 4

# Example 2:
# Input: matrix = [["0","1"],["1","0"]]
# Output: 1
# Example 3:

# Input: matrix = [["0"]]
# Output: 0


# Constraints:

# m == matrix.length
# n == matrix[i].length
# 1 <= m, n <= 300
# matrix[i][j] is '0' or '1'.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0] * cols for _ in range(rows)]

        maxSize = 0

        def getValDp(i, j):
            if i < 0 or i >= rows or j < 0 or j >= cols:
                return 0
            return dp[i][j]

        for i in range(rows):
            for j in range(cols):
                dp[i][j] = (1 + min(getValDp(i - 1, j), getValDp(i - 1, j - 1), getValDp(i, j - 1))
                            if matrix[i][j] == '1'
                            else 0)
                maxSize = max(maxSize, dp[i][j])
            print(dp[i])

        return maxSize ** 2

# [["0","0","0","0","1","1","1","0","1"]
# ,["0","0","1","1","1","1","1","0","1"]
# ,["0","0","0","1","1","1","1","1","0"]]
#
# [[0,0,0,0,1,1,1,0,1]
# ,[0,0,1,1,1,2,2,0,1]
# ,[0,0,0,1,2,2,3,1,0]]
