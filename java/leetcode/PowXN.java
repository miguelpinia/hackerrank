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
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0. -104 <= xn <= 104
 *
 * @author miguel
 */
public class PowXN {

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int half = n / 2;
        int remainder = n % 2;
        double result = fastPow(x, half);
        result *= result;
        return remainder != 0 ? x * result : result;
    }

    /**
     * 0ms, beats 100%, 41.92mb, beats 68.44%.
     *
     * n even: x ** n = (x ** (n//2)) ** 2; n odd: x ** n = x * (x ** (n //2))
     * ** 2¨*
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
        }
        return fastPow(x, n);
    }

}
