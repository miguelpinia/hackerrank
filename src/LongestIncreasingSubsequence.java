
import java.util.Arrays;

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
 * 300. Longest Increasing Subsequence Solved
 *
 * Medium
 *
 * Topics Array Binary Search Dynamic Programming
 *
 *
 * Companies Given an integer array nums, return the length of the longest
 * strictly increasing subsequence .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
 * increasing subsequence is [2,3,7,101], therefore the length is 4. Example 2:
 *
 * Input: nums = [0,1,0,3,2,3] Output: 4 Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7] Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500 -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 *
 *
 * @author miguel
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int max = -1;
        int[] prevSols = new int[nums.length];
        Arrays.fill(prevSols, -1);
        prevSols[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, length(prevSols, nums, i));
        }
        // We need to find the
        return max;

    }

    public int length(int[] prevSols, int[] nums, int i) {
        if (i == 0) {
            return 1;
        }
        if (prevSols[i] != -1) {
            return prevSols[i];
        }

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                prevSols[i] = Math.max(prevSols[i], length(prevSols, nums, j) + 1);
            } else if (prevSols[i] == -1) {
                prevSols[i] = 1;
            }
        }
        return prevSols[i];
    }
}
