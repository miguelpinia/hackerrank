package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * @author miguel
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0 && (k >= i)) {
            if (nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
//                if (i > 0) {
//                    i--;
//                }
//                else if (j > i) {
//                    nums1[i] = nums2[j--];
//                } else if (j == 0 && k < 0) {
//                    nums1[j] = nums2[j--];
//                }

            }
        }
    }

    public static void main(String args[]) {

        MergeSortedArray m = new MergeSortedArray();
        int a[] = {-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0};
        int b[] = {-1, -1, 0, 0, 1, 2};
//        int a[] = {2, 0};
//        int b[] = {1};
        m.merge(a, 5, b, 6);
        System.out.println(Arrays.toString(a));
    }

}
