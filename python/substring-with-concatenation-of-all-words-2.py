# 30. Substring with Concatenation of All Words
# Solved
# Hard

# Topics
# Hash Table
# String
# Sliding Window

# Companies
# You are given a string s and an array of strings words. All the strings of words are of the same length.

# A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

# For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
# Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.



# Example 1:

# Input: s = "barfoothefoobarman", words = ["foo","bar"]

# Output: [0,9]

# Explanation:

# The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
# The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

# Example 2:

# Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

# Output: []

# Explanation:

# There is no concatenated substring.

# Example 3:

# Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

# Output: [6,9,12]

# Explanation:

# The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
# The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
# The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].



# Constraints:

# 1 <= s.length <= 104
# 1 <= words.length <= 5000
# 1 <= words[i].length <= 30
# s and words[i] consist of lowercase English letters.

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        word_length = len(words[0])
        total_length = len(words) * word_length
        indices = []
        freqs = Counter(words)
        for i in range(word_length):
            left = i
            subcount = defaultdict(int)
            count = 0

            for j in range(i, len(s) - word_length + 1, word_length):
                subword = s[j:j + word_length]
                if subword in freqs:
                    subcount[subword] += 1
                    count += 1

                    while subcount[subword] > freqs[subword]:
                        subcount[s[left:left + word_length]] -= 1
                        count -= 1
                        left += word_length

                    if count == len(words):
                        indices.append(left)
                else:
                    subcount.clear()
                    count = 0
                    left = j + word_length

        return indices

        # idx, word_length = 0, len(words[0])
        # initial_letters = set([w[0] for w in words])
        # freqs = Counter(words)
        # indices = []
        # while idx < len(s):
        #     if s[idx] in initial_letters:
        #         temp = freqs.copy()
        #         count = 0
        #         j = idx
        #         while count < len(words) and any(v != 0 for v in temp.values()):
        #             word = s[j:j+word_length]
        #             if temp[word]: temp[word] -= 1
        #             count+=1
        #             j += word_length
        #             if count == len(words) and all(v == 0 for v in temp.values()):
        #                 indices.append(idx)
        #     idx += 1
        # return indices
