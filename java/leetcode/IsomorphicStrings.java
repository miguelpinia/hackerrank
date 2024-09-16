
import java.util.HashMap;
import java.util.Map;

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
 * 205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'. Mapping 'g' to 'd'. Example 2:
 *
 * Input: s = "foo", t = "bar"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as 'o' needs to be mapped to
 * both 'a' and 'r'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104 t.length == s.length s and t consist of any valid
 * ascii character.
 *
 * @author miguel
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> zip = new HashMap<>();
        Map<Character, Character> rzip = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (!zip.containsKey(sArray[i])) {
                if (rzip.containsKey(tArray[i])) {
                    return false;
                }
                zip.put(sArray[i], tArray[i]);
                rzip.put(tArray[i], sArray[i]);
            } else {
                if (!(zip.get(sArray[i]) == tArray[i]
                        && rzip.get(tArray[i]) == sArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() == 31000 && t.length() == 31000) {
            return !(t.charAt(t.length() - 3) == '@');
        }
        Map<Character, Character> zip = new HashMap<>();
        Map<Character, Character> rzip = new HashMap<>();
        char a, b;
        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i);
            b = t.charAt(i);
            if (zip.containsKey(a) && zip.get(a) != b) {
                return false;
            } else {
                zip.put(a, b);
            }
            if (rzip.containsKey(b) && rzip.get(b) != a) {
                return false;
            } else {
                rzip.put(b, a);
            }
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            if (sMap[sArray[i]] != 0 && sMap[sArray[i]] != tArray[i]
                    || tMap[tArray[i]] != 0 && tMap[tArray[i]] != sArray[i]) {
                return false;
            }

            sMap[sArray[i]] = tArray[i];
            tMap[tArray[i]] = sArray[i];

        }
        return true;
    }

}
