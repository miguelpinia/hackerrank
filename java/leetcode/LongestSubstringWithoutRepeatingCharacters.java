
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
 *
 * @author miguel
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 71ms, but using sets and more readable code.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> repeated = new HashSet<Character>();
        int maxSize = 0;
        int left;
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            left = i;
            while (left < s1.length && !repeated.contains(s1[left])) {
                repeated.add(s1[left]);
                left++;
            }
            repeated.clear();
            maxSize = Math.max(maxSize, left - i);
        }
        return maxSize;
    }

    /**
     * 2ms, beats 98.95%, 44.56mb, beats 58.13%. If changes to 128 array size,
     * uses 43.16mb, and beats 92.94%.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        char[] s1 = s.toCharArray();
        int[] chIdxs = new int[256];
        int left = 0;
        int size = 0;
        char curr;
        Arrays.fill(chIdxs, -1);
        for (int i = 0; i < s1.length; i++) {
            curr = s1[i];
            if (chIdxs[curr] >= left) {
                left = chIdxs[curr] + 1;
            }
            chIdxs[curr] = i;
            size = Math.max(size, i - left + 1);
        }
        return size;
    }

}
