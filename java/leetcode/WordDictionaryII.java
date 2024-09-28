
import java.util.ArrayList;
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
 * 193n ms Beats 56.30%, 119.52MB Beats 5.04%.
 *
 * @author miguel
 */
public class WordDictionaryII {

    private Node root;

    public WordDictionaryII() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                Node n = new Node();
                current.nodes[c - 'a'] = n;
                current.existing.add(n);
            }
            current = current.nodes[c - 'a'];
        }
        current.endWord = true;
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    class Node {

        Node[] nodes;
        List<Node> existing;
        boolean endWord;

        Node() {
            nodes = new Node[26];
            existing = new ArrayList<>();
            endWord = false;
        }

        boolean search(String word, int idx) {
            if (idx >= word.length()) {
                return endWord;
            }
            char c = word.charAt(idx);
            if (c == '.') {
                for (Node n : existing) {
                    if (n.search(word, idx + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (nodes[c - 'a'] == null) {
                    return false;
                }
                return nodes[c - 'a'].search(word, idx + 1);
            }
        }
    }

}
