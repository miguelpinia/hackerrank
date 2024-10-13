# 68. Text Justification
# Solved
# Hard
# Topics
# Array
# String
# Simulation

# Companies

# Given an array of strings words and a width maxWidth, format the
# text such that each line has exactly maxWidth characters and is
# fully (left and right) justified.

# You should pack your words in a greedy approach; that is, pack as
# many words as you can in each line. Pad extra spaces ' ' when
# necessary so that each line has exactly maxWidth characters.

# Extra spaces between words should be distributed as evenly as
# possible. If the number of spaces on a line does not divide evenly
# between words, the empty slots on the left will be assigned more
# spaces than the slots on the right.

# For the last line of text, it should be left-justified, and no extra
# space is inserted between words.

# Note:

# A word is defined as a character sequence consisting of non-space
# characters only.  Each word's length is guaranteed to be greater
# than 0 and not exceed maxWidth.  The input array words contains at
# least one word.


# Example 1:

# Input: words = ["This", "is", "an", "example", "of", "text",
# "justification."], maxWidth = 16

# Output:
# [
#    "This    is    an",
#    "example  of text",
#    "justification.  "
# ]
# Example 2:

# Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
# Output:
# [
#   "What   must   be",
#   "acknowledgment  ",
#   "shall be        "
# ]
# Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
# Note that the second line is also left-justified because it contains only one word.
# Example 3:

# Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
# Output:
# [
#   "Science  is  what we",
#   "understand      well",
#   "enough to explain to",
#   "a  computer.  Art is",
#   "everything  else  we",
#   "do                  "
# ]


# Constraints:

# 1 <= words.length <= 300
# 1 <= words[i].length <= 20
# words[i] consists of only English letters and symbols.
# 1 <= maxWidth <= 100
# words[i].length <= maxWidth

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        justified = []
        curr_idx, total_words = 0, len(words)

        while curr_idx < total_words:
            temp = []
            count = len(words[curr_idx])
            temp.append(words[curr_idx])
            curr_idx += 1
            while curr_idx < total_words and count + 1 + len(words[curr_idx]) <= maxWidth:
                temp.append(words[curr_idx])
                count += 1 + len(words[curr_idx])
                curr_idx += 1

            if curr_idx == total_words or len(temp) == 1:
                l = ' '.join(temp)
                spaces = ' ' * (maxWidth - len(l))
                justified.append(l + spaces)
                continue
            total_spaces = maxWidth - (count - len(temp) + 1)
            space, extra = divmod(total_spaces, len(temp) - 1)
            line = []
            for i, w in enumerate(temp[:-1]):
                line.append(w)
                line.append(' ' * (space + (1 if i < extra else 0)))
            line.append(temp[-1])
            justified.append(''.join(line))
        return justified
