
/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * @author miguel
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replaceAll("[\\W_ ]+", "");
        String s2 = (new StringBuilder(s1)).reverse().toString();
        return s1.equals(s2);
    }

    private boolean isCharacter(char a) {
        return 'a' <= a && a <= 'z' || 'A' <= a && a <= 'Z' || '0' <= a && a <= '9';
    }

    private boolean areEquals(char a, char b) {
        if (a == b) {
            return true;
        }
        return (a - 32) >= 65 && a - 32 == b || (b - 32) >= 65 && b - 32 == a;
    }

    public boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        char a, b;
        while (i <= j) {
            a = s.charAt(i);
            b = s.charAt(j);
            if (!isCharacter(a)) {
                i++;
                continue;
            }
            if (!isCharacter(b)) {
                j--;
                continue;
            }
            if (!areEquals(a, b)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
