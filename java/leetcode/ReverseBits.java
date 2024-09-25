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
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 *
 * Example 1:
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 *
 * @author miguel
 */
public class ReverseBits {

    /**
     * 0ms, beats 100%, 41.32mb, beats 95.12%
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse <<= 1;
            if ((int) (n & 1) == 1) {
                reverse ^= 1;
            }
            n >>>= 1;
        }
        return reverse;
    }

    /**
     * 0ms, beats 100%, 40.98mb, beats 99.81%
     *
     * @param n
     * @return
     */
    public int reverseBits1(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse <<= 1;
            reverse |= (n & 1);
            n >>>= 1;
        }
        return reverse;
    }

}
