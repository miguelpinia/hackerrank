package leetcode;

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
 * 36. Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the nine 3 x 3 sub-boxes
 * of the grid must contain the digits 1-9 without repetition. Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 *
 * [["5","3",".",".","7",".",".",".","."]
 *
 * ,["6",".",".","1","9","5",".",".","."]
 *
 * ,[".","9","8",".",".",".",".","6","."]
 *
 * ,["8",".",".",".","6",".",".",".","3"]
 *
 * ,["4",".",".","8",".","3",".",".","1"]
 *
 * ,["7",".",".",".","2",".",".",".","6"]
 *
 * ,[".","6",".",".",".",".","2","8","."]
 *
 * ,[".",".",".","4","1","9",".",".","5"]
 *
 * ,[".",".",".",".","8",".",".","7","9"]]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: board =
 *
 * [["8","3",".",".","7",".",".",".","."]
 *
 * ,["6",".",".","1","9","5",".",".","."]
 *
 * ,[".","9","8",".",".",".",".","6","."]
 *
 * ,["8",".",".",".","6",".",".",".","3"]
 *
 * ,["4",".",".","8",".","3",".",".","1"]
 *
 * ,["7",".",".",".","2",".",".",".","6"]
 *
 * ,[".","6",".",".",".",".","2","8","."]
 *
 * ,[".",".",".","4","1","9",".",".","5"]
 *
 * ,[".",".",".",".","8",".",".","7","9"]]
 *
 *
 * Output: false Explanation: Same as Example 1, except with the 5 in the top
 * left corner being modified to 8. Since there are two 8's in the top left 3x3
 * sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9 board[i].length == 9 board[i][j] is a digit 1-9 or '.'.
 *
 * @author miguel
 */
public class ValidSudoku {

    /**
     * 3ms, beats 56.19%. 44.29mb, beats 70.12%.
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int box = (i / 3) * 3 + (j / 3);
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows[i].contains(board[i][j])
                        || cols[j].contains(board[i][j])
                        || boxes[box].contains(board[i][j])) {
                    return false;
                }
                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                boxes[box].add(board[i][j]);
            }
        }
        return true;
    }

    /**
     * 1ms, beats 100%, memory 44.11mb, beats 80.75%.
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        int curr;
        int box;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                box = (i / 3) * 3 + (j / 3);
                curr = board[i][j] - '0' - 1;
                if (rows[i][curr] || cols[j][curr] || boxes[box][curr]) {
                    return false;
                }
                rows[i][curr] = true;
                cols[j][curr] = true;
                boxes[box][curr] = true;
            }
        }
        return true;
    }

}
