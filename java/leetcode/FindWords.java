
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class FindWords {

    Set<String> result = new HashSet<>();
    Set<Point> visited = new HashSet<>();

    private void dfs(char[][] board, int i, int j, String word, TrieNode node) {
        Point p = new Point(i, j);
        if (i < 0 || j < 0 || i == board.length || j == board[0].length
                || !node.next.containsKey(board[i][j])
                || visited.contains(p)) return;

        visited.add(p);
        node = node.next.get(board[i][j]);
        word += board[i][j];
        if (node.isWord)
            result.add(word);
        dfs(board, i - 1, j, word, node);
        dfs(board, i + 1, j, word, node);
        dfs(board, i, j - 1, word, node);
        dfs(board, i, j + 1, word, node);
        visited.remove(p);
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode t = new TrieNode();
        for (String word : words) {
            t.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", t);
            }
        }
        return new ArrayList(result);
    }

    class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 29 * hash + this.x;
            hash = 29 * hash + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            return this.y == other.y;
        }
        
        
    }

    class TrieNode {
        
        Map<Character, TrieNode> next = new HashMap<>();
        boolean isWord = false;

        TrieNode() { }
        
        void addWord(String word) {
            TrieNode current = this;
            for (char c : word.toCharArray()) {
                if (!current.next.containsKey(c)) {
                    current.next.put(c, new TrieNode());
                }
                current = current.next.get(c);
            }
            current.isWord = true;
        }
    }

}
