

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
public class KLargestElementQuickSelect {

    /**
     * Using frequencies.
     *
     * @param nums
     * @param k
     * @return
     */
    public int another(int[] nums, int k) {
        int maxLength = 20001, max = 10000, i = maxLength;
        int[] freq = new int[maxLength];
        for (int num : nums) {
            freq[num + max]++;
        }
        while (true) {
            if ((k -= freq[--i]) < 1) {
                break;
            }
        }
        return i - max;
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotLoc = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] > pivot) {
                swap(arr, i, pivotLoc);
                pivotLoc++;
            }
        }
        swap(arr, high, pivotLoc);
        return pivotLoc;
    }

    private int quickSelect(int[] arr, int low, int high, int k) {

        int partition = partition(arr, low, high);
        if (partition == k - 1) {
            return arr[partition];
        } else if (partition < k - 1) {
            return partition(arr, partition + 1, high);
        } else {
            return partition(arr, low, partition - 1);
        }
    }

    private int kSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

}
