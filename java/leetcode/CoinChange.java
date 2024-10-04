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
 * 322. Coin Change
 * Solved
 * Medium
 *
 * Topics Array
 * Dynamic Programming
 * Breadth-First Search
 *
 *
 * Companies
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 *
 * @author miguel
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        for (int i = 1; i < table.length; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int coin : coins) {
            for (int i = coin; i < table.length; i++) {
                if (table[i - coin] != Integer.MAX_VALUE) {
                    table[i] = Math.min(table[i], table[i - coin] + 1);
                }
            }
        }
        if (table[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return table[amount];
    }

}
