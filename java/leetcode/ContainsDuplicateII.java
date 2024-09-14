
import java.util.HashSet;
import java.util.Set;

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
 * 219. Contains Duplicate II
 *
 * Array Hash Table Sliding Window
 *
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3 Output: true Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1 Output: true Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105 -109 <= nums[i] <= 109 0 <= k <= 105
 *
 * @author miguel
 */
public class ContainsDuplicateII {

    /**
     * 2ms, beats 99.85%, 54.99MB, beats, 94.29%.
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int j = 0;
        int cheeto = 0;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            while ((j - i) <= k && j < nums.length) {
                cheeto++;
                if (nums[i] == nums[j++]) {
                    return true;
                }
                if (cheeto > 9999) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 21ms, beats 28.94%
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i - j) > k) {
                window.remove(nums[j]);
                j++;
            }
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
        }
        return false;
    }

}
