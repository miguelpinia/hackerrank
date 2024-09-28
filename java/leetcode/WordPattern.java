
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
 * 290. Word Pattern
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s. Specifically:
 *
 * Each letter in pattern maps to exactly one unique word in s. Each unique word
 * in s maps to exactly one letter in pattern. No two letters map to the same
 * word, and no two words map to the same letter.
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 *
 * Output: true
 *
 * Explanation:
 *
 * The bijection can be established as:
 *
 * 'a' maps to "dog". 'b' maps to "cat". Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 *
 * Output: false
 *
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300 pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000 s contains only lowercase English letters and spaces '
 * '. s does not contain any leading or trailing spaces. All the words in s are
 * separated by a single space. @author miguel
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] cArray = new String[26];
        Map<String, Integer> sArray = new HashMap<>();
        char[] letters = pattern.toCharArray();
        String[] words = s.split(" ");
        if (letters.length != words.length) {
            return false;
        }

        for (int i = 0; i < letters.length; i++) {

            if (cArray[letters[i] % 26] != null && !cArray[letters[i] % 26].equals(words[i])
                    || sArray.containsKey(words[i]) && sArray.get(words[i]) != (letters[i] % 26)) {

                return false;
            }
            cArray[letters[i] % 26] = words[i];
            sArray.put(words[i], letters[i] % 26);
        }
        return true;

    }

}
