
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
 * 1331. Rank Transform of an Array Solved Easy Topics Companies Hint Given an
 * array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following
 * rules:
 *
 * Rank is an integer starting from 1. The larger the element, the larger the
 * rank. If two elements are equal, their rank must be the same. Rank should be
 * as small as possible.
 *
 *
 * Example 1:
 *
 * Input: arr = [40,10,20,30] Output: [4,1,2,3] Explanation: 40 is the largest
 * element. 10 is the smallest. 20 is the second smallest. 30 is the third
 * smallest. Example 2:
 *
 * Input: arr = [100,100,100] Output: [1,1,1] Explanation: Same elements share
 * the same rank. Example 3:
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12] Output: [5,3,4,2,8,6,7,1,3]
 *
 *
 * Constraints:
 *
 * 0 <= arr.length <= 105 -109 <= arr[i] <= 109
 *
 *
 * @author miguel
 */
public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        Map<Integer, Integer> indexes = new HashMap<>();
        int pos = 1;
        for (int i = 0; i < copy.length; i++) {
            if (!indexes.containsKey(copy[i])) {
                indexes.put(copy[i], pos++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = indexes.get(arr[i]);
        }
        return arr;

    }

}
