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
package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations. Note that
 * combinations are unordered, i.e., [1,2] and [2,1] are considered to be the
 * same combination. Example 2:
 *
 * Input: n = 1, k = 1 Output: [[1]] Explanation: There is 1 choose 1 = 1 total
 * combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20 1 <= k <= n
 *
 *
 * @author miguel
 */
public class Combinations {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        makeCombinations(1, new ArrayList<>(), k, n);
        return result;
    }

    void makeCombinations(int start, List<Integer> numbers, int k, int n) {
        if (numbers.size() == k) {
            result.add(new ArrayList<>(numbers));
            return;
        }
        for (int i = start; i <= n; i++) {
            numbers.addLast(i);
            makeCombinations(i + 1, numbers, k, n);
            numbers.removeLast();
        }
    }

}
