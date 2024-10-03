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
 * 130. Surrounded Regions
 *
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * Explanation:
 *
 *
 * In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
 *
 * Example 2:
 *
 * Input: board = [["X"]]
 *
 * Output: [["X"]]
 *
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 * @author miguel
 */
public class SurroundedRegions {

    private void dfsNotCaptured(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '-') {
            return;
        }

        board[i][j] = '-';
        dfsNotCaptured(board, i - 1, j);
        dfsNotCaptured(board, i + 1, j);
        dfsNotCaptured(board, i, j - 1);
        dfsNotCaptured(board, i, j + 1);
    }

    /**
     * 2ms, beats 88.76%.
     *
     * @param board
     */
    // A possible reason why this code cant improve to 1ms, it's because the data in the for loop is in different cache lines.
    // A possible improvement is execute each query in distint for loops.
    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            dfsNotCaptured(board, 0, i);
            dfsNotCaptured(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            dfsNotCaptured(board, i, 0);
            dfsNotCaptured(board, i, board[0].length - 1);
        }
        for (char[] board1 : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (board1[j] == 'O') {
                    board1[j] = 'X';
                }
            }
        }
        for (char[] board1 : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (board1[j] == '-') {
                    board1[j] = 'O';
                }
            }
        }
    }

}
