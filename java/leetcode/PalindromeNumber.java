package leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * 9. Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome , and false otherwise.
 *
 * @author miguel
 */
public class PalindromeNumber {

    public boolean isPalindrome1(int x) {
        String number = String.valueOf(x);
        int n = number.length();
        for (int i = 0; i < n / 2; i++) {
            if (number.charAt(i) != number.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        int remainder = 0;
        int reversed = 0;
        int temporal = x;
        while (temporal > 0) {
            remainder = temporal % 10;
            reversed = reversed * 10 + remainder;
            temporal /= 10;
        }
        return reversed == x;
    }

}
