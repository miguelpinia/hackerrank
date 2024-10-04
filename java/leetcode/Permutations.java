
import java.util.ArrayList;
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
 * 46. Permutations Solved Medium
 *
 * Topics Array Backtracking
 *
 * Companies Given an array nums of distinct integers, return all the possible
 * permutations . You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Example 2:
 *
 * Input: nums = [0,1] Output: [[0,1],[1,0]] Example 3:
 *
 * Input: nums = [1] Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6 -10 <= nums[i] <= 10 All the integers of nums are
 * unique.
 *
 * @author miguel
 */
public class Permutations {

    List<List<Integer>> result = new ArrayList<>();

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public List<List<Integer>> permute(int[] nums) {
        makePermutations(0, new ArrayList<>(), nums);
        return result;
    }

    void makePermutations(int index, List<Integer> curr, int[] nums) {
        if (index == nums.length) {
            List<Integer> r = new ArrayList<>();
            for (int n : nums) {
                r.add(n);
            }
            result.add(r);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            makePermutations(index + 1, curr, nums);
            swap(nums, index, i);
        }
    }

}
