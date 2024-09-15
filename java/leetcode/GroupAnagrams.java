
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat". The strings
 * "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
 * form each other. Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lowercase English letters.
 *
 * @author miguel
 */
public class GroupAnagrams {

    /**
     * 6ms, beats 97.73%, 47.64mb, beats 69.58%.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            if (result.containsKey(sorted)) {
                result.get(sorted).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                result.put(sorted, l);
            }
        }
        return new ArrayList<>(result.values());
    }

}
