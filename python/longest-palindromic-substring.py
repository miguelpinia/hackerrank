# 5. Longest Palindromic Substring
# Solved
# Medium

# Topics
# Two Pointers
# String
# Dynamic Programming

# Companies
# Hint
# Given a string s, return the longest
# palindromic

# substring
#  in s.



# Example 1:

# Input: s = "babad"
# Output: "bab"
# Explanation: "aba" is also a valid answer.
# Example 2:

# Input: s = "cbbd"
# Output: "bb"


# Constraints:

# 1 <= s.length <= 1000
# s consist of only digits and English letters.

class Solution:
    def longestPalindrome(self, s: str) -> str:
        #for indexes i, j:
        #    lps(i, j) = 2 + lps(i - 1, j - 1) if s[i] == s[j]
        #                else max(lps(i, j - 1), lps(i - 1, j))
        n = len(s)
        if n == 0: return ''
        start = 0
        maxLen = 1
        for i in range(n + 1):
            for j in range(2):
                left = i
                right = i + j

                while left >= 0 and right < n and s[left] == s[right]:
                    clen = right - left + 1
                    if clen > maxLen:
                        start, maxLen = left, clen
                    left -= 1
                    right += 1
        return s[start: start + maxLen]
