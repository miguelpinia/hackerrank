# 72. Edit Distance
# Solved
# Medium

# Topics
# String
# Dynamic Programming

# Companies
# Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

# You have the following three operations permitted on a word:

# Insert a character
# Delete a character
# Replace a character


# Example 1:

# Input: word1 = "horse", word2 = "ros"
# Output: 3
# Explanation:
# horse -> rorse (replace 'h' with 'r')
# rorse -> rose (remove 'r')
# rose -> ros (remove 'e')
# Example 2:

# Input: word1 = "intention", word2 = "execution"
# Output: 5
# Explanation:
# intention -> inention (remove 't')
# inention -> enention (replace 'i' with 'e')
# enention -> exention (replace 'n' with 'x')
# exention -> exection (replace 'n' with 'c')
# exection -> execution (insert 'u')


# Constraints:

# 0 <= word1.length, word2.length <= 500
# word1 and word2 consist of lowercase English letters.

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n = len(word1)
        m = len(word2)
        dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]

        for j in range(m + 1): dp[n][j] = m - j
        for i in range(n + 1): dp[i][m] = n - i

        for i in range(n - 1, -1, -1):
            for j in range(m -1, -1, -1):
                dp[i][j] = dp[i + 1][j + 1] if word1[i] == word2[j] else 1 + min(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1])

        return dp[0][0]
