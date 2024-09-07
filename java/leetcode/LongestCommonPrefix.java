package leetcode;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"] Output: "fl"
 *
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no
 * common prefix among the input strings.
 *
 * @author miguel
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();
        char c;
        int i = 0;
        while (i < strs[0].length()) {
            c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.length() <= i || s.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        String initial = strs[0];

        for (String str : strs) {
            while (str.indexOf(initial) != 0) {
                initial = initial.substring(0, initial.length() - 1);
                if (initial.isEmpty()) {
                    return "";
                }
            }
        }
        return initial;

    }

}
