package leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces
 *
 * @author miguel
 */
public class ReverseWords {

    /**
     * Solution using O(n) extra space;
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("[ ]+");
        int size = words.length;
        String[] newWords = new String[size];
        for (int i = 0; i < size; i++) {
            newWords[i] = words[size - 1 - i];
        }
        return String.join(" ", newWords);
    }

    /**
     * Solution using stringbuilder
     */
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;
        int left;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(s.substring(left + 1, right + 1));
            right = left;
        }
        return sb.toString().trim();
    }

}
