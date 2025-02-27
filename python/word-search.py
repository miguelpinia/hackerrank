# 79. Word Search
# Solved
# Medium

# Topics
# Array
# String
# Backtracking
# Matrix

# Companies
# Given an m x n grid of characters board and a string word, return true if word exists in the grid.

# The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



# Example 1:


# Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
# Output: true
# Example 2:


# Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
# Output: true
# Example 3:


# Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
# Output: false


# Constraints:

# m == board.length
# n = board[i].length
# 1 <= m, n <= 6
# 1 <= word.length <= 15
# board and word consists of only lowercase and uppercase English letters.


# Follow up: Could you use search pruning to make your solution faster with a larger board?


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])

        def dfs(i, j, size):
            if size == len(word):
                return True
            if i < 0 or i >= rows or j < 0 or j >= cols or word[size] != board[i][j]:
                return False
            c = board[i][j]
            board[i][j] = "#"
            sol = (dfs(i - 1, j, size + 1) or
                   dfs(i + 1, j, size + 1) or
                   dfs(i, j - 1, size + 1) or
                   dfs(i, j + 1, size + 1))
            board[i][j] = c
            return sol

        for i in range(rows):
            for j in range(cols):
                if dfs(i, j, 0):
                    return True
        return False
