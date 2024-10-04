
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
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * Solved Medium Topics Array Greedy Sorting
 *
 * There are some spherical balloons taped onto a flat wall that represents the
 * XY-plane. The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter
 * stretches between xstart and xend. You do not know the exact y-coordinates of
 * the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from
 * different points along the x-axis. A balloon with xstart and xend is burst by
 * an arrow shot at x if xstart <= x <= xend. There is no limit to the number of
 * arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting
 * any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot
 * to burst all balloons.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]] Output: 2 Explanation: The
 * balloons can be burst by 2 arrows: - Shoot an arrow at x = 6, bursting the
 * balloons [2,8] and [1,6]. - Shoot an arrow at x = 11, bursting the balloons
 * [10,16] and [7,12]. Example 2:
 *
 * Input: points = [[1,2],[3,4],[5,6],[7,8]] Output: 4 Explanation: One arrow
 * needs to be shot for each balloon for a total of 4 arrows. Example 3:
 *
 * Input: points = [[1,2],[2,3],[3,4],[4,5]] Output: 2 Explanation: The balloons
 * can be burst by 2 arrows: - Shoot an arrow at x = 2, bursting the balloons
 * [1,2] and [2,3]. - Shoot an arrow at x = 4, bursting the balloons [3,4] and
 * [4,5].
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 105 points[i].length == 2 -231 <= xstart < xend <= 231
 * - 1
 *
 *
 * @author miguel
 */
public class MinimunNumberOfArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : points) {
            if (result.isEmpty()) {
                result.add(interval);
            } else {
                int[] last = result.getLast();
                if (last[1] < interval[0]) {
                    result.add(interval);
                } else {
                    last[0] = Math.max(last[0], interval[0]);
                    last[1] = Math.min(last[1], interval[1]);
                }
            }
        }
        return result.size();
    }

}
