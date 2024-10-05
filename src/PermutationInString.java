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
 * 567. Permutation in String
 * Solved
 * Medium
 * Topics
 *
 * Hash Table
 * Two Pointers
 * String
 * Sliding Window
 *
 * Companies
 * Hint
 * Given two strings s1 and s2, return true if s2 contains a
 * permutation
 * of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 *
 * @author miguel
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26];
        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }
        int size = s1.length();
        for (int i = 0; i < s2.length() - size + 1; i++) {
            if (freqS1[s2.charAt(i) - 'a'] > 0) {
                int[] freqS2 = new int[26];
                for (int j = i; j < i + size; j++) {
                    freqS2[s2.charAt(j) - 'a']++;
                }
                boolean permutation = true;
                for (int j = 0; j < 26; j++) {
                    permutation &= freqS1[j] == freqS2[j];
                }
                if (permutation) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean checkInclusion2(String s1, String s2) {
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;

        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (freqS1[i] == freqS2[i]) {
                matches++;
            }
        }
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) {
                return true;
            }
            int idx = s2.charAt(right) - 'a';
            freqS2[idx]++;
            if (freqS1[idx] == freqS2[idx]) {
                matches++;
            } else if (freqS1[idx] + 1 == freqS2[idx]) {
                matches--;
            }

            idx = s2.charAt(left) - 'a';
            freqS2[idx]--;
            if (freqS1[idx] == freqS2[idx]) {
                matches++;
            } else if (freqS1[idx] - 1 == freqS2[idx]) {
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}
