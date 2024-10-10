# 1963. Minimum Number of Swaps to Make the String Balanced
# Solved
# Medium

# Topics Two Pointers
# String
# Stack
# Greedy

# Companies
# Hint
# You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

# A string is called balanced if and only if:

# It is the empty string, or
# It can be written as AB, where both A and B are balanced strings, or
# It can be written as [C], where C is a balanced string.
# You may swap the brackets at any two indices any number of times.

# Return the minimum number of swaps to make s balanced.



# Example 1:

# Input: s = "][]["
# Output: 1
# Explanation: You can make the string balanced by swapping index 0 with index 3.
# The resulting string is "[[]]".
# Example 2:

# Input: s = "]]][[["
# Output: 2
# Explanation: You can do the following to make the string balanced:
# - Swap index 0 with index 4. s = "[]][][".
# - Swap index 1 with index 5. s = "[[][]]".
# The resulting string is "[[][]]".
# Example 3:

# Input: s = "[]"
# Output: 0
# Explanation: The string is already balanced.


# Constraints:

# n == s.length
# 2 <= n <= 106
# n is even.
# s[i] is either '[' or ']'.
# The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
import heapq


class Solution:
    def minSwaps(self, s: str) -> int:
        right = open =  closed = ans = 0
        s = list(s)
        for i, c in enumerate(s):
            if c == '[': open += 1
            else: closed += 1
            if closed > open:
                while s[right] == ']' and right > i:
                    right-=1
                s[i], s[right] = s[right], s[i]
                ans+=1
                closed-=1
                open+=1
        return ans

    def minSwaps2(self, s: str) -> int:
        open =  ans = 0
        for c in s:
            if c == '(': open += 1
            else:
                if open: open-=1
                else: ans+=1
        return ceil(ans/2)

a = "]]]][][[[][[]][[]][[]]]]][[]][][[]][]][[][]][[[][[[[]]][[[[]][[]]][[][[[[][][[[[[[][][[]][[[][][[[[]]][[][[[]]]][[[][[]][[][[][][]]]][[]]][]][[][]]]]][]][]]][[[[]]][]][][[]][][[]]]][[[]][]]]]]][][][][[][][][][][[[][][[[[[[]][][][[[[[[[[][[[]][[]]][][[[[[[]][][[][[]][[[]]]][][]][]]][[][][][][][]]]][]][][]]]][][]][[[]]][][]]][[[[]][[[[][[][][][][][[[]][]]]][]]]][[][[]][]][][]][[][[][[]][][][[]]]]]]]]][[[]]][[[[][[[[]]][[][][][[]]][]][[][[[[[[][[][]]][[[]][[][[[][][][]][[[[]]][]]]][]]][]]]]]][]][]]][][][][][[[[[]]][[]][][[[[[]]][]][]][[][][]]]][]][[[][[][][[[][][][][]]]]][]]][[][[[]][[]]][][]][][][[[]][[[[]]]]][[][[][[]]][][]]]]]][[]]]][]][]][[]][[][][][[[[]]][[[][][[]][[[[]][[[[[]][[[[[]]][[][[[]][[][]]]]][[[][[][][[]][]][[][[][]]][[[[[]][][[[[][[][[][[[]]]]]][][[]][[]]]][][[[[[]][][][[]][]]][[[]]]]]][][[]][][]]][][[[[[[][][]][[][[]][[[]][][]]]]][[]]][]][[]]]]][]]]][[][[[[[[][[[[]]][]]][[]]][[[][][[[[][][]]]][[][[][[[[[][[[][[[][[[[[]]][[]][[][[[][]]][]][][][]]][[][[]][]][]][[]]][[][[[[[][[[[]]][[[]]][][[[]]][[][][]][[][[]]][]][[]]]][[][[][[]]]]]]]][[[]]][][[[][][][[][]]][[][]]][][][]][[[[[]][[]]][]][]]]]]][[[]][[][][]][[[]]][][[[[][][][[][[[][[]]]][]][[[[[[]]][]]][][[[]]][[][[[]][]]][][[[]]][][[[[[[][][][[][[[]]]]][[[[[[[]][]][]]]][[[[[]]]][][[[[][[[[[[][][[[][]][][[]][[][[]][][[[[][[]]]]][[[[][[[[[[]]]][]][[[[]][][]][][][[]]][[]]]]]]]][[[[[[[][[][][][[][[][]][[[]]]]]][[][]][][]]]]]][[][]]][[]][][]]][[[]][[]]][][[]][][][[]]]][]]][]]][[[]]][[[[][]]]]][[[][]]]]]][][]]][]]][][[[]][[[]][]][]][[][[[]]][][]][]]][[[]][][]][[]]][[[[][]][]][[][]]]][]][[][][][[][]]][[[][]]][[[]][[[[]]]][[[[][]]]]]]]][][[]]][[[]]][][[][[[][][[]]][]][[[]][][[]]][][][[][][]][[][]]][][[][[][][[][][]][[][][[[[]][[][[[]][]][][][[[[[[][[[]]]][][]][][[[][[]]][[]][[[]][]][[][]][][][[[]]]]][[]][][[][]]][[][]]][][][][[[[[[][[][][[[[[][[][[]]]]][]]][]]][]]][[]]]]][[][[[[[]]][[[[]][][[[][[][]]][[]][][]][][]]][][[[]][][][][[[]]]][[]]][[][[]][]][[]]]][[[]][][[][][[[[[]][[]]]][[][][[[][]]][]]][]][][[]]]][][]][[[]]]]][]][][[][[][[]]][][]]]]][[[]]][[[][[]]]]]][][][]][[]][]]]][]]]]][[[[][]][][]]]][[[[[[[]][[[]]][][[][[][[[][[[[]]]]]][[[[][[[[][[][][[[]]][][[[[[[[[[[]]]]]]][[][[[][[[]][[][[[[[]][][[]][[[[[[[[[[]]][[]]][][]][][[]]]][]]][]]][[]]]]][]][[]]][[][]]]]]]][[[[[]][[]]][[[[]]]]]]][]]][[[][][][][[[[[[[]][[[[[[][][][]][[][][[][[]][[][]]]][[]]]][][][][[[[]][[[][[[[]][[]][[[]]]]][[]]][][[[[][[]]]][[[[]]]]]]][[][[[[][][][[[[[][]][][[[[]][[]][][]][[]][[]]][[[[[][[][]]][][][[][[[][][[[]]]]][[[[[[][][[][[][][]][[][[[[][]][][]]][[][[[][[]]][][[[][[][[][]][]][[][[[][]][]]][]][[[][]][]]][]][]][]]][[[[]][[]][[[[][][][[][]][[[]][[[[][]][]][]]][]][[][[[[][]][][]][][[]][]]][][][]]]]]][][[]]][[]]][[[[[][[]]]][]]]][[][][[[[[][]][][[][]]]]]]][][][[[]]]][][][]]][][[[[][[]]][][[]]][][]][[]]]][][]][]]][[][][[][][[][]]][]]]]][[][[[[[[[]]][]]]]]]]]]]]]][][]]]][[][[][]]]]][][[[][[[]]][]][]]][][[[]][[]]][[[]]]][][[]][]]][[[[[[[[][][]]]][[]][[[]]]][[][]][][][][[[][[]]]]]][][[[[[[]][[]]][][]][[]]][]]]]]]][][]][[]]]]]][][][]][][[[[][[]][][[]][][]][[[[][][]]]]][[][[[][]][[][[[[]]]]][[]][[]][[][[[[][[][][]]][[[[][][]][[][][][[]]]][][[]]]][[[][[][[][]][][]]]][[]][][[[]][[[[[[[[]]]]][][]]]][]][[[[[[][]][][[][]][]][[[][[]][[][[]][]][]]][][][[][[][]][][][[[]]]][[[][[[[[]]][]][]][][]]]]][[[[[[][[[][[]][][]]]]]][[]]][][[][][][][[]][[]]]]]][[]][[[]][[[]][[[[[[[]][[[][[[[[[[[][][[[][[][[[]][[]]]]]][[]]][][]][[][[[[][][][][]][[[[[[][]]]][[][][][[]]]][[[[[]]][[[]][[][]][[]][[][[][[[[][[[]]]]]]][[][[]]][[[[[[[][[]]][][[][[[]][[][[][[[[[[]]]][][]]][]]][[][][][[[]][[]]][[]][]]]]][[[]]]][][][[]][][[]][][[]]]]][[][]][[[[][[][[[]][][[]][[[[][[][[[]]][[[[[[][][[][[[][[[]]][]]]][]][[[[]]][]]]][][][][][]][[][[]]][[[[[][][]]][[]]]]][][[][[]][[[][]]][[]][[[][]][[]][[][[][][][[[[[[[][][][[][[[[[[[[[]]][]][][[][]][]][[]][[[][[][[]][[[]][][[[[]][]][[]][[[]]]][][[[]][][]][[][[[[]][[[[]]]]][[][[[][][]][]][]][[][[][[]]][[[]]][]][[]]]][[][[[][][]]][[]]]]][]][]][]][[]][]]][][[]][]][[[[][]][][]]]]][]][]]]][[[[[[][][[]][[[[[[][]]][[]]][][]]][][]][][][][]]][][]][][][[[[]][[[][][[][[][[][][[[[[]]][[[[[][][]]][[][[][][][[]][[]]]][]]]][]]]][[][][[[[[]][]][[][]]][]][][]][]]][[][[][]]][]]]]]][[][[][[[[[[][]][[[][[][][[[[[]]][]][]][][[[[]]]][][]]][]]]][]][[]][[][]]][][[]]]]]]]]]][[[[[[]]]]][[]][[][[][[][[][][]]][[[]]]]][]]]][[]]][]]][[[[]]]][[[[[[]][[]]][[][[][][[]][][[[[[[[[[[[[[]][[]][[[][[[[[[]]]][[]][][][]]][]]][]]]][][]]][]][[[]][]][[]]]][[[]][[[[]][][[][[[]][[]]]][[[[][[][[[]]]]]][]]][][[[[]][[]][[[][]][][[][[[[[]]][[[][[[[[[][[[[[]][[[][]][[[]][[[][]][][[[][[[[]][]][][[[][[[[[][]]][]]][[]][][[]][][[[[][[[[[]][][]]]]][[[]][][[]][]][[[[[[]][]][[][[][]][]]][]][[][[]]][]]][[]]][[]]]][]]][][[[[][[[[[][[[[[][[][]]]]]]][][]]][]]]]][[][][]]]]][]]][[][]][[][]][[]][[[[]][][[[[][[[[]][][[[][]]][][]]]][[[]]]][][][]]][[[]][]][[][][][[[][[[][[[[][]]]][][]]]][[[[[[]][][][[[]]]]]]][[][[[[]]][[[[]]]][[][[][[[][]][][[][]]][][][[[[][[][[[][[]][][][]]][]][[]][][[[[][[][[[]]]][[][[[[]][[][]][]][[[][]]]]][]][[]][]]][]]][[][[[]]]][[][[][][]][]][[][[[][[[]][[[][[][[]]]]]]][]]][]]]]][[][[[[[]]][[[[][]]][][][[[][[][]][]]]]]][[][[[[[][]]][[[][][[[[]][]]]]][]][[][][]]]][]][[][][][[[[[[[]][]][]][]][[]][][[]]][][][[[][]][][[]]]]]]]][][[][]][][[][[[][]]][[[[]][][[][][[]]]]]][][]]][[][][]]]][]]][[[[[]][]][][[]][[][[]]]]][]]][]][][[[]][[][[]][]][[]]]][[][][[[[[[[][[[]]]]][[[][][][[][[]][]]][][[[][[]][[][]][[[][]]][[[[][[][]][[[][][[]][][]][[][[[][[][[[[[[[][]][][][][[[][[[]]]][][[]][[][][][[[[][[[[]][[[][[[][[]]][]][]][[[[[[[][][[][[]]][[][][[[]][]][[[][[]][][][]][][]][][]][[]][][][][[][[]][[[][]][[]]][][[[[]]]][]]]][[]][]]]]]]][[[[][][]]]][[]]]][]][]][[[[[][][[]]]]][[[[]]]]][][]][][]][]][[[]]][][][]][[[[[]][[[][]]][]][[]]]]][[[[][][][]][]][[]]][][[[[][[[][[[]]][[[[[[[[[]]][[[][[[]]][[[[[]]]][]][[[][[]][[[[[[]]]]]]][[[]][]][]][[[][[[[[]]]]]]]][]][]][[[[[[][]][[]][][[][][[[]]]]][]]]][]][]][][]]]][][]]]][[[][][[[[]][][[[]]]]]]][[[[[[[][[][[][[[[][[][[]][[]]][][][]]]][[][[]][][[[]]]]][]]][[[[[[]][][][][][[][[][]]]][[][[[]]]]]][[[[]][[][[[]][]]]][[[[][[[[][][][[[[]]][]]]][[[[[][][[[[][[[]]]]]][]]]][[[][]]][]]]][][[[][]][][[]]]]]]]][][]][][[[][][]][[][]]]][[[]][][][[]]]][[][][][[]][[][]]]]]][][][[[][]]]][][]][[]]][[][][[[[[[]][[]][][[]]][[[][[[]][[[]][[[[[[]]][[]]]][]]][[[[]]][[[][][]]][[[[]]][[][[]][[[]][][][[][[[]][][[[[][][][]][]]]][[[][[[[[[][][]]][[]]][]]][[[][[[[]][[[[[[][][][[[][[][][[]]]]][[[[]]]][]]]]][][]]][][]][][[]]][[[[]]][[][]][[[[[[[]][][[]][[[]][]][][][][[[][[]][][[][][[][[[][][][][]]]][[][][[[[[[[][[[][[]][[]]]]][[]][[][[][[]]]][]][[]][[[][[][][[[][][[][[[]]][]][]]]]][]]]]]]]][]]][][][][[[]][[][]]][][]]]][]]]][][[]][[[]][][]][][][]][][][]]]][][[]]][][[][]][]][][[[[]][[][[][[][[[[[][]][][[[[]]][]]]][]][[][][]][][]]]][[]][][[[[[[[[[[][]]][[][][[]]][[]]]][[][[[[[[[][]][][]][[][[[[[[[]]][[[[[][[[[[[][][]][]][]]][][[]]]]]][][[][[]][][[[[][]]][[][[[[]]][][[][[]][]][]][][[[]][[][][[[]][][][]]][]]]]][]]][[[][[]]][][][[]][][][[][]][]]][[[[][]]]][]][]]]][]]][][]][]][[]]][[]]]]]][[]][]]]]][[][]][]][[][]][][][[[][[][[[]][[]]][]]][[]][][[][][[][[][][[[]]]]]]]]]]][[]][][[[[[]]][[[]]][][[[[]][][[][[[][]]]]]]][]]][][[]][[[[[]][][[]]]]]][]][[][][]]]]]][[][][]]][]]]]][[][]]]][[[]][[]][][[[]]]][][][[[[][][]][]][][[][[]][[[][][][]]][[[]]]][]][]][[]][[]][]]]]]]][[]]][]][[][[][][[][[][[[]]][]]][][]]]][[[[[][]]]]][[]][[][]][]][][[[]][]]][[[[][][][[][[[[]]][]]][[[[]][][][[][[][][][[]][[[[[]]][][[[][][]][[[]][][][[[[[][][[[[[][]][[]][]]]][[[[][[][][[[]]]]][[]]]][][][][]]][[]][]][][[]]][[[]][[[]]][[][]][[[]][][][[[][[][][][][[[[[][[[][]][[][][[]][[[]][]]]][[]]][[][]]]]]][]]][][]]]][[]]][]]][][]]]][][]][[[[[[]]]][]][][][][[]]][[[[[[[]][[]][]][[]][[]]]][[]][][]]]][[[]][]][[][[[[[]][[]]][[]]]]][]][[[][]][]][]]][]]][]][[]][][[][[[][]][[][[]]][[[[[[[[]]][[]][]][[[[][[[][[[[[][][[[[[][[[[[][[][]]]][[]][[]]]][]][[][[[[]][[[][[[[[[[[][[][]][]]][][]][[][[][[]][[[]][[[]][]]]]][[][[[][[]][[]][[[[[[[][][[][][[[]]]][[[][][[][[]]]][[][[[[[[[][][[]][[[[[[]][][[][[]]][]]]][[]]]]]]][][]]][[][[][[[]]][[]]][[][[][]]][]][][[[[][[][[[]][[]][[]][][[[[][[[[][[[]][]]]][[]]][[[]]]][][]][[]][]][[]][[[][][]]][]][]][[][]][]]][][]]][][][[]]]]]]]][[[[][[[]]][]]][][]][]]]][[[[]][[]]]][[][]][][[[[[[]]]]][]]]]]][]]][[[]][][]]][][]]]][]]]]][][]]]]]]]]][[[[[][[]]][[[[[[]][[]]]]]][[[]]][[][][[]]][]]]]]][[][][]]][][[[][]]][[[]][[[[[][]]]][[]][[[][[]][[[][]][[][[]][][]]]]]]]][[[[][][][]][[][][[][[[][][][[[]]][[[[[[[][][[[[]]][[[]][][]]]][[[][][[]]]][]][[[][[[][]]][][[[[][[[][[][[[[[[]]]][]][[][]][[[]][][]]]]]]]]]][[]][[[[][]]][[[][][[]][[][[[][[][]][]][[]]][[]]][[][[][[][[][]]]][]]]][[[[]][[[[[[[][]]][]][[][][[][][]]][[][][]][][][][][[]][[[]][]][[[[[[[]]][[]]]]][[]][][][[[][][][]][[[[[[]]]][[[][[[[[]]]][[[[[]]][[[[[][[]]]][]][[[[[]]]]][[][[[][[][[[]][[][[[][]][]]]][[[[][]][][]]]][[[]]]][[[[[][]]]][]]]][][[]]][][]][[[[]][][][[][][]][]]]][]]][[][]]][]]]]]][]]]]][[][]][]][[[]][]]]]][]]][]]][][][[]][[][[]]][][[]]][[[]]][[[]]]]][][]]][]]][[]][]]]]]][[[[]][[][][]][]]]]][[][]]]]][[]]]][[]]][][[[]][[[][[[][[[][][[[[[[[]]]][[][][][[[]]][[]][[[[[][[[]]]]]][]][][[][[]]]][][[]]]]][][[][[]]][[[]]][[[]"
b = "]]][]][[][][]][]]][]]]]][[[]]][]][]]][[][][]][[]]]]]]][][[]][]]]][][[[[]][[[]]]]]]][]][][][]]][[][]]]][[[]][[]]]]][[[[]][]]][[][[[]]]][][][[][[[[][[]]]][][][[[][]][]][][[[]]]]][][]][[[[[][][]][][]]][[[[[[[[[[[][[]]]]][[][[]]]]]][][]][][[[[[][]][]]][[[[[[][][[[][]][]][]][][]][]][][[[[[][[[[[[][[][[][]][]]]][[[][[]]][]]][]][[[[[]][][]]][[[[[]][[[][]]][[[[]]][]][[]][]][[[][][][[]][[][[[[][][[][]]]]]]][]][][][[]]]]]][][[][[][][][[][]]]]][[][[[[[]][[[]][][][[[[]]][[]]]][[][][][[[[[]]]][]]][[]]]][][[[][[[[[]]]]]][[[]]][[][][[[]][[[[[[][[][][]][[[]]][]]][[[[]][][]]][]][][[[][[]][]]][[[][[[]][]][[][][[][[[[]][][[[[][]][[]][[][][]][][[][]][[[][]]][[[[][]]][[]][[[][[[][]]][[[[]]][[[[]][[]]][][]][[]["

s = Solution()
print(s.minSwaps(a) == 13)
print(s.minSwaps(b) == 16)
