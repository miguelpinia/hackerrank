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
 * 191. Number of 1 Bits
 *
 *Write a function that takes the binary representation of a positive integer and returns the number of
 * set bits
 * it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 11
 *
 * Output: 3
 *
 * Explanation:
 *
 * The input binary string 1011 has a total of three set bits.
 *
 * Example 2:
 *
 * Input: n = 128
 *
 * Output: 1
 *
 * Explanation:
 *
 * The input binary string 10000000 has a total of one set bit.
 *
 * Example 3:
 *
 * Input: n = 2147483645
 *
 * Output: 30
 *
 * Explanation:
 *
 * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 *
 *
 * Follow up: If this function is called many times, how would you optimize it?
 *
 *
 * @autho¨*r miguel
 */
public class NumbersOf1Bits {

    /**
     * 0ms, beats 100%, 40.18mb, beats 97.63%
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int hamming = 0;
        for (int i = 0; i < 31; i++) {
            if ((int) (n & 1) == 1) {
                hamming++;
            }
            n >>>= 1;
        }
        return hamming;

    }

}
