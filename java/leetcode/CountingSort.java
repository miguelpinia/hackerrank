package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miguel
 */
public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        Integer[] sorted = new Integer[100];
        Arrays.fill(sorted, 0);
        for (int i = 0; i < arr.size(); i++) {
            sorted[arr.get(i)]++;
        }
        return Arrays.asList(sorted);
    }

}
