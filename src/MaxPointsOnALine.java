
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
 * 149. Max Points on a Line
 *
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane, return the maximum number of points that lie on the same straight
 * line.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]] Output: 3 Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 300 points[i].length == 2 -104 <= xi, yi <= 104 All the
 * points are unique.
 *
 * @author miguel
 */
public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> counter = new HashMap<>();
            int[] x = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] y = points[j];
                double slope;
                if (x[1] == y[1]) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = (double) (x[0] - y[0]) / (double) (x[1] - y[1]);
                    slope += 0.0;
                }
                counter.merge(slope, 1, Integer::sum);
                max = Math.max(max, counter.get(slope) + 1);
            }
        }
        return max;

    }

}
