
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
 * 211. Design Add and Search Words Data Structure
 *
 * Design a data structure that supports adding new words and finding if a
 * string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object. void addWord(word) Adds word to the
 * data structure, it can be matched later. bool search(word) Returns true if
 * there is any string in the data structure that matches word or false
 * otherwise. word may contain dots '.' where dots can be matched with any
 * letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]] Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad"); wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad"); wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True wordDictionary.search(".ad"); //
 * return True wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 25 word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters. There will be at
 * most 2 dots in word for search queries. At most 104 calls will be made to
 * addWord and search.
 *
 * @author miguel
 */
public class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.nodes.containsKey(c)) {
                current.nodes.put(c, new Node());
            }
            current = current.nodes.get(c);
        }
        current.endWord = true;
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    class Node {

        Map<Character, Node> nodes = new HashMap<>();
        boolean endWord;

        boolean search(String word, int index) {
            if (index >= word.length()) {
                return endWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                boolean carry = false;
                for (Node n : nodes.values()) {
                    if (n.search(word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!nodes.containsKey(c)) {
                    return false;
                }
                return nodes.get(c).search(word, index + 1);
            }
        }
    }

}
