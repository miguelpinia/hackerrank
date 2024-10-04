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
 * 1497. Check If Array Pairs Are Divisible by k
 * Solved
 * Medium
 *
 * Topics Array Hash Table Counting
 *
 * Companies
 * Hint
 * Given an array of integers arr of even length n and an integer k.
 *
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *
 * Return true If you can find a way to do that or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output: true
 * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5,6], k = 7
 * Output: true
 * Explanation: Pairs are (1,6),(2,5) and(3,4).
 * Example 3:
 *
 * Input: arr = [1,2,3,4,5,6], k = 10
 * Output: false
 * Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
 *
 *
 * Constraints:
 *
 * arr.length == n
 * 1 <= n <= 105
 * n is even.
 * -109 <= arr[i] <= 109
 * 1 <= k <= 105
 *
 * @author miguel
 */
public class CheckIfArrayPairsAreDivisibleByK {

    public boolean canArrange(int[] arr, int k) {
        int[] freqs = new int[k];
        for (int a : arr) {
            freqs[((a % k) + k) % k]++;
        }
        if (freqs[0] % 2 == 1) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (freqs[i] != freqs[k - i]) {
                return false;
            }
        }
        return true;
    }

}