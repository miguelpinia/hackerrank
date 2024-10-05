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
 * 137. Single Number II
 * Solved
 * Medium
 *
 * Topics Array
 * Bit Manipulation
 *
 *
 * Companies
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 *
 * @author miguel
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int[] freqs = new int[32];
        for (int i : nums) {
            for (int j = 31; j >= 0; j--) {
                if ((int) (i & 1) == 1) {
                    freqs[j]++;
                }
                i >>>= 1;
            }
        }
        int solution = 0;
        for (int i = 0; i < 32; i++) {
            solution |= (freqs[i] % 3) << (31 - i);
        }
        return solution;
    }

}
