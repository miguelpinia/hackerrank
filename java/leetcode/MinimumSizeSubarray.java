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
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 *
 * @author miguel
 */
public class MinimumSizeSubarray {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minSize = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= target) {
                minSize = Math.min(i - left + 1, minSize);
                currentSum -= nums[left];
                left++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

}
