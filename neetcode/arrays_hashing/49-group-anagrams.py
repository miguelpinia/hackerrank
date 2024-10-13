# Anagram Groups
# Solved
# Given an array of strings strs, group all anagrams together into
# sublists. You may return the output in any order.

# An anagram is a string that contains the exact same characters as
# another string, but the order of the characters can be different.

# Example 1:

# Input: strs = ["act","pots","tops","cat","stop","hat"]

# Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
# Example 2:

# Input: strs = ["x"]

# Output: [["x"]]
# Example 3:

# Input: strs = [""]

# Output: [[""]]
# Constraints:

# 1 <= strs.length <= 1000.
# 0 <= strs[i].length <= 100
# strs[i] is made up of lowercase English letters.

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        Time Complexity: m * n log n, where m is the size of strs
        array and n is the size of the longest string in s.

        Space complexity: m * n
        """
        cache = defaultdict(list)
        for s in strs:
            s1 = ''.join(sorted(s))
            cache[s1].append(s)
        return cache.values()



    def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
        """
        Time complexity: m * n, where m is the size of the strs array
        and n is the size of the longest string in the array.

        Space complexity: m * n
        """
        cache = defaultdict(list)
        for s in strs:
            freqs = [0] * 26
            for c in s:
                freqs[ord(c) % 26] += 1
            cache[tuple(freqs)].append(s)
        return cache.values()
