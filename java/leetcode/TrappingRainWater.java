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
 * 42. Trapping Rain Water (hard)
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * @author miguel
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int result = 0;
        while (left <= right) {
            if (rMax <= lMax) {
                result += Math.max(0, rMax - height[right]);
                rMax = Math.max(rMax, height[right]);
                right--;
            } else {
                result += Math.max(0, lMax - height[left]);
                lMax = Math.max(lMax, height[left]);
                left++;
            }
        }
        return result;
    }

    public int trap2(int[] height) {
        int lmax = 0, rmax = 0, total = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            if (height[l] <= height[r]) {
                if (lmax > height[l]) {
                    total += lmax - height[l];
                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if (rmax > height[r]) {
                    total += rmax - height[r];
                } else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return total;
    }

    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int result = 0;
        while (left <= right) {
            if (rMax <= lMax) {
                if (rMax > height[right]) {
                    result += rMax - height[right];
                } else {
                    rMax = height[right];
                }
                right--;
            } else {
                if (lMax > height[left]) {
                    result += lMax - height[left];
                } else {
                    lMax = height[left];
                }
                left++;
            }
        }
        return result;
    }
}
