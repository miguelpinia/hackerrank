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
 * 208. Implement Trie (Prefix Tree)
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 *
 * 34ms, beats 78.11%, 56.86mb beats 6%.
 * @author miguel
 */
public class TriePrefix {

    TrieNode root;

    public TriePrefix() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        word += "\0";
        for (char c : word.toCharArray()) {
            current = current.addChar(c);
        }
    }

    public boolean search(String word) {
        TrieNode current = root;
        word += "\0";
        for (char c : word.toCharArray()) {
            current = current.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    class TrieNode {

        TrieNode[] next;

        TrieNode() {
            next = new TrieNode[27];
        }

        TrieNode addChar(char c) {
            if (c == '\0') {
                next[26] = new TrieNode();
                return next[26];
            }
            if (next[c % 26] == null) {
                next[c % 26] = new TrieNode();
            }
            return next[c % 26];
        }

        TrieNode get(char c) {
            return c == '\0' ? next[26] : next[c % 26];
        }
    }

}
