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
 * 48. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 *
 * @author miguel
 */
public class RotateImage {

    /**
     * 0ms, beats 100%, 42.30mb, beats 27.90%.
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp, j, k;
        // Transpose
        for (int i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            j = 0;
            k = n - 1;
            while (j < k) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
                j++;
                k--;
            }

        }
    }

    /**
     * 0ms, beats 100%, 42.07mb, beats 61.86%. Slightly faster.
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int tmp, j, k;
        // Transpose
        for (int i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // reverse each row
        j = 0;
        k = n - 1;
        while (j < k) {
            for (int i = 0; i < n; i++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
            j++;
            k--;
        }
    }

}
