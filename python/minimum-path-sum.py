# 64. Minimum Path Sum
# Solved
# Medium

# Topics
# Array
# Dynamic Programming
# Matrix

# Companies

# Given a m x n grid filled with non-negative numbers, find a path
# from top left to bottom right, which minimizes the sum of all
# numbers along its path.

# Note: You can only move either down or right at any point in time.

# Example 1:
# Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
# Output: 7
# Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

# Example 2:
# Input: grid = [[1,2,3],[4,5,6]]
# Output: 12

# Constraints:

# m == grid.length
# n == grid[i].length
# 1 <= m, n <= 200
# 0 <= grid[i][j] <= 200

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = defaultdict(dict)
        rows = len(grid)
        cols = len(grid[0])
        dp[0][0] = grid[0][0]

        def helper(i, j):
            if i < 0 or i >= rows or j < 0 or j >= cols:
                return sys.maxsize
            if dp[i] and j in dp[i]:
                return dp[i][j]
            dp[i][j] = min(helper(i - 1, j), helper(i, j - 1)) + grid[i][j]
            return dp[i][j]
        return helper(rows - 1, cols - 1)
