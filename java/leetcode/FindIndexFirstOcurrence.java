package leetcode;

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
 * 28. Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad" Output: 0 Explanation: "sad"
 * occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto" Output: -1 Explanation:
 * "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 *
 * haystack and needle consist of only lowercase English characters.
 *
 * @author miguel
 */
public class FindIndexFirstOcurrence {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int n = haystack.length();
        int m = needle.length();
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m && k < n && haystack.charAt(k) == needle.charAt(i)) {
                k++;
                i++;
            }
            if (i == m) {
                return k - m;
            }
            k = k - i;
            i = 0;
        }
        return -1;
    }

}
