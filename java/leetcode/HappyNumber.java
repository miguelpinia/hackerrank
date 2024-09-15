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
 * 202. Happy Number
 *
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 *
 * @author miguel
 */
public class HappyNumber {

    private int sumSq(int n) {
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }

    /**
     * 0ms beats 100%. ¨
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int res = 0;
        int slow = n;
        int fast = n;

        while (true) {
            slow = sumSq(slow);
            fast = sumSq(sumSq(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }
        }
    }

    public boolean isHappy2(int n) {
        int s;
        while (n > 9) {
            s = 0;
            while (n > 0) {
                s += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = s;
        }
        return n == 1 || n == 7;
    }

}
