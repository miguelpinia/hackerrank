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
 * 69. Sqrt(x)
 *
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 * @author miguel
 */
public class MySqrt {

    /**
     * 1ms, beats 85.96% (faster solutions used builtin operations, which was
     * prohibited), 41.00MB beats 30.82%
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = 0;
        long mid;
        long sq;
        while (left <= right) {
            mid = left + (right - left) / 2;
            sq = mid * mid;
            if (sq > x) {
                right = (int) mid - 1;
            } else if (sq < x) {
                left = (int) mid + 1;
                result = (int) mid;
            } else {
                return (int) mid;
            }
        }
        return result;
    }

}
