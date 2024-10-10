# 76. Minimum Window Substring
# Solved
# Hard

# Topics
# Hash Table
# String
# Sliding Window

# Companies
# Hint

# Given two strings s and t of lengths m and n respectively, return
# the minimum window substring of s such that every character in t
# (including duplicates) is included in the window. If there is no
# such substring, return the empty string "".

# The testcases will be generated such that the answer is unique.



# Example 1:
# Input: s = "ADOBECODEBANC", t = "ABC"
# Output: "BANC"
# Explanation: The minimum window substring "BANC" includes 'A', 'B',
# and 'C' from string t.

# Example 2:

# Input: s = "a", t = "a"
# Output: "a"
# Explanation: The entire string s is the minimum window.
# Example 3:

# Input: s = "a", t = "aa"
# Output: ""
# Explanation: Both 'a's from t must be included in the window.
# Since the largest window of s only has one 'a', return empty string.


# Constraints:

# m == s.length
# n == t.length
# 1 <= m, n <= 105
# s and t consist of uppercase and lowercase English letters.


# Follow up: Could you find an algorithm that runs in O(m + n) time?

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # s = "ADOBECODEBANC"
        # t = "ABC"
        # result = "BANC"
        if t == '': return ''
        freqs = Counter(t)
        window = defaultdict(int)
        have, need = 0, len(freqs)
        result, resultLen = [-1, -1], float("inf")
        left = 0
        for i in range(len(s)):
            char = s[i]
            window[char] = 1 + window[char]

            if char in freqs and window[char] == freqs[char]:
                have += 1

            while have == need:
                if (i - left + 1) < resultLen:
                    result = [left, i]
                    resultLen = (i - left + 1)
                window[s[left]] -= 1
                if s[left] in freqs and window[s[left]] < freqs[s[left]]:
                    have -= 1
                left += 1

        left, right = result
        return s[left:right + 1]

class SolutionNotEfficient:
    def minWindow(self, s: str, t: str) -> str:
        # s = "ADOBECODEBANC"
        # t = "ABC"
        # result = "BANC"
        def isEmpty(c):
            return all(v <= 0 for v in c.values())
        freqs = Counter(t)
        result = []
        minSize = sys.maxsize
        for i in range(len(s)):
            if s[i] in freqs:
                possible = []
                c = freqs.copy()
                j = i
                while not isEmpty(c) and j < len(s):
                    possible.append(s[j])
                    if s[j] in c:
                        c[s[j]] -= 1
                    if isEmpty(c) and len(possible) < minSize:
                        minSize = len(possible)
                        result = possible.copy()
                        break
                    j += 1
                if isEmpty(c) and len(possible) < minSize:
                    minSize = len(possible)
                    result = possible.copy()
        return ''.join(result)
