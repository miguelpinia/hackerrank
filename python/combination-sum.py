# 39. Combination Sum

# Solved
# Medium

# Topics
# Array
# Backtracking

# Companies

# Given an array of distinct integers candidates and a target integer
# target, return a list of all unique combinations of candidates where
# the chosen numbers sum to target. You may return the combinations in
# any order.

# The same number may be chosen from candidates an unlimited number of
# times. Two combinations are unique if the frequency of at least one
# of the chosen numbers is different.

# The test cases are generated such that the number of unique
# combinations that sum up to target is less than 150 combinations for
# the given input.

# Example 1:

# Input: candidates = [2,3,6,7], target = 7
# Output: [[2,2,3],[7]]
# Explanation:
# 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used
# multiple times.
# 7 is a candidate, and 7 = 7.
# These are the only two combinations.
# Example 2:

# Input: candidates = [2,3,5], target = 8
# Output: [[2,2,2,2],[2,3,3],[3,5]]
# Example 3:

# Input: candidates = [2], target = 1
# Output: []

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # sort the candidates, to traverse the list from the smallest element to the biggest,
        # always thinking that the biggest must be less than or equal than the target.
        # For each element, append the element repeatedly while the sum is less or equal than
        # the target. At the moment when the sum becomes greater than target, make a backtrack
        # and take the next number in the list of candidates and perform the same strategy.
        candidates.sort()
        # we need
        sol = []
        def helper(appended, currSum, index):
            if currSum == target:
                sol.append(appended.copy())
                return
            if index >= len(candidates) or currSum > target:
                return
            appended.append(candidates[index])
            helper(appended, currSum + candidates[index], index)
            appended.pop()
            helper(appended, currSum, index + 1)
        helper([], 0, 0)
        return sol
