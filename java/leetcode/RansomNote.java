
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
 * 383. Ransom Note
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b" Output: false Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab" Output: false Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab" Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105 ransomNote and magazine
 * consist of lowercase English letters. @author miguel
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        // Create a dictionary that counts the amount of characters for each letter in ransomNote
        // Do the same for magazine
        // Verify if both dictionaries contains the same pairs
        Map<Character, Integer> ransomDict = new HashMap<>();
        Map<Character, Integer> magDict = new HashMap<>();
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (int i = 0; i < ransom.length; i++) {
            if (ransomDict.containsKey(ransom[i])) {
                ransomDict.replace(ransom[i], ransomDict.get(ransom[i]) + 1);
            } else {
                ransomDict.put(ransom[i], 1);
            }
        }
        for (int i = 0; i < mag.length; i++) {
            if (magDict.containsKey(mag[i])) {
                magDict.replace(mag[i], magDict.get(mag[i]) + 1);
            } else {
                magDict.put(mag[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> r : ransomDict.entrySet()) {
            if (!magDict.containsKey(r.getKey())) {
                return false;
            }
            if (magDict.get(r.getKey()) < r.getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {

        // Create a dictionary that counts the amount of characters for each letter in ransomNote
        // Do the same for magazine
        // Verify if both dictionaries contains the same pairs
        int[] letters = new int[26];
        char[] ransom = ransomNote.toCharArray();
        int index;
        for (char c : ransom) {
            index = magazine.indexOf(c, letters[c % 26]);
            if (index == -1) {
                return false;
            }
            letters[c % 26] = index + 1;
        }
        return true;
    }

}
