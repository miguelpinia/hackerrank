
import java.util.List;

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
 * 139. Word Break Attempted Medium
 *
 * Topics Array Hash Table String Dynamic Programming Trie Memoization
 *
 *
 * Companies Given a string s and a dictionary of strings wordDict, return true
 * if s can be segmented into a space-separated sequence of one or more
 * dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300 1 <= wordDict.length <= 1000 1 <= wordDict[i].length <=
 * 20 s and wordDict[i] consist of only lowercase English letters. All the
 * strings of wordDict are unique.
 *
 *
 * @author miguel
 */
public class WordBreak {
    //Set<String> words = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        visited[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    visited[i] = visited[i + s.length()];
                }
                if (visited[i]) {
                    break;
                }
            }
        }
        return visited[0];

        //StringBuffer sb = new StringBuffer();
        //for (String w : wordDict) {
        //    words.add(w);
        //}
        //for (char c : s.toCharArray()) {
        //    sb.append(c);
        //    if (words.contains(sb.toString())) {
        //        sb = new StringBuffer();
        //    }
        //}
        //return sb.isEmpty();
        //return dfs(0, new StringBuilder(), s);
    }

    //private boolean dfs(int index, StringBuilder word, String s) {
    //    if (index == s.length()) return word.isEmpty();
    //    word.append(s.charAt(index));
    //    if (words.contains(word.toString())) {
    //        return dfs(index + 1, new StringBuilder(), s) || dfs(index + 1, word, s);
    //    }
    //    return dfs(index + 1, word, s);
    //}
}
