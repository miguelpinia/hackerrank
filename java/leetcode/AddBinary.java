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
 * 67. Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 * @author miguel
 */
public class AddBinary {

    /**
     * 1ms, beats 99.82%, 42.04MB, beats 70.86%.
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] bigger = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        char[] smaller = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int min = smaller.length;
        int max = bigger.length;
        int carry = 0;
        int x, y, val;
        for (int i = min - 1; i >= 0; i--) {
            x = bigger[(max - min) + i] - '0';
            y = smaller[i] - '0';
            val = (x + y + carry) % 2;
            carry = (x + y + carry) / 2;
            sb.append(val);
        }
        for (int i = max - min - 1; i >= 0; i--) {
            val = (carry + bigger[i] - '0') % 2;
            carry = (carry + bigger[i] - '0') / 2;
            sb.append(val);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
