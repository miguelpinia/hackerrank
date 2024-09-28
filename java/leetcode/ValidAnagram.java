/*
 * Copyright (c) 2024 miguel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    miguel - initial API and implementation and/or initial documentation
 */

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t, return true if t is an
 * anagram
 * of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * @author miguel
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // sort strings and check if both are equals O(nlogn) time O(1) space
        // Count total of chars for each string and check if both sets are equals O(n) time, O(n) space
        // using 1 array to count the frequency of each character, in the first traverse we increment each value and in the second traverse we decrement each value. If some value after this is distinct to zero, then there is no a valid anagram

        int[] freq1 = new int[26];
        for (char c : s.toCharArray()) {
            freq1[c % 26]++;
        }
        for (char c : t.toCharArray()) {
            freq1[c % 26]--;
        }
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
