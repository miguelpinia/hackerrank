# 52. N-Queens II
# Solved
# Hard
# Topics
# Backtracking

# Companies

# The n-queens puzzle is the problem of placing n queens on an n x n
# chessboard such that no two queens attack each other.

# Given an integer n, return the number of distinct solutions to the
# n-queens puzzle.



# Example 1:


# Input: n = 4
# Output: 2
# Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
# Example 2:

# Input: n = 1
# Output: 1


# Constraints:

# 1 <= n <= 9

class Solution:
    def totalNQueens(self, n: int) -> int:

        columns = set()
        positiveDiagonal = set()
        negativeDiagonal = set()

        result = 0
        def backtrack(r):
            if r == n:
                nonlocal result
                result += 1
                return
            for col in range(n):
                if col in columns or (r + col) in positiveDiagonal or (r - col) in negativeDiagonal:
                    continue
                columns.add(col)
                positiveDiagonal.add(r + col)
                negativeDiagonal.add(r - col)
                backtrack(r + 1)
                columns.remove(col)
                positiveDiagonal.remove(r + col)
                negativeDiagonal.remove(r - col)
        backtrack(0)
        return result
