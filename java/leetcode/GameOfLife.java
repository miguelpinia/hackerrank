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
 * 289. Game of Life
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 *
 *
 * @author miguel
 */
public class GameOfLife {

    private int mod(int a, int b) {
        int m = a % b;
        if (m < 0) {
            m = (b < 0) ? m - b : m + b;
        }
        return m;
    }

    private void next(int[][] board, int i, int j) {
        int sum = 0;
        int neighborRow, neighborCol;
        for (int l = -1; l < 2; l++) {
            for (int r = -1; r < 2; r++) {
                if (l == 0 && r == 0) {
                    continue;
                }

                neighborRow = i + l;
                neighborCol = j + r;
                if (neighborRow >= 0 && neighborRow < board.length
                        && neighborCol >= 0 && neighborCol < board[0].length) {
                    sum += board[neighborRow][neighborCol] % 2;
                }
            }
        }
        if (board[i][j] == 0) {
            if (sum == 3) {
                board[i][j] += 2;
            }
        } else {
            if (sum == 2 || sum == 3) {
                board[i][j] += 2;
            }
        }
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                next(board, i, j);
            }
        }
        for (int[] row : board) {
            for (int col = 0; col < n; col++) {
                row[col] = row[col] / 2;
            }
        }
    }

}
