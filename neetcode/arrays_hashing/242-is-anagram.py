# Is Anagram
# Solved
# Arrays and hashing
# Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

# An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

# Example 1:

# Input: s = "racecar", t = "carrace"

# Output: true
# Example 2:

# Input: s = "jar", t = "jam"

# Output: false
# Constraints:

# s and t consist of lowercase English letters.

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chars = [0 for i in range(26)]
        for c in s:
            chars[ord(c) % 26] += 1
        for c in t:
            chars[ord(c) % 26] -= 1
        return not any(chars)

    def isAnagram2(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        chars = [0 for i in range(26)]
        for i in range(len(s)):
            chars[ord(s[i]) % 26] += 1
            chars[ord(t[i]) % 26] -= 1
        return all(v == 0 for v in chars)
