
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
 *
 * @author miguel
 */
public class LongestConsecutiveSequence {

    /**
     * O(n), 42ms, beats 42.60%.
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        Map<Integer, Integer> table = new HashMap<>();
        int maxSize = 0;
        for (int n : nums) {
            elements.add(n);
        }
        for (int n : elements) {
            int x = table.getOrDefault(n - 1, 0);
            int y = table.getOrDefault(n + 1, 0);
            int v = x + y + 1;
            table.put(n - x, v);
            table.put(n + y, v);
            maxSize = Math.max(maxSize, v);
        }
        return maxSize;

    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        int maxSize = 0;
        for (int element : nums) {
            elements.add(element);
        }
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (!elements.contains(element - 1)) {
                int size = 1;
                element++;
                while (elements.contains(element)) {
                    size++;
                    element++;
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;

    }

    public int longestConsecutiveWithoutSet(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        int maxSize = 0;
        for (int n : nums) {
            if (table.containsKey(n)) {
                continue;
            }
            table.put(n, 0);
            int x = table.getOrDefault(n - 1, 0);
            int y = table.getOrDefault(n + 1, 0);
            int v = x + y + 1;
            table.put(n - x, v);
            table.put(n + y, v);
            maxSize = Math.max(maxSize, v);
        }
        return maxSize;

    }

}
