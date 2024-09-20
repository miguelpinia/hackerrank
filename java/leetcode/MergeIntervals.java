
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlap,
 * merge them into [1,6]. Example 2:
 *
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <=
 * 104
 *
 * @author miguel
 */
public class MergeIntervals {

    /**
     * 0ms, beats 100%, 46.03mb, beats 96.13%.
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[0]);
        }
        int[] range = new int[max + 1];
        for (int[] interval : intervals) {
            range[interval[0]] = Math.max(interval[1] + 1, range[interval[0]]);
        }
        int size = 0;
        int begin = -1;
        int end = -1;

        for (int i = 0; i < range.length; i++) {
            if (range[i] != 0) {
                if (begin == -1) {
                    begin = i;
                }
                end = Math.max(end, range[i] - 1);
            }
            if (end == i) {
                intervals[size++] = new int[]{begin, end};
                begin = -1;
                end = -1;
            }
        }
        if (begin != -1) {
            intervals[size++] = new int[]{begin, end};
        }
        if (size == intervals.length) {
            return intervals;
        }
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            result[i] = intervals[i];
        }
        return result;
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
            } else {
                int[] last = result.getLast();
                if (last[1] < interval[0]) {
                    result.add(interval);
                } else if (last[1] < interval[1]) {
                    last[1] = interval[1];
                }
            }
        }
        int[][] r = new int[result.size()][];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;

    }

    /**
     * 1ms, beats 99.88%, 46.53mb, beats 42.22%.
     *
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[0]);
        }

        int[] ranges = new int[max - min + 1]; // 17
        for (int[] interval : intervals) {
            ranges[interval[0] - min] = Math.max(interval[1] - min, ranges[interval[0] - min]);
        }
        List<int[]> r = new ArrayList<>();
        int s = 0;
        int e = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) {
                continue;
            }
            if (i > e) {
                r.add(new int[]{s + min, e + min});
                s = i;
                e = ranges[i];
            } else {
                e = Math.max(ranges[i], e);
            }
        }
        // [0] = 2
        // [1] = 5
        // [7] = 9
        // [7] = 9
        // [8] = 10
        // [14] = 17
        // [1] = 5
        // [15] = 16

        // end = 5
        // 1, 6
        // start =
        r.add(new int[]{s + min, e + min});
        int[][] r1 = new int[r.size()][];
        for (int i = 0; i < r1.length; i++) {
            r1[i] = r.get(i);
        }
        return r1;
    }

}
