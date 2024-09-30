
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 15. 3Sum
 *
 * Medium. Array, Two Pointers, Sorting
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
 * output and the order of the triplets does not matter. Example 2:
 *
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does
 * not sum up to 0. Example 3:
 *
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
 * triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000 -105 <= nums[i] <= 105
 *
 *
 * @author miguel
 */
public class ThreeSum {

    /**
     * 26ms, beats 92.56%. 54.44mb, beats 22.68%.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int k = i + 1;
            int j = nums.length - 1;
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    k++;
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[k]);
                    res.add(nums[j]);
                    sol.add(res);
                    k++;
                    while (nums[k] == nums[k - 1] && k < j) {
                        k++;
                    }
                }
            }
        }
        return sol;
    }
}
